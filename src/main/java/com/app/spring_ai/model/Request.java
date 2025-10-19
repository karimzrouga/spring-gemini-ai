package com.app.spring_ai.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Request {

    @NotBlank(message = "Le champ 'prompt' ne doit pas être vide.")
    @NotNull
    private String prompt;

}
