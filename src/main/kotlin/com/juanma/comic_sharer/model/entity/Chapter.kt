package com.juanma.comic_sharer.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.nio.file.Path

@Entity(name = "chapters")
class Chapter(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotBlank
    var chapNumber: Int = 0,

    @ManyToOne
    @JoinColumn(name = "comic_id", nullable = false)
    var comic: Comic
)