package org.example.template.scapping

import com.microsoft.playwright.*
import com.microsoft.playwright.options.WaitUntilState
import java.rmi.UnexpectedException

object PlayrightUtils {

    @JvmStatic
    fun fetchAllMatching(url: String, pattern: String): String {
        val context = Playwright.create()
        val chromium: Browser = context.chromium().launch(BrowserType.LaunchOptions().setHeadless(true).setSlowMo(100.0))
        val timeout = Page.WaitForSelectorOptions().setTimeout(30_000.0)
        val page = chromium.newPage()
        page.setDefaultTimeout(timeout.timeout)
        page.setDefaultNavigationTimeout(timeout.timeout)
        val resp = page.navigate(url, Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE))
        if (!resp.ok()) {
            throw UnexpectedException("bad response from page : $resp")
        }
        if (pattern != "") page.waitForSelector(pattern)
        val result = page.locator(pattern)
        val builder = StringBuilder()
        for (i in 0..<result.count()) {
            builder.append(onlyOuterHtml(result.nth(i)))
        }
        chromium.close()
        context.close()
        return builder.toString()
    }

    private fun onlyOuterHtml(result : Locator) : String {
        val str = result.evaluate("element => element.outerHTML").toString()
        return str.substring(0, str.indexOf(">"))
    }


}