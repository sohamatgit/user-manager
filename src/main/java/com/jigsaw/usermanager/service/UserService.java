package com.jigsaw.usermanager.service;


import com.jigsaw.usermanager.dto.UserDTO;
import java.util.List;

public interface UserService {

    UserDTO create(final UserDTO user);

    List<UserDTO> findAll();

    UserDTO single(final int id);

    UserDTO modify(final UserDTO user, final int id);

    void remove(final int id);

}
