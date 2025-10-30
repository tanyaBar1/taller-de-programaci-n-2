package nuevo_proyecto; 

import java.util.ArrayList;

public class Mecanico extends Persona {

    private int aniosExperiencia; 

    private Especialidad especialidad; 

    private ArrayList<Escuderia> escuderias; 


    public Mecanico() {

        super(); 

        aniosExperiencia = 0; 

        especialidad = null;

        escuderias = new ArrayList<>();


    } 


    public Mecanico(String d, String n, String a, int anios, Especialidad e, Pais pais) {

        super(d, n, a, pais); 

        this.aniosExperiencia = anios; 

        this.especialidad = e; 

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

}