package com.neeraj.studentinfo.activity;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.neeraj.studentinfo.R;
import com.neeraj.studentinfo.data.model.Student;
import com.neeraj.studentinfo.data.sqlite.DatabaseHandler;
import com.neeraj.studentinfo.prsenter.PresenterValidationImplimentation;
import com.neeraj.studentinfo.view.IViewData;
import com.neeraj.studentinfo.view.IViewProgress;

public class DataInsertActivity extends AppCompatActivity implements View.OnClickListener ,IViewData,IViewProgress{


    EditText et_userName, et_userRollNo, et_userMathsMark, et_userScienceMark, et_userEnglishMark;
    Button bt_inserData;
    DatabaseHandler databaseHandler;
    ProgressDialog progressDialog;
    Student student;
    String roll_no,stud_name,maths_mark,english_mark,science_mark;
    PresenterValidationImplimentation pVI;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insert);

        initUi();
        clickListerners();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Call some material design APIs here
        } else {
            // Implement this feature without material design
        }

        toolbar.setTitle("Data Insert");
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait");

        pVI = new PresenterValidationImplimentation();

    }

    private void getEtValue() {
        roll_no=et_userRollNo.getText().toString().trim();
        stud_name=et_userName.getText().toString().trim();
        maths_mark=et_userMathsMark.getText().toString().trim();
        science_mark=et_userScienceMark.getText().toString().trim();
        english_mark=et_userEnglishMark.getText().toString().trim();
    }

    private void initUi() {


        //EditText
        et_userName = findViewById(R.id.et_userName);
        et_userRollNo = findViewById(R.id.et_userRollNo);
        et_userMathsMark = findViewById(R.id.et_userMathsMark);
        et_userScienceMark = findViewById(R.id.et_userScienceMark);
        et_userEnglishMark = findViewById(R.id.et_userEnglishMark);

        //Button
        bt_inserData = findViewById(R.id.bt_inserData);

        toolbar = findViewById(R.id.toolbar);
    }

    private void clickListerners() {
        bt_inserData.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_inserData:

                getEtValue();

                if(submit()){
                    showProgress();

                    student=new Student(Integer.parseInt(roll_no),
                            stud_name,
                            Integer.parseInt(maths_mark),
                            Integer.parseInt(science_mark),
                            Integer.parseInt(english_mark),
                            pVI.calculatePercentage(maths_mark, science_mark, english_mark));

                    databaseHandler=new DatabaseHandler(this);

                    boolean insert= databaseHandler.insertValue(student);

                    if(insert){
                        sccess();
                        hideProgrss();
                    }else {
                        hideProgrss();
                        Failuer();
                    }
                }


                break;
        }
    }




    @Override
    public void showRollNoError() {
        Toast.makeText(this, "Please enter valid roll no", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStudentNameError() {
        Toast.makeText(this, "Please enter valid Student Name", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showMathsMarkError() {
        Toast.makeText(this, "Please enter valid Maths MArk", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showScienceMarkError() {
        Toast.makeText(this, "Please enter valid Science Mark", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showEnglishMarkError() {
        Toast.makeText(this, "Please enter valid English Mark", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void sccess() {
        Toast.makeText(this, "Data insert SucessFully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Failuer() {
        Toast.makeText(this, "Data insertion fail", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean submit() {

        if(!pVI.validate_roll_no(roll_no)){
            showRollNoError();
            return false;
        }else if(!pVI.validate_student_name(stud_name)){
            showStudentNameError();
            return false;
        }else if(!pVI.validat_mark(maths_mark)){
            showMathsMarkError();
            return false;
        }else if(!pVI.validat_mark(science_mark)){
            showScienceMarkError();
            return false;
        }else if(!pVI.validat_mark(english_mark)){
           showEnglishMarkError();
            return false;
        }

        return true;
    }

    @Override
    public void showProgress() {
     // progressDialog.show();

    }

    @Override
    public void hideProgrss() {

        //progressDialog.hide();
    }


}
