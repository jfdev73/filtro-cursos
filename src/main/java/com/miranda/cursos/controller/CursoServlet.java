package com.miranda.cursos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;



import com.miranda.cursos.model.Curso;
import com.miranda.cursos.service.CursoService;

@WebServlet("/cursos")
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection)request.getAttribute("conn");
        CursoService service = new CursoService(conn);
        List<Curso> cursos = service.listar();

        request.setAttribute("cursos", cursos);
        request.setAttribute("titulo", "Listado de Cursos");
		/*
		 * boolean bandera = false; request.setAttribute("bandera", bandera);
		 */
        request.getRequestDispatcher("/listar.jsp").forward(request, response);
	}

}
