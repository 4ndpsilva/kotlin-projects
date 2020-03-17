package br.com.lotominer.repository

import br.com.lotominer.document.LotoFacil
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface LotoFacilRepository : MongoRepository<LotoFacil, String>{
    fun findByContestNumber(contest: Int): LotoFacil?
    fun deleteByContestNumber(contest: Int): Unit
}