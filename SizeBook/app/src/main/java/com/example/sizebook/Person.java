package com.example.sizebook;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by PeterWeckend on 2017-01-28.
 */

public class Person implements Serializable{

    // no id generated here, didn't show up
    private String name;
    private Date date;
    private Float neck;
    private Float bust;
    private Float chest;
    private Float waist;
    private Float hip;
    private Float inseam;
    private String comment;


    public Person(String name) {
        this.name = name;
        //this.date = new Date();
    }

    public Person(String name, Float neck, Float bust, Float chest, Float waist, Float hip, Float inseam, String comment) {
        this.name = name;
        //this.date = date;
        this.neck = neck;
        this.bust = bust;
        this.chest = chest;
        this.waist = waist;
        this.hip = hip;
        this.inseam = inseam;
        this.comment = comment;
    }

    //@Override
    public String toString(){
        return getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getNeck() {
        return neck;
    }

    public void setNeck(Float neck) {
        this.neck = neck;
    }

    public Float getBust() {
        return bust;
    }

    public void setBust(Float bust) {
        this.bust = bust;
    }

    public Float getChest() {
        return chest;
    }

    public void setChest(Float chest) {
        this.chest = chest;
    }

    public Float getWaist() {
        return waist;
    }

    public void setWaist(Float waist) {
        this.waist = waist;
    }

    public Float getHip() {
        return hip;
    }

    public void setHip(Float hip) {
        this.hip = hip;
    }

    public Float getInseam() {
        return inseam;
    }

    public void setInseam(Float inseam) {
        this.inseam = inseam;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
