package proyecto_taller;

import java.util.List;

import java.util.ArrayList;

public class Escuderia {
   
    private String nombreEsc;

    private List<Auto> autos;

    private Pais pais;

    private ArrayList<PilotoEscuderia> contratoEscuderia;

    private ArrayList<Mecanico> mecanicos;


    public Escuderia() {

        nombreEsc = "";

        contratoEscuderia = new ArrayList<>(); 

        autos = new ArrayList<>(); 

        mecanicos = new ArrayList<>(); 

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


    public void setPaisEsc(Pais pais){

        if (existePais() == true) {

            System.out.println("Hay un país asignado: " + this.getPaisEsc()); 

            
        }

        this.pais = pais;

    } 


    public Piloto crearPiloto(String dni, String nombre, String apellido) {

        return new Piloto(dni, nombre, apellido); 
    }



    public boolean pilotoInscrito(Piloto piloto) { 

        for (PilotoEscuderia p : contratoEscuderia) {

            if (p.getPiloto().getDni().equals(piloto.getDni())) {

                return true; 


            }

        }

        return false; 
    }


    public void agregarPiloto(Piloto p, String dni, String nombre, String apellido, String fechaInicio, String fechaFin) {

        if (pilotoInscrito(p) == true) {

            System.out.println("El piloto está inscrito en la escudería.");

        } 

        else {

            Piloto piloto = crearPiloto(dni, nombre, apellido); 

            PilotoEscuderia nuevoPiloto = new PilotoEscuderia(piloto, this, fechaInicio, fechaFin);

            contratoEscuderia.add(nuevoPiloto);
        }

    } 


    public boolean existeAuto(Auto auto) {

        for (Auto a : autos) {

            if (a.getModelo().equals(auto.getModelo()) && a.getMotor().equals(auto.getMotor())) { 

                return true; 


            }
        }

        return false;
    } 


    public void agregarAutos(Auto auto, String modelo, String motor) {

        if (existeAuto(auto) == true) {

            System.out.println("El auto " + auto + " se encuentra registrado en la escudería."); 


        } 

        else {

            Auto nuevoAuto = new Auto(modelo, motor); 

            nuevoAuto.setEscuderia(this); 

            autos.add(nuevoAuto); 
            
            
        }
    } 


    public boolean existeMecanico(Mecanico mecanico) {

        for (Mecanico m : mecanicos) {

            if (m.getDni().equals(mecanico.getDni())) {

                return true;
            }
        } 

        return false; 

    }


    public void agregarMecanico(Mecanico mecanico, String dni, String nombre, String apellido, int aniosExperiencia, Especialidad especialidad) {

        if (existeMecanico(mecanico) == true) {

            System.out.println("El mecánico ya está registrado."); 

        } 

        else {

            Mecanico nuevoMecanico = new Mecanico(dni, nombre, apellido, aniosExperiencia, especialidad); 

            mecanicos.add(nuevoMecanico); 

        }
    }


}