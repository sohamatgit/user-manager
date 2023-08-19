package com.jigsaw.usermanager.controller;

import com.jigsaw.usermanager.dto.GroupDTO;
import com.jigsaw.usermanager.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user-manager/groups")
@RequiredArgsConstructor
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping
    public GroupDTO create(@RequestBody GroupDTO group){
        return groupService.create(group);
    }

    @GetMapping
    public List<GroupDTO> listGroup(){
        return groupService.findAll();
    }


    @GetMapping(value = "/{id}")
    public GroupDTO single(@PathVariable(value = "id") Integer id){
        return groupService.single(id);
    }

    @PutMapping(value = "/{id}")
    public GroupDTO updateGroup(@PathVariable(value = "id") Integer id, @RequestBody GroupDTO group){
        return groupService.modify(group, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGroup(@PathVariable(value = "id") Integer id){
        groupService.remove(id);
    }


}
