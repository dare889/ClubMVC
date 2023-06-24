package com.example.clubmvc.service.impl

import com.example.clubmvc.dto.ClubDto
import com.example.clubmvc.models.Club
import com.example.clubmvc.repository.ClubRepository
import com.example.clubmvc.service.ClubService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

import java.util.List
import java.util.stream.Collectors

/**
 * The type Club service.
 */
@Service
class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository

    /**
     * Instantiates a new Club service.
     *
     * @param clubRepository the club repository
     */
    @Autowired
    ClubServiceImpl(ClubRepository clubRepository){
        this.clubRepository = clubRepository
    }

    @Override
    List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll()
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList())
    }

    @Override
    Club saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto)
        return clubRepository.save(club)
    }

    @Override
    ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get()
        return mapToClubDto(club)
    }

    @Override
    void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto)
        clubRepository.save(club)
    }

    @Override
    void deleteClub(long clubId) {
        clubRepository.deleteById(clubId)
    }

    @Override
    List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query)
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList())
    }

    private Club mapToClub(ClubDto club) {
        Club clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .build()
        return clubDto
    }

    private ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .build()
        return clubDto
    }
}
