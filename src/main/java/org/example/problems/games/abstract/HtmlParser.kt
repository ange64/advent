package org.example.problems.games.abstract


interface IHtmlParser<in T : IFileModel<Any>> {

    fun  htmlToFileEntry(level: Int, html: String, model: T): FileEntry

    fun boardCssPattern() : String

    fun getUrl() : String
}



