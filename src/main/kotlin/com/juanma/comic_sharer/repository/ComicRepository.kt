package com.juanma.comic_sharer.repository

import com.juanma.comic_sharer.model.entity.Comic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComicRepository :JpaRepository<Comic, Long>{
    fun findByTitle(title: String): Comic

    fun existsByTitle(title: String): Boolean
}