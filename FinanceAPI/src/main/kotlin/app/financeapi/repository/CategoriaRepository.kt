package app.financeapi.repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

import app.financeapi.entity.Categoria

@Repository
interface CategoriaRepository: BaseRepository<Categoria>{}