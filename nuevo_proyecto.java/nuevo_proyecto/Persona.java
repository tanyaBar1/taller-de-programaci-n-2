package nuevo_proyecto;

public class Persona { 

    private String dni;

    private String nombre; 

    private String apellido; 

    private Pais pais;

    public Persona() {

        dni = " ";

        nombre = " "; 

        apellido = " "; 

        pais = null;

    } 

    public Persona(String dni, String nombre, String apellido, Pais pais) {

        this.dni = dni;

        this.nombre = nombre;

        this.apellido = apellido; 

        this.pais = pais;

    }  

    public Persona(String dni, String nombre, String apellido) {

        this.dni = dni;

        this.nombre = nombre;

        this.apellido = apellido;
        
    }


    public String getDni() {

        return dni;
    }

    public String getNombre() {

        return nombre; 
    } 

    public String getApellido() {

        return apellido;
    } 


    public Pais getPais() {

        return pais;
    }


    public void setDni(String dni) {

        this.dni = dni; 
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido; 
    }

    public void setPais(Pais p) {

        this.pais = p; 
    }

    
}
