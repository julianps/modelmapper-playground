package com.github.julianps.modelmapper.playground;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Address {

    private String addressLine;
    private String city;
    private String country;
}
