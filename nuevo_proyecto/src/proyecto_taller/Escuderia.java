package proyecto_taller;

import java.util.ArrayList;

public class Escuderia {
   
    private String nombreEsc;

    private ArrayList<Auto> autos;

    private Pais pais;

    private ArrayList<PilotoEscuderia> contratoEscuderia;

    private ArrayList<Mecanico> mecanicos;


    public Escuderia() {

        this.nombreEsc = "";

        this.contratoEscuderia = new ArrayList<>(); 

        this.autos = new ArrayList<>(); 

        this.mecanicos = new ArrayList<>(); 

    }


    public Escuderia(String nombre) {

        this.nombreEsc = nombre;

         
        
    }

    public String getNombreEsc() {

        return nombreEsc;
    }

    public void setNombre(String nombre) {

        this.nombreEsc = nombre;
    }


    public Pais getPaisEsc() {

        return pais;
    }
    

    public boolean existePais() {

        return this.pais != null;

    }


    public void setPaisEsc(Pais pais) {

        if (existePais()) {

            System.out.println("Hay un país asignado. No se puede cambiar."); 

            return;

        }

        this.pais = pais;

    }



    public boolean pilotoInscrito(Piloto piloto) { 

        for (PilotoEscuderia p : contratoEscuderia) {

            if (p.getPiloto().getDni().equals(piloto.getDni())) {

                return true; 
            }

        }

        return false; 
    }


    public void agregarPiloto(Piloto piloto, String fechaInicio, String fechaFin) {

        if (pilotoInscrito(piloto)) {

            System.out.println("El piloto está inscrito en la escudería.");

            return;

        } 

        PilotoEscuderia nuevoContrato = new PilotoEscuderia(piloto, this, fechaInicio, fechaFin);

        contratoEscuderia.add(nuevoContrato);

        piloto.getPilotoEscuderia().add(nuevoContrato);
        

    } 


    public boolean existeAuto(String modelo, String motor) {

        for (Auto a : autos) {

            if (a.getModelo().equals(modelo) && a.getMotor().equals(motor)) { 

                return true; 


            }
        }

        return false;
    } 


    public void agregarAutos(String modelo, String motor) {

        if (existeAuto(modelo, motor)) {

            System.out.println("El auto se encuentra registrado en la escudería."); 

            return;

        } 

        Auto nuevoAuto = new Auto(modelo, motor); 

        nuevoAuto.setEscuderia(this); 

        autos.add(nuevoAuto); 
            
            
    } 


    public boolean existeMecanico(String dni) {

        for (Mecanico m : mecanicos) {

            if (m.getDni().equals(dni)) {

                return true;
            }
        } 

        return false; 

    }


    public void agregarMecanico(String dni, String nombre, String apellido, int aniosExperiencia, Especialidad especialidad) {

        if (existeMecanico(dni)) {

            System.out.println("El mecánico ya está registrado."); 

            return;

        } 

        Mecanico nuevoMecanico = new Mecanico(dni, nombre, apellido, aniosExperiencia, especialidad); 

        mecanicos.add(nuevoMecanico); 


    }
    


}