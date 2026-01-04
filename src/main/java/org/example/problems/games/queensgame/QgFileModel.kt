package org.example.problems.games.queensgame

import org.example.problems.games.abstract.FileEntry
import org.example.problems.games.abstract.IFileModel
import org.example.template.Utils
import org.example.template.primitive.StringUtils
import java.io.File

class QgFileModel(fileName: String) : IFileModel<IQueenSolver> {

    val startCode = 'a'.code
    val squareMark = 'S'
    val colorMark = 'C'
    val sep = '|'

    private val file: File = Utils.inputAsFile("queensGame", fileName)

    override fun fileEntryToModel(entry: FileEntry): IQueenSolver {
        println("parsing level's ${entry.level} text file entry to model..")
        val boardString = entry.board.split(sep)
        val grid = Array(boardString[1][0].code - startCode + 1) {
            CharArray(boardString[1][1].code - startCode + 1) { ' ' }
        }
        StringUtils.splitRanges(boardString[0], squareMark) { i1, _ ->
            val color = boardString[0][i1]
            val row = (boardString[0][i1 + 1] - startCode).code
            val col = (boardString[0][i1 + 2] - startCode).code
            grid[row][col] = color.code.toChar()
        }
        val colorMap = HashMap<Char, Int>()
        StringUtils.splitRanges(boardString[2], colorMark) { i1, i2 ->
            val colorCode = boardString[2].substring(i1 + 1, i2).toInt()
            colorMap[boardString[2][i1].lowercaseChar()] = colorCode
        }
        return QueenSolver(entry.level, grid, colorMap)
    }

    override fun fileToEntries(): MutableMap<Int, String> {
        return file.readLines()
            .associate { Pair(it.substringBefore(' ').toInt(), it.substringAfter(' ')) }
            .toMutableMap()
    }

    override fun appendToFile(entry: FileEntry) {
        file.appendText("${entry.level} ${entry.board}\n")
    }
}

