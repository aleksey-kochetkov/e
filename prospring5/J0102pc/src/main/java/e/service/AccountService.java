package e.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import e.model.Account;
import e.repository.AccountRepository;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Transactional
    public void createAccount(Account account) {
        this.accountRepository.persist(account);
    }

    @Transactional(readOnly = true)
    public List<Account> findAllAccounts() {
        return (List<Account>) this.accountRepository.findAll();
    }

    @Autowired
    public void setAccountRepository(
                                   AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
