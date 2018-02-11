package com.neeraj.studentinfo.data.sqlite;

import com.neeraj.studentinfo.data.model.Student;

import java.util.List;

/**
 * Created by neeraj on 10/2/18.
 */

public interface InterfaceSqlitData {

    boolean insertValue(Student  student);

    List<Student> fetchValue();

}
