package com.juanma.comic_sharer.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity(name = "comics")
class Comic (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotBlank
    var title: String = "",

    @NotBlank
    var author: String = "",

    @NotBlank
    var releaseYear: Int = 0,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "comic_genre",
        joinColumns = [JoinColumn(name = "comic_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    @JsonManagedReference
    var genres: Set<Genre> = setOf(),

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "comic_category",
        joinColumns = [JoinColumn(name = "comic_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    @JsonManagedReference
    var categories: Set<Category> = setOf(),

    @OneToMany(mappedBy = "comic")
    @JsonManagedReference
    var chapters: Set<Chapter> = setOf()
)