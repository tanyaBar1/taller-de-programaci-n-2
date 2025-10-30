package nuevo_proyecto;

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


    public Piloto(String d, String n, String a, Pais pais, int comp, int vic, int pole, int vueltas, int podios) {

        super(d, n, a, pais); 

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


}