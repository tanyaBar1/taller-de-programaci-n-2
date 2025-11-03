package proyecto_taller;

import java.util.ArrayList; 

public class AutoPiloto {

    private String fechaAsignacion;

    private Auto auto;

    private Piloto piloto;

    private ArrayList<Carrera> carreras; 


    public AutoPiloto() {

        fechaAsignacion = " "; 

        this.carreras = new ArrayList<>();

    } 


    public AutoPiloto(String fecha) {

        this.fechaAsignacion = fecha;   

    } 


    public String getFechaAsignacion() {

        return fechaAsignacion; 
    }


    public Auto getAuto() {

        return auto;
    }


    public void setAuto(Auto auto) {

        this.auto = auto;
    }


    public Piloto getPiloto() {

        return piloto;
    }


    public void setPiloto(Piloto piloto) {
        
        this.piloto = piloto;
    }


    public ArrayList<Carrera> getCarreras() {

        return carreras;

    }

    
    public boolean verificarAuto(String modelo, String motor) {

       return auto.getEscuderia().existeAuto(modelo, motor);

    }

    
    public boolean verificarContratoPiloto(PilotoEscuderia pilotoEsc, Escuderia escuderia) {
        
        return pilotoEsc.getEscuderia().equals(escuderia);

    }




    public void asignarAutoPiloto(String modelo, String motor, PilotoEscuderia pilotoEsc, Escuderia escuderia, Piloto piloto, Auto auto, String fecha) {

        if (!verificarAuto(modelo, motor)) {

            System.out.println("El auto no está registrado en la escudería."); 

            return;
        }

        if (!verificarContratoPiloto(pilotoEsc, escuderia)) {

            System.out.println("El piloto no tiene contrato con la escudería."); 

            return; 
        }

        if (this.fechaAsignacion != null && !this.fechaAsignacion.isEmpty()) {

            System.out.println("Existe un contrato auto-piloto.");

            return;
        }

        this.auto = auto;

        this.piloto = piloto;

        this.fechaAsignacion = fecha;


        piloto.getPilotoAuto().add(this);

        auto.getAutoPiloto().add(this); 

    }



    public boolean verificarContratoAutoPiloto(Auto auto, Piloto piloto, String fechaAsignacion) {
         
        return this.auto.equals(auto) && this.piloto.equals(piloto) && this.fechaAsignacion.equals(fechaAsignacion);

    }

    
}