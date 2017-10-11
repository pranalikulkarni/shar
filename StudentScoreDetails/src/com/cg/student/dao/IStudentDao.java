package com.cg.student.dao;

import java.io.IOException;
import java.util.ArrayList;

import com.cg.student.bean.StudentInfo;
import com.cg.student.exception.StudentException;



public interface IStudentDao {

	int insert(StudentInfo bean) throws IOException;

	

	ArrayList<Integer> retrieveId() throws IOException, StudentException;

}
