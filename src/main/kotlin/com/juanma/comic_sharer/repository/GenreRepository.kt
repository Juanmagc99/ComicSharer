package com.juanma.comic_sharer.repository

import com.juanma.comic_sharer.model.entity.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository:JpaRepository<Genre, Long> {
    override fun findAllById(ids: MutableIterable<Long>): MutableList<Genre>
}