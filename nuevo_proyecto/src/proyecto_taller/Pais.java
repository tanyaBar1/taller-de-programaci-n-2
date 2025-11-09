package proyecto_taller;

import java.util.ArrayList;

import java.util.Collections;

public class Pais {

    private int id;

    private String descripcion;

    private ArrayList<Persona> personas;

    private ArrayList<Escuderia> escuderias;

    private ArrayList<Carrera> carreras;

    private ArrayList<Circuito> circuitos;

    public Pais() {

        id = 0;

        descripcion = "";

        personas = new ArrayList<>();

        escuderias = new ArrayList<>();

        carreras = new ArrayList<>();

        circuitos = new ArrayList<>();

    }


    public Pais(int id, String descripcion) {

        this.id = id;

        this.descripcion = descripcion;

        personas = new ArrayList<>();

        escuderias = new ArrayList<>();

        carreras = new ArrayList<>();

        circuitos = new ArrayList<>();

    }


    public int getId() {

        return id;

    }


    public void setId(int id) {

        this.id = id;

    }


    public String getDescripcion() {

        return descripcion;

    }


    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;

    }


    public boolean existeEscuderia(String nombre) {

        for (Escuderia e : escuderias) {

            if (e.getNombreEscuderia().equalsIgnoreCase(nombre)) {

                return true;
            }
        }

        return false;
    }


    public void agregarEscuderia(String nombre) {

        if (existeEscuderia(nombre)) {

            System.out.println("La escudería ya existe.");

            return;

        }

        Escuderia nuevaEscuderia = new Escuderia(nombre);

        nuevaEscuderia.setPaisEscuderia(this);

        escuderias.add(nuevaEscuderia);

    }



    public boolean existePersona(String dni) {

        for (Persona p : personas) {

            if (p.getDni().equals(dni)) {

                return true;

            }

        }

        return false;
    }



    public void agregarPersonas(String dni, String nombre, String apellido) {

        if (existePersona(dni)) {

            System.out.println("La persona ya habita el país.");

            return;

        }

        personas.add(new Persona(dni, nombre, apellido));
    }



    public boolean existeCarrera(Carrera carrera) {

        for (Carrera c : carreras) {

            if (c.getFechaRealizacion().equals(carrera.getFechaRealizacion())

                    && c.getHoraRealizacion().equals(carrera.getHoraRealizacion())) {

                return true;
            }
        }

        return false;
    }



    public boolean disponibilidadCircuito(Circuito circuito, String fecha) {

        for (Carrera c : carreras) {

            if (c.getCircuito().equals(circuito) && c.getFechaRealizacion().equals(fecha)) {

                return false;

            }
        }

        return true;
    }



    public void planificarCarrera(String fecha, int numVueltas, String horario, Circuito circuito) {
        
        if (existeCarrera(new Carrera(fecha, numVueltas, horario))) {

           System.out.println("Ya existe una carrera en la fecha y hora indicadas.");

           return;
        }

        if (!disponibilidadCircuito(circuito, fecha)) {

            System.out.println("El circuito estará ocupado por otra carrera en la fecha correspondiente.");

            return;
        }

        Carrera nuevaCarrera = new Carrera(fecha, numVueltas, horario);

        nuevaCarrera.setPais(this);

        carreras.add(nuevaCarrera);

        circuito.getCarrera().add(nuevaCarrera);

        System.out.println("La carrera planificada se realizará en el circuito " + circuito.getNombreCircuito());

    }



    public void registrarParticipanteACarrera(Carrera carrera, AutoPiloto participante) {

        if (carrera == null || participante == null) {

            System.out.println("Datos inválidos o inexistentes.");

            return;

        }


        for (AutoPiloto ap : carrera.getAutosPilotos()) {


            if (ap.getAuto().getModelo().equals(participante.getAuto().getModelo())) {


                System.out.println("El auto ya pertenece a otro participante.");


                return;


            }


            if (ap.getPiloto().getDniPiloto().equals(participante.getPiloto().getDniPiloto())) {

                System.out.println("EL participante ya está registrado en la carrera.");

                return;

            }

        }

        carrera.getAutosPilotos().add(participante);

        participante.getCarreras().add(carrera);

        System.out.println("El piloto " + participante.getPiloto().nombrePiloto() + " ha sido registrado exitosamente.");

    }



    public void resultadosDetalladosEnFechas(String fechaInicio, String fechaFin) {

        boolean hayCarreras = false;

        System.out.println("Resultados de las carreras en un rango de fechas: " + fechaInicio + " y " + fechaFin);

        for (Carrera c : carreras) {

            String fechaCarrera = c.getFechaRealizacion();

            if (fechaCarrera.compareTo(fechaInicio) >= 0 && fechaCarrera.compareTo(fechaFin) <= 0) {

                hayCarreras = true;

                System.out.println("\n------------------------------------------");

                System.out.println("\nCarrera en circuito: " + c.getCircuito().getNombreCircuito() + " - Fecha: "
                        + c.getFechaRealizacion() + " - Horario: " + c.getHoraRealizacion() + " - Número de vueltas: "
                        + c.getNumeroVueltas() + " - País: " + c.getPaisCarrera());


                Collections.sort(c.getAutosPilotos());


                for (AutoPiloto ap : c.getAutosPilotos()) {

                    Piloto p = ap.getPiloto();

                    System.out.println("\nPiloto: " + p.nombrePiloto() + " " + p.apellidoPiloto() + "- Auto: "
                            + ap.getAuto().getModelo() + " - Puesto en carrera: " + ap.getPuestoEnCarrera()
                            + " - Vuelta rápida: " + (ap.vueltaMasRapida() ? "Sí" : "No"));
                }


            }

        }

        if (!hayCarreras) {

            System.out.println("No se ecnontraron carreras en este rango de fechas.");

        }

    }



    public void rankingPilotos() {


        ArrayList<Piloto> pilotosRanking = new ArrayList<>();

        for (Carrera c : carreras) {

            for (AutoPiloto ap : c.getAutosPilotos()) {

                boolean seEncuentra = false;

                Piloto p = ap.getPiloto();

                for (Piloto piloto : pilotosRanking) {

                    if (piloto.getDniPiloto().equals(p.getDniPiloto())) {

                        seEncuentra = true;

                        break;

                    }

                }


                if (!seEncuentra) {

                    if (p.getCompetencias() > 0 && p.getPuntosAcumulados() > 0) {

                        pilotosRanking.add(p);

                    }

                }

            }

        }


        Collections.sort(pilotosRanking);

        System.out.println(" === Ranking de Pilotos según puntos acumulados ===\n ");

        int posicion = 1;

        for (Piloto p : pilotosRanking) {

            System.out.println(posicion + ") " + p.nombrePiloto() + " " + p.apellidoPiloto() + ". Puntos: "
                    + p.getPuntosAcumulados());


            posicion++;

        }

    }



    public void mostrarHistoricosPodiosVictorias() {

        ArrayList<Piloto> historicoPilotos = new ArrayList<>();

        for (Carrera c : carreras) {

            for (AutoPiloto ap : c.getAutosPilotos()) {

                boolean existe = false;

                Piloto p = ap.getPiloto();

                for (Piloto piloto : historicoPilotos) {

                    if (piloto.getDniPiloto().equals(p.getDniPiloto())) {

                        existe = true;

                        break;

                    }

                }

                if (!existe) {

                    historicoPilotos.add(p);

                }

            }

        }

        Collections.sort(historicoPilotos, new OrdenPorVictoriaPodio());

        System.out.println(" === Histórico de Podios y Victorias ===\n");

        for (Piloto p : historicoPilotos) {

            System.out.println("Piloto: " + p.nombrePiloto() + " " + p.apellidoPiloto());

            System.out.println("Podios: " + p.getPodios());

            System.out.println("Victorias: " + p.getVictorias());

            System.out.println("-------------------------------------------");


        }


    }



    public int cantidadParticipacionesEnCircuito(Piloto participante, Circuito circuito) {

        int cantidad = 0;

        for (Carrera c : carreras) {

            if (c.getCircuito().getNombreCircuito().equals(circuito.getNombreCircuito())) {

                for (AutoPiloto ap : c.getAutosPilotos()) {

                    if (ap.getPiloto().getDniPiloto().equals(participante.getDniPiloto())) {

                        cantidad++;

                    }

                }

            }

        }

        if (cantidad == 0) {

           System.out.println("El piloto " + participante.nombrePiloto() 
            + " " + participante.nombrePiloto() + " no ha participado en el circuito " + circuito.getNombreCircuito() + ".");

        } else {

             System.out.println("El piloto " + participante.nombrePiloto() + " " + participante.apellidoPiloto()
            + " ha participado " + cantidad + " veces en el circuito " + circuito.getNombreCircuito() + ".");

        }

        return cantidad;

    }



    public int cantidadCarreras(Circuito circuito) {

        int cantidad = 0;

        for (Carrera c : carreras) {

            if (c.getCircuito().getNombreCircuito().equals(circuito.getNombreCircuito())) {

                cantidad++;

            }

        }

        if (cantidad == 0) {

           System.out.println("El circuito " + circuito.getNombreCircuito() + " no tiene carreras registradas.");

        } else {
        
            System.out.println("El circuito " + circuito.getNombreCircuito() + " tiene " + cantidad + " carreras registradas.");

        }


        return cantidad;

    }



    public void informeAutosPorEscuderia() {

        System.out.println("=== Informe de Autos por Escudería ===\n");

        for (Escuderia e : escuderias) {

            System.out.println("Escudería: " + e.getNombreEscuderia());

            for (Auto a : e.getAutosEscuderia()) {

                System.out.println("Auto: " + a.getModelo());

                ArrayList<Carrera> carrerasPorAuto = new ArrayList<>();

                for (AutoPiloto ap : a.getAutoPiloto()) {

                    for (Carrera carrera : ap.getCarreras()) {

                        if (!carreraRegistrada(carrerasPorAuto, carrera)) {

                            carrerasPorAuto.add(carrera);

                            System.out.println("Se registró correctamente la carrera en la cual participó el auto.");

                        }

                    }

                }

            }


            System.out.println("-------------------------------------------");

        }


    }



    private boolean carreraRegistrada(ArrayList<Carrera> lista, Carrera carrera) {

        for (Carrera c : lista) {

            if (c.getFechaRealizacion().equals(carrera.getFechaRealizacion())) {

                return true;

            }

        }

        return false;

    }


    public void informeMecanicosPorEscuderia() {

        System.out.println("=== Informe de Mecánicos por Escudería ===\n");

        for (Escuderia e : escuderias) {

            System.out.println("Escudería: " + e.getNombreEscuderia());

            ArrayList<Mecanico> mecanicosRegistrados = new ArrayList<>();

            int posicion = 1;

            for (Mecanico mecanico : e.getMecanicos()) {

                if (!estaRegistradoMecanico(mecanicosRegistrados, mecanico)) {

                    if (escuderiaRegistrada(mecanico.getEscuderiasMecanicos(), e)) {

                        mecanicosRegistrados.add(mecanico);

                        System.out.println("  " + posicion + ") " + mecanico.nombreMecanico() + " "
                                + mecanico.apellidoMecanico());

                        System.out.println("   Experiencia: " + mecanico.getAniosExperiencia() + " años.");

                        System.out.println("   Especialidad: " + mecanico.getEspecialidad());

                        posicion++;

                    } else {

                        System.out.println("  [Inconsistencia detectada] Mecánico " + mecanico.nombreMecanico() + " "
                                + mecanico.apellidoMecanico() + " no tiene registrada a la escudería "
                                + e.getNombreEscuderia());
                    }

                }

            }


            if (posicion == 1) {

                System.out.println("[No hay mecánicos registrados]");

            }


            System.out.println("-------------------------------------------");


        }
    }

    private boolean estaRegistradoMecanico(ArrayList<Mecanico> lista, Mecanico mecanico) {

        for (Mecanico m : lista) {

            if (m.dniMecanico().equals(mecanico.dniMecanico())) {

                return true;

            }

        }

        return false;

    }

    private boolean escuderiaRegistrada(ArrayList<Escuderia> lista, Escuderia escuderia) {

        for (Escuderia e : lista) {

            if (e.getNombreEscuderia().equals(escuderia.getNombreEscuderia())) {

                return true;

            }

        }

        return false;

    }


}

    

