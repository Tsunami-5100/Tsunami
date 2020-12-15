/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.KClass;


import Business.Resident.Resident;
import Business.Role.ResidentRole;
import Business.WorkQueue.WorkRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Unicorn
 */
public class KClass {
    private String className;
    private String teacherName;
    private int teacherId;
    private String classType;
    private int capacity;
    private int remainPlaces;
    private String deadline;
    private String startDate;
    private String endDate;
    private String teacherUserName;
    
    public int studentNum = 0;

    public KClass() {
        this.className = className;
        this.teacherName = teacherName;
        this.classType = classType;
        this.capacity = capacity;
        this.deadline = deadline;
        this.startDate = startDate;
        this.endDate = endDate;
    }  
    
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
    
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRemainPlaces() {
        return remainPlaces;
    }

    public void setRemainPlaces(int remainPlaces) {
        this.remainPlaces = remainPlaces;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getTeacherUserName() {
        return teacherUserName;
    }

    public void setTeacherUserName(String teacherUserName) {
        this.teacherUserName = teacherUserName;
    }
    
    @Override
    public String toString() {
        return className;
    }
   
}
