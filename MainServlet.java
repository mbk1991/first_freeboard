package com.tistory.mabb.freeboard.mainsevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tistory.mabb.freeboard.BoardVo;
import com.tistory.mabb.freeboard.dao.BoardDao;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = dao.selectBoard();
		request.setAttribute("list", list);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BoardMain.jsp");
		requestDispatcher.forward(request, response);	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
