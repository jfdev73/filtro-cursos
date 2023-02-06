package com.miranda.cursos.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.miranda.cursos.exception.ServiceJdbcException;
import com.miranda.cursos.model.Curso;
import com.miranda.cursos.repository.CursoRepository;

public class CursoService {
	
	private CursoRepository repository;
	
	public CursoService(Connection conn) {
		this.repository = new CursoRepository(conn);
	}
	
	
	public List<Curso> listar() {
		try {
			return repository.getAll();
		} catch (SQLException e) {
			throw new ServiceJdbcException(e.getMessage(), e.getCause());
		}
	}
	
	public List<Curso> search(String busqueda) {
		try {
			return repository.getAllFind(busqueda);
		} catch (SQLException e) {
			throw new ServiceJdbcException(e.getMessage(), e.getCause());
		}
	}
	
	

}
