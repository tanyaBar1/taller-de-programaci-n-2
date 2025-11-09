package proyecto_taller;

public class Persona { 

    private String dni;

    private String nombrePersona; 

    private String apellido; 

    private Pais pais;

    public Persona() {

        dni = "";

        nombrePersona = ""; 

        apellido = ""; 

        pais = null;

    } 



    public Persona(String dni, String nombre, String apellido) {

        this.dni = dni;

        this.nombrePersona = nombre;

        this.apellido = apellido;
        
    }
    


    public String getDni() {

        return dni;
    }


    public String getNombrePersona() {

        return nombrePersona; 
    }


    public String getApellidoPersona() {

        return apellido;
    } 



    public Pais getPaisPersona() {

        return pais;
    }



    public void setDni(String dni) {

        this.dni = dni; 
    }



    public void setNombrePersona(String nombre) {

        this.nombrePersona = nombre;
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
