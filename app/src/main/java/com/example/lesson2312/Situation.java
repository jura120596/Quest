package com.example.lesson2312;

public class Situation {
    Situation[] direction;
    String subject,text;
    int dCareer, dActives, dRating;

    public Situation(String subject, String text, int variants, int dk,int da,int dr) {
        this.subject=subject;
        this.text=text;
        this.dCareer = dk;
        this.dActives = da;
        this.dRating = dr;
        this.direction = new Situation[variants];
    }
}
