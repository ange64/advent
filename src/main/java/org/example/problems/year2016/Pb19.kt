package org.example.problems.year2016

import org.example.template.Template

class Pb19 : Template<Int>(2016, 19, "An Elephant Named Joseph") {

    override fun exec_part_1(data: Int) {
        var removeOdd = true;
        var start = 1
        var end = data
        var step = 1
        do {
            // var sb = StringBuilder()
            // for (i in start..end step step) {
            //     sb.append(" $i ")
            // }
            //println("step : $step | $sb")
            println("$start $end $step")
            val nbElemOdd = ((end - start) / step + 1) % 2 != 0
            println("nbElemOdd: $nbElemOdd | removeOdd $removeOdd")
            // println(if (state) "Remove Odd Indexes" else "Remove Even indexes")
            if (!removeOdd) start += step
            if (removeOdd != nbElemOdd) end -= step
            step *= 2
            if (nbElemOdd) removeOdd = !removeOdd
        } while (start + step < end)
        println("$start $end $step")
    }


    @OptIn(ExperimentalUnsignedTypes::class)
    override fun exec_part_2(data: Int) {
        var example = IntArray(data) { it + 1 }
        var left = example.size;
        while (left > 1) {
            var i = -1;
            var emptySlots = 0
            while (++i < example.size) {
                if (example[i] == 0) emptySlots--
                else example[(i + emptySlots++ + (left-- / 2)) % example.size] = 0
            }
            example = example.filter { it != 0 }.toIntArray()
        }
        println(example[0])

    }

    override fun parseInput(lines: Array<out String>?): Int {
        return lines?.get(0)!!.toInt();
    }


}