package app.finance.api.repository

import app.finance.api.entity.Categoria
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository : BaseRepository<Categoria> {}