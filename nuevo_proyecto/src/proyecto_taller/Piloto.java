package proyecto_taller;

import java.util.ArrayList; 

public class Piloto extends Persona {

    private int numeroCompetencia; 

    private int victorias; 

    private int polePosition;

    private int vueltasRapidas; 

    private int podios; 

    private ArrayList<PilotoEscuderia> pilotoEscuderia; 

    private ArrayList<AutoPiloto> pilotoAuto;

    
    public Piloto() {

        super();

        numeroCompetencia = 0; 

        victorias = 0;

        polePosition = 0; 

        vueltasRapidas = 0; 

        podios = 0; 

        this.pilotoEscuderia = new ArrayList<>(); 

        this.pilotoAuto = new ArrayList<>();

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


    public ArrayList<PilotoEscuderia> getPilotoEscuderia() {

        return pilotoEscuderia;
    }


    public ArrayList<AutoPiloto> getPilotoAuto() {

        return pilotoAuto;
    }


    public void setPolePosition(int polePosition) {

        if (polePosition >= 0) {

            this.polePosition = polePosition;

        }

    }
 

    public int calcularPosicionPiloto(int puesto, boolean vueltaRapida) {

        this.numeroCompetencia++;

        int puntos = 0; 


        switch (puesto) {

            case 1:

                this.victorias++;

                this.podios++;

                puntos = 25; 

                break; 


            case 2:

                this.podios++;

                puntos = 18; 

                break; 
                

            case 3:

                this.podios++;
               
                puntos = 15; 

                break; 


            case 4:

                puntos = 12; 

                break; 


            case 5:

                puntos = 10; 

                break; 


            case 6:

                puntos = 8; 

                break; 


            case 7:
 

                puntos = 6; 

                break; 


            case 8:


                puntos = 4; 

                break; 



            case 9:


                puntos = 2; 

                break; 



            case 10:

                puntos = 1; 

                break; 


            default:

                puntos = 0;

                break; 

        }
        

        if (vueltaRapida && puesto <= 10) {

            this.vueltasRapidas++;

            puntos += 1; 

        }

        return puntos;

    }   

     
}