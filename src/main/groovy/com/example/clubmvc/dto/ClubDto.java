package com.example.clubmvc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * The type Club dto.
 * DTO (Data Transfer Objects) are objects that transfer
 * data between processes to reduce the number of method calls
 *
 */
@Data
@Builder
public class ClubDto {
    private Long id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "Photo link should not be empty")
    private String photoUrl;
    @NotEmpty(message = "Content should not be empty")
    private String content;
    private LocalDateTime createOn;
    private LocalDateTime updateOn;
}
