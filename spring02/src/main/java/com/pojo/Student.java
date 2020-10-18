package com.pojo;

import java.util.Map;

public class Student {
    private Teacher teacher;
    private int stuid;
    private String stuname ;
    private String[] loves;
    private Map other;

    public Map getOther() {
        return other;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setOther(Map other) {
        this.other = other;
    }

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }
}
