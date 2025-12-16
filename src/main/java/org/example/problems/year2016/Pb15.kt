package org.example.problems.year2016

import org.example.template.Template
import org.example.template.Utils
import java.util.*
import kotlin.math.max

class Pb15 : Template<Array<Disk>>(2016, 15, "timing") {


    override fun exec_part_1(data: Array<Disk>) {
        val pairs = Array(data.size) {IntArray(2)}
        for ((tReach, disk: Disk) in data.withIndex()) {
            pairs[tReach][0] = disk.nbPos - (tReach + 1 + disk.startPos ) % disk.nbPos
            pairs[tReach][1] = disk.nbPos;
        }
        pairs.sortBy { -it[0] }
        var start = 1
        var max = 0
        while (start < pairs.size) {
            max = max(pairs[start][0], max);
            if (start == 0) {
                pairs[start][0] += pairs[start][1]
                start++
            } else if (pairs[start - 1][0] < max){
                start--;
            } else if (pairs[start - 1][0] > pairs[start][0]) {
                pairs[start][0] += pairs[start][1]
            } else {
                start++
            }
        }
        Utils.print2dArray(pairs, " ", 3)
    }

    override fun exec_part_2(data: Array<Disk>?) {
    }

    override fun parseInput(lines: Array<out String>?): Array<Disk> {
        return lines?.map {
            val split = it.split(" ");
            Disk(split[3].toInt(), split.last().dropLast(1).toInt())
        }?.toTypedArray()!!
    }


}

class Disk(val nbPos: Int, var startPos: Int)