package me.study.unittest;

import lombok.Getter;

@Getter
public class Report {

    private final int numberOfUsers;

    public Report(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
}
