package cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MvcAction;
import di.MvcFoward;

/**
 * Servlet implementation class F_Controller
 */
@WebServlet("/board/*")
public class F_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		
		String service = request.getRequestURI().substring("/mvcProj/board/".length());
		try {
			
			request.setAttribute("mainUrl", "board/"+service+".jsp");
			
			MvcAction action = (MvcAction)Class.forName("service_p."+service).newInstance();
			MvcFoward forward = action.execute(request, response); //list.java의 execute 메소드 실행
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
			dispatcher.forward(request, response);
			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(service);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
}
/*
 * http://localhost:8080/mvcProj/board/List
 */