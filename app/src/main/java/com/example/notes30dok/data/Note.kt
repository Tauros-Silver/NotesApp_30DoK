package com.example.notes30dok.data

data class Note(val noteText: String,
                val ref: String) {
    override fun toString(): String {
        return "$noteText - $ref"
    }
}