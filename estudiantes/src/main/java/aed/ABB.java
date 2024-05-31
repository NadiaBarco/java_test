package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int size;
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
    public int longitud_rama(Nodo n){
        Nodo actual=n;
        int k=0;
        if (actual!=null){
            k++;
            longitud_rama(actual.der);
            
        }
        if (actual.der ==null){
            longitud_rama(actual.izq);
        }
        while (actual!=raiz){
            longitud_rama(actual.up);
        }

        return k;
    }
    public int cardinal() {
        int total=0;
        if (raiz==null){
            return 0;
        }else {
            total=longitud_rama(raiz.der)+longitud_rama(raiz.izq)+1;
        }
        return total;
    }

    public T minimo(){
        return minimoNodo(raiz);
    }
    public T minimoNodo(Nodo n){
        Nodo minimo=n;
        Nodo actual=n;
        if (actual!=null){
            minimo=actual;
            minimoNodo(actual.izq);
        }
        return minimo.valor;
    }

    public T maximoNdo(Nodo n){
        Nodo maximo=n;
        Nodo actual;
        if (maximo!=null){
            actual=maximo;
            maximoNdo(maximo.der);
        }
        return maximo.valor;
    }

    public T maximo(){
        
        return maximoNdo(raiz);
    }

    public void insertarRec(Nodo n, Nodo m){
        if (n==null){
            n=m;
        }
        if (n.valor.compareTo(m.valor)==0){
            return;
        }
         if(n.valor.compareTo(m.valor)>0){
            insertarRec(n.izq, m);
            
        if (n.valor.compareTo(m.valor)<=0){
            insertarRec(n.der,m);
            if (n.der==null){
                n.der=m;
            }
        }
        }
    }

    public void insertar(T elem){
        Nodo nuevo=new Nodo(elem);
        if (raiz==null){
            raiz=nuevo;
            return;
        }
        insertarRec(raiz,nuevo);
        
    }

    public boolean pertenece(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
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
        
        ABB  arAbb= new ABB<>();

    }

}

