package com.jackli.greendao;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HistoryData {

    private String date;
    private String history;
    @Generated(hash = 895975915)
    public HistoryData(String date, String history) {
        this.date = date;
        this.history = history;
    }
    @Generated(hash = 422767273)
    public HistoryData() {
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getHistory() {
        return this.history;
    }
    public void setHistory(String history) {
        this.history = history;
    }
}
