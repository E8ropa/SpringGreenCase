package com.example.springgreencase.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="files")
public class FileTable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "description")
    private String description;
    @Column(name = "filedata")
    private byte[] filedata;

    public FileTable(String title, byte[] filedata, String description) {
        this.title=title;
        this.filedata=filedata;
        this.creationDate=LocalDateTime.now();
        this.description=description;

    }
    public FileTable(Integer id, String title, byte[] filedata, String description) {
        this.id=id;
        this.title=title;
        this.filedata=filedata;
        this.creationDate=LocalDateTime.now();
        this.description=description;

    }
    public FileTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreation_date() {
        return creationDate;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creationDate = creation_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFiledata() {
        return filedata;
    }

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }
}
