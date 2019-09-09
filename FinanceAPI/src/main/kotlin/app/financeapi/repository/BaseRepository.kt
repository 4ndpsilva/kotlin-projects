package app.financeapi.repository

import org.springframework.stereotype.Repository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

import app.financeapi.entity.BaseEntity

@NoRepositoryBean
interface BaseRepository<T> : JpaRepository<T, Long>, JpaSpecificationExecutor<T> where T : BaseEntity<Long> {}