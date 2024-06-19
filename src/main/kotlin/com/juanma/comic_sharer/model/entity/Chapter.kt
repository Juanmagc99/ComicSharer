package com.juanma.comic_sharer.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity(name = "chapters")
class Chapter(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val chap_number: Int = 0,

    @ManyToOne
    @JoinColumn(name = "comic_id", nullable = false)
    val comic: Comic
)