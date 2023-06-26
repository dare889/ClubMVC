package com.example.clubmvc.controller;

import com.example.clubmvc.dto.ClubDto;
import com.example.clubmvc.models.Club;
import com.example.clubmvc.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Club controller.
 */
@Controller
public class ClubController {
    private ClubService clubService;

    /**
     * Instantiates a new Club controller.
     *
     * @param clubService the club service
     */
    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    /**
     * List clubs string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/")
    public String index(Model model){
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs",clubs);
        return "clubs-list";
    }

    /**
     * List clubs string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs",clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model){
        List<ClubDto> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    /**
     * Create club form string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    /**
     * Save club string.
     *
     * @param clubDto the club dto
     * @param result  the result
     * @return the string
     */
    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto,
                           BindingResult result) {
        if(result.hasErrors()){
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

    /**
     * Club detail string.
     *
     * @param clubId the club id
     * @param model  the model
     * @return the string
     */
    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") long clubId, Model model) {
        ClubDto clubDto = clubService.findClubById(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-detail";
    }

    /**
     * Edit club form string.
     *
     * @param clubId the club id
     * @param model  the model
     * @return the string
     */
    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model) {
        ClubDto clubDto = clubService.findClubById(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-edit";
    }

    /**
     * Update club string.
     *
     * @param clubId the club id
     * @param club   the club
     * @param result the result
     * @return the string
     */
    @PostMapping("clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId,
                             @Valid @ModelAttribute("club") ClubDto club,
                             BindingResult result) {
        if(result.hasErrors()){
            return "clubs-edit";
        }
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

    /**
     * Delete club string.
     *
     * @param clubId the club id
     * @return the string
     */
    @GetMapping("clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId){
        clubService.deleteClub(clubId);
        return "redirect:/clubs";
    }
}
