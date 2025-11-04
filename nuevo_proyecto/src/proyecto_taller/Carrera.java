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

        this.autosPilotos = new ArrayList<>(); 
        

    } 

    public Carrera(String fecha, int vueltas, String hora, AutoPiloto autoPiloto) {

        this.fechaRealizacion = fecha; 

        this.numeroVueltas = vueltas; 

        this.horaRealizacion = hora; 
        
        this.agregarParticipante(autoPiloto);
    

    } 

    public Carrera(String fecha, int vueltas, String hora) {

        this.fechaRealizacion = fecha;

        this.numeroVueltas = vueltas;

        this.horaRealizacion = hora;
    }


    public String getFechaRealizacion() {

        return fechaRealizacion; 
    } 

    public int getVueltas() {

        return numeroVueltas;
    }  

    public String getHoraRealizacion() {

        return horaRealizacion; 
    } 


    public Pais getPaisCarrera() {

        return pais;

    }


    public ArrayList<AutoPiloto> getAutosPilotos() {

        return autosPilotos;
    }



    public boolean existeCircuito() {

        return this.circuito != null;
    }
    


    public void setCircuito(Circuito circuito) {

        if (existeCircuito()) {

            System.out.println("El circuito se encuentra asignado.");

            return; 

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

        if (existePais()) {

            System.out.println("Hay un país asignado."); 

            return;  
        }

        this.pais = pais;

    }

 
    public void agregarParticipante(AutoPiloto autoPiloto) {

        if (autoPiloto == null) {

          System.out.println("Datos inválidos.");

          return;

        }

        for (AutoPiloto ap : autosPilotos) {

            if (ap.getAuto().equals(autoPiloto.getAuto())) {

               System.out.println("El auto ya está asignado a otro piloto en esta carrera.");
               
               return;

            }

            if (ap.getPiloto().equals(autoPiloto.getPiloto())) {

                System.out.println("El piloto está participando en la carrera."); 

                return;
            }
        }

        autosPilotos.add(autoPiloto); 

       
    }


    
}