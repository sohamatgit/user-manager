package com.jigsaw.usermanager.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jigsaw.usermanager.dto.GroupDTO;
import com.jigsaw.usermanager.entity.Group;
import com.jigsaw.usermanager.exception.UserManagerException;
import com.jigsaw.usermanager.repository.GroupRepository;
import com.jigsaw.usermanager.service.GroupService;
import com.jigsaw.usermanager.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public GroupDTO create(GroupDTO group) {
        try{
            Group groupResponse = groupRepository.save(objectMapper.convertValue(group, Group.class));
            return objectMapper.convertValue(groupResponse, GroupDTO.class);
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }

    @Override
    public List<GroupDTO> findAll() {
        try{
            List<Group> groupResponse = groupRepository.findAll();
            List<GroupDTO> groups = new ArrayList<>();
            groupResponse.stream().forEach(group -> groups.add(objectMapper.convertValue(group, GroupDTO.class)));
            return groups;
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }

    @Override
    public GroupDTO single(int id) {
        try{
            Group groupResponse = groupRepository.findById(id).get();
            return objectMapper.convertValue(groupResponse, GroupDTO.class);
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }

    @Override
    public GroupDTO modify(GroupDTO group, int id) {
        try{
            Group groupToModify = groupRepository.findById(id).get();
            groupToModify.setDescription(group.getDescription());
            Group groupResponse = groupRepository.save(groupToModify);
            return objectMapper.convertValue(groupResponse, GroupDTO.class);
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }

    @Override
    public void remove(int id) {
        try{
            groupRepository.deleteById(id);
        } catch (Exception e){
            throw new UserManagerException(Constants.SERVER_ERROR ,e.getLocalizedMessage());
        }
    }
}