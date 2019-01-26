package com.beniregev.model;

import java.util.Date;

public class Schedule {
    private Date scheduledStartTime;
    private Integer allotedDurationMs;
    private Integer allotedBufferMs;
    private Integer actualDurationMs;

    public Schedule() {
        //  Default
    }

    public Date getScheduledStartTime() {
        return scheduledStartTime;
    }

    public void setScheduledStartTime(Date scheduledStartTime) {
        this.scheduledStartTime = scheduledStartTime;
    }

    public Integer getAllotedDurationMs() {
        return allotedDurationMs;
    }

    public void setAllotedDurationMs(Integer allotedDurationMs) {
        this.allotedDurationMs = allotedDurationMs;
    }

    public Integer getAllotedBufferMs() {
        return allotedBufferMs;
    }

    public void setAllotedBufferMs(Integer allotedBufferMs) {
        this.allotedBufferMs = allotedBufferMs;
    }

    public Integer getActualDurationMs() {
        return actualDurationMs;
    }

    public void setActualDurationMs(Integer actualDurationMs) {
        this.actualDurationMs = actualDurationMs;
    }
}
