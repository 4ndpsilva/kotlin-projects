package app.finance.api.repository

import app.finance.api.entity.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseRepository<T> : JpaRepository<T, Long>, JpaSpecificationExecutor<T> where T : BaseEntity {}