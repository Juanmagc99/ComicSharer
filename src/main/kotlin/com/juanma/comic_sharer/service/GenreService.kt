package com.juanma.Genre_sharer.service

import com.juanma.comic_sharer.model.dto.GenreDTO
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

    fun create(genreDTO: GenreDTO): Genre {
        val genre = Genre(
            genre = genreDTO.genre
        )
        return db.save(genre)
    }

    fun update(genreDTO: GenreDTO): Genre {
        val genre = Genre(
            genre = genreDTO.genre
        )
        return db.save(genre)
    }

    fun delete(id: Long) {
        return db.deleteById(id)
    }

    fun existById(id: Long): Boolean {
        return db.existsById(id)
    }
}