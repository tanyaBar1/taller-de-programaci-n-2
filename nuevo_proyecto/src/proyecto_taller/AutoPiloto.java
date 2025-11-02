package proyecto_taller;

import java.util.ArrayList; 

public class AutoPiloto {

    private String fechaAsignacion;

    private Auto auto;

    private Piloto piloto;

    private ArrayList<Carrera> carreras; 


    public AutoPiloto() {

        fechaAsignacion = " "; 

        carreras = new ArrayList<>();

    } 


    public AutoPiloto(String fecha) {

        this.fechaAsignacion = fecha;

         

    } 


    public String getFechaAsig() {

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

    
    public boolean verificarAuto(Auto auto) {

        if (auto.getEscuderia().existeAuto(auto)) {

            return true;

        }

        return false; 
    }
    
    public boolean verificarPiloto( Piloto piloto){
        
        if (piloto.getEscuderia().pilotoInscrito(piloto)){
            return true;
        }
        
        return false;
    }


    public void asignarAutoPiloto(Auto auto, Piloto piloto, String fecha) {

        if (verificarAuto(auto) && verificarPiloto(piloto)&& this.fechaAsignacion.equals (null)) {

            this.auto = auto;

            this.piloto = piloto; 
            
            this.fechaAsignacion = fecha;
        
        
        } else {

            System.out.println("El auto o el piloto no están registrados en la escudería.");

        }

    }

}