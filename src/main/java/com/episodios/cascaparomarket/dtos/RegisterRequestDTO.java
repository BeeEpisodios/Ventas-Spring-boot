package com.episodios.cascaparomarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequestDTO {
    private String userName;
    private String userEmail;
    private String userPassword;
}
