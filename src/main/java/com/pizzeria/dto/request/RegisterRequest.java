package com.pizzeria.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @NotBlank(message = "el apellido es obligatorio")
        String lastname,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El formato del correo no es válido")
        String email,

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 6 , message = "La contraseña debe tener al menos 6 caracteres")
        String password

) {
}
