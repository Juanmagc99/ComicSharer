package com.juanma.comic_sharer.repository

import com.juanma.comic_sharer.model.entity.Chapter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChapterRepository: JpaRepository<Chapter, Long> {
}