import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

public class Wzory extends JFrame{

    public void init(Duration time){
        setUndecorated(true);                                                           //okno
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("back1.jpg"));             //tlo
        add(background);

        JButton mark = new JButton(new ImageIcon("sign.png"));
        ImageIcon sign=new ImageIcon("sign.png");
        mark.setBorder(null);
        mark.setContentAreaFilled(false);
        mark.setBounds(735, 734, sign.getIconWidth(), sign.getIconHeight());
        background.add(mark);


        JLabel osiagniecie=new JLabel("Udało się i osiągnąłeś to w czasie "+time.getSeconds()+"."+time.getNano()/1000000+" sekund.");
        osiagniecie.setForeground(Color.WHITE);                                          //kolor JLabela osiagniecie
        osiagniecie.setFont(new Font("Arial",Font.BOLD,11));
        osiagniecie.setBounds(100,20,450,100);
        background.add(osiagniecie);

        JLabel instr=new JLabel("A teraz spójrz na poniższe wzory (zaraz z nich skorzystasz)");
        instr.setForeground(Color.WHITE);
        instr.setBounds(280,50,650,100);
        instr.setFont(new Font("Arial",Font.BOLD,15));
        background.add(instr);

        JButton kolo = new JButton(new ImageIcon("kolo.png"));
        ImageIcon koloObraz=new ImageIcon("kolo.png");
        kolo.setBorder(null);
        kolo.setContentAreaFilled(false);
        kolo.setBounds(120, 180, koloObraz.getIconWidth(), koloObraz.getIconHeight());
        background.add(kolo);

        JButton prostokat = new JButton(new ImageIcon("prostokat.png"));
        ImageIcon prostokatObraz=new ImageIcon("prostokat.png");
        prostokat.setBorder(null);
        prostokat.setContentAreaFilled(false);
        prostokat.setBounds(120, 450, prostokatObraz.getIconWidth(), prostokatObraz.getIconHeight());
        background.add(prostokat);

        JButton trojkat = new JButton(new ImageIcon("trojkat.png"));
        ImageIcon trojkatObraz=new ImageIcon("trojkat.png");
        trojkat.setBorder(null);
        trojkat.setContentAreaFilled(false);
        trojkat.setBounds(550, 160, trojkatObraz.getIconWidth(), trojkatObraz.getIconHeight());
        background.add(trojkat);

        JButton walec = new JButton(new ImageIcon("walec.png"));
        ImageIcon walecObraz=new ImageIcon("walec.png");
        walec.setBorder(null);
        walec.setContentAreaFilled(false);
        walec.setBounds(550, 430, walecObraz.getIconWidth(), walecObraz.getIconHeight());
        background.add(walec);

        JButton start = new JButton(new ImageIcon("start.png"));
        ImageIcon startObraz=new ImageIcon("start.png");
        start.setBorder(null);
        start.setContentAreaFilled(false);
        start.setBounds(400, 650, startObraz.getIconWidth(), startObraz.getIconHeight());
        background.add(start);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kola start=new Kola();                              //klsa Kola pod lokalna nazwa start
                start.init(time);                                   //startowanie init() ze startu i przekazanie time

                start.setVisible(true);                             //start on
                setVisible(false);                                  //wzory off
            }
        });


    }
}
