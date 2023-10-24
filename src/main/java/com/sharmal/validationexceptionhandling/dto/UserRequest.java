package com.sharmal.validationexceptionhandling.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "User's name should not be null")
    private String name;
    @Email(message = "Enter valid Email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered")
    private String mobile;
    private String gender;
    @Min(value = 18, message = "Minimum age should be 18")
    @Max(value = 60, message = "Maximum age should be 60")
    private int age;
    @NotBlank(message = "Nationality should not be blank")
    private String nationality;
}
