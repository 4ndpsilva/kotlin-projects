package br.com.financeapi.repository

import br.com.financeapi.document.BaseDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseRepository<T : BaseDocument> : MongoRepository<T, String>