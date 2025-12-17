package org.example.problems.year2016

import org.example.template.Template
import org.example.template.Utils
import org.example.template.primitive.PUtils
import org.example.template.primitive.arrays.ArrUtils
import org.example.template.primitive.collections.ByteList
import org.example.template.primitive.functional.Mapper

class Pb17 : Template<String>(2016, 17, "Two Steps Forward") {

    private val hashOut = ByteArray(16)

    override fun exec_part_1(data: String) {
        val byteList = ByteList().addAll(data.toByteArray())
        byteList.md5Hash(hashOut)
        println(byteList.toString(",") { PUtils.toBits(it, 8) })
        println(byteList.toString(",", PUtils::hexOf))
    }



    override fun exec_part_2(data: String) {

    }

    override fun parseInput(lines: Array<out String>?): String {
        return lines!![0];
    }
}