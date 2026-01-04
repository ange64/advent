package org.example.problems.games.queensgame

import org.example.template.primitive.arrays.ArrUtils
import org.example.template.primitive.collections.integer.IntList

interface IQueenSolver {

    fun solve()

    fun getSolution(): Array<CharArray>

    fun getColorMap(): Map<Char, Int>

    fun getLevel(): Int
}

class QueenSolver(
    private val level: Int,
    private val grid: Array<CharArray>,
    private val colorMap: HashMap<Char, Int>
) : IQueenSolver {

    private val queens: IntList = IntList(16)
    private val cols: BooleanArray = BooleanArray(grid[0].size)
    private val rows: BooleanArray = BooleanArray(grid.size)
    private val cellsByColor = Array(grid.size) { IntList(16) }
    private val colorIndices = IntArray(colorMap.size) { it }
    private var nbLoops = 0;
    private var solFound = false

    init {
        for ((i, chars) in grid.withIndex()) {
            for ((j, c) in chars.withIndex()) {
                cellsByColor[c.code - 'a'.code].add((i shl 8) or (j))
            }
        }
        ArrUtils.mapInPlace(colorIndices, colorIndices.size) { (cellsByColor[it].size() shl 8) + it }
        colorIndices.sort()
        ArrUtils.mapInPlace(colorIndices, colorIndices.size) { (it and 255) }
        cellsByColor.sortBy { it.size() }
    }

    override fun solve() {
        println("solving level $level..")
        backtrack(0)
        println("solution found in : $nbLoops iterations")
        queens.forEach {
            val row = it shr 8
            val col = it and 255
            grid[row][col] = 'Q'
        }
    }

    private fun backtrack(colIdx: Int) {
        if (queens.size() == grid.size) solFound = true
        if (solFound) return
        nbLoops++
        for (i in colIdx until cellsByColor.size) {
            for (j in 0 until cellsByColor[i].size()) {
                val cell = cellsByColor[i][j]
                val row = cell shr 8
                val col = cell and 255
                if (rows[row] || cols[col] || diagOccupied(cell)) continue
                if (queens.contains(cell)) continue
                rows[cell shr 8] = true
                cols[cell and 255] = true
                queens.add(cell)
                backtrack(i + 1)
                if (solFound) return
                queens.pop()
                rows[cell shr 8] = false
                cols[cell and 255] = false
            }
        }
    }

    private fun diagOccupied(cell: Int): Boolean {
        val dy = (1 shl 8)
        val topLeft = cell - dy - 1
        val topRight = cell - dy + 1
        val botRight = cell + dy + 1
        val botLeft = cell + dy - 1
        for (i in 0..<queens.size()) {
            if (queens[i] == topLeft || queens[i] == topRight || queens[i] == botRight || queens[i] == botLeft) return true
        }
        return false
    }

    override fun getSolution(): Array<CharArray> {
        return grid
    }

    override fun getColorMap(): Map<Char, Int> {
        return colorMap
    }

    override fun getLevel(): Int {
        return level
    }

}

