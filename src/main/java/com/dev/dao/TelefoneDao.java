package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dev.conexao.SingleConnection;
import com.dev.model.Telefone;

public class TelefoneDao {
	
	private Connection connection;
	private String sql;
	
	public TelefoneDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void insert(Telefone telefone) {
		sql = "INSERT INTO telefone (numero, tipo, id_usuario) VALUES(?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, telefone.getNumero());
			preparedStatement.setString(2, telefone.getTipo());
			preparedStatement.setLong(3, telefone.getIdUsuario());
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
	
	public void update(Telefone telefone, Long id) {
		sql = "UPDATE telefone SET numero = ?, tipo = ? WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, telefone.getNumero());
			preparedStatement.setString(2, telefone.getTipo());
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
		sql = "DELETE FROM telefone WHERE id = ?";
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

}
