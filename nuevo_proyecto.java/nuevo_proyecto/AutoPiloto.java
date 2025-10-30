package nuevo_proyecto;

import java.util.ArrayList; 

public class AutoPiloto {

    private String fechaAsignacion; 
    private Auto auto;
    private Piloto piloto;
    private ArrayList<Carrera> carreras; 


    public AutoPiloto() {

        fechaAsignacion = " ";
        auto = null;
        piloto = null; 

        carreras = new ArrayList<>(); 
    } 


    public AutoPiloto(String fecha, Auto auto, Piloto piloto) {

        this.fechaAsignacion = fecha;
        this.auto = auto;
        this.piloto = piloto; 

    } 


    public String getFechaAsig() {

        return fechaAsignacion; 
    }

    public Auto getAuto(){
        return auto;
    }
    public void setAuto(Auto auto){
        this.auto = auto;
    }
    public Piloto getPiloto(){
        return piloto;
    }
    public void setPiloto(Piloto piloto){
        this.piloto = piloto;
    }

}