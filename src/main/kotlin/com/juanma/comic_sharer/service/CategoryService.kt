package com.juanma.comic_sharer.service

import com.juanma.comic_sharer.model.dto.CategoryDTO
import com.juanma.comic_sharer.model.entity.Category
import com.juanma.comic_sharer.repository.CategoryRepository

class CategoryService(val db: CategoryRepository) {
    fun findAll(): List<Category> {
        return db.findAll()
    }

    fun findById(id: Long): Category {
        return db.findById(id).orElse(null)
    }

    fun create(categoryDTO: CategoryDTO): Category {
        val category = Category(
            category = categoryDTO.category
        )
        return db.save(category)
    }

    fun update(categoryDTO: CategoryDTO): Category {
        val category = Category(
            category = categoryDTO.category
        )
        return db.save(category)
    }

    fun delete(id: Long) {
        return db.deleteById(id)
    }

    fun existById(id: Long): Boolean {
        return db.existsById(id)
    }
}