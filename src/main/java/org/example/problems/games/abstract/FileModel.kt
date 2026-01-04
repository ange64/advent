package org.example.problems.games.abstract

import org.example.problems.games.queensgame.IQueenSolver

data class FileEntry(val level: Int, val board: String)

interface IFileModel<out R> {

    fun fileEntryToModel(entry: FileEntry): R

    fun fileToEntries(): MutableMap<Int, String>

    fun appendToFile(entry: FileEntry)
}

