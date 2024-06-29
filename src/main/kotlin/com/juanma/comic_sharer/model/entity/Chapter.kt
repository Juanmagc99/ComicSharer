package com.juanma.comic_sharer.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.nio.file.Path

@Entity(name = "chapters")
class Chapter(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @NotBlank
    val chap_number: Int = 0,

    @NotBlank
    val where_save: String = "",

    @ManyToOne
    @JoinColumn(name = "comic_id", nullable = false)
    val comic: Comic
)