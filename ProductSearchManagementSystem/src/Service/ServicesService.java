package Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServicesService
 */
@WebServlet("/ServicesService")
public class ServicesService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicesService() {
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
		
		RequestDispatcher rd = null;
		
		if(request.getParameter("buttonLogout") != null) {
			rd=request.getRequestDispatcher("index.jsp");  
	    }
		else if(request.getParameter("buttonManageProductsInShops") != null) {
			rd=request.getRequestDispatcher("manageProductsInShops.jsp");  
		}
		else if(request.getParameter("buttonUpdateManager") != null) {
			rd=request.getRequestDispatcher("updateManager.jsp");  
		}
		else {
			rd=request.getRequestDispatcher("manageProductsOrShops.jsp");  
		}
		rd.forward(request,response); 
		
		out.close();
	}

}
