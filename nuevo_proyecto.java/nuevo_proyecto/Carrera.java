package nuevo_proyecto;

import java.util.ArrayList; 

public class Carrera {

    private String fechaRealizacion;

    private int numeroVueltas;

    private String horaRealizacion;

    private Pais pais;

    private Circuito circuito;

    private ArrayList<AutoPiloto> autosPilotos; 


    public Carrera() {

        fechaRealizacion = " ";

        numeroVueltas = 0; 

        horaRealizacion = " "; 

        pais = null;
        
        circuito = null; 

        autosPilotos = new ArrayList<>(); 

    } 

    public Carrera(String fecha, int vueltas, String hora, Pais pais, Circuito circuito) {

        this.fechaRealizacion = fecha; 

        this.numeroVueltas = vueltas; 

        this.horaRealizacion = hora; 

        this.pais = pais;

        this.circuito = circuito; 

    } 


    public String getFecha() {

        return fechaRealizacion; 
    } 

    public int getVueltas() {

        return numeroVueltas;
    }  

    public String getHora() {

        return horaRealizacion; 
    }
}