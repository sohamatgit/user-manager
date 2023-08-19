package com.jigsaw.usermanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"createDate", "lastModifiedDate"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDTO implements Serializable {

    private Integer groupId;
    public String groupName;
    public String description;
}

