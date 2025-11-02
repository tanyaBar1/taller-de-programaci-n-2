package proyecto_taller;

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

        autosPilotos = new ArrayList<>(); 

    } 

    public Carrera(String fecha, int vueltas, String hora) {

        this.fechaRealizacion = fecha; 

        this.numeroVueltas = vueltas; 

        this.horaRealizacion = hora;  

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


    public Pais getPaisCar() {

        return pais;

    }



    public boolean existeCircuito() {

        return this.circuito != null;
    }
    


    public void setCircuito(Circuito circuito) {

        if (existeCircuito() == true) {

            System.out.println("El circuito se encuentra asignado.");

        }

        this.circuito = circuito; 

    }


    public Circuito getCircuito() {

        return circuito; 
    }


    public boolean existePais() {

        return this.pais != null;

    }


    public void setPais(Pais pais) {

        if (existePais() == true) {

            System.out.println("Hay un país asignado: " + this.getPaisCar()); 

            
        }

        this.pais = pais;

    }
 
    public void agregarParticipante(AutoPiloto autoPiloto){

        for (AutoPiloto ap : autosPilotos){
            if (ap.getFechaAsig().equals(autoPiloto.getFechaAsig())) {

                System.out.print(" el participante ya se encuentra asignado a la carrera");
                
            }
            
            else {
                
                autosPilotos.add(autoPiloto);
            }    
    
         }
    }

    
}