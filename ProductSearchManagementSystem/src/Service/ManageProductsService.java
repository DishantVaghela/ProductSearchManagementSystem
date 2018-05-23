package Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ManageProductsDao;

/**
 * Servlet implementation class ManageProductService
 */
@WebServlet("/ManageProductsService")
public class ManageProductsService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageProductsService() {
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
		
		String productId=request.getParameter("textFieldProductId");
		String category=request.getParameter("selectCategory");
		String brand=request.getParameter("textFieldBrand");
		String name=request.getParameter("textFieldName");
		String price=request.getParameter("textFieldPrice");
		
		if (request.getParameter("buttonAdd") != null) {
			if(ManageProductsDao.addProducts(category, brand, name, price)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('product added');");
				out.println("location='manageProductsOrShops.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to add product');");
		    	out.println("location='manageProductsOrShops.jsp';");
			    out.println("</script>");
		    }
		}
		else if (request.getParameter("buttonRemove") != null) {
			if(productId != "") {
				if(ManageProductsDao.removeProducts(productId)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('product removed');");
					out.println("location='manageProductsOrShops.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to remove product');");
			    	out.println("location='manageProductsOrShops.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter product id');");
		    	out.println("location='manageProductsOrShops.jsp';");
			    out.println("</script>");
			}
		}else {
			if(productId != "") {
				if(ManageProductsDao.updateProducts(productId, category, brand, name, price)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('product updated');");
					out.println("location='manageProductsOrShops.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to update product');");
			    	out.println("location='manageProductsOrShops.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter product id');");
		    	out.println("location='manageProductsOrShops.jsp';");
			    out.println("</script>");
			}
		}
		
		out.close();
	}

}
