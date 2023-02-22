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
@WebServlet("/@abhijit006")
public class PrincipleData extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		String s=req.getParameter("id");
		String s1=req.getParameter("Name");
		String s2=req.getParameter("email");
		String s3=req.getParameter("password");
		String s4=req.getParameter("mobno");
		
		Principle p =new Principle();
		int mob=Integer.parseInt(s4);
		int id =Integer.parseInt(s);
		p.setId(id);
		p.setName(s1);
		p.setPassword(s3);
		p.setEmail(s2);
		p.setMobno(mob);
		
		et.begin();
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.forward(req, res);
	
	}
	

}
