package com.example.demo.movie;

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
    public Movie(long id, String name, int rate, String review) {
        super();
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.review = review;
    }
    public Movie() {
        super();
    }

//toString
    @Override
    public String toString() {
        return "Movie [id=" + id + ", name=" + name + ", rate=" + rate + ", review=" + review + "]";
    }

}
