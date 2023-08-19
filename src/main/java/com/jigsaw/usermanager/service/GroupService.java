package com.jigsaw.usermanager.service;

import com.jigsaw.usermanager.dto.GroupDTO;

import java.util.List;

public interface GroupService {

    GroupDTO create(final GroupDTO group);

    List<GroupDTO> findAll();

    GroupDTO single(final int id);

    GroupDTO modify(final GroupDTO group, final int id);

    void remove(final int id);
}
