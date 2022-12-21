package com.example.myproject;

import lombok.Data;

@Data
public class queryForm {

    private String owner;

    private String repoName;

    @Override
    public String toString() {
        return "owner: " + owner + " repoName: " + repoName;
    }
}
