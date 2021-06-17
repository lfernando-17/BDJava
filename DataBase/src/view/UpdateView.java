package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
     private JLabel aluno;
     private JLabel nome;
     private JLabel cidade;
     private JLabel resultado;
     private JTextField txtnum1;
     private JTextField txtnum2;
     private JTextField txtnum3;
     private JButton btnUp;
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        painel = new JPanel();
        aluno = new JLabel("Deseja atualizar o aluno de qual matricula? ");
        painel.add(aluno);
        txtnum1 = new JTextField(" ");
        painel.add(txtnum1);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));
        nome = new JLabel("Insira o nome : ");
        painel.add(nome);
        txtnum2 = new JTextField(" ");
        painel.add(txtnum2);
        cidade = new JLabel("Insira a cidade: ");
        painel.add(cidade);
        txtnum3 = new JTextField(" ");
        painel.add(txtnum3);
        btnUp = new JButton("Atualizar");
        resultado = new JLabel("");
        painel.add(resultado);
        btnUp.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	new AlunoView(txtnum1,txtnum2,txtnum3,resultado,2);
              }
            });
        painel.add(btnUp);
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Tela de Update");
        janela.setSize(300,300);
        janela.setLocation(1040, 460);
        janela.pack();
        janela.setVisible(true); 
    }   
}