package Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ManagerLoginDao;

/**
 * Servlet implementation class ManagerLoginService
 */
@WebServlet("/ManagerLoginService")
public class ManagerLoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String loginId=request.getParameter("textFieldId");
		String loginPassword=request.getParameter("textFieldPassword");
		
		if (request.getParameter("buttonLogin") != null) {
			if(ManagerLoginDao.validate(loginId, loginPassword)){  
				HttpSession session=request.getSession();  
		        session.setAttribute("sessionLoginId",loginId); 
		        
		        RequestDispatcher rd=request.getRequestDispatcher("services.jsp");  
		        rd.forward(request,response); 
		    }  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('manager id or password is incorrect');");
		    	out.println("location='index.jsp';");
		    	out.println("</script>");
		    } 
		}
		else  {
			if(loginId==""){
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter id');");
		    	out.println("location='index.jsp';");
		    	out.println("</script>");
			}
			else{
				if (ManagerLoginDao.idExists(loginId)){
					RequestDispatcher rd=request.getRequestDispatcher("recoverPassword.jsp"); 
					rd.forward(request,response); 
				}
				else{
					out.println("<script type=\"text/javascript\">");
			    	out.println("alert('id does not exist');");
			    	out.println("location='index.jsp';");
			    	out.println("</script>");
				}
			}
		}
	    out.close();  
	}

}
