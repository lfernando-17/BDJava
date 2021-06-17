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
        painel.setLayout(new GridBagLayout());
        janela.setTitle("Tela de Listagem");
        janela.setSize(400,350);
        janela.setLocation(300, 320);
        janela.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets (10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        painel.add(list,c);
        c.gridx=0;
        c.gridy=2;
        btn1 = new JButton("Revelar");
        btn1.setBounds(20,30,50,30);
        painel.add(btn1,c);
        c.gridx=0;
        c.gridy=3;
        janela.add(painel);
        btn1.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	AlunoView leitura = new AlunoView();
        		List<Aluno> listaAlunos = new ArrayList<Aluno>();
        		listaAlunos = leitura.read();
        		int x=3;
        		for(Aluno aluno:listaAlunos) 
        		{
        			c.gridx=0;
        			c.gridy=x;
        			x++;
        			painel.remove(btn1);
        			System.out.println(listaAlunos);
        			System.out.println(aluno.getNome());
        			jt = new JLabel(" ");
        			jt.setText("Matricula : "+aluno.getMatricula()+" Nome : "+aluno.getNome()+" Cidade : "+aluno.getCidade());
        			painel.add(jt,c);
        			painel.revalidate();
        			painel.repaint();
        		}
              }
            });
    }   

}
