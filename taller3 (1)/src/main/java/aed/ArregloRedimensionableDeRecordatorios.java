package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private String[] _arreglo;

    
    public ArregloRedimensionableDeRecordatorios() {
        this._arreglo=new String[0];

    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this._arreglo=vector._arreglo;

    }

    public int longitud() {
        return _arreglo.length;
    }

    public void agregarAtras(Recordatorio i) {
        String[] add_atras;
        int count=0;
       
        if (_arreglo.length==0){
            add_atras[count]=i.toString();
            count++;
            }
        _arreglo=add_atras;

    }
    
    public Recordatorio obtener(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void quitarAtras() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
