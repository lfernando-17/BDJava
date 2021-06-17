package controller;

import java.util.ArrayList;
import java.util.List;

import bo.Aluno;
import model.AlunoDAO;

public class AlunoController {
	public void create(Aluno aluno)
	{
		//Regras de Negocio , Ex Verificar se a escola e lasalle
		AlunoDAO model = new AlunoDAO();
		
		model.create(aluno);
		
	}
	
	public List<Aluno> read()
	{
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		try {
			AlunoDAO model = new AlunoDAO();
			listaAlunos = model.read();
			
		}
		catch (Exception e)
		{
			System.out.println("Erro no controller read");
		}
		return listaAlunos;
	}
	
	public void update(Aluno aluno) {
		// Atualizar o Aluno

			AlunoDAO model = new AlunoDAO();
			model.update(aluno);
	
	}
	public void delete(String matricula) {
		// Deletar o Aluno
		AlunoDAO model = new AlunoDAO();
		model.delete(matricula);
	}
}
