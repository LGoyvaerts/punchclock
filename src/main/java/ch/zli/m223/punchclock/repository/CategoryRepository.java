package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.id = 1")
    Category findFirstCategory();
}
