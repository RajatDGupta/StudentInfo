package com.neeraj.studentinfo.view;

/**
 * Created by neeraj on 10/2/18.
 */

public interface IViewData {

    void showRollNoError();

   void showStudentNameError();

   void showMathsMarkError();

   void showScienceMarkError();

   void showEnglishMarkError();

   void sccess();

   void Failuer();

   boolean submit();

}
