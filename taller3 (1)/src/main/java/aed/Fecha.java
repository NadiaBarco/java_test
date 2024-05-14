package aed;
//un metodo que lleva void no devuelve dato
public class Fecha {
    private int _dia; //encapsulo las variables con private, para que luego no haya/halla(? cambios en su uso
    private int _mes; //son propiedades
    public Fecha(int dia, int mes) {//constructor Fecha
        this._dia = dia;//con this hago referencia a estas variables
        this._mes= mes;
    }

    public Fecha(Fecha fecha) { //constructor copia Fecha y los objetos de Fecha y los llama fecha
        this._dia =fecha._dia;
        this._mes = fecha._mes;
        
    }

    public Integer dia() {//metodo GETTER captador sii necesita que retorne algo
        return this._dia;
    }

    public Integer mes() {
        return this._mes;
    }

    public String toString() {
        
        return  Integer.toString(dia()) +"/"+Integer.toString(mes());
    }
    
    @Override
    public boolean equals(Object otra) {
        boolean oen=(otra ==null);
        boolean cd = otra.getClass() != this.getClass();
        if (oen||cd){
            return false;
        }
       Fecha otraFecha = (Fecha) otra;
       return otraFecha._mes==_mes && otraFecha._dia==this._dia;
    } 

    public void incrementarDia() {
        _dia=_dia+1;
        if (_dia > diasEnMes(_mes)){
            _dia=1;
            _mes=_mes+1;
        }
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
