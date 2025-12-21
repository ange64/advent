package org.example.problems.year2016

import org.example.template.Template

class Pb18 : Template<IntArray>(2016, 18, "Like a Rogue") {

    override fun exec_part_1(data: IntArray) {
        var safe = data.count { it == 0 }
        var current = data;
        var next = IntArray(data.size);
        for (i in 0..<400000 - 1) {
            for (j in 1..data.size - 2) {
                next[j] = current[j - 1] xor current[j + 1]
                safe += 1 - next[j];
            }
            next[0] = current[1]
            next[next.lastIndex] = current[current.lastIndex - 1]
            safe += 1 - next[0]
            safe += 1 - next.last()
            val temp = current
            current = next
            next = temp
        }
        println(safe)
    }

    override fun exec_part_2(data: IntArray) {

    }

    override fun parseInput(lines: Array<out String>): IntArray {
        return lines[0].map { if (it == '.') 0 else 1 }.toIntArray();
    }

}