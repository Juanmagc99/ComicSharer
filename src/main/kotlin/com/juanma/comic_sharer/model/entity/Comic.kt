package com.juanma.comic_sharer.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
class Comic (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotBlank
    val title: String = "",

    @NotBlank
    val author: String = "",

    @NotBlank
    val releaseYear: Int = 0,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "comic_genre",
        joinColumns = [JoinColumn(name = "comic_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    @JsonManagedReference
    val genres: Set<Genre> = setOf(),

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "comic_category",
        joinColumns = [JoinColumn(name = "comic_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    @JsonManagedReference
    val categories: Set<Category> = setOf()
)