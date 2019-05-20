package com.example.demo.domain;

public class Summary {

    private int totalCount;
    private int startedCount;
    private int stoppedCount;

    public Summary() {
        this.totalCount = 0;
        this.startedCount = 0;
        this.stoppedCount = 0;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount() {
        this.totalCount++;

        //System.out.println("Aumento il total count");
    }

    public int getStartedCount() {
        return startedCount;
    }

    public void setStartedCount() {
        this.startedCount ++;

        //System.out.println("Aumento lo started count");
    }

    public int getStoppedCount() {
        return stoppedCount;
    }

    public void setStoppedCount() {
        this.stoppedCount++;

        //System.out.println("Aumento lo stopped count");
    }

    @Override
    public String toString() {
        return "Summary{" +
                "totalCount=" + totalCount +
                ", startedCount=" + startedCount +
                ", stoppedCount=" + stoppedCount +
                '}';
    }
}


