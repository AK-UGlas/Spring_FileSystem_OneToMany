package com.codeclan.folder_service.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

// This is another ship (one to many)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Folder> dirList;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getDirList() {
        return dirList;
    }

    public void setDirList(List<Folder> dirList) {
        this.dirList = dirList;
    }

    public void addFolder(Folder folder) {
        dirList.add(folder);
    }
}

