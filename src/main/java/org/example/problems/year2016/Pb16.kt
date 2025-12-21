package org.example.problems.year2016

import org.example.template.Template
import org.example.template.primitive.arrays.ArrUtils
import kotlin.experimental.xor

class Pb16 : Template<ByteArray>(2016, 16, "Checksum ") {

    var diskLen = 0
    override fun exec_part_1(data: ByteArray) {
        var temp = data
        while (temp.size < diskLen) temp = fillDisk(temp)
        var check = checksum(temp, diskLen);
        while (check.size % 2 == 0) check = checksum(check, check.size)
        println(check.joinToString(""))
    }

    private fun fillDisk(data: ByteArray): ByteArray {
        val result = ByteArray((data.size shl 1) + 1)
        for (i in data.indices) {
            result[i] = data[i]
            result[result.lastIndex - i] = data[i] xor 1
        }
        return result
    }

    private fun checksum(data: ByteArray, len: Int): ByteArray {
        val result = ByteArray(len / 2)
        for (i in 0..<len step 2) {
            result[i / 2] = data[i] xor ((1 - data[i + 1]).toByte())
        }
        return result
    }

    override fun exec_part_2(data: ByteArray) {

    }

    override fun parseInput(lines: Array<out String>): ByteArray {
        diskLen = lines[0].toInt()
        val arr = lines[1].toByteArray();
        ArrUtils.mapInPlace(arr, arr.size) { (it - 48).toByte() };
        return arr;
    }
}
