package proyecto_taller;

public class Persona { 

    private String dni;

    private String nombrePer; 

    private String apellido; 

    private Pais pais;

    public Persona() {

        dni = " ";

        nombrePer = " "; 

        apellido = " "; 

        pais = null;

    } 



    public Persona(String dni, String nombre, String apellido) {

        this.dni = dni;

        this.nombrePer = nombre;

        this.apellido = apellido;
        
    }


    public String getDni() {

        return dni;
    }

    public String getNombrePer() {

        return nombrePer; 
    } 

    public String getApellido() {

        return apellido;
    } 


    public Pais getPaisPer() {

        return pais;
    }


    public void setDni(String dni) {

        this.dni = dni; 
    }

    public void setNombrePer(String nombre) {

        this.nombrePer = nombre;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido; 
    }

    public boolean existePais() {

        return this.pais != null;

    }


    public void setPaisPer(Pais pais){

        if (existePais() == true) {

            System.out.println("Hay un país asignado: " + this.getPaisPer()); 

            
        }

        this.pais = pais;

    }

    
}
