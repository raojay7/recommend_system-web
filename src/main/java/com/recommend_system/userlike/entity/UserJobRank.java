package com.recommend_system.userlike.entity;

import java.io.Serializable;

public class UserJobRank extends UserJobRankKey implements Serializable {
    private Integer grade;

    private static final long serialVersionUID = 1L;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}