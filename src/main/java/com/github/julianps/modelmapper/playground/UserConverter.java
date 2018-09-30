package com.github.julianps.modelmapper.playground;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.modelmapper.ModelMapper;

public class UserConverter {

    private static ModelMapper modelMapper = new ModelMapper();

    public static UserDTO toUserDTO(final User user) {
        UserDTO result = null;
        if (user == null) {
            return result;
        } else {
            result = new UserDTO();
            result.setCreated(user.getCreated());
            result.setType(user.getType());
            result.setAddress(user.getAddress());
            result.setFirstName(user.getFirstName());
            result.setLastName(user.getLastName());
            return result;
        }
    }

    public static UserDTO toUserDTOwithModelMapper(final User user) {
        return modelMapper.map(user, UserDTO.class);
    }

}
