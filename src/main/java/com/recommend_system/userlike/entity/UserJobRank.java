package com.recommend_system.userlike.entity;

import java.io.Serializable;

public class UserJobRank extends UserJobRankKey implements Serializable {
    private Double grade;

    private static final long serialVersionUID = 1L;

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}