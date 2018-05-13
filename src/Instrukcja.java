import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Instrukcja extends JFrame{
    public void init(){
        setUndecorated(true);                                   //okno
        setSize(1024,768);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("back0.jpg"));   //tlo
        add(background);

        background.setLayout(new BorderLayout());

        JButton mark = new JButton(new ImageIcon("sign.png"));
        ImageIcon sign=new ImageIcon("sign.png");
        mark.setBorder(null);
        mark.setContentAreaFilled(false);
        mark.setBounds(735, 734, sign.getIconWidth(), sign.getIconHeight());
        background.add(mark);

        JLabel label = new JLabel("<html><font color='white' size='4'>Po naciśnięciu START roczpoczynamy rozgrywkę.<br> Rozgrywka polega na (w 1 etapie) jak najszybszym znalezieniu dwóch takich samych obrazków<br> oraz znalezieniu rzutu figury przedstawinej u góry i, po wybraniu odpowiedniego, obliczeniu i wpisaniu losowej wartości(2 etap).<br>Pomiędzy etapami pojawi się zbiór wzorów geometrycznych przydatnych w końcowym etapie gry.</font></html>");
        JButton start=new JButton(new ImageIcon("start.png"));
        start.setBorder(null);
        start.setContentAreaFilled(false);


        background.add(label,BorderLayout.CENTER);
        background.add(start,BorderLayout.SOUTH);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start start=new Start();
                start.init();
                start.setVisible(true);
                setVisible(false);

            }

        });
    }

}
