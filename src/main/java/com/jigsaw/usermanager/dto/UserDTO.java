package com.jigsaw.usermanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"createDate", "lastModifiedDate"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {

    private Integer userId;
    public String firstname;
    public String lastname;
    public String email;
}
