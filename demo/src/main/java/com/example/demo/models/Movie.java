package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "movies")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "like")
    private Boolean like;

    @Column(name = "rate")
    private int rate;

    @Column(name = "review")
    private String review;

//getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

//constructors
    public Movie(long id, String name, Boolean like, int rate, String review) {
        this.id = id;
        this.name = name;
        this.like = like;
        this.rate = rate;
        this.review = review;
    }
    public Movie() {
    }

//toString
    @Override
    public String toString() {
        return "Movie [id=" + id + ", like=" + like + ", name=" + name + ", rate=" + rate + ", review=" + review + "]";
    }

}
