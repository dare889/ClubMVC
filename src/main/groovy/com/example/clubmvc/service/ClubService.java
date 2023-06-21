package com.example.clubmvc.service;

import com.example.clubmvc.dto.ClubDto;
import com.example.clubmvc.models.Club;

import java.util.List;

/**
 * The interface Club service.
 */
public interface ClubService {
    /**
     * Find all clubs list.
     *
     * @return the list
     */
    List<ClubDto> findAllClubs();

    /**
     * Save club club.
     *
     * @param clubDto the club dto
     * @return the club
     */
    Club saveClub(ClubDto clubDto);

    /**
     * Find club by id club dto.
     *
     * @param clubId the club id
     * @return the club dto
     */
    ClubDto findClubById(long clubId);

    /**
     * Update club.
     *
     * @param club the club
     */
    void updateClub(ClubDto club);
    void deleteClub(long clubId);
    List<ClubDto> searchClubs(String query);
}
