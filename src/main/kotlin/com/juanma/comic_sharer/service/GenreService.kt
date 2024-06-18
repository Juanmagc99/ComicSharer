package com.juanma.Genre_sharer.service

import com.juanma.comic_sharer.model.entity.Genre
import com.juanma.comic_sharer.repository.GenreRepository
import org.springframework.stereotype.Service

@Service
class GenreService(val  db: GenreRepository) {

    fun findAll(): List<Genre> {
        return db.findAll()
    }

    fun findById(id: Long): Genre {
        return db.findById(id).orElse(null)
    }

    fun create(genre: Genre): Genre {
        return db.save(genre)
    }

    fun update(genre: Genre): Any {
        if (db.existsById(genre.id.toLong())){
            return db.save(genre)
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
            println("This Genre doesn't exists")
            return false
        }
    }
}