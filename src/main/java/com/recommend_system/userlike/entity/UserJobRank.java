package com.recommend_system.userlike.entity;

import java.io.Serializable;

public class UserJobRank extends UserJobRankKey implements Serializable {
    private Float grade;

    private static final long serialVersionUID = 1L;

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
}