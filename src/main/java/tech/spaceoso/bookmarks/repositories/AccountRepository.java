package tech.spaceoso.bookmarks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.spaceoso.bookmarks.model.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
