package com.neeraj.studentinfo.prsenter;

/**
 * Created by neeraj on 10/2/18.
 */

public interface InterfacePresenterValidateData {


    boolean validate_roll_no(String roll_no);

    boolean validate_student_name(String stud_name);

    boolean validat_mark(String mark);

    float calculatePercentage(String maths,String science,String english);

}
