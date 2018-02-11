package com.neeraj.studentinfo.prsenter;

/**
 * Created by neeraj on 10/2/18.
 */

public class PresenterValidationImplimentation implements InterfacePresenterValidateData {


    @Override
    public boolean validate_roll_no(String roll_no) {

        if(roll_no.isEmpty()){
            return false;
        }

        return true;

    }

    @Override
    public boolean validate_student_name(String stud_name) {

        return !stud_name.isEmpty();
    }

    @Override
    public boolean validat_mark(String mark) {

        if(mark.isEmpty()){
            return false;
        }else if (Integer.parseInt(mark) > 100){
            return false;
        }

        return true;
    }


    @Override
    public float calculatePercentage(String maths, String science, String english) {

        float percentage;
        int total=Integer.parseInt(maths) + Integer.parseInt(science) + Integer.parseInt(english) ;
        percentage=(float) total/3;
        return percentage;

    }


}
