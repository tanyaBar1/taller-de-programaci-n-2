package nuevo_proyecto;

import java.util.ArrayList;

public class Pais {
   
  private int id;
  private String descripcion;
  private ArrayList<Persona> personas; 
  private ArrayList<Escuderia> escuderias;



  public Pais() {
    id = 0;
    descripcion = ""; 

    personas = new ArrayList<>();
    escuderias = new ArrayList<>();

  }
     
  public Pais(int id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
  }

  public int getId (){
    return id;
  }

  public void setId (int id){
    this.id = id;
  }

  public String getDescripcion(){
    return descripcion;
  }

  public void setDescripcion (String descripcion){
    this.descripcion = descripcion;

  }


  public boolean existeEscuderia(Escuderia esc) {

    for (Escuderia e : escuderias) {

      if (e.getNombre().equals(esc.getNombre())) {

        return true; 
      }

    }

    return false; 
  } 


  public void agregarEscuderia(Escuderia escuderia, String nombre) {

    if (existeEscuderia(escuderia) == true) {

      System.out.println("La escudería " + escuderia.getNombre() + " ya existe."); 
    }

    Escuderia nuevaEscuderia = new Escuderia(nombre); 

    nuevaEscuderia.setPais(this); 

    escuderias.add(nuevaEscuderia); 
  }
}