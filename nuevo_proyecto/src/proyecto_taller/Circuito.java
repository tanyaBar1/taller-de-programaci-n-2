package proyecto_taller; 

import java.util.ArrayList;

public class Circuito {
    
    private String nombre;

    private int longitud;

    private Pais pais;

    private ArrayList<Carrera> carreras;


    public Circuito() {

        nombre = "";

        longitud = 3;

        carreras = new ArrayList<>(); 

        pais = null;

    }
    

    public Circuito(String nombre, int longitud) {

        this.nombre = nombre;

        this.longitud = longitud; 

        carreras = new ArrayList<>(); 

    }

    public String getNombreCircuito() {
       
        return nombre;
    }


    public void setNombreCircuito(String nombre) {
       
        this.nombre = nombre;
    }


    public int getLongitud() {

      return longitud;

    }   


    public void setLongitud(int longitud) {

      this.longitud = longitud;

    }


    public ArrayList<Carrera> getCarrera() {

        return carreras; 
        
    }

    

    public boolean existePais() {

        return this.pais != null;

    }


    public Pais getPaisCircuito() {

        return pais; 
    }


    public void setPaisCircuito(Pais pais) {

        if (existePais()) {

            System.out.println("Hay un país asignado."); 

            return;
            
        }

        this.pais = pais;

    }



}


