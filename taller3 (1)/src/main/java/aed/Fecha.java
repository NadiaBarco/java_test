package aed;

public class Fecha {
    private int _dia; 
    private int _mes; 
    public Fecha(int dia, int mes) {
        this._dia = dia;
        this._mes= dia;
    }

    public Fecha(Fecha fecha) {
        
    }

    public Integer dia() {
        
    }

    public Integer mes() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    @Override
    public boolean equals(Object otra) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void incrementarDia() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
