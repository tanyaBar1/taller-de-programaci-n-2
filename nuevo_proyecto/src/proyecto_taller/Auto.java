package proyecto_taller;

import java.util.ArrayList;

public class Auto {

    private String modelo;

    private String motor;

    private Escuderia escuderia;

    private ArrayList <AutoPiloto> autoPiloto;


    public Auto() {

       modelo = "";

       motor = "";

       autoPiloto = new ArrayList<>();

    }

    
    public Auto(String modelo, String motor) {

        this.modelo = modelo; 

        this.motor = motor; 

        autoPiloto = new ArrayList<>();

    }


    public String getModelo() {

       return modelo;

    }


    public void setModelo(String modelo) {

       this.modelo = modelo;

    }


    public String getMotor() {

       return motor;

    } 


    public void setMotor(String motor) {

        this.motor = motor;

    }


    public Escuderia getEscuderia() {

        return escuderia;

    }


    public ArrayList<AutoPiloto> getAutoPiloto() {

        return autoPiloto;
    }
    

    public boolean igualAuto(Auto otro) {

        return this.modelo.equals(otro.getModelo()) && this.motor.equals(otro.getMotor());

    }


    public boolean pilotoAsignado(Piloto piloto) {

        for (AutoPiloto ap : autoPiloto) {

            if (ap.getPiloto().getDniPiloto().equals(piloto.getDniPiloto())) {

                return true;
            }

        }

        return false;
    }


    public boolean asignarPiloto(Piloto piloto, String fechaAsignacion) {

        if (pilotoAsignado(piloto)) {

            System.out.println("Este piloto ya está asignado a este auto.");

            return false;

        }

        for (AutoPiloto ap : autoPiloto) {

            if (ap.getFechaAsignacion().equals(fechaAsignacion)) {

                System.out.println("El auto ya tiene un piloto asignado en esa fecha.");

                return false;

            }

        }

        AutoPiloto nuevoAutoPiloto = new AutoPiloto(fechaAsignacion);

        nuevoAutoPiloto.setAuto(this);

        nuevoAutoPiloto.setPiloto(piloto);

        autoPiloto.add(nuevoAutoPiloto);

        return true;

    }


    public void setEscuderia(Escuderia esc) {

        if (existeEscuderia()) {

          System.out.println("La escudería está asignada."); 

          return;
        
        }

        this.escuderia = esc;

    }



    public boolean existeEscuderia() {

        return this.escuderia != null;

    }

    

}

