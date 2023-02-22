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
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/teacherfetch@123")
public class FetchTeacher extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytomany");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		String s=req.getParameter("tid");
		int id=Integer.parseInt(s);
		
		
		Query q=em.createQuery("select a from Teacher a where id=?1");
    	q.setParameter(1,id);
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		List<Teacher> p=q.getResultList();
		if(p.size()!=0) {
			pw.write(p.get(0).getId() +"\n");
			pw.write(p.get(0).getName()+"\n");
			pw.write(p.get(0).getEmail()+"\n");
			pw.write(p.get(0).getPassword()+"\n");
			pw.write(p.get(0).getMobno()+"\n");
		}
		else {
			pw.write("Invalid");
		}
		
	}

}
