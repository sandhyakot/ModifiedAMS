package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ValidatorDao;
import model.User;

/**
 * Servlet implementation class Validator
 */
@WebServlet("/Validator")
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Validator() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		session.setAttribute("SessionId", session.getId());
		ValidatorDao vdao = null;
		try {
			vdao = new ValidatorDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		User u = vdao.validate(userid);
		//set employee attribute into session to be used in every page
		session.setAttribute("users", u);

		if(u!=null)//if object not null
		{
			
			if(!password.equals(u.getPassword()))
			{
				
				request.setAttribute("msg", "Wrong Password Retry...");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else
			{
				if("A".equalsIgnoreCase(u.getRole()))
				{
					response.sendRedirect("Admin.jsp");


				}
				else
				{
					response.sendRedirect("User.jsp");


				}
			}

		}
		else
		{
			request.setAttribute("msg", "Either Wrong id /You are Not registered....");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		}

	} 

	

}
