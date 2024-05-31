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
            minimoNodo(actual.izq);
        }
        return minimo.valor;
    }

    public T maximoNdo(Nodo n){
        Nodo maximo=n;
        Nodo actual=n;
        if (maximo.der!=null){
            actual=maximo.der;
            maximoNdo(maximo.der);
        }
        return actual.valor;
    }

    public T maximo(){
        
        return maximoNdo(raiz);
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
        Nodo nuevo=new Nodo(elem);
        if (n==null){
            n=nuevo;
        }else 
        {
            if (n.valor.compareTo(elem)==0){
                return;
            }
            if (n.valor.compareTo(elem)>0 && n.izq==null){
                n.izq=nuevo;


            }else{
                insertarNodo(n.der,elem);
            }
            if (n.valor.compareTo(elem)<0 && n.der==null) {
                n.der=nuevo;
            }else{
                insertarNodo(n.izq, elem);
            }
        }
    }

    public boolean pertenece(T elem){
        return perteneceAlNodo(raiz,elem);
    }

    public boolean perteneceAlNodo(Nodo n,T elem){
        int comparacion=n.valor.compareTo(elem);//n=5,elem =2--n=1 , elem =2
        if (comparacion==0){
            return true;
        }else{
            if (comparacion>0&&n.izq!=null){//5>2
                perteneceAlNodo(n.izq, elem);//perteneceN(1,2)
            }else if (comparacion<0&&n.der!=null){//1<2
                perteneceAlNodo(n.der, elem);//n==2 ,elem=2
            }
        }
        return false;
    }

    public void eliminar(T elem){
        eliminarNodo(raiz,elem);
    }
    public void eliminarNodo(Nodo n,T elem){//raiz=3 elem=5
        int comparacion=(n.valor).compareTo(elem);//3!=5
        if(comparacion==0 && n.der==null &&n.izq==null){
            n=null;
        }else if(comparacion==0 && (n.der!=null && n.izq!=null)){
            n=n.izq;
        }
        else{
            if(comparacion>0){
                eliminarNodo(n.der, elem);
            }else if(comparacion==0 && n.der!=null){

            }else if(comparacion<0){
                eliminarNodo(n.izq, elem);
            }
        }
    }

    public Nodo obtenerPredecesor(Nodo n){
        if (n.izq!=null&&(n.izq.izq!=null|| n.izq.der!=null)){

        }
        return raiz;
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
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
        //System.out.println(arAbb.maximo());
        //System.out.println(arAbb.raiz.valor);
        //System.out.println(arAbb.maximo());
    }

}
