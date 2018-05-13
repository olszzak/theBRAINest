import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame{

    public void init() {

        this.setSize(1024,768);                       //rozmiar okna programu
        this.setLocationRelativeTo(null);                           //okno na srodku ekranu
        setUndecorated(true);                                       //brak windows'owatego paska u gory
        setResizable(false);                                        //brak mozliwosci zmiany rozmiaru okna programu


        setLayout(new BorderLayout());                              //nowy layout obecnej klasy
        setContentPane(new JLabel(new ImageIcon("back0.jpg")));//ustawienie tla jako "Pane". JLabel-w zawartosci obraz backo.jpg
        setLayout(new FlowLayout());


         JButton [] b=new JButton [2];
         b[0]=new JButton(new ImageIcon("START.png" ));
         b[1]=new JButton(new ImageIcon("INSTRUKCJA.png"));

        b[0].setBorder(null);                                       //korzystanie z przezroczystosci pliku .png (brak obramowania)
        b[0].setContentAreaFilled(false);                           //korzystanie z przezroczystosci pliku .png (brak wypelniania przezroczystego obszaru obrazu)

        b[1].setBorder(null);
        b[1].setContentAreaFilled(false);

        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS)); //nowy Layout dla klasy, w celu rozmieszczenia przyciskow

        add(Box.createRigidArea(new Dimension(0,200))); //pusty "pasek" o wysokosci 200 (dla rozmieszczena JButtonow)
        for(int i=0;i<b.length;i++){
            b[i].setAlignmentX(0.2f);
            this.add(b[i]);
            this.add(Box.createRigidArea(new Dimension(0,80)));
        }


        b[0].addActionListener(new ActionListener() {                  //po wcisnieciu przycisku b[0] nastepuje:
            public void actionPerformed(ActionEvent e) {
                Start start=new Start();                               //klasa Start, nazwana lokalnie start
                start.init();                                          //startuje init() w start

                start.setVisible(true);                                //start on
                setVisible(false);                                     //menu off
            }
        });

        b[1].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Instrukcja ins=new Instrukcja();
                ins.init();

                ins.setVisible(true);                                  //instrukcja on
                setVisible(false);                                     //menu off
            }
        });
    }



}
