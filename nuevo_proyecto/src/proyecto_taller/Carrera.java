package proyecto_taller;

import java.util.ArrayList; 

public class Carrera {

    private String fechaRealizacion;

    private int numeroVueltas;

    private String horaRealizacion;

    private Pais pais;

    private Circuito circuito;

    private ArrayList<AutoPiloto> autosPilotos; 


    public Carrera() {

        fechaRealizacion = " ";

        numeroVueltas = 0; 

        horaRealizacion = " ";  

        autosPilotos = new ArrayList<>(); 

        pais = null;

        circuito = null;
        
    } 
    

    public Carrera(String fecha, int vueltas, String hora, AutoPiloto autoPiloto) {

        this.fechaRealizacion = fecha; 

        this.numeroVueltas = vueltas; 

        this.horaRealizacion = hora; 
        
        this.agregarParticipante(autoPiloto);
    

    } 

    public Carrera(String fecha, int vueltas, String hora) {

        this.fechaRealizacion = fecha;

        this.numeroVueltas = vueltas;

        this.horaRealizacion = hora;

        autosPilotos = new ArrayList<>(); 

    }


    public String getFechaRealizacion() {

        return fechaRealizacion; 
    } 

    public int getNumeroVueltas() {

        return numeroVueltas;
    }  

    public String getHoraRealizacion() {

        return horaRealizacion; 
    } 


    public Pais getPaisCarrera() {

        return pais;

    }


    public ArrayList<AutoPiloto> getAutosPilotos() {

        return autosPilotos;
    }



    public boolean existeCircuito() {

        return this.circuito != null;
    }
    


    public void setCircuito(Circuito circuito) {

        if (existeCircuito()) {

            System.out.println("El circuito se encuentra asignado.");

            return; 

        }

        this.circuito = circuito; 

    }


    public Circuito getCircuito() {

        return circuito; 
    }


    public boolean existePais() {

        return this.pais != null;

    }


    public void setPais(Pais pais) {

        if (existePais()) {

            System.out.println("Hay un país asignado."); 

            return;  
        }

        this.pais = pais;

    }

 
    public void agregarParticipante(AutoPiloto autoPiloto) {

        if (autoPiloto == null) {

          System.out.println("Datos inválidos.");

          return;

        }

        for (AutoPiloto ap : autosPilotos) {

            if (ap.getAuto().equals(autoPiloto.getAuto())) {

               System.out.println("El auto ya está asignado a otro piloto en esta carrera.");
               
               return;

            }

            if (ap.getPiloto().equals(autoPiloto.getPiloto())) {

                System.out.println("El piloto está participando en la carrera."); 

                return;
            }

        }

        autosPilotos.add(autoPiloto); 

       
    } 


    public boolean esPosicionValida(int puesto) {

       return puesto >= 1 && puesto <= 10;

    }


    public void registrarResultadosDeCarrera() {

        boolean hayResultadoRegistrado = false;

        for (AutoPiloto ap : autosPilotos) {

            if (!ap.resultadoEstaRegistrado()) {

                System.out.println("Registre los resultados del participante: ");


                Piloto p = ap.getPiloto();

                int puesto = ap.getPuestoEnCarrera();

                boolean vueltaRapida = ap.vueltaMasRapida(); 


                if (!esPosicionValida(puesto)) {

                   System.out.println("Posición no válida para el piloto " + p.nombrePiloto() + ": " + puesto);

                   continue;

                }


                int puntos = this.obtenerPuntosPorPosicion(puesto);

                p.incrementarNumeroCompetencias(); 



                if (puesto == 1) {

                   p.incrementarVictorias(); 

                }



                if (puesto <= 3) {

                   p.incrementarPodios(); 

                }



                if (vueltaRapida && puesto <= 10) {

                   p.incrementarVueltasRapidas();

                   puntos += 1; 
                }

                
                p.sumarPuntos(puntos); 

                ap.setPuestoEnCarrera(puesto);

                ap.setVueltaMasRapida(vueltaRapida);

                ap.setResultadoEstaRegistrado(true);


                hayResultadoRegistrado = true;

            }

            
        }


    }


    public int obtenerPuntosPorPosicion(int puesto) {

        switch (puesto) {

            case 1:

                return 25; 


            case 2:

                return 18; 
                

            case 3:

                return 15;  


            case 4:

                return 12;  


            case 5:

                return 10; 


            case 6:

                return 8; 


            case 7:
 

               return 6; 


            case 8:


                return 4;



            case 9:


                return 2;  



            case 10:

                return 1; 


            default:

                return 0;



        }
        

    }


    
}