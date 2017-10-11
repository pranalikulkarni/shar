package com.cg.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.student.bean.StudentInfo;
import com.cg.student.exception.StudentException;
import com.cg.student.service.IStudentService;
import com.cg.student.service.StudentServiceImpl;


@WebServlet("*.obj")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
		StudentInfo bean=new StudentInfo();
		IStudentService service=new StudentServiceImpl();
		PrintWriter out=response.getWriter();
		String path=request.getServletPath();
		String target=null;
		
		switch(path)
		{
		case "/add.obj":
			ArrayList<Integer> list;
			try {
				list = service.retrieveId();
				session.setAttribute("list", list);
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			target="add.jsp";
			
			break;
			
		case "/retrieve.obj":
			int id=Integer.parseInt(request.getParameter("ddlId"));
			String name=request.getParameter("ddlname");
			int theory=Integer.parseInt(request.getParameter("theory"));
			int mcq=Integer.parseInt(request.getParameter("mcq"));
			int lab=Integer.parseInt(request.getParameter("lab"));
			
			
			
			bean.setSid(id);
			bean.setSubname(name);
			bean.setTheory(theory);
			bean.setPrac(mcq);
			bean.setLab(lab);
			
			
			int total=service.calculateTotal(theory,mcq,lab);
			System.out.println(total);
			String grade=service.givegrade(total);
			bean.setTotalscore(total);
			bean.setGrade(grade);
			int res=service.insert(bean);
			
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("total", total);
			session.setAttribute("grade", grade);
			target="success.jsp";
			break;
	}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
	

}
}
