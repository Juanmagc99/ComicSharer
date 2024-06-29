package com.juanma.comic_sharer.repository

import com.juanma.comic_sharer.model.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository:JpaRepository<Category, Long> {
    override fun findAllById(ids: MutableIterable<Long>): MutableList<Category>
}