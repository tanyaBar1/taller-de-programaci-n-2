package nuevo_proyecto; 

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

    }

     public Circuito(String nombre, int longitud) {

        this.nombre = nombre;

        this.longitud = 3; 

    }

    public String getNombreCir() {
       
        return nombre;
    }


    public void setNombreCir(String nombre) {
       
        this.nombre= nombre;
    }


    public int getLongitud() {

      return longitud;

    }   


    public void setLongitud(int longitud) {

      this.longitud = longitud;

    }

    

    public boolean existePais() {

        return this.pais != null;

    }


    public Pais getPaisCir() {

        return pais; 
    }


    public void setPais(Pais pais){

        if (existePais() == true) {

            System.out.println("Hay un país asignado: " + this.getPaisCir()); 

            
        }

        this.pais = pais;

    }



}


