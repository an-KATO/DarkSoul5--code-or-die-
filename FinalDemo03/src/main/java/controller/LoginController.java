package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* show login page
		 */
		
		RequestDispatcher rd=request.getRequestDispatcher("/view/login.jsp");  
        rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 1. Lấy thông tin email, password => request.getParameter
		 * 2. Tạo đối tượng user => dùng model User
		 * 3. Kiểm tra tính hợp của email, pw => kết nối database 
		 * 	3.1 Email, pw đúng => lưu thông tin user vào session, chuyển đến home page
		 *  3.2 Email, pw không đúng => login 
		 */
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String email=request.getParameter("email");  
        String password=request.getParameter("password");
        
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        
        request.setAttribute("user",user);  
        
        boolean status = user.validate();
        
        if(status){  
        	response.sendRedirect("home");
        }  
        else{  
            RequestDispatcher rd=request.getRequestDispatcher("/view/login-error.jsp");  
            rd.forward(request, response);  
        }  
		
	}
	
}