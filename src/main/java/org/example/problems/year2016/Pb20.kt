package org.example.problems.year2016

import org.example.template.Template
import kotlin.math.max

@OptIn(ExperimentalUnsignedTypes::class)
class Pb20 : Template<ULongArray>(2016, 20, "Firewall Rules") {

    override fun exec_part_1(data: ULongArray) {
        data.sort()
        var min = data[0] and 0xFFFFFFFFu
        var allowed :ULong = 0u
        for (d in data) {
            val start = d shr 32
            val end = d and 0xFFFFFFFFu
            ///println("$start, $end, min : $min")
            if (start > min + 1u)  allowed += (start - (min + 1u))
            min = max(min, end)
        }
        allowed += 0xFFFFFFFFu - min
        println(allowed)
    }

    override fun exec_part_2(data: ULongArray) {

    }

    override fun parseInput(lines: Array<out String>?): ULongArray {
         val array = ULongArray(lines!!.size)
         for (i in lines.indices) {
             val idx = lines[i].indexOf('-')
             val a = lines[i].substring(0,idx).toULong()
             val b = lines[i].substring(idx + 1).toULong()
             array[i] = (a shl 32) or b
         }
        return array
    }
}