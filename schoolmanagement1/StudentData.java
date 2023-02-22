package schoolmanagement1;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/createStudent@1234")
public class StudentData extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		String s=req.getParameter("sid");
		String s1=req.getParameter("sName");
		String s2=req.getParameter("semail");
		String s3=req.getParameter("spassword");
		String s4=req.getParameter("smobno");
		
		Student1 stu =new Student1();
		int mob=Integer.parseInt(s4);
		int id =Integer.parseInt(s);
		stu.setId(id);
		stu.setName(s1);
		stu.setPassword(s3);
		stu.setEmail(s2);
		stu.setMobno(mob);
		
		et.begin();
		em.persist(stu);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.forward(req, res);
	
	}
	

}
