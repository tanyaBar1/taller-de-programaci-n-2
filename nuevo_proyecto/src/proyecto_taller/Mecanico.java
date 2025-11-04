package proyecto_taller; 

import java.util.ArrayList;

public class Mecanico extends Persona {

    private int aniosExperiencia; 

    private Especialidad especialidad; 

    private ArrayList<Escuderia> escuderias; 


    public Mecanico() {

        super(); 

        aniosExperiencia = 0; 

        especialidad = null;

        this.escuderias = new ArrayList<>();


    } 


    public Mecanico(String d, String n, String a, int anios, Especialidad e, Escuderia escuderia) {

        super(d, n, a); 

        this.aniosExperiencia = anios; 

        this.especialidad = e; 

        this.agregarEscuderia(escuderia);
 

    }  


    public Mecanico(String d, String n, String a, int anios, Especialidad e) {

        super(d, n, a);  

        this.aniosExperiencia = anios; 

        this.especialidad = e; 
    }




    public int getAnios() {

        return aniosExperiencia; 

    } 


    public Especialidad getEspecialidad() {

        return especialidad; 
    }


    public boolean existeEscuderia(Escuderia esc) {

        for (Escuderia e : escuderias) {

            if (e.getNombreEscuderia().equalsIgnoreCase(esc.getNombreEscuderia())) {

                return true; 
            }
        }

        return false; 

    }


    public void agregarEscuderia(Escuderia escuderia) {

        if (escuderia == null) {

            System.out.println("Es necesario que exista una escudería.");

            return;
        }

        if (existeEscuderia(escuderia)) {

            System.out.println("La escudería ya existe.");

            return;

        } 

        escuderias.add(escuderia); 
    
    }

}