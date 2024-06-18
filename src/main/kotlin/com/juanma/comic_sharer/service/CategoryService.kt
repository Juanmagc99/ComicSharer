package com.juanma.comic_sharer.service

import com.juanma.comic_sharer.model.entity.Category
import com.juanma.comic_sharer.repository.CategoryRepository

class CategoryService(val db: CategoryRepository) {
    fun findAll(): List<Category> {
        return db.findAll()
    }

    fun findById(id: Long): Category {
        return db.findById(id).orElse(null)
    }

    fun create(category: Category): Category {
        return db.save(category)
    }

    fun update(category: Category): Any {
        if (db.existsById(category.id.toLong())){
            return db.save(category)
        } else {
            println("This Genre doesn't exists")
            return false
        }
    }

    fun delete(id: Long): Boolean {
        if (db.existsById(id)) {
            db.deleteById(id)
            return true
        } else {
            println("This Category doesn't exists")
            return false
        }
    }
}