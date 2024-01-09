package com.quickbite.businesslogic.Dto.User;

public record UserDTO(
        Long id,
        String firstname,
        String lastname,
        String email,
        int age,
        String avaImageUrl
) {
}
