package com.jigsaw.usermanager.controller;

import com.jigsaw.usermanager.dto.UserDTO;
import com.jigsaw.usermanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user-manager/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserDTO create(@RequestBody UserDTO user){
        return userService.create(user);
    }

    @GetMapping
    public List<UserDTO> listUser(){
        return userService.findAll();
    }


    @GetMapping(value = "/{id}")
    public UserDTO single(@PathVariable(value = "id") Integer id){
        return userService.single(id);
    }

    @PutMapping(value = "/{id}")
    public UserDTO updateUser(@PathVariable(value = "id") Integer id, @RequestBody UserDTO user){
        return userService.modify(user, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer id){
        userService.remove(id);
    }


}
