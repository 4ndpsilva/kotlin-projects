package br.com.financeapi.service

import br.com.financeapi.document.Account
import br.com.financeapi.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(private var repository: AccountRepository) : BaseService<Account>(repository)