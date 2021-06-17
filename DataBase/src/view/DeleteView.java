package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
     private JLabel aluno;
     private JTextField txtnum1;
     private JButton btnDel;
     private JLabel resultado;
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        painel = new JPanel();
        aluno = new JLabel("Deseja deletar o aluno de qual matricula? ");
        painel.add(aluno);
        txtnum1 = new JTextField(" ");
        painel.add(txtnum1);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));
        btnDel = new JButton("Deletar");
        resultado = new JLabel(" ");
        btnDel.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	new AlunoView(txtnum1,resultado);
              }
            });
        painel.add(btnDel);
        painel.add(resultado);
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Tela de Delete");
        janela.setSize(300,300);
        janela.setLocation(840, 220);
        janela.pack();
        janela.setVisible(true);
    }   
}