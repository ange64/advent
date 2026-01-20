package org.example.problems.year2016

import org.example.template.Template
import java.util.regex.Pattern

class Pb22 : Template<Array<Pb22.Entry>>(2016, 22, "Grid computing") {
    override fun exec_part_1(data: Array<Entry>) {

    }

    override fun exec_part_2(data: Array<Entry>) {

    }

    override fun parseInput(lines: Array<out String>): Array<Entry> {
        val pat = Pattern.compile(" +")
        val result = Array(lines.size) { Entry.DEFAULT }
        for ((i, l) in lines.withIndex()) {
            if (!l.startsWith("/")) continue
            val split = l.split(pat)
            val coords = split[0].split("-")
            val entry = Entry(
                coords[1].drop(1).toInt(),
                coords[2].drop(1).toInt(),
                split[1].dropLast(1).toInt(),
                split[2].dropLast(1).toInt(),
                split[3].dropLast(1).toInt(),
                split[4].dropLast(1).toInt(),
            )
            println(entry)
            result[i] = entry
        }
        return result
    }

    data class Entry(val x: Int, val y: Int, val s: Int, val u: Int, val a: Int, val p: Int) {
        companion object {
            val DEFAULT = Entry(0, 0, 0, 0, 0, 0);
        }
    }
}