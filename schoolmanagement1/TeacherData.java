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
@WebServlet("/createStudent@123")
public class TeacherData extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		String s=req.getParameter("tid");
		String s1=req.getParameter("tName");
		String s2=req.getParameter("temail");
		String s3=req.getParameter("tpassword");
		String s4=req.getParameter("tmobno");
		
		Teacher t =new Teacher();
		int mob=Integer.parseInt(s4);
		int id =Integer.parseInt(s);
		t.setId(id);
		t.setName(s1);
		t.setPassword(s3);
		t.setEmail(s2);
		t.setMobno(mob);
		
		et.begin();
		em.persist(t);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.forward(req, res);
	
	}
	

}
