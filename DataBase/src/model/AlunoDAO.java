package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Aluno;
import jdbc.ConnectionFactory;

public class AlunoDAO {

	public void create(Aluno aluno)
	{
		// Insert sql no banco
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "insert into aluno(matricula,nome,cidade) values (?,?,?)";
			
			stmt = banco.prepareStatement(sql);
			
			//Popular Query
			
			stmt.setString(1,aluno.getMatricula());
			stmt.setString(2,aluno.getNome());
			stmt.setString(3,aluno.getCidade());
			
			stmt.executeUpdate();
			
			System.out.println("Aluno incluido com sucesso !!!");
		}
		catch(SQLException e) {
			System.out.println("Erro ao tentar incluir aluno");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
	}
	
	public List<Aluno> read(){
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null ;
		ResultSet rs = null ;
		
		String sql = "select * from aluno";
		
		try {
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCidade(rs.getString("cidade"));
				
				listaAlunos.add(aluno);
			}
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler Aluno...");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
		return listaAlunos;
	}
	
	public void update(Aluno aluno) {
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ; 
		try {
		String sql = " update aluno \r\n"
				+ "set nome = (?), cidade = (?) \r\n"
				+ "where matricula = (?)";
		stmt = banco.prepareStatement(sql);
		
		stmt.setString(1,aluno.getNome());
		stmt.setString(2,aluno.getCidade());
		stmt.setString(3,aluno.getMatricula());
		
		stmt.executeUpdate();
		
		System.out.println("Aluno atualizado com sucesso !!!");
		
		}
		
		catch(SQLException e) {
			System.out.println("Erro ao atualizar o aluno");
		}
		
	}
	
	public void delete(String matricula)
	{
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ; 
		try {
			String sql = "delete from aluno where matricula = (?)";
			
			stmt = banco.prepareStatement(sql);
			stmt.setString(1, matricula);
			stmt.executeUpdate();
			
			System.out.println("Aluno deletado com sucesso !!!");
			
		}
		catch (SQLException e)
		{
			System.out.println("Erro ao deletar aluno");
		}
	}
	
}
