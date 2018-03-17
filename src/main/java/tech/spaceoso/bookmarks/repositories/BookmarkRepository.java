package tech.spaceoso.bookmarks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.spaceoso.bookmarks.model.Bookmark;

import java.util.Collection;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Collection<Bookmark> findByAccountUsername(String username);
}
