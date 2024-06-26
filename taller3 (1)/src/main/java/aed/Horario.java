package aed;

public class Horario {
    private int _hora;
    private int _minutos;
    public Horario(int hora, int minutos) {
        this._hora=hora;
        this._minutos=minutos;
    }

    public int hora() {
        return _hora;
    }

    public int minutos() {
        return _minutos;
    }

    @Override
    public String toString() {
        String res;
        if (_minutos<10){
            res= Integer.toString(_hora)+":"+"0"+Integer.toString(_minutos);
            return res;
        }else{
             res=Integer.toString(_hora)+":"+Integer.toString(_minutos);
        return  res;
        }
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen=(otro ==null);
        boolean cd = otro.getClass() != this.getClass();
        if (oen||cd){
            return false;
        }
        Horario otroHorario = (Horario) otro;
        return otroHorario._hora==this._hora && otroHorario._minutos==this._minutos;
    }

}
