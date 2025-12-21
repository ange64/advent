package org.example.problems.year2016

import org.example.template.Template
import org.example.template.primitive.arrays.ArrUtils
import kotlin.math.max

@OptIn(ExperimentalUnsignedTypes::class)
class Pb21 : Template<Array<out String>>(2016, 21, "Scrambled Letters and Hash ") {

    val start = "abcdefgh".toCharArray()
    var current = start

    override fun exec_part_1(data: Array<out String>) {
        for (c in data) {
            val split = c.split(" ")
            when (split[0]) {
                "move" -> handleMove(split)
                "reverse" -> handleReverse(split)
                "swap" ->  handleSwap(split)
                "rotate" -> handleRotate(split)
            }
        }
    }

    override fun exec_part_2(data: Array<out String>?) {

    }

    private fun handleSwap(command : List<String>) {
        if (command[1][0] == 'p') {
            var i1 = command[2].toInt()
            var i2 = command[5].toInt()
        } else {
            var c1 = command[2][0]
            var c2 = command[5][0]
        }
    }

    private fun handleMove(command : List<String>) {

    }

    private fun handleReverse(command : List<String>) {

    }

    private fun handleRotate(command : List<String>) {

    }




    override fun parseInput(lines: Array<out String>): Array<out String> {
        return lines
    }

}