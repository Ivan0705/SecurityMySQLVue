package com.security.demo.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "usr")
@Data
public class User implements Serializable {
    @Id
    @Column(length = 250)
    private String id;
    private String name;
    private String email;
    private String gender;
    private String locale;
    private LocalDateTime lastVisit;
}