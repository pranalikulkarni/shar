package com.cg.student.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.student.bean.StudentInfo;
import com.cg.student.exception.StudentException;
import com.cg.student.util.DBUtil;



public class StudentDAOImpl implements IStudentDao{
	Connection conn=null;
public int insert(StudentInfo bean) throws IOException{
		
		int row=0;
		int value=0;
		try{
			conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into score_student2 values(?,?,?,?,?,?,?)");
			
			ps.setInt(1,bean.getSid());
			ps.setString(2,bean.getSubname());
			ps.setInt(3,bean.getTheory());
			ps.setInt(4,bean.getPrac());
			ps.setInt(5,bean.getLab());
			ps.setInt(6,bean.getTotalscore());
			ps.setString(7,bean.getGrade());
			
			
			row=ps.executeUpdate();
		}
			
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return row;
}

	
		

	
	public ArrayList<Integer> retrieveId() throws IOException, StudentException {
		ArrayList<Integer> list=new ArrayList<Integer>();
		try
		{
		conn=DBUtil.getConnection();
		String sl="Select studId from student1";
		
		
		Statement stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(sl);
		while(rs.next())
		{
			
			list.add(rs.getInt(1));
		}
		System.out.println(list);
	}
	catch(SQLException e)
	{
	
		throw new StudentException(e.getMessage());
	}
	return list;
	}





	
	}


