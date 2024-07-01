package com.juanma.comic_sharer.service

import com.juanma.comic_sharer.model.dto.ComicDTO
import com.juanma.comic_sharer.model.entity.Comic
import com.juanma.comic_sharer.repository.ComicRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ComicService @Autowired constructor(
    val db: ComicRepository,
    val genreService: GenreService,
    val categoryService: CategoryService
) {

    fun findAll(): List<Comic> {
        return db.findAll()
    }

    fun findById(id: Long): Comic {
        return db.findById(id).orElse(null)
    }

    fun create(comicDTO: ComicDTO): Comic {
        val genres = genreService.findAllById(comicDTO.genres)
        val categories = categoryService.findAllById(comicDTO.genres)
        val comic = Comic(
            title = comicDTO.title,
            author = comicDTO.author,
            releaseYear = comicDTO.releaseYear,
            genres = genres,
            categories = categories
        )
        return db.save(comic)
    }

    fun update(comicDTO: ComicDTO, id: Long): Comic {
        val genres = genreService.findAllById(comicDTO.genres)
        val categories = categoryService.findAllById(comicDTO.genres)
        val comic = findById(id)
        comic.title = comicDTO.title
        comic.author = comicDTO.author
        comic.releaseYear = comicDTO.releaseYear
        comic.genres = genres
        comic.categories = categories
        return db.save(comic)
    }

    fun delete(id: Long) {
        return db.deleteById(id)
    }

    fun existById(id: Long): Boolean {
        return db.existsById(id)
    }

    fun findByTitle(title: String): Comic {
        return db.findByTitle(title)
    }

    fun existsByTitle(title: String): Boolean {
        return db.existsByTitle(title)
    }
}