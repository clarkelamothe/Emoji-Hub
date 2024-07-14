package com.clarkelamothe.emojihub.domain

data class Emoji(
    val id: Long?,
    val name: String,
    val category: String,
    val group: String,
    val unicode: String
)
