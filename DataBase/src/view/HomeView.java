package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
    private JButton btn1;
    private JLabel cr;
    private JLabel us;
    private JButton btn2;
    private JLabel list;
    private JButton btn3;
    private JLabel up;
    private JButton btn4;
    private JLabel del;


     public HomeView(){
         janela = new JFrame();
         painel = new JPanel();
         us = new JLabel("Deseja");
         painel.add(us);
         painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
         painel.setLayout(new GridLayout(0,1));
         cr = new JLabel("Cadastrar Aluno: ");
         painel.add(cr);
         
         btn1 = new JButton("Cadastrar");
         btn1.addActionListener(new CreateView());
         
         painel.add(btn1);
         list = new JLabel("Ver Lista de alunos: ");
         painel.add(list);
         
         btn2 = new JButton("Ir");
         btn2.addActionListener(new ReadView());
         
         painel.add(btn2);
         up = new JLabel("Atualizar dados de aluno: ");
         painel.add(up);
         
         btn3 = new JButton("Atualizar");
         btn3.addActionListener(new UpdateView());
         
         painel.add(btn3);
         del = new JLabel("Deletar Aluno: ");
         painel.add(del);
         
         btn4 = new JButton("Deletar");
         btn4.addActionListener(new DeleteView());
         
         painel.add(btn4);
         janela.add(painel, BorderLayout.CENTER);
         janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         janela.setTitle("Tela de Inicio");
         janela.setSize(300,300);
         janela.setLocation(840, 420);
         janela.setVisible(true);
    }
    public static void main(String[] args) {
            new HomeView();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
              
    }   
}
