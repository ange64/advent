package org.example.problems.games

import org.example.template.primitive.StringUtils

fun String.indexOfEnd(toFind: String, start: Int = 0): Int {
    return StringUtils.indexOfEnd(this, toFind, start);
}
