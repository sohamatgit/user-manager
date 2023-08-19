package com.jigsaw.usermanager.service.impl;

import com.jigsaw.usermanager.entity.Group;
import com.jigsaw.usermanager.entity.User;
import com.jigsaw.usermanager.exception.UserManagerException;
import com.jigsaw.usermanager.repository.GroupRepository;
import com.jigsaw.usermanager.repository.UserRepository;
import com.jigsaw.usermanager.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserGroupService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;


    public void addUserToGroup(Integer userId, Integer groupId){

        Optional<User> user = userRepository.findById(userId);
        Optional<Group> group = groupRepository.findById(groupId);

        if (user.isPresent() && group.isPresent()) {
            if(group.get().getUsers().contains(user.get())){
                throw new UserManagerException(Constants.SERVER_ERROR, "User already in the Group");
            }
            group.get().getUsers().add(user.get());
            groupRepository.save(group.get());
        } else {
            throw new UserManagerException(Constants.SERVER_ERROR, "User/Group Not present");
        }
    }

    public void removeUserFromGroup(Integer userId, Integer groupId){

        Optional<User> user = userRepository.findById(userId);
        Optional<Group> group = groupRepository.findById(groupId);

        if (user.isPresent() && group.isPresent()) {
            if(!group.get().getUsers().contains(user.get())){
                throw new UserManagerException(Constants.SERVER_ERROR, "User already not in the Group");
            }
            group.get().getUsers().remove(user.get());
            groupRepository.save(group.get());
        } else {
            throw new UserManagerException(Constants.SERVER_ERROR, "User/Group Not present");
        }
    }
}
