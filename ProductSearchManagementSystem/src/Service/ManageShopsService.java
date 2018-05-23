package Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ManageShopsDao;

/**
 * Servlet implementation class ManageShopsService
 */
@WebServlet("/ManageShopsService")
public class ManageShopsService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageShopsService() {
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
		
		String shopId=request.getParameter("textFieldShopId");
		String name=request.getParameter("textFieldName");
		String street=request.getParameter("textFieldStreet");
		String city=request.getParameter("selectCity");
		String state=request.getParameter("selectState");
		
		if (request.getParameter("buttonAdd") != null) {
			if(ManageShopsDao.addShops(name, street, city, state)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('shop added');");
				out.println("location='manageProductsOrShops.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to add shop');");
		    	out.println("location='manageProductsOrShops.jsp';");
			    out.println("</script>");
		    }
		}
		else if (request.getParameter("buttonRemove") != null) {
			if(shopId != "") {
				if(ManageShopsDao.removeShops(shopId)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('shop removed');");
					out.println("location='manageProductsOrShops.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to remove shop');");
			    	out.println("location='manageProductsOrShops.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter shop id');");
		    	out.println("location='manageProductsOrShops.jsp';");
			    out.println("</script>");
			}
		}else {
			if(shopId != "") {
				if(ManageShopsDao.updateShops(shopId, name, street, city, state)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('shop updated');");
					out.println("location='manageProductsOrShops.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to update shop');");
			    	out.println("location='manageProductsOrShops.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter shop id');");
		    	out.println("location='manageProductsOrShops.jsp';");
			    out.println("</script>");
			}
		}
		
		out.close();
	}

}
