package org.example.problems.year2016

import org.example.template.Template
import org.example.template.primitive.arrays.ArrUtils

class Pb21 : Template<Array<out String>>(2016, 21, "Scrambled Letters and Hash ") {

    lateinit var start : CharArray

    override fun exec_part_1(data: Array<out String>) {
        for (c in data) {
            val split = c.split(" ")
            when (split[0]) {
                "move" -> handleMove(split)
                "reverse" -> handleReverse(split)
                "swap" -> handleSwap(split)
                "rotate" -> handleRotate(split)
            }
        }
        println(start.joinToString(""))
    }

    override fun exec_part_2(data: Array<out String>?) {

    }

    private fun handleSwap(command: List<String>) {
        val i1 = if (command[1][0] == 'p') command[2].toInt() else ArrUtils.indexOf(start, command[2][0])
        val i2 = if (command[1][0] == 'p') command[5].toInt() else ArrUtils.indexOf(start, command[5][0])
        ArrUtils.swap(start, i1, i2)
    }

    private fun handleMove(command: List<String>) {
        ArrUtils.move(start, command[2].toInt(), command[5].toInt())
    }

    private fun handleReverse(command: List<String>) {
        ArrUtils.reverse(start, command[2].toInt(), command[4].toInt())
    }

    private fun handleRotate(command: List<String>) {
        when (command[1][0]) {
            'b' -> {
                val index = ArrUtils.indexOf(start, command[6][0]) + 1
                ArrUtils.rotate(start, if (index > 4) index + 1 else index)
            }
            'r' ->  ArrUtils.rotate(start, command[2].toInt())
            'l' ->  ArrUtils.rotate(start, start.size - command[2].toInt())
        }
    }


    override fun parseInput(lines: Array<out String>): Array<out String> {
        start = lines[0].toCharArray()
        ArrUtils.reverse(lines, 0, lines.size - 1)
        return lines
    }

}