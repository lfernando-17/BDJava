package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import bo.Aluno;
import controller.AlunoController;

public class AlunoView implements ActionListener {
	private JLabel resultado;
	private String matricula;
	private String nome;
	private String cidade;
	
	public AlunoView(JTextField txtnum1, JTextField txtnum2, JTextField txtnum3,JLabel resultado,int op) {
		this.matricula=txtnum1.getText().trim();
		this.nome=txtnum2.getText().trim();
		this.cidade=txtnum3.getText().trim();
		this.resultado=resultado;
		if(op==1)
			create();
		else 
			update();
	}

	public AlunoView(JTextField txtnum1 , JLabel resultado) {
		// TODO Auto-generated constructor stub
		this.matricula = txtnum1.getText();
		this.resultado = resultado;
		delete();
	}

	public AlunoView() {
		// TODO Auto-generated constructor stub
	}

	public void create() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setCidade(cidade);
		try {
			AlunoController controller = new AlunoController();
			controller.create(aluno);
			resultado.setText("Aluno Criado !");
			}
		catch(Exception e1) {
			resultado.setText("Erro Tente Novamente");
		}
	}
	public List<Aluno> read()
	{

		AlunoController controller = new AlunoController();
		return controller.read();

	}
	public void update() {
		
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setCidade(cidade);
		try {
			AlunoController controller = new AlunoController();
			controller.update(aluno);
			resultado.setText("Aluno Atualizado !");
			}
		catch(Exception e1) {
			resultado.setText("Erro Tente Novamente");
		}
	
	}
	
	public void delete() {
		try {
			AlunoController controller = new AlunoController();
			controller.delete(matricula);
			resultado.setText("Aluno Deletado !");
			}
		catch(Exception e1) {
			resultado.setText("Erro Tente Novamente");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
