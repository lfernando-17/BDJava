package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import bo.Aluno;
import java.awt.*;
import java.awt.event.*;

public class ReadView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
    private JLabel list;
    private JLabel jt;
    private JButton btn1;

    @Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        painel = new JPanel();
        list = new JLabel("Listagem de Alunos");
        painel.add(list);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Tela de Listagem");
        janela.setSize(600,350);
        janela.setLocation(300, 320);
        janela.setVisible(true);
        
       
        btn1 = new JButton("Revelar");
        btn1.setBounds(20,30,50,30);
        painel.add(btn1);
        
        btn1.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	AlunoView leitura = new AlunoView();
        		
        		List<Aluno> listaAlunos = new ArrayList<Aluno>();
        		listaAlunos = leitura.read();
        		
        		for(Aluno aluno:listaAlunos) 
        		{
        			
        			painel.remove(btn1);
        			System.out.println(listaAlunos);
        			System.out.println(aluno.getNome());
        			jt = new JLabel(" ");
        			jt.setText("Matricula : "+aluno.getMatricula()+" Nome : "+aluno.getNome()+" Cidade : "+aluno.getCidade());
        			painel.add(jt);
        			painel.revalidate();
        			painel.repaint();
        		}
              }
            });

        
        
			//System.out.println("Nome :"+aluno.getNome()+" Cidade :"+aluno.getCidade());
		//}
    }   

}