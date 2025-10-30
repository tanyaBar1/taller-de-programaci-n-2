package nuevo_proyecto;

import java.util.ArrayList;

public class Pais {
   
  private int id;

  private String descripcion;

  private ArrayList<Persona> personas; 

  private ArrayList<Escuderia> escuderias;

  private ArrayList<Carrera> carreras; 

  private ArrayList<Circuito> circuitos; 



  public Pais() {

    id = 0;

    descripcion = ""; 

    this.personas = new ArrayList<>();

    this.escuderias = new ArrayList<>();

    this.carreras = new ArrayList<>();

    this.circuitos = new ArrayList<>();

  }
     
  public Pais(int id, String descripcion) {

    this.id = id;

    this.descripcion = descripcion;
  }

  public int getId() {

    return id;

  }

  public void setId(int id) {

    this.id = id;

  }


  public String getDescripcion() {

    return descripcion;

  }


  public void setDescripcion (String descripcion) {

    this.descripcion = descripcion;

  }


  public boolean existeEscuderia(Escuderia esc) {

    for (Escuderia e : escuderias) {

      if (e.getNombreEsc().equals(esc.getNombreEsc())) {

        return true; 
      }

    }

    return false; 
  } 


  public void agregarEscuderia(Escuderia escuderia, String nombre) {

    if (existeEscuderia(escuderia) == true) {

      System.out.println("La escudería " + escuderia.getNombreEsc() + " ya existe."); 
    }

    Escuderia nuevaEscuderia = new Escuderia(nombre); 

    nuevaEscuderia.setPaisEsc(this); 

    escuderias.add(nuevaEscuderia); 
  }



  public boolean existePersona(Persona per) {

    for (Persona p : personas) {

      if (p.getDni().equals(per.getDni())) {

        return true; 
      }

    }

    return false; 
  } 

  

  public Persona crearPersona(String dni, String nombre, String apellido) {

    return new Persona(dni, nombre, apellido);

  }


  public void agregarPersonas(Persona p, String dni, String nombre, String apellido) {

    if (existePersona(p) == true) {

      System.out.println("La persona ya habita el país."); 

    }

    else {

      Persona nuevaPersona = crearPersona(dni, nombre, apellido); 

      personas.add(nuevaPersona); 

    }
  }


  
}