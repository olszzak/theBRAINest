
public class BazaPytan {
    public String[][] init(int nrPytania){
        String tab[][]=new String[13][2];               //tablica na pytania
        String tabOdp[][]=new String[1][2];             //tablica do przekazania

        tab[0][0]="Oblicz pole koła; r=2, π=3.14";
        tab[0][1]="12.56";

        tab[1][0]="Oblicz pole koła; r=1, π=3.14";
        tab[1][1]="3.14";

        tab[2][0]="Oblicz obwód koła; r=2, π=3.14";
        tab[2][1]="12.56";

        tab[3][0]="Oblicz obwód koła; r=5, π=3.14";
        tab[3][1]="31.4";

        tab[4][0]="Oblicz objętość walca; r=1, π.=3.14, h=2";
        tab[4][1]="6.28";

        tab[5][0]="Oblicz objętość walca; r=2, π=3.14, h=2";
        tab[5][1]="25.12";

        tab[6][0]="Oblicz pole całkowite walca; r=2, π=3.14, h=2";
        tab[6][1]="50.24";

        tab[7][0]="Oblicz pole całkowite walca; r=1, π=3.14, h=5";
        tab[7][1]="37.68";
//--
        tab[8][0]="Oblicz obwód trójkąta; a=2, b=3";
        tab[8][1]="8";

        tab[9][0]="Oblicz obwód trójkąta; a=6, b=8";
        tab[9][1]="22";

        tab[10][0]="Oblicz pole trójkąta; a=6, h=8";
        tab[10][1]="24";

        tab[11][0]="Oblicz pole trójkąta; a=2, h=5";
        tab[11][1]="5";

        tab[12][0]="Oblicz pole trójkąta; a=10, h=5";
        tab[12][1]="25";

        tabOdp[0][0]=tab[nrPytania][0];
        tabOdp[0][1]=tab[nrPytania][1];
        return tabOdp;
    }
}
