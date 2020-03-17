package br.com.lotominer.service

import br.com.lotominer.document.LotoFacil
import br.com.lotominer.exception.ResourceNotFoundException
import br.com.lotominer.repository.LotoFacilRepository
import org.springframework.stereotype.Service

@Service
class LotoFacilService(private var repository: LotoFacilRepository) {
    fun save(entities: List<LotoFacil>): List<LotoFacil> = repository.saveAll(entities)

    fun save(entity: LotoFacil) = repository.save(entity)

    fun deleteAll() = repository.deleteAll()

    fun deleteByContest(contest: Int) = repository.deleteByContestNumber(contest)

    fun findByContest(contest: Int): LotoFacil {
        val entity = repository.findByContestNumber(contest)
        return entity ?: throw ResourceNotFoundException("Concurso não encontrado")
    }

    fun count() = repository.count()

    fun findAll(): List<LotoFacil> = repository.findAll()
}