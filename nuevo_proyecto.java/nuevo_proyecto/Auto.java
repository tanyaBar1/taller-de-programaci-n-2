package nuevo_proyecto;

import java.util.ArrayList;

public class Auto {

    private String modelo;

    private String motor;

    private Escuderia escuderia;

    private ArrayList <AutoPiloto> autoPiloto;


public Auto() {

    modelo = "";

    motor = "";

    autoPiloto = new ArrayList<>();
}

public Auto(String modelo, String motor) {

    this.modelo = modelo; 

    this.motor = motor; 

}


public String getModelo() {
    return modelo;
}

public void setModelo(String modelo) {

    this.modelo = modelo;
}

public String getMotor() {

    return motor;
}

public void setMotor(String motor) {

    this.motor = motor;
}


public Escuderia getEscuderia() {

    return escuderia;
}


public void setEscuderia(Escuderia esc) {

    if (existeEscuderia() == true) {

        System.out.println("La escudería está asignada."); 

    }

    this.escuderia = esc;
}



public boolean existeEscuderia() {

    return this.escuderia != null;
}

}

