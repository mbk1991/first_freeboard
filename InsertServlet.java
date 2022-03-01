package com.tistory.mabb.freeboard.mainsevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tistory.mabb.freeboard.dao.BoardDao;


public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher requestDispatcer = request.getRequestDispatcher("/BoardInsert.jsp");
		requestDispatcer.forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		String sub = request.getParameter("sub");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		BoardDao dao = new BoardDao();
		dao.insertBoard(sub, content, writer);
		
		response.sendRedirect("Main");
	}

}
