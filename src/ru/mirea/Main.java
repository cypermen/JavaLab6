package ru.mirea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame implements ActionListener{
    JTextField jtf = new JTextField(10);
    JLabel label = new JLabel("введите от 0 до 20");
    Font fnt = new Font("Calibri", Font.PLAIN, 20);
    JButton button = new JButton("проверка");
    Random random = new Random();
    int a = random.nextInt(20);
    int num = 1;
    public Main() {
        super("Игра-угадайка");
        setLayout(new FlowLayout());
        setSize(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(label);
        label.setFont(fnt);
        add(jtf);
        jtf.setFont(fnt);

        add(button);
        button.setFont(fnt);

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == button){

                    if(num == 3 && Integer.parseInt(jtf.getText()) != a){
                        JOptionPane.showMessageDialog(null, "Вы проиграли( Число было равно " + a);
                        setVisible(false);
                        System.exit(0);
                    }
                    if(Integer.parseInt(jtf.getText()) < 0 || Integer.parseInt(jtf.getText()) > 20){
                        JOptionPane.showMessageDialog(null, "Число должно быть от 0 до 20, попыток осталось:" + (3-num));
                        num++;

                    }else if (Integer.parseInt(jtf.getText()) == a){
                        JOptionPane.showMessageDialog(null, "Вы победили!!!");
                        setVisible(false);
                        System.exit(0);
                    }else if(Integer.parseInt(jtf.getText()) < a && num != 3) {
                        JOptionPane.showMessageDialog(null, "Число больше");
                        num++;
                    }else if (Integer.parseInt(jtf.getText()) > a && num != 3) {
                        JOptionPane.showMessageDialog(null, "Число меньше");
                        num++;
                    }

                }
            }
        });
    }

    public void actionPerformed(ActionEvent event) {}

    public static void main(String[] args) {
        new Main();
    }
}