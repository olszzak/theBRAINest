import java.util.Random;

public class LosowaniePytan {

    public Integer init(Integer nrFigury){

        Random r=new Random();
        int odp;

        odp=10;                         //podstawienie proforma, dla skompilowania kodu

        if(nrFigury>=0 & nrFigury<=4){
            odp=r.nextInt(8);
        }
        if(nrFigury>=5 & nrFigury<=9){
            odp=r.nextInt(4)+8;
        }

        return odp;
    }
}
