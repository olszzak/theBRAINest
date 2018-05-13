import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class BRAIN { //poczatek programu. Gra startuje

    public static void main(String arg[]){

        Menu menu=new Menu();   //klasa Menu, nazwana lokalnie menu
        menu.init();            //wystartowanie init() z klasy Menu
        menu.setVisible(true);  //wyswietlenie menu

    }

}
