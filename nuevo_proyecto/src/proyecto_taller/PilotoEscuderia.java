package proyecto_taller;

public class PilotoEscuderia implements Comparable<PilotoEscuderia> {
      
    private String desdeFecha;

    private String hastaFecha;

    private Piloto piloto; 

    private Escuderia escuderia;


    public PilotoEscuderia() {

        desdeFecha = "";

        hastaFecha = "";

    }
    

    public PilotoEscuderia(Piloto piloto, Escuderia escuderia, String desde, String hasta) {

        this.piloto = piloto;

        this.escuderia = escuderia;

        this.desdeFecha = desde;

        this.hastaFecha = hasta;

    }


    public String getDesdeFecha() {

        return desdeFecha;

    }


    public void setDesdeFecha(String fecha) {

       this.desdeFecha = fecha;

    }



    public String getHastaFecha() {

        return hastaFecha;

    }


    public void setHastaFecha(String fecha) {

       this.hastaFecha = fecha;
    }
    

    public Piloto getPiloto() {

        return piloto;
    }

    
    public void setPiloto(Piloto piloto) {

        this.piloto = piloto;
    }

    
    public Escuderia getEscuderia() {

        return escuderia;
    }


    public void setEscuderia(Escuderia escuderia) {

        this.escuderia = escuderia;
    }  
    
    
    @Override

    public int compareTo(PilotoEscuderia otro) {

        int inicioContrato = this.desdeFecha.compareTo(otro.getDesdeFecha()); 

        if (inicioContrato != 0) {

            return inicioContrato;
        }

        return this.hastaFecha.compareTo(otro.getHastaFecha()); 

    }


    public boolean contratosSuperpuestos(PilotoEscuderia otro) {

        return (this.desdeFecha.compareTo(otro.getHastaFecha()) <= 0) && (otro.getDesdeFecha().compareTo(this.hastaFecha) <= 0);
    }
     

     
}

