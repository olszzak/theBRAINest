import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

public class Finish extends JFrame {

    public void init(Duration time1, Duration time2){
        setUndecorated(true);                                                   //okno
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("back3.jpg"));     //tlo
        add(background);

        JButton mark = new JButton(new ImageIcon("sign.png"));
        ImageIcon sign=new ImageIcon("sign.png");
        mark.setBorder(null);
        mark.setContentAreaFilled(false);
        mark.setBounds(735, 734, sign.getIconWidth(), sign.getIconHeight());
        background.add(mark);

        long timeS=time1.getSeconds()+time2.getSeconds();                       //timeS to suma sekund uzyskanych czasow na planszy 1 i 3
        long timeN=time1.getNano()/1000000+time2.getNano()/1000000;             //timeN to suma czesci tysiecznych czasow uzyskanych na planszy 1 i 3

        JLabel osiagniecie=new JLabel("Twój łączny wynik wynosi  "+timeS+"."+timeN+" sekund.");
        osiagniecie.setForeground(Color.WHITE);
        osiagniecie.setFont(new Font("Arial",Font.BOLD,11));
        osiagniecie.setBounds(390,170,450,100);
        background.add(osiagniecie);

        ImageIcon wygranaObraz=new ImageIcon("WYGRANA.png");
        JButton wygrana=new JButton(wygranaObraz);
        wygrana.setBorder(null);
        wygrana.setContentAreaFilled(false);
        wygrana.setBounds(350, 155, wygranaObraz.getIconWidth(), wygranaObraz.getIconHeight());
        background.add(wygrana);


        if(timeS<20){                                                               //JLabel uzalezniony od uzyskanego wyniku
            JLabel rewelacja=new JLabel("Twój wynik jest rewelacyjny, ale...");
            rewelacja.setBounds(262,300,300,50);
            rewelacja.setForeground(Color.WHITE);
            background.add(rewelacja);
        }
        if(timeS>=20 & timeS<40)
        {
            JLabel supe=new JLabel("Osiągnąłeś super wynik, ale...");
            supe.setBounds(270,300,300,50);
            supe.setForeground(Color.WHITE);
            background.add(supe);
        }
        if(timeS>=40 & timeS<50)
        {
            JLabel srednio=new JLabel("Twój wynik pokazuje, że niewiele Ci brakuje, ale...");
            srednio.setBounds(270,300,350,50);
            srednio.setForeground(Color.WHITE);
            background.add(srednio);
        }
        if(timeS>=50)
        {
            JLabel slabo=new JLabel("Musisz troszkę popracować nad swoim wynikiem, ale...");
            slabo.setBounds(270,300,350,50);
            slabo.setForeground(Color.WHITE);
            background.add(slabo);
        }

        JLabel praca=new JLabel("..ale pamiętaj, że możesz go jeszcze poprawić oraz że uczysz się przez częste powtarzanie i ponowne gry!");
        praca.setBounds(250,310,600,100);
        praca.setForeground(Color.WHITE);
        background.add(praca);

        ImageIcon zakonczObraz=new ImageIcon("ZAKONCZ.png");
        JButton zakoncz=new JButton(zakonczObraz);
        zakoncz.setBorder(null);
        zakoncz.setContentAreaFilled(false);
        zakoncz.setBounds(150, 605, zakonczObraz.getIconWidth(), zakonczObraz.getIconHeight());
        background.add(zakoncz);

        ImageIcon sprobujObraz=new ImageIcon("SPROBUJ.png");
        JButton sprobuj=new JButton(sprobujObraz);
        sprobuj.setBorder(null);
        sprobuj.setContentAreaFilled(false);
        sprobuj.setBounds(550, 605, sprobujObraz.getIconWidth(), sprobujObraz.getIconHeight());
        background.add(sprobuj);

        zakoncz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        sprobuj.addActionListener(new ActionListener() {
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