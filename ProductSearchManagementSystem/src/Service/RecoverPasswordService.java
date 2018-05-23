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

import Dao.RecoverPasswordDao;

/**
 * Servlet implementation class RecoverPasswordService
 */
@WebServlet("/RecoverPasswordService")
public class RecoverPasswordService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecoverPasswordService() {
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
		
		String loginId=request.getParameter("textAreaManagerId");
		String loginRecoveryanswer=request.getParameter("textAreaRecoveryAnswer");
		
		if(RecoverPasswordDao.recover(loginId, loginRecoveryanswer)){  
			HttpSession session=request.getSession();  
	        session.setAttribute("sessionLoginId",loginId); 
	        
	        RequestDispatcher rd=request.getRequestDispatcher("displayPassword.jsp");  
	        rd.forward(request,response); 
	    }  
	    else{  
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('recovery answer is incorrect');");
	    	out.println("location='index.jsp';");
	    	out.println("</script>");
	    } 
		out.close();
	}

}
