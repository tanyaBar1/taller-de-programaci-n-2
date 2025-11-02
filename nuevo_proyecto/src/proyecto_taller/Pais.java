package proyecto_taller;

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

   
  public boolean existeCarrera(Carrera carrera) {

    for (Carrera c : carreras) {
      
      if (c.getFecha().equals(carrera.getFecha()) && c.getHora().equals(carrera.getHora())) {

        return true;

      }

    } 

    return false;
  }



  public boolean disponibilidadCircuito(Carrera car) {
    
    for (Carrera  c : carreras) {

      if (c.existeCircuito()) {

        if (c.getCircuito().equals(car.getCircuito())) {
       
          return true;

        }

      }

      else {

        System.out.println("El circuito no existe.");
      }

    }

    return false;
    
  }



  public Carrera crearCarrera(String fecha, int numVueltas, String horario) {

    return new Carrera(fecha, numVueltas, horario); 

  } 


  public void planificarCarrera(Carrera nuevaCarrera, String fecha, int numVueltas, String horario, Circuito circuito) {

    if (!(this.existeCarrera(nuevaCarrera)) && !disponibilidadCircuito(nuevaCarrera)) {

      nuevaCarrera = crearCarrera(fecha, numVueltas, horario); 

      Circuito nuevoCircuito = new Circuito(); 

      nuevaCarrera.setCircuito(circuito); 

      carreras.add(nuevaCarrera); 

    }

    else if (existeCarrera(nuevaCarrera) && disponibilidadCircuito(nuevaCarrera)) {

      System.out.println("No pueden haber dos carreras en un mismo circuito."); 

    } 

  }

    
  public void registrarParticipanteACarrera(Carrera carrera, AutoPiloto participante) {

    carrera.agregarParticipante(participante);

  }


   



}




  
