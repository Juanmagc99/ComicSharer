package com.juanma.comic_sharer.model.dto

import com.juanma.comic_sharer.model.entity.Category
import com.juanma.comic_sharer.model.entity.Genre

data class ComicDTO(
    val title: String,
    val author: String,
    val releaseYear: Int,
    val genres: Set<Long>,
    val categories: Set<Long>
)
