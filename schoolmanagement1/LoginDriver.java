package schoolmanagement1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/loginservlet1")
public class LoginDriver extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	String s=req.getParameter("eamil");
	String s1=req.getParameter("password");
	
	if(s.equals("mainkarabhijit085@gmail.com") && s1.equals("133"))
	{
		RequestDispatcher rd=req.getRequestDispatcher("AfterprincipleLogin.html");
		rd.forward(req, res);
	}
	else
	{
		PrintWriter pw=res.getWriter();
		pw.write("Invaliddd.....");
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.include(req, res);
		res.setContentType("text/html");
	}
	
//	Query q=em.createQuery("select a from Principle a where email =?1 and password=?2");
//	q.setParameter(1,s);
//	q.setParameter(2, s1);
//	res.setContentType("text/html");
//	PrintWriter pw = res.getWriter();
//	List<Principle> p=q.getResultList();
//	if(p.size()!=0) {
//		pw.write(p.get(0).getId() +"\n");
//		pw.write(p.get(0).getName()+"\n");
//		pw.write(p.get(0).getEmail()+"\n");
//		pw.write(p.get(0).getPassword()+"\n");
//		pw.write(p.get(0).getMobno()+"\n");
//	}
//	else {
//		pw.write("Invalid");
//	}
	
	}
}
