package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
//todo: change field names from reserved MySQL keywords
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String namer;

    @Column
    private String describer;

    @Column
    @Temporal(TemporalType.TIME)
    private Date dater;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User userr;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamer() {
        return namer;
    }

    public void setNamer(String name) {
        this.namer = name;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describe) {
        this.describer = describe;
    }

    public Date getDater() {
        return dater;
    }

    public void setDater(Date dater) {
        this.dater = dater;
    }

    public User getUser() {
        return userr;
    }

    public void setUser(User user) {
        this.userr = user;
    }
}
