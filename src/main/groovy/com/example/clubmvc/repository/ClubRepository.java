package com.example.clubmvc.repository;

import com.example.clubmvc.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * The interface Club repository.
 */
public interface ClubRepository extends JpaRepository<Club, Long> {
    /**
     * Find by title optional.
     *
     * @param url the url
     * @return the optional
     */
    Optional<Club> findByTitle(String url);

    /**
     * Search clubs list.
     *
     * @param query the query
     * @return the list
     */
    @Query("SELECT c from Club c WHERE c.title LIKE CONCAT('%', :query, '%')")
    List<Club> searchClubs(@Param("query") String query);
}
