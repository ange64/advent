package org.example.problems.year2016

import org.example.template.Template
import org.example.template.primitive.arrays.ArrUtils

class Pb21 : Template<Array<out String>>(2016, 21, "Scrambled Letters and Hash ") {

    private lateinit var start : CharArray
    private lateinit var working: CharArray
    private val target = "fbgdceah".toCharArray()

    override fun exec_part_1(data: Array<out String>) {
        execOps(start, data)
    }

    override fun exec_part_2(data: Array<out String>) {
        start = "fbgdceah".toCharArray()
        ArrUtils.heapPermute(start.clone()) { result ->
            val temp = result.clone()
            execOps(temp, data)
            if (temp.contentEquals(target)) {
                println(result.joinToString(""))
                println(temp.joinToString(""))
            }
        }
    }

    private fun execOps(on : CharArray, data: Array<out String>){
        for (c in data) {
            val split = c.split(" ")
            when (split[0]) {
                "move" -> handleMove(on, split)
                "reverse" -> handleReverse(on, split)
                "swap" -> handleSwap(on, split)
                "rotate" -> handleRotate(on, split)
            }
        }
    }

    private fun handleSwap(target : CharArray, command: List<String>) {
        val i1 = if (command[1][0] == 'p') command[2].toInt() else ArrUtils.indexOf(target, command[2][0])
        val i2 = if (command[1][0] == 'p') command[5].toInt() else ArrUtils.indexOf(target, command[5][0])
        ArrUtils.swap(target, i1, i2)
    }

    private fun handleMove(target : CharArray, command: List<String>) {
        ArrUtils.move(target, command[2].toInt(), command[5].toInt())
    }

    private fun handleReverse(target : CharArray, command: List<String>) {
        ArrUtils.reverse(target, command[2].toInt(), command[4].toInt())
    }

    private fun handleRotate(target : CharArray, command: List<String>) {
        when (command[1][0]) {
            'b' -> {
                val index = ArrUtils.indexOf(target, command[6][0])
                ArrUtils.rotate(target, if (index >= 4) index + 2 else index + 1)
            }
            'r' ->  ArrUtils.rotate(target, command[2].toInt())
            'l' ->  ArrUtils.rotate(target, target.size - command[2].toInt())
        }
    }



    override fun parseInput(lines: Array<out String>): Array<out String> {
        start = lines[0].toCharArray()
        return lines
    }

}