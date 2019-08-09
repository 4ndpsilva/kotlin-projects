package app.financeapi.repository

import org.springframework.data.jpa.repository.JpaRepository

import app.financeapi.entity.Categoria

interface CategoriaRepository: JpaRepository<Categoria, Long>{}