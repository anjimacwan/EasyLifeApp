package com.example.anjimacwan.easylifeapp.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Date.*;


/**
 * Created by Anji Macwan on 2016-11-01.
 */
public class Note {

    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public String getReadableModifiedDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy - h:mm a", Locale.getDefault());
        //sdf.setTimeZone(getDataModified().getTimeZone());
        //Date modifiedDate = getDataModified().getTime();
        //String displayDate = sdf.format(modifiedDate);
        //return displayDate;
        return  sdf.toString();
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getDataModified() {
        return dataModified;
    }

    public void setDataModified(Long dataModified) {
        this.dataModified = dataModified;
    }

    private String content;
    private Long dateCreated;
    private Long dataModified;
}
