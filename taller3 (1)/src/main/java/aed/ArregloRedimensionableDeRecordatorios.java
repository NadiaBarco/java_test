package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private Recordatorio[] _arreglo;
    private int _count;
    
    public ArregloRedimensionableDeRecordatorios() {
        this._arreglo=new Recordatorio[10];
        this._count= 0;

    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this._arreglo=vector._arreglo;
        this._count=0;
        
    }

    public int longitud() {
        return _arreglo.length;
    }

    public int seeCount(){
        return _count;
    }

    public void incremento_count(){
        _count++;
    }
    public void agregarAtras(Recordatorio i) {
        if (_arreglo.length==_count){
            
            Recordatorio[] add_atras=new Recordatorio[_arreglo.length+1];
            for (int k=0;k<_arreglo.length;k++){
                add_atras[k]=_arreglo[k];
            }
            _arreglo=add_atras;
            }
        _arreglo[_count]=i;
        incremento_count();
        
        

    }
    
    public Recordatorio obtener(int i) {
        return _arreglo[i];
    }

    public void quitarAtras() {
        Recordatorio[] sin_el_ultimo=new Recordatorio[_count-1];
        System.arraycopy(_arreglo, 0, sin_el_ultimo, 0, _count-1);
        _arreglo=sin_el_ultimo;
        _count--;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        _arreglo[indice]=valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios otroArreglo=  new ArregloRedimensionableDeRecordatorios();
        for (int k=0;k<_count;k++){
        otroArreglo.agregarAtras(_arreglo[k]);
        }
        return otroArreglo;

    }

}
