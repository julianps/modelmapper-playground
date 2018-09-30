package com.github.julianps.modelmapper.playground;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class UserDTO {

    private LocalDate created;

    private UserType type;

    private String firstName;

    private String lastName;

    private Address address;
}
