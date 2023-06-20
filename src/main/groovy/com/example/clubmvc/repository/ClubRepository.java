package com.example.clubmvc.repository;

import com.example.clubmvc.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
