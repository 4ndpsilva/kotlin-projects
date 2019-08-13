package app.financeapi.repository

import org.springframework.stereotype.Repository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.jpa.repository.JpaRepository

@NoRepositoryBean
interface BaseRepository<T>: JpaRepository<T, Long>{}