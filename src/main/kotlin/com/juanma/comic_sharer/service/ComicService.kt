package com.juanma.comic_sharer.service

import com.juanma.comic_sharer.model.dto.ComicDTO
import com.juanma.comic_sharer.model.entity.Comic
import com.juanma.comic_sharer.repository.ComicRepository
import org.springframework.stereotype.Service

@Service
class ComicService(val db: ComicRepository) {

    fun findAll(): List<Comic> {
        return db.findAll()
    }

    fun findById(id: Long): Comic {
        return db.findById(id).orElse(null)
    }

    fun create(comicDTO: ComicDTO): Comic {
        val comic = Comic(
            title = comicDTO.title,
            author = comicDTO.author,
            releaseYear = comicDTO.releaseYear,
            genres = comicDTO.genres,
            categories = comicDTO.categories
        )
        return db.save(comic)
    }

    fun update(comicDTO: ComicDTO): Comic {
        val comic = Comic(
            title = comicDTO.title,
            author = comicDTO.author,
            releaseYear = comicDTO.releaseYear,
            genres = comicDTO.genres,
            categories = comicDTO.categories
        )
        return db.save(comic)
    }

    fun delete(id: Long) {
        return db.deleteById(id)
    }

    fun existById(id: Long): Boolean {
        return db.existsById(id)
    }
}