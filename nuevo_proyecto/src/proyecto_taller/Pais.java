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


  public boolean existeEscuderia(String nombre) {

    for (Escuderia e : escuderias) {

      if (e.getNombreEsc().equalsIgnoreCase(nombre)) {

        return true; 
      }

    }

    return false; 
  } 


  public void agregarEscuderia(String nombre) {

    if (existeEscuderia(nombre)) {

      System.out.println("La escudería ya existe."); 

      return;

    }

    Escuderia nuevaEscuderia = new Escuderia(nombre); 

    nuevaEscuderia.setPaisEsc(this); 

    escuderias.add(nuevaEscuderia); 
  }



  public boolean existePersona(String dni) {

    for (Persona p : personas) {

      if (p.getDni().equals(dni)) {

        return true; 
      }

    }

    return false; 
  } 

  


  public void agregarPersonas(String dni, String nombre, String apellido) {

    if (existePersona(dni)) {

      System.out.println("La persona ya habita el país."); 

      return;

    } 

    personas.add(new Persona(dni, nombre, apellido)); 

  }

   
  public boolean existeCarrera(Carrera carrera) {

    for (Carrera c : carreras) {
      
      if (c.getFechaRealizacion().equals(carrera.getFechaRealizacion()) && c.getHoraRealizacion().equals(carrera.getHoraRealizacion())) {

        return true;

      }

    } 

    return false;
  }



  public boolean disponibilidadCircuito(Circuito circuito, String fecha) {
    
    for (Carrera  c : carreras) {

      if (c.getCircuito().equals(circuito) && c.getFechaRealizacion().equals(fecha)) {
       
        return false;

      }

    }

    return true;
    
  }



  public void planificarCarrera(String fecha, int numVueltas, String horario, Circuito circuito) {

    if (!disponibilidadCircuito(circuito, fecha)) {

      System.out.println("El circuito se realizará otra carrera en la fecha correspondiente.");

      return;

    }

    Carrera nuevaCarrera = new Carrera(fecha, numVueltas, horario); 

    nuevaCarrera.setPais(this); 

    carreras.add(nuevaCarrera); 

    circuito.getCarrera().add(nuevaCarrera); 

    System.out.println("La carrera planificada se realizará en el circuito " + circuito.getNombreCircuito()); 

  }

    
  public void registrarParticipanteACarrera(Carrera carrera, AutoPiloto participante) {

    if (carrera == null || participante == null) {

      System.out.println("Datos inválidos o inexistentes."); 

      return; 

    }

    for (AutoPiloto ap : carrera.getAutosPilotos()) {

      if (ap.getAuto().equals(participante.getAuto())) {

        System.out.println("El auto ya pertenece a otro participante."); 

        return;

      }

      if (ap.getPiloto().equals(participante.getPiloto())) {

        System.out.println("EL participante ya está registrado en la carrera."); 

        return; 

      }
    }

    carrera.getAutosPilotos().add(participante);

    participante.getCarreras().add(carrera); 


  }


   



}




  
