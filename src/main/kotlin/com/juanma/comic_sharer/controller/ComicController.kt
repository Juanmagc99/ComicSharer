package com.juanma.comic_sharer.controller

import com.juanma.comic_sharer.model.dto.ComicDTO
import com.juanma.comic_sharer.model.entity.Comic
import com.juanma.comic_sharer.service.ComicService
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/comics")
class ComicController(private val comicService: ComicService) {

    @GetMapping("/{id}")
    fun getComic(
        @PathVariable id: Long
    ): ResponseEntity<Any> {
        try {
            if (comicService.existById(id)){
                return ResponseEntity.ok(comicService.findById(id))
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This comic doesnt exists")
            }
        } catch (ext: DataAccessException) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong")
        }
    }

    @GetMapping
    fun getAllComics(): ResponseEntity<Any> {
        val comics = comicService.findAll()
        println(comics)
        return if (comics.isNotEmpty()) {
            ResponseEntity.ok(comics)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @PostMapping
    fun create(
        @RequestBody comicDTO: ComicDTO
    ): ResponseEntity<Any> {
        val comic: Comic?
        try {
            comic = comicService.create(comicDTO)
            return ResponseEntity.status(HttpStatus.OK).body(comicDTO)
        } catch (ext: DataAccessException) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong")
        }
    }

    @PutMapping("/{id}")
    fun update(
        @RequestBody comicDTO: ComicDTO,
        @PathVariable id: Long
    ): ResponseEntity<Any> {
        val comicUpdate: Comic?
        try {
            if (comicService.existById(id)) {
                comicUpdate = comicService.update(comicDTO, id)
                return ResponseEntity.status(HttpStatus.OK).body(comicDTO)
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This comic doesnt exists")
            }
        } catch (ext: DataAccessException) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong")
        }
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long
    ): ResponseEntity<Any> {
        try {
            if (comicService.existById(id)) {
                comicService.delete(id)
                return ResponseEntity.status(HttpStatus.OK).body("Comic deleted")
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This comic doesnt exists")
            }
        } catch (ext: DataAccessException) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong")
        }
    }
}