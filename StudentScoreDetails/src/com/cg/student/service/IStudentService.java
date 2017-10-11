package com.cg.student.service;

import java.io.IOException;
import java.util.ArrayList;

import com.cg.student.bean.StudentInfo;
import com.cg.student.exception.StudentException;



public interface IStudentService {



	ArrayList<Integer> retrieveId() throws IOException, StudentException;

	int insert(StudentInfo bean) throws IOException;

	

	String givegrade(int total);

	int calculateTotal(int theory, int mcq, int lab);



}
