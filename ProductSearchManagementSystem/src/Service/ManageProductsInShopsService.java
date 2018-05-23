package Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ManageProductsInShopsDao;


/**
 * Servlet implementation class ManageProductsInShopsService
 */
@WebServlet("/ManageProductsInShopsService")
public class ManageProductsInShopsService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageProductsInShopsService() {
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
		
		String id=request.getParameter("textFieldId");
		String shopId=request.getParameter("textFieldShopId");
		String productId=request.getParameter("textFieldProductId");
		
		if (request.getParameter("buttonAdd") != null) {
			if(ManageProductsInShopsDao.add(shopId, productId)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('successfully added');");
				out.println("location='manageProductsInShops.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to add');");
		    	out.println("location='manageProductsInShops.jsp';");
			    out.println("</script>");
		    }
		}
		else if (request.getParameter("buttonRemove") != null) {
			if(id != "") {
				if(ManageProductsInShopsDao.remove(id)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('successfully removed');");
					out.println("location='manageProductsInShops.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to remove');");
			    	out.println("location='manageProductsInShops.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter id');");
		    	out.println("location='manageProductsInShops.jsp';");
			    out.println("</script>");
			}
			
		}else {
			if(id != "") {
				if(ManageProductsInShopsDao.update(id, shopId, productId)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('successfully  updated');");
					out.println("location='manageProductsInShops.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to update');");
			    	out.println("location='manageProductsInShops.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter id');");
		    	out.println("location='manageProductsInShops.jsp';");
			    out.println("</script>");
			}
		}
		
		out.close();
	}

}
