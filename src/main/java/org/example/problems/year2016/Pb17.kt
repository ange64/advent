package org.example.problems.year2016

import org.example.template.Template
import org.example.template.primitive.collections.ByteList

class Pb17 : Template<String>(2016, 17, "Two Steps Forward") {


    private val A: Byte = 0b1010
    private val D: Byte = 68
    private val U: Byte = 85
    private val L: Byte = 76
    private val R: Byte = 82

    private var minDepth = 1000;
    private var maxDepth = 0
    private val hash = ByteArray(16)
    private val visited = HashSet<Long>()

    override fun exec_part_1(data: String) {
        maxDepth = 0
        val byteList = ByteList().addAll(data.toByteArray())
        findPath(byteList, 0, 0, 0)
    }

    private fun findPath(list: ByteList, x: Int, y: Int, depth: Int) {
        if (x == 3 && y == 3) {
            maxDepth = depth.coerceAtLeast(maxDepth)
            println(maxDepth)
            return
        }
        list.md5Hash(hash)
        val hashHash = hashHash(hash)
        if (visited.contains(hashHash))
            return
        visited.add(hashHash)
        val up = (hash[0].toInt() ushr 4) and 0xF
        val down = hash[0].toInt() and 0xF
        val left = (hash[1].toInt() ushr 4) and 0xF
        val right = hash[1].toInt() and 0xF
        if (up > A && y > 0) {
            list.add(U)
            findPath(list, x, y - 1, depth + 1)
            list.pop()
        }
        if (down > A && y < 3) {
            list.add(D)
            findPath(list, x, y + 1, depth + 1)
            list.pop()
        }
        if (left > A && x > 0) {
            list.add(L)
            findPath(list, x - 1, y, depth + 1)
            list.pop()
        }
        if (right > A && x < 3) {
            list.add(R)
            findPath(list, x + 1, y, depth + 1)
            list.pop()
        }
    }

    private fun hashHash(hash: ByteArray): Long {
        var result: Long = hash[0].toLong()
        result += hash[1].toLong() shl 8
        result += hash[2].toLong() shl 16
        result += hash[3].toLong() shl 24
        result += hash[4].toLong() shl 32
        result += hash[5].toLong() shl 40
        result += hash[6].toLong() shl 48
        result += hash[7].toLong() shl 56
        return result
    }

    override fun exec_part_2(data: String) {

    }

    override fun parseInput(lines: Array<out String>?): String {
        return lines!![0];
    }
}