import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
//import java.util.HashMap;

public class Calculadora extends JFrame implements ActionListener{
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, suma, resta, multiplicacion, division, igual, punto;
    private JButton[] numeros;
    private JButton[] operadores;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField operador;
    private String expresion1;
    private String expresion2;
    private int actualExpresion;

    
    public Calculadora(){
        setTitle("Calculadora");
        setLayout(null);
        setBounds(0,0,400,600);
        setResizable(false);

        expresion1 = "";
        expresion2 = "";
        actualExpresion = 1;

        makeTextFields();
        makeButtons();
    }

    private void makeButtons(){
        b0 = new JButton("0");
        b0.setBounds(12,490,85,50);
        b0.addActionListener(this);
        add(b0);

        punto = new JButton(".");
        punto.setBounds(109,490,85,50);
        punto.addActionListener(this);
        add(punto);

        suma = new JButton("+");
        suma.setBounds(206, 490, 85, 50);
        suma.addActionListener(this);
        add(suma);
        
        igual = new JButton("=");
        igual.setBounds(301,490,85,50);
        igual.addActionListener(this);
        add(igual);

        b1 = new JButton("1");
        b1.setBounds(12,420,85,50);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("2");
        b2.setBounds(109,420,85,50);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("3");
        b3.setBounds(206, 420, 85, 50);
        b3.addActionListener(this);
        add(b3);
        
        resta = new JButton("-");
        resta.setBounds(301,420,85,50);
        resta.addActionListener(this);
        add(resta);

        b4 = new JButton("4");
        b4.setBounds(12,350,85,50);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("5");
        b5.setBounds(109,350,85,50);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("6");
        b6.setBounds(206, 350, 85, 50);
        b6.addActionListener(this);
        add(b6);
        
        multiplicacion = new JButton("*");
        multiplicacion.setBounds(301,350,85,50);
        multiplicacion.addActionListener(this);
        add(multiplicacion);

        b7 = new JButton("7");
        b7.setBounds(12,280,85,50);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton("8");
        b8.setBounds(109,280,85,50);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton("9");
        b9.setBounds(206, 280, 85, 50);
        b9.addActionListener(this);
        add(b9);
        
        division = new JButton("/");
        division.setBounds(301,280,85,50);
        division.addActionListener(this);
        add(division);
        
        numeros = new JButton[] {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9};
        operadores = new JButton[] {suma, resta, multiplicacion, division};
    }

    private void makeTextFields(){
        textField1 = new JTextField();
        textField1.setBounds(12,35,376,50);
        textField1.setEditable(false);
        textField1.setFont(new Font("Arial",Font.PLAIN, 20));
        add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(12,155,376,50);
        textField2.setEditable(false);
        textField2.setFont(new Font("Arial",Font.PLAIN, 20));
        add(textField2);

        operador = new JTextField();
        operador.setBounds(175, 95, 50, 50);
        operador.setEditable(false);
        operador.setFont(new Font("Arial",Font.PLAIN, 30));
        operador.setHorizontalAlignment(JTextField.CENTER);
        add(operador);

    }

    public void actionPerformed(ActionEvent e){
        for (JButton boton : numeros){
            if (e.getSource() == boton){
                if (actualExpresion == 1){
                    expresion1 = expresion1 + boton.getText();
                    textField1.setText(expresion1);
                } else {
                    expresion2 = expresion2 + boton.getText();
                    textField2.setText(expresion2);
                }
            }
        }
        
        for (JButton boton : operadores){
            if (e.getSource() == boton){
                operador.setText(boton.getText());
                actualExpresion = 2;
            }
        } 

        if (e.getSource() == igual){
            int a = Integer.parseInt(expresion1);
            int b = Integer.parseInt(expresion2);
            int resultado = 0; 
            switch (operador.getText()){
                case "+" : resultado = a + b; break;
                case "-" : resultado = a - b; break;
                case "*" : resultado = a * b; break;
                case "/" : resultado = a / b; break;
            }
            textField1.setText(expresion1 + operador.getText() + expresion2);
            operador.setText("=");
            textField2.setText(resultado + "");

        }        
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        c.setVisible(true);
        c.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}




