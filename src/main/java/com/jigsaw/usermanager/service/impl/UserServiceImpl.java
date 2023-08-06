package com.jigsaw.usermanager.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jigsaw.usermanager.dto.UserDTO;
import com.jigsaw.usermanager.entity.User;
import com.jigsaw.usermanager.exception.UserManagerException;
import com.jigsaw.usermanager.repository.UserRepository;
import com.jigsaw.usermanager.service.UserService;
import com.jigsaw.usermanager.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserDTO create(UserDTO user) {
        try{
            User userResponse = userRepository.save(objectMapper.convertValue(user, User.class));
            return objectMapper.convertValue(userResponse, UserDTO.class);
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }

    @Override
    public List<UserDTO> findAll() {
        try{
            List<User> userResponse = userRepository.findAll();
            List<UserDTO> users = new ArrayList<>();
            userResponse.stream().forEach(user -> users.add(objectMapper.convertValue(user, UserDTO.class)));
            return users;
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }

    @Override
    public UserDTO single(int id) {
        try{
            User userResponse = userRepository.findById(id).get();
            return objectMapper.convertValue(userResponse, UserDTO.class);
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }

    @Override
    public UserDTO modify(UserDTO user, int id) {
        try{
            User userToModify = userRepository.findById(id).get();
            userToModify.setFirstname(user.getFirstname());
            userToModify.setLastname(user.getLastname());
            userToModify.setEmail(user.getEmail());
            User userResponse = userRepository.save(userToModify);
            return objectMapper.convertValue(userResponse, UserDTO.class);
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }

    @Override
    public void remove(int id) {
        try{
            userRepository.deleteById(id);
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }
}