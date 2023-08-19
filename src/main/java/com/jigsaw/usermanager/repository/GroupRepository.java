package com.jigsaw.usermanager.repository;

import com.jigsaw.usermanager.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>, JpaSpecificationExecutor<Group> {

}
