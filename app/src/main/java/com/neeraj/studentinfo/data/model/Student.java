package com.neeraj.studentinfo.data.model;

/**
 * Created by neeraj on 10/2/18.
 */

public class Student {

     private int student_roll_no;
     private String student_name;
     private int student_maths_marks;
     private int student_science_marks;
     private int student_english_marks;
     private float student_percentage;
     private float student_id;

    public Student() {
    }

    public Student(int student_roll_no, String student_name, int student_maths_marks, int student_science_marks, int student_english_marks, float student_percentage) {
        this.student_roll_no = student_roll_no;
        this.student_name = student_name;
        this.student_maths_marks = student_maths_marks;
        this.student_science_marks = student_science_marks;
        this.student_english_marks = student_english_marks;
        this.student_percentage = student_percentage;

    }

    public float getStudent_id() {
        return student_id;
    }

    public void setStudent_id(float student_id) {
        this.student_id = student_id;
    }

    public int getStudent_roll_no() {
        return student_roll_no;
    }

    public void setStudent_roll_no(int student_roll_no) {
        this.student_roll_no = student_roll_no;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getStudent_maths_marks() {
        return student_maths_marks;
    }

    public void setStudent_maths_marks(int student_maths_marks) {
        this.student_maths_marks = student_maths_marks;
    }

    public int getStudent_science_marks() {
        return student_science_marks;
    }

    public void setStudent_science_marks(int student_science_marks) {
        this.student_science_marks = student_science_marks;
    }

    public int getStudent_english_marks() {
        return student_english_marks;
    }

    public void setStudent_english_marks(int student_english_marks) {
        this.student_english_marks = student_english_marks;
    }

    public float getStudent_percentage() {
        return student_percentage;
    }

    public void setStudent_percentage(float student_percentage) {
        this.student_percentage = student_percentage;
    }


}
