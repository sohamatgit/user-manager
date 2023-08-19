package com.jigsaw.usermanager.controller;

import com.jigsaw.usermanager.dto.GroupDTO;
import com.jigsaw.usermanager.service.GroupService;
import com.jigsaw.usermanager.service.impl.UserGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user-manager")
@RequiredArgsConstructor
public class UserGroupController {

    @Autowired
    UserGroupService userGroupService;

    @PostMapping(value = "/group/{groupId}/user/{userId}")
    public void createMapping(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "groupId") Integer groupId){
        userGroupService.addUserToGroup(userId, groupId);
    }

    @DeleteMapping(value = "/group/{groupId}/user/{userId}")
    public void deleteMapping(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "groupId") Integer groupId){
        userGroupService.removeUserFromGroup(userId, groupId);
    }


}
