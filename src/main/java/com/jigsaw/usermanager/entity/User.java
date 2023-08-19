package com.jigsaw.usermanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    public String firstname;

    @Column(nullable = false)
    public String lastname;

    @Column(nullable = false, unique = true)
    public String email;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Group> groups = new HashSet<>();
}