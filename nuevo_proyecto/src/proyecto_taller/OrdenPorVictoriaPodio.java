package proyecto_taller;

import java.util.Comparator;

public class OrdenPorVictoriaPodio implements Comparator<Piloto> {

    @Override


    public int compare(Piloto p1, Piloto p2) {


        if (p1.getVictorias() > p2.getVictorias()) {

            return -1; 

        } else if (p1.getVictorias() < p2.getVictorias()) {

            return 1; 

        }

        if (p1.getPodios() > p2.getPodios()) {

            return -1; 


        }  else if (p1.getPodios() < p2.getPodios()) {

            return 1;

        }

        return 0;

    }



    
}
