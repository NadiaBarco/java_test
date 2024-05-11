package aed;

public class Recordatorio {
    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;
    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this._mensaje=mensaje;
        this._fecha=fecha;
        this._horario=horario;
    }

    public Horario horario() {
        return _horario;
    }

    public Fecha fecha() {
        return _fecha;
    }

    public String mensaje() {
        return _mensaje;
    }

    @Override
    public String toString() {
        return _mensaje +" "+ "@"+" "+_fecha+" "+_horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (this==otro){
            return true;
        }
        if (otro==null || getClass() !=otro.getClass()){
            return false;
        }

        Recordatorio otroRecordatorio=(Recordatorio) otro;
        return this._mensaje.equals(otroRecordatorio._mensaje)&& this._fecha.equals(otroRecordatorio._fecha)&& this._horario.equals(otroRecordatorio._horario);
    }

}
