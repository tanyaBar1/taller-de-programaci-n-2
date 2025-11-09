package proyecto_taller;

import java.util.ArrayList; 

public class AutoPiloto implements Comparable<AutoPiloto> {

    private String fechaAsignacion;

    private Auto auto;

    private Piloto piloto;

    private ArrayList<Carrera> carreras; 

    private int puesto;

    private boolean vueltaRapida;

    private boolean resultadoRegistrado;


    public AutoPiloto() {

        fechaAsignacion = " "; 

        carreras = new ArrayList<>();

        puesto = 0;

        vueltaRapida = false;

        resultadoRegistrado = false;

        auto = null;

        piloto = null;

    } 


    public AutoPiloto(String fecha) {

        this.fechaAsignacion = fecha; 
        
        carreras = new ArrayList<>();

    } 


    public String getFechaAsignacion() {

        return fechaAsignacion; 
    }


    public Auto getAuto() {

        return auto;
    }


    public void setAuto(Auto auto) {

        if (auto == null) {

            System.out.println("El auto no puede ser nulo.");

            return;

        }

        if (auto.pilotoAsignado(piloto)) {

            System.out.println("El auto ya tiene un piloto asignado.");

            return;

        }


        this.auto = auto;
    }


    public Piloto getPiloto() {

        return piloto;
    }


    public void setPiloto(Piloto piloto) {

        if (piloto == null) {

            System.out.println("El piloto no puede ser nulo.");

            return;

        }

        if (auto != null && auto.pilotoAsignado(piloto)) {

            System.out.println("El piloto ya está asignado a otro auto.");

            return;

        }
        
        this.piloto = piloto;
    }


    public void setFechaAsignacion(String fechaAsignacion) {

        if (fechaAsignacion == null || fechaAsignacion.isEmpty()) {

           System.out.println("La fecha de asignación no puede ser nula o vacía.");

           return;
        }

        if (this.fechaAsignacion != null && !this.fechaAsignacion.isEmpty()) {

           System.out.println("Ya existe una fecha de asignación para este auto-piloto.");

           return;
        }
    }


    public ArrayList<Carrera> getCarreras() {

        return carreras;

    }


    public int getPuestoEnCarrera() {

        return puesto;
    }


    public boolean vueltaMasRapida() {

        return vueltaRapida;

    }


    public boolean resultadoEstaRegistrado() {

        return resultadoRegistrado;

    }


    public void setPuestoEnCarrera(int puesto) {

        this.puesto = puesto;

    }


    public void setVueltaMasRapida(boolean vueltaRapida) {

        this.vueltaRapida = vueltaRapida;

    }


    public void setResultadoEstaRegistrado(boolean resultadoRegistrado) {

        this.resultadoRegistrado = resultadoRegistrado; 

    }

    
    public boolean verificarAuto(String modelo, String motor) {

       return auto.getEscuderia().existeAuto(modelo, motor);

    }


    @Override

    public int compareTo(AutoPiloto otro) {

        return Integer.compare(this.puesto, otro.getPuestoEnCarrera());
        
    }

    
    public boolean verificarContratoPiloto(PilotoEscuderia pilotoEsc, Escuderia escuderia) {
        
        return pilotoEsc.getEscuderia().getNombreEscuderia().equals(escuderia.getNombreEscuderia());

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