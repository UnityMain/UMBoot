package com.unitymain.core.utils;

import java.util.List;

public class DoubleColorBall {
    private String blueBall;
    private List<String> redBall;

    public String getBlueBall() {
        return blueBall;
    }

    public void setBlueBall(String blueBall) {
        this.blueBall = blueBall;
    }

    public List<String> getRedBall() {
        return redBall;
    }

    public void setRedBall(List<String> redBall) {
        this.redBall = redBall;
    }

    @Override
    public String toString() {
        return "DoubleColorBall{" +
                "blueBall='" + blueBall + '\'' +
                ", redBall=" + redBall +
                '}';
    }
}
