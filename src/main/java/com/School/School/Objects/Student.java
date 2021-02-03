package com.School.School.Objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//Класс студент
public class Student {
    private Integer id;
    private String name;
    private String group;
    private Date dateOfBirthday;

    public Integer getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name=name;
    }
    public String getGroup(){
        return group;
    }
    public void setGroup(){
        this.group=group;
    }
    public String getDateOfBirthday() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("Y-M-D");
        return df.format(dateOfBirthday);
    }
    public void setDateOfBirthday(){
        this.dateOfBirthday=dateOfBirthday;
    }
}
