package com.tistory.mabb.freeboard.mainsevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tistory.mabb.freeboard.BoardVo;
import com.tistory.mabb.freeboard.dao.BoardDao;


public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ContentServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		request.setCharacterEncoding("utf-8");
		String num_c = request.getParameter("num_c");
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.contentBoard(Integer.parseInt(num_c));
		
		request.setAttribute("vo", vo);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BoardContent.jsp");
		requestDispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
