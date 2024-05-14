package aed;

public class Agenda {
    Fecha fecha;
    Recordatorio _recordatorio;

    public Agenda(Fecha fechaActual) {
        this.fecha=fechaActual;
        
        
    }


    public void agregarRecordatorio(Recordatorio recordatorio) {
       agregarRecordatorio(recordatorio);
        

    }
    @Override
    public String toString() {
        String barras="=====";
        for (int i=0;i<_recordatorio._arreglo;i++){

        }
        return fecha+ "\n"+barras+"\n"+_recordatorio+"\n";

    }

    public void incrementarDia() {
        fecha.incrementarDia();

    }

    public Fecha fechaActual() {
        return fecha;
    }

}
