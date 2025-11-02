package proyecto_taller;

import java.util.ArrayList; 

public class Piloto extends Persona {

    private int numeroCompetencia; 

    private int victorias; 

    private int polePosition;

    private int vueltasRapidas; 

    private int podios; 

    private ArrayList<PilotoEscuderia> pilotoEscuderia; 

    private ArrayList<AutoPiloto> autoPiloto;

    
    public Piloto() {

        super();

        numeroCompetencia = 0; 

        victorias = 0;

        polePosition = 0; 

        vueltasRapidas = 0; 

        podios = 0; 

        pilotoEscuderia = new ArrayList<>(); 

        autoPiloto = new ArrayList<>();

    } 


    public Piloto(String d, String n, String a, int comp, int vic, int pole, int vueltas, int podios) {

        super(d, n, a); 

        this.numeroCompetencia = comp; 

        this.victorias = vic; 

        this.polePosition = pole; 

        this.vueltasRapidas = vueltas; 

        this.podios = podios; 

    } 


    public Piloto(String dni, String nombre, String apellido) {

        super(dni, nombre, apellido);
        
    }


    public int getCompetencias() {

        return numeroCompetencia; 
    } 


    public int getVictorias() {

        return victorias; 
    }


    public int getPosition() {

        return polePosition; 
    } 


    public int getVueltas() {

        return vueltasRapidas;
    }
    

    public int getPodios() {

        return podios; 
    } 


    public void setPolePosition(int polePosition) {

        if (polePosition >= 1 && polePosition <= 20) {

            this.polePosition = polePosition;

        }

    }
 

    public void calcularPosicionPiloto(int puesto, boolean vueltaRapida) {

        this.numeroCompetencia++;

        int puntos = 0; 

        boolean fueraTop10 = puesto > 10; 


        switch (puesto) {

            case 1:

                this.victorias++;

                this.podios++;

                puntos = 24; 

                break; 


            case 2:

                this.podios++;

                puntos = 17; 

                break; 
                

            case 3:

                this.podios++;
               
                puntos = 14; 

                break; 


            case 4:

                puntos = 11; 

                break; 


            case 5:

                puntos = 9; 

                break; 


            case 6:

                puntos = 7; 

                break; 


            case 7:
 

                puntos = 5; 

                break; 


            case 8:


                puntos = 3; 

                break; 



            case 9:


                puntos = 1; 

                break; 



            case 10:

                puntos = 0; 

                break; 


            default:

                puntos = 0; 

                fueraTop10 = true; 

                break; 

        }
        

        if (vueltaRapida && puesto <= 10) {

            this.vueltasRapidas++;

            puntos++; 

        }

    } 

     
}