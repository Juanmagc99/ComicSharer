package com.juanma.comic_sharer.service

import com.juanma.comic_sharer.model.dto.ChapterDTO
import com.juanma.comic_sharer.model.dto.ComicDTO
import com.juanma.comic_sharer.model.entity.Chapter
import com.juanma.comic_sharer.model.entity.Comic
import com.juanma.comic_sharer.repository.ChapterRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.Path

@Service
class ChapterService @Autowired constructor(
    val db: ChapterRepository,
    val comicService: ComicService
) {
    fun findAll(): List<Chapter> {
        return db.findAll()
    }

    fun findById(id: Long): Chapter {
        return db.findById(id).orElse(null)
    }

    @Transactional
    fun create(num: Int, title: String, data: MultipartFile): Chapter {
        val comic = comicService.findByTitle(title)
        val directory = "D:\\data"
        val path = Paths.get(directory, data.originalFilename)

        try {
            Files.createDirectories(path.parent) // Asegura que el directorio exista
            Files.write(path, data.bytes)
        } catch (e: IOException) {
            throw RuntimeException("Error al guardar el archivo", e)
        }

        val chapter = Chapter(
            chapNumber = num,
            comic = comic
        )
        return db.save(chapter)
    }

    fun update(chapterDTO: ChapterDTO, id: Long): Chapter {
        val comic = comicService.findById(chapterDTO.comicID)
        val chapter = findById(id)
        chapter.chapNumber = chapterDTO.chapNumber
        chapter.comic = comic
        return db.save(chapter)
    }

    fun delete(id: Long) {
        return db.deleteById(id)
    }

    fun existById(id: Long): Boolean {
        return db.existsById(id)
    }
}