package br.com.financeapi.service

import br.com.financeapi.document.Entry
import br.com.financeapi.repository.EntryRepository
import org.springframework.stereotype.Service

@Service
class EntryService(private var repository: EntryRepository) : BaseService<Entry>(repository)