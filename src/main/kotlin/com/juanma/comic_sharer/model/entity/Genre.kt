package com.juanma.comic_sharer.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.validation.constraints.NotBlank

@Entity
class Genre (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @NotBlank
    val genre: String = "",

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    val comics: Set<Comic> = setOf(),
)