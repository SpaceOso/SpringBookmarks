package tech.spaceoso.bookmarks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.spaceoso.bookmarks.model.Account;
import tech.spaceoso.bookmarks.model.Bookmark;
import tech.spaceoso.bookmarks.repositories.AccountRepository;
import tech.spaceoso.bookmarks.repositories.BookmarkRepository;

import java.util.Arrays;

@SpringBootApplication
public class BookmarksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmarksApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository,
                           BookmarkRepository bookmarkRepository) {
        return (evt) -> Arrays.asList(
                "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,long".split(","))
                .forEach(
                        a -> {
                            Account account = accountRepository.save(new Account(a,
                                    "password"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/1/" + a, "A Description"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/2/" + a, "A description"));
                        }
                );
    }
}
