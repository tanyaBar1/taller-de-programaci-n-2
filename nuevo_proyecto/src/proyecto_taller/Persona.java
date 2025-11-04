package proyecto_taller;

public class Persona { 

    private String dni;

    private String nombrePer; 

    private String apellido; 

    private Pais pais;

    public Persona() {

        dni = "";

        nombrePer = ""; 

        apellido = ""; 

    } 



    public Persona(String dni, String nombre, String apellido) {

        this.dni = dni;

        this.nombrePer = nombre;

        this.apellido = apellido;
        
    }


    public String getDni() {

        return dni;
    }

    public String getNombrePersona() {

        return nombrePer; 
    } 

    public String getApellido() {

        return apellido;
    } 


    public Pais getPaisPersona() {

        return pais;
    }


    public void setDni(String dni) {

        this.dni = dni; 
    }

    public void setNombrePersona(String nombre) {

        this.nombrePer = nombre;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido; 
    }

    public boolean existePais() {

        return this.pais != null;

    }


    public void setPaisPersona(Pais pais) {

        if (existePais()) {

            System.out.println("Hay un país asignado: " + this.getPaisPersona()); 

            return;  
        }

        this.pais = pais;

    }

    
}
