package com.juanma.comic_sharer.controller

import com.juanma.comic_sharer.service.ChapterService
import com.juanma.comic_sharer.service.ComicService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("api/v1/chapter")
class ChapterController @Autowired constructor(
    private val chapterService: ChapterService,
    private val comicService: ComicService
) {

    @PostMapping("/{title}/{num}")
    fun create(
        @PathVariable title: String,
        @PathVariable num: Int,
        @RequestParam chapterData: MultipartFile
    ){

            if (comicService.existsByTitle(title)){
                chapterService.create(num, title, chapterData)
            }


    }
}