package com.imagehoster.ImageHosterApplication.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "images")
public class Image {

    //id of the image
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    //title of the image
    @Column(name = "title")
    private String title;

    //The image in Base64 format
    @Column(name = "imageFile")
    private String imageFile;

    //Description of the image
    @Column(name = "description")
    private String description;

    //Date on which the image is posted
    @Column(name = "date")
    private Date date;

    //Write the constructor for id, title, imageFile, and date
    public Image(Integer id, String title, String imageFile, Date date) {
        this.id = id;
        this.title = title;
        this.imageFile = imageFile;
        this.date = date;
    }

    //relationship between image and user
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    //getter and setter for relationship

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    //getter and setter for image

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

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Write getter and setter for all the attributes

}
