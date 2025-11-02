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

        if (polePosition >= 1 && polePosition <= 10) {

            this.polePosition = polePosition;
        }

    }
 

    public int calcularPosicion(int puesto) {

        int puntos = 0; 

        switch (polePosition) {

            case 1:

                this.polePosition = puesto; 

                puntos = 25; 

                break; 

            case 2:

                this.polePosition = puesto; 

                puntos = 18; 

                break; 
                

            case 3:

                this.polePosition = puesto;
               
                puntos = 15; 

                break; 


            case 4:

                this.polePosition = puesto;

                puntos = 12; 

                break; 


            case 5:

               this.polePosition = puesto; 

                puntos = 10; 

                break; 

            case 6:

                this.polePosition = puesto;

                puntos = 8; 

                break; 

            case 7:

                this.polePosition = puesto; 

                puntos = 6; 

                break; 


            case 8:

                this.polePosition = puesto; 

                puntos = 4; 

                break; 


            case 9:

                this.polePosition = puesto;

                puntos = 2; 

                break; 



            case 10:

                this.polePosition = puesto; 

                puntos = 1; 

                break; 


            default:

                puntos = 0; 

                break; 

        }

        return puesto;
    } 

     
}