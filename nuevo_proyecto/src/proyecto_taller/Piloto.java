package proyecto_taller;

import java.util.ArrayList; 

public class Piloto extends Persona implements Comparable<Piloto> {

    private int numeroCompetencia; 

    private int victorias; 

    private int polePosition;

    private int vueltasRapidas; 

    private int podios; 

    private int puntosAcumulados; 

    private ArrayList<PilotoEscuderia> pilotoEscuderia; 

    private ArrayList<AutoPiloto> pilotoAuto;

    
    public Piloto() {

        super();

        numeroCompetencia = 0; 

        victorias = 0;

        polePosition = 0; 

        vueltasRapidas = 0; 

        podios = 0; 

        puntosAcumulados = 0;

        pilotoEscuderia = new ArrayList<>(); 

        pilotoAuto = new ArrayList<>();

    } 


    public Piloto(String d, String n, String a, int comp, int vic, int pole, int vueltas, int podios) {

        super(d, n, a); 

        this.numeroCompetencia = comp; 

        this.victorias = vic; 

        this.polePosition = pole; 

        this.vueltasRapidas = vueltas; 

        this.podios = podios; 

        pilotoEscuderia = new ArrayList<>();

        pilotoAuto = new ArrayList<>();

    } 


    public Piloto(String dni, String nombre, String apellido) {

        super(dni, nombre, apellido);

        pilotoEscuderia = new ArrayList<>();

        pilotoAuto = new ArrayList<>();
        
    }


    public String nombrePiloto() {

        return getNombrePersona(); 

    }


    public String apellidoPiloto() {

        return getApellidoPersona(); 

    }


    public String getDniPiloto() {

        return getDni();

    }


    public int getCompetencias() {

        return numeroCompetencia; 
    } 


    public int getVictorias() {

        return victorias; 
    }


    public int getPosition() {

        return polePosition; 
    } 


    public int getVueltas() {

        return vueltasRapidas;
    }
    

    public int getPodios() {

        return podios; 
    } 


    public int getPuntosAcumulados() {

        return puntosAcumulados;

    }


    public void agregarContratoEscuderia(Escuderia escuderia, String fechaInicio, String fechaFin) {

        if (fechaInicio == null || fechaInicio.isEmpty() || fechaFin == null || fechaFin.isEmpty()) {

           System.out.println("Las fechas de inicio o fin no pueden ser vacías.");

           return;

        }

        if (fechaInicio.compareTo(fechaFin) > 0) {

           System.out.println("La fecha de inicio no puede ser posterior a la fecha de fin.");
           
           return;

        }


        PilotoEscuderia nuevoContrato = new PilotoEscuderia(this, escuderia, fechaInicio, fechaFin);

        if (escuderia.pilotoInscrito(this)) {

           System.out.println("El piloto ya está inscrito en esta escudería.");

           return;

        }

        for (PilotoEscuderia contratoExistente : this.pilotoEscuderia) {

            if (contratoExistente.getEscuderia().equals(escuderia) && contratoExistente.contratosSuperpuestos(nuevoContrato)) {

               System.out.println("El piloto ya tiene un contrato que se superpone con esta escudería.");

                return;
            
            }

        }

        this.pilotoEscuderia.add(nuevoContrato);

        escuderia.getContratoEscuderia().add(nuevoContrato); 

        System.out.println("Contrato agregado con éxito.");

    }


    public void asignarAuto(Auto auto, String fechaAsignacion) {

        if (auto.pilotoAsignado(this)) {

            System.out.println("Este piloto ya está asignado a este auto.");

            return;
        }

        for (AutoPiloto ap : auto.getAutoPiloto()) {

            if (ap.getFechaAsignacion().equals(fechaAsignacion)) {

                System.out.println("El piloto ya tiene asignado otro auto en esa fecha.");

                return;

            }
            
        }

        AutoPiloto nuevoAutoPiloto = new AutoPiloto(fechaAsignacion);

        nuevoAutoPiloto.setAuto(auto);

        nuevoAutoPiloto.setPiloto(this);

        pilotoAuto.add(nuevoAutoPiloto);

        auto.getAutoPiloto().add(nuevoAutoPiloto);

        System.out.println("El piloto ha sido asignado al auto.");

    }
    



    public void sumarPuntos(int puntos) {

        this.puntosAcumulados += puntos;

    }


    public ArrayList<PilotoEscuderia> getPilotoEscuderia() {

        return pilotoEscuderia;
    }


    public ArrayList<AutoPiloto> getPilotoAuto() {

        return pilotoAuto;
    }


    public void incrementarPolePosition() {

        polePosition++;

    }


    public void incrementarNumeroCompetencias() {

        numeroCompetencia++;
    }


    public void incrementarVueltasRapidas() {

        vueltasRapidas++;
    }


    public void incrementarVictorias() {

        victorias++;
    }


    public void incrementarPodios() {

        podios++;

    }


    @Override


    public int compareTo(Piloto otro) {

        return Integer.compare(otro.getPuntosAcumulados(), this.getPuntosAcumulados());

    }
 

       

     
}