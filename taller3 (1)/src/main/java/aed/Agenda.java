package aed;

public class Agenda {
    Fecha _fecha;
    Recordatorio _recordatorio;
    Agenda agenda;

    public Agenda(Fecha fechaActual) {
        this._fecha=fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        ArregloRedimensionableDeRecordatorios agenda= new ArregloRedimensionableDeRecordatorios();
        this._recordatorio=recordatorio;
        agenda.agregarAtras(recordatorio);
        

    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public void incrementarDia() {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public Fecha fechaActual() {
        return _fecha;
    }

}
