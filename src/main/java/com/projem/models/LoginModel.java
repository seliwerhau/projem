package com.projem.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;

public class LoginModel {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String slug;
    private String content;
    private String author;
    private LocalDateTime publishedOn;
    private LocalDateTime updatedOn;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public LocalDateTime getPublishedOn() {
        return publishedOn;
    }
    public void setPublishedOn(LocalDateTime publishedOn) {
        this.publishedOn = publishedOn;
    }
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
    public LoginModel(){

    }
    public LoginModel(String title, String slug, String content, String author) {
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.author = author;
        this.publishedOn = LocalDateTime.now();
        
    }
    @Override
    public String toString() {
        return "LoginModel [id=" + id + ", title=" + title + ", slug=" + slug + ", content=" + content + ", author="
                + author + ", publishedOn=" + publishedOn + ", updatedOn=" + updatedOn + "]";
    }

    

}
