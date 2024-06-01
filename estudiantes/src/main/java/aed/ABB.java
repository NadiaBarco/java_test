package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int size=0;
    private Conjunto elems; 
    private class Nodo {
        // Agregar atributos privados del Nodo
    private    Nodo izq;
    private    Nodo der;
    private    Nodo up;
    private    T valor;

        // Crear Constructor del nodo
        Nodo(T v){
            valor=v;
            izq=null;
            der=null;
            up=null;
            
        }
    }

    public ABB() {
        Nodo raiz=null;
    }
    public int longitud_rama(Nodo n){//raiz =4, n=5 
        Nodo actual=n;//4,5

        if (actual!=null){ //4!=null ,5!=null
            contador();//k=1 ,k=2
            longitud_rama(actual.der);//5
            longitud_rama(actual.izq);
        }
        return size;
    }
    public void contador(){
        size++;
    }
    public int cardinal() {
        int total;
        size=0;
        total=longitud_rama(raiz);
        
        return total;
    }

    public T minimo(){
        return minimoNodo(raiz);
    }
    public T minimoNodo(Nodo n){
        Nodo minimo=n;
        Nodo actual=n;
        if (actual.izq!=null){
            minimo=actual.izq;
            return minimoNodo(actual.izq);
        }
        return minimo.valor;
    }

    public T maximoNodo(Nodo n){
        Nodo maximo=n;
        Nodo actual=n;
        if (maximo.der!=null){
            actual=maximo.der;
            maximoNodo(maximo.der);
        }
        return actual.valor;
    }

    public T maximo(){
        
        return maximoNodo(raiz);
    }

    public void insertar(T elem){
        Nodo nuevo=new Nodo(elem);
        if (raiz==null){
            raiz=nuevo;
            return;
        }else{
            insertarNodo(raiz,elem);
        }
      
    }

    public void insertarNodo(Nodo n, T elem){
        Nodo nuevo=new Nodo(elem);//raiz=null->n==null//n=2 elem =1
        if (n==null){
            n=nuevo;// raiz=2
        }else {
            //si el elem ya esta en el arbol no hago nada
            if (n.valor.compareTo(elem)==0){
                return;
            }
            //si n.valor>elem y su nodo izq esta habilitado
            else if (n.valor.compareTo(elem)>0 ){
                if (n.izq==null){
                n.izq=nuevo;//n.izq=1

            }else{
                insertarNodo(n.izq,elem);
            }}
            else if (n.valor.compareTo(elem)<0){
                if((n.der==null)){
                n.der=nuevo;
            }else{
                insertarNodo(n.der, elem);
            }
        }
        }
    }

    public boolean pertenece(T elem){
        return perteneceAlNodo(raiz,elem);
    }

    public boolean perteneceAlNodo(Nodo n,T elem){
        Nodo actual=n;
        int comparacion=actual.valor.compareTo(elem);//n=2,elem =4//n=1 , elem =2
        if (comparacion==0){
            return true;
        }else{
            if (comparacion>0&&n.izq!=null){//5>2

                return perteneceAlNodo(actual.izq, elem);//perteneceN(1,2)
            }else if (comparacion<0&&n.der!=null){//1<2
                return perteneceAlNodo(actual.der, elem);//n==2 ,perteneceN(n=3,elem=4)->perteneceNodo(n=4,elem=4)
            }
            
        }
        return false;
    }

    public void eliminar(T elem){
        eliminarNodo(raiz,elem);
    }
    public void eliminarNodo(Nodo n,T elem){//
        Nodo actual=n;
        int comparacion=(actual.valor).compareTo(elem);//
     
        //si es hoja
        if(comparacion==0 && actual.der==null &&actual.izq==null){
            n=null;

        //si tiene un hijo en der
        }else if(comparacion==0 && actual.izq==null&&actual.der!=null){
            n=obtenerSucesorInmediato(n);
        // si tiene un hijo en izq    
        }else if(comparacion==0 && actual.der==null &&actual.izq!=null){
            actual.der=actual.der.izq;
            n=obtenerPredecesorInmediato(actual);
            n.der=null;
            
        }
        //si tiene dos hijos
        else if(comparacion==0&& actual.der!=null&&actual.izq!=null){
            Nodo pred=obtenerPredecesorInmediato(n);
            pred.der=n;
            n=obtenerPredecesorInmediato(n);
            n.der=n.izq.der;
            
            
        }
    
        else{
            if(comparacion<0){
                eliminarNodo(n.der, elem);//n=5,n.der=20->eliNodo(20,11)

            }else if(comparacion>0){
                eliminarNodo(n.izq, elem);//n=20 ,n.izq=15 ->eliNodo(15,11)//n=15,n.izq=11-> eliNodo(11,11)
            }
        }
    }
    //EL MAYOR DE LOS MENORES
    public Nodo obtenerPredecesorInmediato(Nodo padre){
        Nodo elMenorMayor=new Nodo(maximoNodo(padre));
        return elMenorMayor;
    }
    //EL MENOR DE LOS MAYORES
    public Nodo obtenerSucesorInmediato(Nodo padre){
        Nodo elMayorMenor=new Nodo(minimoNodo(padre));
        return elMayorMenor;
    }

    public String toString(){
        Nodo actual=raiz;
        T min=minimoNodo(actual);
        //String cadena="{"+toString(min);
         return "";
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            _actual=new Nodo(minimo());
            return _actual!=null;
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

    public static void main(String[] args) {
        
        ABB<Integer>  arAbb= new ABB<Integer>();
        arAbb.insertar(2);
        arAbb.insertar(1);
        arAbb.insertar(3);
        arAbb.insertar(4);
        System.out.println(arAbb.cardinal());
        System.out.println(arAbb.pertenece(4));
        arAbb.eliminar(2);
        System.out.println(arAbb.size);

    }

}
