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

@WebServlet("/buscar")
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda = request.getParameter("busqueda");
		
		Connection conn = (Connection)request.getAttribute("conn");
        CursoService service = new CursoService(conn);
        List<Curso> cursos = service.search(busqueda);
		/*
		 * System.out.println("Busqueda -> "+busqueda);
		 * cursos.forEach(System.out::println);
		 */
        request.setAttribute("cursos", cursos);
        request.setAttribute("titulo", "Filtro de Cursos");
        request.getRequestDispatcher("/listar.jsp").forward(request, response);
	}

}
