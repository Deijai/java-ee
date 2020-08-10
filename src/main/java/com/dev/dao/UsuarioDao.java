package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.conexao.SingleConnection;
import com.dev.model.Telefone;
import com.dev.model.Usuario;

public class UsuarioDao {
	
	private Connection connection;
	private String sql;
	
	public UsuarioDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void insert(Usuario usuario) {
		sql = "INSERT INTO usuario (nome, email) VALUES(?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.execute();
			connection.commit();
			
		} catch (SQLException e) {
			
			try {
				
				connection.rollback();
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
				
			}
			
			e.printStackTrace();
		}
		
	}
	
	public void update(Usuario usuario, Long id) {
		sql = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setLong(3, id);
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void delete(Long id) {
		sql = "DELETE FROM usuario WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();
			connection.commit();
			
		} catch (SQLException e) {
			
			try {
				
				connection.rollback();
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public Usuario getUsuario(Long id) {
		Usuario usuario =  new Usuario();
		sql = "SELECT * FROM usuario INNER JOIN telefone WHERE usuario.id = telefone.id_usuario AND usuario.id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				Telefone telefone = new Telefone(resultSet.getLong("id"), resultSet.getString("numero"), resultSet.getString("tipo"), resultSet.getLong("id_usuario"));
				 usuario = new Usuario(resultSet.getLong("id"), resultSet.getString("nome"), resultSet.getString("email"), telefone);
			} else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
		
		
	}
	
	
	public List<Usuario> listarTodos(){
		List<Usuario> lista = new ArrayList<>();
		sql = "SELECT * FROM usuario INNER JOIN telefone WHERE usuario.id = telefone.id_usuario";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Telefone telefone = new Telefone(resultSet.getLong("id"), resultSet.getString("numero"), resultSet.getString("tipo"), resultSet.getLong("id_usuario"));
				Usuario usuario = new Usuario(resultSet.getLong("id"), resultSet.getString("nome"), resultSet.getString("email"), telefone);
				lista.add(usuario);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return lista;
	}

}
