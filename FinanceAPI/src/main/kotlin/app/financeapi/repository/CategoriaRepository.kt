package app.financeapi.repository

import org.springframework.stereotype.Repository

import app.financeapi.entity.Categoria

@Repository
interface CategoriaRepository : BaseRepository<Categoria>, CommonSelect<Categoria> {}