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

@WebServlet("/removestudent@123")
public class removeSudent extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		String s=req.getParameter("sid");
		int id=Integer.parseInt(s);
		
	
    	
    	Teacher as=em.find(Teacher.class, id);
		if(as!=null) {
			et.begin();
			em.remove(as);
			et.commit();
			System.out.println("deleted sucessfully");
		}
			else
			{
				System.out.println("invalid data");
			}
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.forward(req, res);
	}

}
