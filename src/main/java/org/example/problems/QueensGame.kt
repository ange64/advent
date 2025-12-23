package org.example.problems

import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright


object QueensGame {
    private const val URL = "https://queensgame.vercel.app/level/"
    private lateinit var page : Page

    init {
        val playwright = Playwright.create()
        val ff = playwright.firefox().launch(BrowserType.LaunchOptions().setHeadless(true))
        val page = ff.newPage()
    }

    fun scrapeData(level: Int) {

    }
}