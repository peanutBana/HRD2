package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CandidateDAO;

@WebServlet("/")
public class CandidateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CandidateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    doPro(request, response);
	}
	
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String context = request.getContextPath(); // 톰캣의 context path를 가져온다. (server.xml에서 확인 가능)
	    String command = request.getServletPath(); // 경로의 맨 끝 파일명을 가져온다.
	    String site = null;
	    
	    CandidateDAO candidate = new CandidateDAO();
	    
	    switch(command) {
	    case "/home":
	         site = "index.jsp"; break;
	    case "/result":
	    	site = candidate.result(request, response);  break;
//	    case "/vote":
//	    	site = candidate.result(request, response);  break;
//	    case "/rank":
//	    	site = candidate.result(request, response);  break;
//	   
	    }
	    getServletContext().getRequestDispatcher("/" + site).forward(request, response);
	}	
}
	