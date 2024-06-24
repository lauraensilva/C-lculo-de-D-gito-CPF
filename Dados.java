package VerificadorCPF;

import java.awt.*;
import java.awt.event.*;

public class Dados extends WindowAdapter implements ActionListener {
	public Frame janela;
	public Panel painel, painelBotoes;
	public TextField tcpf, tdigito;
	public Label lcpf, ldigito;
	public Button botao;
	
	public Dados() {
		janela = new Frame();
		janela.setTitle("Verificador Dígito CPF");
		janela.setSize(500,600);
		janela.setBackground(new Color(255,255,255));
		janela.setLayout(null);
		janela.addWindowListener(this);
		
		painel = new Panel();
		painel.setBackground(new Color(0,0,0));
		painel.setSize(480, 400);
		painel.setLocation(10,20);
		painel.setLayout(null);
		
		painelBotoes = new Panel();
        painelBotoes.setSize(480, 40);
        painelBotoes.setLocation(10,410);
        painelBotoes.setBackground(new Color(0, 0, 0));
        painelBotoes.setLayout(new FlowLayout());
		
		lcpf = new Label ("Digite o CPF:");
		lcpf.setForeground(Color.WHITE);
        lcpf.setFont(new java.awt.Font("Arial", Font.ITALIC, 20));
        lcpf.setBounds(180,127,120,23);
        
        ldigito = new Label ("-");
        ldigito.setForeground(Color.WHITE);
        ldigito.setFont(new java.awt.Font("Arial", Font.ITALIC, 20));
        ldigito.setBounds(350,150,10,23);
        
        final int maxLength = 9;
        tcpf = new TextField(maxLength);
        tcpf.setForeground(Color.black);
        tcpf.setFont(new java.awt.Font("Arial", Font.ITALIC, 20));
        tcpf.setBounds(120,150,240,23);
        tcpf.addTextListener(new TextListener() {
        	public void limitarCaract(TextEvent e) {
        		String caracteres = tcpf.getText();
        		if (caracteres.length() > maxLength) {
        			tcpf.setText(caracteres.substring(0,maxLength));
        		}
        	}

			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        
        tdigito = new TextField(10);
        tdigito.setForeground(Color.black);
        tdigito.setFont(new java.awt.Font("Arial", Font.ITALIC, 20));
        tdigito.setEditable(false);
        tdigito.setBounds(360,150,40,23);
        
        botao = new Button ("Envia");
        botao.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent e) {
        		String lercpf = tcpf.getText();
        		String resultado = useTexto(lercpf);
        		tdigito.setText(resultado);
        	}
        });
        
        painel.add(lcpf);
        painel.add(ldigito);
        painel.add(tcpf);
        painel.add(tdigito);
        painelBotoes.add(botao);
        janela.add(painel);
        janela.add(painelBotoes);
        
	}
	
	
	public static String useTexto(String texto) {
		String str = texto;
		int soma = 0;
		int x=11;
		for (int i=0; i<=8; i++) {
			int pop = str.charAt(i);
			soma= soma+((pop-48)*(x-=1));
			System.out.println(pop);
			}
		int verificarresto1 = 11-(soma%11);
		if (verificarresto1 >=10) {
			verificarresto1 = 0;
		}
		System.out.println(soma);
		
		int soma2 = 0;
		int x2= 12;
		for (int i=0; i<=8; i++) {
				int pop2 = str.charAt(i);
				soma2= soma2+((pop2-48)*(x2-=1));
		}
		int resto2 = soma2+(verificarresto1*2);
		int verificarresto2 = 11-(resto2%11);
		if (verificarresto2>=10) {
			verificarresto2 = 0;
		}
		String digito = (verificarresto1+""+verificarresto2);
		return digito;
		
	}
	
	
	public void mostraTela() {
        janela.setVisible(true);
    }
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String[] args) {
        Dados inicio = new Dados();
        inicio.mostraTela();
	}
	
}


