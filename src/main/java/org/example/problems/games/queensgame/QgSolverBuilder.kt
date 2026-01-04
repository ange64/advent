package org.example.problems.games.queensgame

import org.example.problems.games.abstract.FileEntry
import org.example.problems.games.abstract.IFileModel
import org.example.problems.games.abstract.IHtmlParser
import org.example.template.scapping.PlayrightUtils

abstract class QgSolverBuilder<in T : IFileModel<IQueenSolver>> protected constructor(
    private val level: Int,
    private val fileModel: T,
    private val parser: IHtmlParser<T>
) {
    private val boardMap = fileModel.fileToEntries()

    fun build(): IQueenSolver {
        if (level !in boardMap.keys) {
            println("Fetching level $level HTML..")
            val string = PlayrightUtils.fetchAllMatching(parser.getUrl() + level, parser.boardCssPattern())
            val temp = parser.htmlToFileEntry(level, string, fileModel)
            fileModel.appendToFile(temp)
            boardMap[temp.level] = temp.board
        }
        return fileModel.fileEntryToModel(FileEntry(level, boardMap[level]!!))
    }
}

class QgVercelSolverBuilder(level: Int) :
    QgSolverBuilder<QgFileModel>(level, QgFileModel("boards.txt"), QgVercelParser())

class QgQglSolverBuilder(level: Int) :
    QgSolverBuilder<QgFileModel>(level, QgFileModel("boardsqg.txt"), QgQgParser())