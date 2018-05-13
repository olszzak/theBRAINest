import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Kola extends JFrame{
    Instant start2, stop2;
    Duration time2;

    public void init(Duration time1){
        setUndecorated(true);                                                               //okno
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("back2.jpg"));                 //tlo
        add(background);

        JButton mark = new JButton(new ImageIcon("sign.png"));
        ImageIcon sign=new ImageIcon("sign.png");
        mark.setBorder(null);
        mark.setContentAreaFilled(false);
        mark.setBounds(735, 734, sign.getIconWidth(), sign.getIconHeight());
        background.add(mark);

        start2= Instant.now();                                               //start2=obecny czas

        int j,n,m;
        boolean pozycja[]=new boolean[3];                                   //tablic bool pt. pozycja bo beda 3 pozycje dla obrazkow

        for(int i=0;i<3;i++){
            pozycja[i]=false;                                               //narazie wszystkie pozycje NIE zajete wiec cala tablica wypelniona FALSE
        }

        Random r=new Random();
        j=r.nextInt(10);                                            //losowanie <0;10) bo jest 10 roznych modeli figur w zasobach

        JButton bok = new JButton(new ImageIcon("3_"+j+"bok.png")); //JButton pod wylosowanym obrazkiem
        ImageIcon bokObraz=new ImageIcon("3_"+j+"bok.png");
        bok.setBorder(null);
        bok.setContentAreaFilled(false);
        bok.setBounds(600, 100, bokObraz.getIconWidth(), bokObraz.getIconHeight());
        background.add(bok);

        n=r.nextInt(2);                                             //losowanie pozycji
        pozycja[n]=true;                                                    //oznaczenie jej jako zajetej
        JButton gora[]=new JButton[3];
        ImageIcon obraz[]=new ImageIcon[3];

        for(int i=0;i<3;i++){
            if(pozycja[i]){                                                //jezeli pozycja jest zajeta
                gora[i]=new JButton(new ImageIcon("3_"+j+"gora.png"));  //dodajemy rzut obrazu ktory wylosowalismy u gory czyli o nr j
                obraz[i]=new ImageIcon("3_"+j+"gora.png");

            } else {                                                        //a jezeli pozycja wolna
                m=r.nextInt(10);                                    //losowanie z bazy wszystkich rzutow
                gora[i]=new JButton(new ImageIcon("3_"+m+"gora.png"));  //dodawanie wyzej wylosowanego rzutu
                obraz[i]=new ImageIcon("3_"+m+"gora.png");

            }
        }
        gora[0].setBorder(null);
        gora[0].setContentAreaFilled(false);
        gora[0].setBounds(30, 400, obraz[0].getIconWidth(), obraz[0].getIconHeight());
        background.add(gora[0]);

        gora[1].setBorder(null);
        gora[1].setContentAreaFilled(false);
        gora[1].setBounds(330, 400, obraz[1].getIconWidth(), obraz[1].getIconHeight());
        background.add(gora[1]);

        gora[2].setBorder(null);
        gora[2].setContentAreaFilled(false);
        gora[2].setBounds(630, 400, obraz[2].getIconWidth(), obraz[2].getIconHeight());
        background.add(gora[2]);

        JButton go=new JButton(new ImageIcon("wyslij.png"));
        ImageIcon wyslij=new ImageIcon("wyslij.png");
        go.setBorder(null);
        go.setContentAreaFilled(false);
        background.add(go);

        JTextArea text=new JTextArea();                             //dodanie JTextArea na wpisanie wyniku dzialania
        background.add(text);

        String tekst1 = bokObraz.getDescription();                  //pod tekst1 nazwa obrazka "glownego", widocznego z boku do ktorego szukamy odpowiedniej pary
        int nrFigury=Integer.valueOf(tekst1.charAt(2))-48;          //zamienienie 3 znaku z nazwy pliku na liczbe numerowana od 0


        LosowaniePytan losowanie=new LosowaniePytan();              //klasa LosowaniePytan pod lookalna nazwa losowanie


        BazaPytan baza=new BazaPytan();                             //klasa BazaPytan pod lokalna nazwa baza
        String tab[][]=new String[2][];                             //tablica stringow dla tablicy z pytaniem i odpowiedzia z bazy

        tab=baza.init(losowanie.init(nrFigury));                    //zapelnienie tab pytaniem i odp z bazy. nr pytania jest wylosowany w losowanie. losowanie uzaleznione jest od przekazanej do klasy nrFigury
        double odpTab=Double.valueOf(tab[0][1]);                    //zamiana na liczbe odpowiedzi na pytanie bedacej na pozycji 0,1 w tablicy

        JLabel pytanie=new JLabel(tab[0][0]);
        pytanie.setForeground(Color.WHITE);
        background.add(pytanie);                                    //wyswietlanie bialego pytania


        gora[0].addActionListener(new ActionListener() {            //po kliknieciu na JButton gora[0]
            @Override
            public void actionPerformed(ActionEvent e) {

                String tekst1 = obraz[0].getDescription();          //pod tekst1 podstawiamy nazwe obrazku bedacego na pozycji JButtonu obraz[0]
                String tekst2 = bokObraz.getDescription();          //pod tekst2 podstawiamy nazwe obrazku bedacego "glownym" obrazem. bokObraz zostalo ustalone przy losowaniu na semj gorze

                if(tekst1.charAt(2)==tekst2.charAt(2)){                                         //sprawdzanie czy nr w nazwach obu obrazkow sa takie same, a wiec czy kliknieto na dobry rzut
                    go.setBounds(120,590,wyslij.getIconWidth(),wyslij.getIconHeight());   //jezeli tak pojawia sie przycisk przeslania odp na pytanie
                    text.setBounds(155,650,100,20);                         //pole na wpisanie odp
                    pytanie.setBounds(100,680,400,30);                      //oraz samo pytanie
                }
            }
        });

        gora[1].addActionListener(new ActionListener() {        //analogicznie wszystie JButtony
            @Override
            public void actionPerformed(ActionEvent e) {

                String tekst1 = obraz[1].getDescription();
                String tekst2 = bokObraz.getDescription();

                if(tekst1.charAt(2)==tekst2.charAt(2)){
                    go.setBounds(420,590,wyslij.getIconWidth(),wyslij.getIconHeight());
                    text.setBounds(455,650,100,20);
                    pytanie.setBounds(400,680,400,30);
                }
            }
        });

        gora[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String tekst1 = obraz[2].getDescription();
                String tekst2 = bokObraz.getDescription();

                if(tekst1.charAt(2)==tekst2.charAt(2)){
                    go.setBounds(720,590,wyslij.getIconWidth(),wyslij.getIconHeight());
                    text.setBounds(755,650,100,20);
                    pytanie.setBounds(700,680,400,30);
                }
            }
        });


        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double odp=Double.valueOf(text.getText());          //zamieniamy ze stringa na doubla odpowiedz wpisana w JTextArea

                if (odp == odpTab) {                                //jezeli odp wpisana jest taka sama jak odp pobrana z tablicy pytan to:
                    stop2= Instant.now();                           //pod stop2 podstawiamy obecny czas
                    time2=Duration.between(start2,stop2);           //mierzona jest roznica czasu

                    Finish finish = new Finish();                   //klasa Finish o nazwie lokalnej finish
                    finish.init(time1, time2);                      //startuje init() z finish z przekazaniem do niej time1 i time2
                    finish.setVisible(true);                        //finish on
                    setVisible(false);                              //kola off
                }
            }
        });



    }
}
