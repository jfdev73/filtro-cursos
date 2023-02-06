package com.miranda.cursos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;



import com.miranda.cursos.model.Curso;

public class CursoRepository {
	
	private Connection conn;
	private String sql;

	public CursoRepository(Connection conn) {
		this.conn = conn;
	}

	private Curso getCurso(ResultSet rs) throws SQLException {
		Curso curso = new Curso();
		curso.setId(rs.getLong(1));
		curso.setNombre(rs.getString(2));
		curso.setDescripcion(rs.getString(3));
		curso.setInstructor(rs.getString(4));
		curso.setDuracion(rs.getDouble(5));
		return curso;
	}

	
	public List<Curso> getAll() throws SQLException {
		sql = "SELECT * FROM curso";
		List<Curso> cursos = new LinkedList<>();
		try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				Curso curso = getCurso(rs);

				cursos.add(curso);

			}

		}
		return cursos;
	}
	
	public List<Curso> getAllFind(String busqueda) throws SQLException {
		sql = "SELECT * FROM curso as c WHERE LOWER(c.nombre) LIKE LOWER(?);";
		List<Curso> cursos = new LinkedList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql);
				
			) {
			ps.setString(1, "%"+busqueda+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Curso curso = getCurso(rs);

				cursos.add(curso);

			}
			rs.close();
		}
		return cursos;
	}

}
