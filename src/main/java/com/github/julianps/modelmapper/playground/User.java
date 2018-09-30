package com.github.julianps.modelmapper.playground;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "of")
public class User {

    private UUID id;

    private LocalDate created;

    private UserType type;

    private String firstName;

    private String lastName;

    private Address address;
}
