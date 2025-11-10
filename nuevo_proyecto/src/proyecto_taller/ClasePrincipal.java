package proyecto_taller;

import java.util.ArrayList;
import java.util.List;


public class ClasePrincipal {

    public static void main(String[] args) {

        System.out.println("¡Hola, bienvenido al proyecto taller!");


        System.out.println(" Iniciando el sistema  de gestión de F1");

        
        System.out.println("--Creación de entidades base y personas--");

         //creacion de paises;
          Pais espania = new Pais(1, "España");
        
          Pais francia = new Pais(2,"Francia");

          Pais italia = new Pais(3, "Italia");

         //creacion de circuitos

          Circuito circuito1 = new Circuito ( "Circuit de Barcelona-Catalunya", 4657);

          Circuito circuito2 = new Circuito("Circuito Paul Ricard",5842);

          Circuito circuito3 = new Circuito ( "Autodromo Nazionale Monza", 5973);

        // creacion de autos

          Auto auto1 = new Auto("RED BULL","RB21" );

          Auto auto2 = new Auto("Ferrari", "sf21");

          Auto auto3 = new Auto ("Alpine", "A521");
        
        //creacion de escuderias;

          Escuderia redBull  = new Escuderia ( "1770463451", "Laurent", "Mekies",48, Especialidad.MOTOR);

          Escuderia ferrari = new Escuderia ("1720312323", "LoÏc","Serra", 58, Especialidad.CHASIS);

          Escuderia alpine = new Escuderia ("1790990786","jean","Michelle", 46, Especialidad.NEUMATICOS);

        //Creacion de pilotos;

          Piloto piloto1 = new Piloto ("1970930213", "Max","Verstapen");

          Piloto piloto2 = new Piloto ( "IDMCO1234567<9MCO1234567", "Charles", "Leclerc");

          Piloto piloto3 = new Piloto ("40.123.456", "Franco", "Colapinto");

        System.out.println("creación de entidades base y personas finalizada.");


      
        System.out.println(" iniciando la creación de contratos entre pilotos y escuderias");

       
         PilotoEscuderia asigPiloto1 =  new PilotoEscuderia (piloto1, redBull, "01/01/2018","31/12/2028");

         PilotoEscuderia asigPiloto2 = new PilotoEscuderia (piloto2, ferrari, "01/01/2019", "31/12/2027");

         PilotoEscuderia asigPiloto3 =  new PilotoEscuderia( piloto3, alpine, "01/01/2025", "31/12/2026");

         redBull.getContratoEscuderia().add(asigPiloto1);

         ferrari.getContratoEscuderia().add(asigPiloto2);

         alpine.getContratoEscuderia().add(asigPiloto3);

        System.out.println("contratos entre pilotos y escuderias finalizados.");

        System.out.println("Planificacion de carrera y asignacion de autos ");

         AutoPiloto participante1 = new AutoPiloto();
           participante1.setAuto(auto1);
           participante1.setPiloto(piloto1);
         
         AutoPiloto participante2 = new AutoPiloto();
           participante2.setAuto(auto2);
           participante2.setPiloto(piloto2);
         
         AutoPiloto participante3 = new AutoPiloto();
           participante3.setAuto(auto3);
           participante3.setPiloto(piloto3);


         Carrera granPremioEspanaCarrera = new Carrera( "2025/05/30", 66 ,"17:00hs", participante1);
         granPremioEspanaCarrera.agregarParticipante(participante2);
         granPremioEspanaCarrera.agregarParticipante(participante3);

         granPremioEspanaCarrera.setCircuito(circuito1);
         granPremioEspanaCarrera.setPais(espania);
         

         participante1.setAuto(auto1);
         participante1.setPiloto(piloto1);

         participante2.setAuto(auto2);
         participante2.setPiloto(piloto2);

         participante3.setAuto(auto3);
         participante3.setPiloto(piloto3);
       
         
         System.out.println("Planificación de carrera y asignación de autos finalizados ");
         System.out.println("La próxima carrera será el dia " );
         System.out.println("carrera: " + granPremioEspanaCarrera.getFechaRealizacion() + " en " + granPremioEspanaCarrera.getPaisCarrera()+ " en el circuito "+ "< " + granPremioEspanaCarrera.getCircuito().getNombreCircuito()+ " >");
         System.out.println("Un participante será: " + participante1.getPiloto().getNombrePersona()+ " " + participante1.getPiloto().getApellidoPersona() + " con auto " + participante1.getAuto().getModelo()+ " " + participante1.getAuto().getMotor());


    


        
        
    








    }

}

