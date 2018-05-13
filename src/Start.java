import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Start extends JFrame {

    int liczbaKlikniec = 0;
    Instant start, stop;
    Duration time1;

    public void init() {
        setUndecorated(true);                                                   //ustawienia okna programu (domyslne dla calej aplikacji, wszedzie to samo)
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setResizable(false);


        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("back1.jpg"));
        add(background);

        background.setLayout(new FlowLayout());

        JButton mark = new JButton(new ImageIcon("sign.png"));
        ImageIcon sign=new ImageIcon("sign.png");
        mark.setBorder(null);
        mark.setContentAreaFilled(false);
        mark.setBounds(735, 734, sign.getIconWidth(), sign.getIconHeight());    //umieszczenie "na twardo" znaku wodnego w miejscu: 735, 734. Rozmiar obrazka pobrany dzieki getIconWidth() itd
        background.add(mark);

        JButton[] jb = new JButton[6];
        background.setLayout(null);
        for (int i = 0; i <= 5; i++) {
            jb[i] = new JButton("jb " + i);
        }


        ImageIcon a = new ImageIcon("1_1.png");
        ImageIcon b = new ImageIcon("1_2.png");
        ImageIcon c = new ImageIcon("1_3.png");
        ImageIcon d = new ImageIcon("1_4.png");
        ImageIcon e = new ImageIcon("1_5.png");

        ImageIcon tab[] = new ImageIcon[5];                         //tablica obrazow (kafelki z 1 planszy gry)
        tab[0] = a;
        tab[1] = b;
        tab[2] = c;
        tab[3] = d;
        tab[4] = e;

        boolean jest[] = new boolean[5];                            //tablica bool dla losowania kafelkow bez powtarzania
        int j;
        String jbaklik, jbbklik, jbcklik, jbdklik, jbeklik, jbfklik;

        Random r = new Random();
        start = Instant.now();                                      //do start zapisywany jest obecny czas


        j = r.nextInt(5);                                   //losowanie liczy <0;5) bo jest 5 roznych kafelkow
        jbaklik = tab[j].getDescription();                          //do jbaklik zapisywana jest nazwa kafelka bedacego pod JButtonem jba
        JButton jba = new JButton(tab[j]);                          //JButton jba
        jba.setBorder(null);
        jba.setContentAreaFilled(false);
        jba.setBounds(250, 150, tab[j].getIconWidth(), tab[j].getIconHeight());
        background.add(jba);

        j = r.nextInt(5);                                   //losowanie liczy <0;5) bo jest 5 roznych kafelkow
        while (jest[j]) {                                           //dopoki w tablicy bool "jest" pod nr j jest true losowana jest kolejna liczba
            j = r.nextInt(5);
        }
        jest[j] = true;                                             //w tablicy "jest" pod nr j wpisywane jest true (bo juz JEST wybrany kafelek pod tym nr)

        jbbklik = tab[j].getDescription();                          //do jbbklik zapisywana jest nazwa kafelka bedacego pod JButtonem jbb
        JButton jbb = new JButton(tab[j]);                          //JButton jbb, ktory bedzie pod obrazem pod nr j w tablicy "tab" kafelek
        jbb.setBorder(null);
        jbb.setContentAreaFilled(false);
        jbb.setBounds(250, 350, tab[j].getIconWidth(), tab[j].getIconHeight());
        background.add(jbb);
                                                                    //analogiczne losowanie i dodawanie pozostalych kafelek jako JButtonow
        j = r.nextInt(5);
        while (jest[j]) {
            j = r.nextInt(5);
        }
        jest[j] = true;
        jbcklik = tab[j].getDescription();
        JButton jbc = new JButton(tab[j]);
        jbc.setBorder(null);
        jbc.setContentAreaFilled(false);
        jbc.setBounds(450, 200, tab[j].getIconWidth(), tab[j].getIconHeight());
        background.add(jbc);

        j = r.nextInt(5);
        while (jest[j]) {
            j = r.nextInt(5);
        }
        jest[j] = true;
        jbdklik = tab[j].getDescription();
        JButton jbd = new JButton(tab[j]);
        jbd.setBorder(null);
        jbd.setContentAreaFilled(false);
        jbd.setBounds(450, 400, tab[j].getIconWidth(), tab[j].getIconHeight());
        background.add(jbd);

        j = r.nextInt(5);
        while (jest[j]) {
            j = r.nextInt(5);
        }
        jest[j] = true;
        jbeklik = tab[j].getDescription();
        JButton jbe = new JButton(tab[j]);
        jbe.setBorder(null);
        jbe.setContentAreaFilled(false);
        jbe.setBounds(650, 150, tab[j].getIconWidth(), tab[j].getIconHeight());
        background.add(jbe);

        j = r.nextInt(5);
        while (jest[j]) {
            j = r.nextInt(5);
        }
        jest[j] = true;
        jbfklik = tab[j].getDescription();
        JButton jbf = new JButton(tab[j]);
        jbf.setBorder(null);
        jbf.setContentAreaFilled(false);
        jbf.setBounds(650, 350, tab[j].getIconWidth(), tab[j].getIconHeight());
        background.add(jbf);


        String klik[][] = new String[100][2];                                           //utworzenie tablicy do zapisywania w niej historii klikniec kafelkow

        jba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczbaKlikniec++;                                                       //licznik klikniec kafelkow

                klik[liczbaKlikniec][0] = jbaklik;                                      //zapisanie do tablicy klik zawartosc jbaklik(czyli nazwa obrazu bedacego pod JButtonem jba)
                klik[liczbaKlikniec][1] = "jbaklik";                                    //zapisanie do tablicy klik ze kliknieto JButton jba

                if (liczbaKlikniec >= 2) {                                              //musza byc conajmniej dwa klikniecia
                    if (klik[liczbaKlikniec - 1][0] == jbaklik & klik[liczbaKlikniec - 1][1] != "jbaklik") {    //sprawdzenie czy w poprzednim kliknieciu kliknelo sie na kafelek pod ktorym byl taki sam obraz, oraz czy nie kliknelo sie dwa razy na ten sam JButton

                        Wzory sukces = new Wzory();                                     //klasa wzory pod lokalna nazwa sukces

                        stop = Instant.now();                                           //pod stop podstawia sie obecny czas
                        time1=Duration.between(start,stop);                             //time1 = roznica czasu pmiedzy startem a stopem czy czas gry na tej planszy

                        sukces.init(time1);                                             //startujemy init() w sukcesie i przesylamy do niego czas rozgrywki
                        sukces.setVisible(true);                                        //sukces on
                        setVisible(false);                                              //start off

                    }
                }

            }
        });

        jbb.addActionListener(new ActionListener() {                                    //pozostale przyciski analogicznie
            @Override
            public void actionPerformed(ActionEvent e) {
                liczbaKlikniec++;

                klik[liczbaKlikniec][0] = jbbklik;
                klik[liczbaKlikniec][1] = "jbbklik";

                if (liczbaKlikniec >= 2) {
                    if (klik[liczbaKlikniec - 1][0] == jbbklik & klik[liczbaKlikniec - 1][1] != "jbbklik") {
                        Wzory sukces = new Wzory();

                        stop = Instant.now();
                        time1=Duration.between(start,stop);

                        sukces.init(time1);
                        sukces.setVisible(true);
                        setVisible(false);
                    }
                }

            }
        });

        jbc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczbaKlikniec++;

                klik[liczbaKlikniec][0] = jbcklik;
                klik[liczbaKlikniec][1] = "jbcklik";

                if (liczbaKlikniec >= 2) {
                    if (klik[liczbaKlikniec - 1][0] == jbcklik & klik[liczbaKlikniec - 1][1] != "jbcklik") {
                        Wzory sukces = new Wzory();

                        stop = Instant.now();
                        time1=Duration.between(start,stop);

                        sukces.init(time1);
                        sukces.setVisible(true);
                        setVisible(false);
                    }
                }

            }
        });

        jbd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczbaKlikniec++;

                klik[liczbaKlikniec][0] = jbdklik;
                klik[liczbaKlikniec][1] = "jbdklik";

                if (liczbaKlikniec >= 2) {
                    if (klik[liczbaKlikniec - 1][0] == jbdklik & klik[liczbaKlikniec - 1][1] != "jbdklik") {
                        Wzory sukces = new Wzory();

                        stop = Instant.now();
                        time1=Duration.between(start,stop);

                        sukces.init(time1);
                        sukces.setVisible(true);
                        setVisible(false);
                    }
                }

            }
        });

        jbe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczbaKlikniec++;

                klik[liczbaKlikniec][0] = jbeklik;
                klik[liczbaKlikniec][1] = "jbeklik";

                if (liczbaKlikniec >= 2) {
                    if (klik[liczbaKlikniec - 1][0] == jbeklik & klik[liczbaKlikniec - 1][1] != "jbeklik") {
                        Wzory sukces = new Wzory();

                        stop = Instant.now();
                        time1=Duration.between(start,stop);

                        sukces.init(time1);
                        sukces.setVisible(true);
                        setVisible(false);
                    }
                }

            }
        });
        jbf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczbaKlikniec++;

                klik[liczbaKlikniec][0] = jbfklik;
                klik[liczbaKlikniec][1] = "jbfklik";

                if (liczbaKlikniec >= 2) {
                    if (klik[liczbaKlikniec - 1][0] == jbfklik & klik[liczbaKlikniec - 1][1] != "jbfklik") {
                        Wzory sukces = new Wzory();

                        stop = Instant.now();
                        time1=Duration.between(start,stop);

                        sukces.init(time1);
                        sukces.setVisible(true);
                        setVisible(false);
                    }
                }

            }
        });

    }


}