package com.jigsaw.usermanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    public String firstname;

    @Column(nullable = false)
    public String lastname;

    @Column(nullable = false, unique = true)
    public String email;

}