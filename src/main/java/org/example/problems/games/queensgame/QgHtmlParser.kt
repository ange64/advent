package org.example.problems.games.queensgame

import org.example.problems.games.indexOfEnd
import org.example.problems.games.abstract.FileEntry
import org.example.problems.games.abstract.IHtmlParser
import org.example.template.primitive.StringUtils

abstract class QgParser : IHtmlParser<QgFileModel> {

    override fun htmlToFileEntry(level: Int, html: String, model: QgFileModel): FileEntry {
        println("Parsing level's $level HTML to text file entry...")
        val colorMap = HashMap<Int, Char>()
        val boardAsString = StringBuilder()
        var l = model.startCode.toChar()
        var h =  model.startCode.toChar()
        StringUtils.splitRanges(html, splitsPattern()) { i1, i2 ->
            val cellInfo = cellInfo(html, i1, i2)
            val col = (cellInfo and 0xFF).toChar() + model.startCode
            val row = ((cellInfo shr 8) and 0xFF).toChar() + model.startCode
            if (row > h) h = row
            if (col > l) l = col
            val rgbIdx = html.indexOfEnd("rgb", i1)
            val colorStr = StringUtils.between(html, '(', ')', rgbIdx, i2)
            val split = colorStr.split(", ")
            val colorCode = (split[0].toInt() shl 16 or (split[1].toInt() shl 8) or split[2].toInt())
            val color = colorMap.computeIfAbsent(colorCode) { (colorMap.size).toChar() + model.startCode }
            boardAsString.append("${model.squareMark}${color}$row$col")
        }
        boardAsString.append("${model.sep}${h}${l}${model.sep}")
        colorMap.forEach { boardAsString.append("${model.colorMark}${it.value}${it.key}") }
        val entry = FileEntry(level, boardAsString.toString())
        return entry
    }

    protected abstract fun splitsPattern() : String

    protected abstract fun cellInfo(str : String, i1 : Int, i2 : Int) : Int
}

class QgVercelParser: QgParser() {

    override fun splitsPattern(): String {
        return "<div class="
    }

    override fun cellInfo(str: String, i1: Int, i2: Int): Int {
        val rowIdx = str.indexOfEnd("row=", i1)
        val colIDx = str.indexOfEnd("col=", rowIdx)
        val row = StringUtils.between(str, '"', '"', rowIdx, colIDx).toInt()
        val col = StringUtils.between(str, '"', '"', colIDx, i2).toInt()
        return (row shl 8) or col
    }

    override fun boardCssPattern(): String {
        return  ".square"
    }

    override fun getUrl(): String {
        return "https://queensgame.vercel.app/community-level/"
    }
}

class QgQgParser : QgParser() {

    override fun splitsPattern(): String {
       return "<div id="
    }

    override fun cellInfo(str: String, i1: Int, i2: Int): Int {
        val coordsIdx = str.indexOfEnd("case", i1)
        val coords = StringUtils.between(str, '-', '"', coordsIdx, i2)
        val row = coords.substringBefore('-').toInt()
        val col = coords.substringAfter('-').toInt()
        return (row shl 8) or col
    }

    override fun boardCssPattern(): String {
        return "div[id*=case]"
    }

    override fun getUrl(): String {
        return "https://www.queens-game.com/?map=map"
    }
}