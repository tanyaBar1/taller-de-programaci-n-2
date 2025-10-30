package nuevo_proyecto; 

import java.util.ArrayList;

public class Circuito {
    
    private String nombre;
    private int longitud;
    private Pais pais;
    private ArrayList<Carrera> carreras;


    public Circuito(){
        nombre = "";
        longitud = 3;
        pais = null;

        carreras = new ArrayList<>(); 

    }

     public Circuito(String nombre, int longitud, Pais pais){
        this.nombre = nombre;
        this.longitud = 3;

        this.pais = pais; 
    }

    public String getNombre(){
       
        return nombre;
    }

    public void setNombre(String nombre){
       
        this.nombre= nombre;
    }

    public int getLongitud(){
      return longitud;
    }   

    public void setLongitud(int longitud){
      this.longitud = longitud;
    }



}


