package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;


    private class Nodo{
        Nodo next;
        Nodo prev;
        T valor;
        Nodo(T valor){
            this.valor=valor;
            this.next=null;
            this.prev=null;
        }
       

    }

    public ListaEnlazada() {
        this.primero =null;
        this.ultimo=null;
    }

    public int longitud() {
        Nodo actual=primero;
        int indice=0;
  
        while (actual!=null) {
            actual=actual.next;
            indice++;
        
        }
     return indice;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo=new Nodo(elem);
    if (primero == null) {
        primero = nuevo;
        ultimo = nuevo;
    } else {
        nuevo.next = primero;
        primero.prev=nuevo;
        primero = nuevo;

    }
    }

    public void agregarAtras(T elem) {
        Nodo nuevo= new Nodo(elem);
        if (ultimo ==primero && ultimo==null){
            ultimo=nuevo;
            primero=nuevo;
        }else{
            nuevo.prev=ultimo;
            ultimo.next=nuevo;
            ultimo=nuevo;
        }
    }

    public T obtener(int i) {
        Nodo actual=primero;
        int indice=0;
        while (indice!=i ){
          actual=actual.next;
          indice++;
        }
        return actual.valor;

    }

    public void eliminar(int i) {
        int count=0;
        Nodo actual=primero;
        Nodo otro = primero;

        while (count<i && actual!=null){
            otro=actual;
            actual=actual.next;
            count++;
        }

        if (actual==primero){
            primero=actual.next;
        }
        if (actual==ultimo ){
            otro=ultimo.prev;
            ultimo=otro;
            ultimo.next=null;

    }else{
        actual.prev=otro;
        actual.prev.next=(actual.next!=null)? actual.next:null;
        actual.next.prev=otro.prev;
    }
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nuevo=new Nodo(elem);
        Nodo actual = primero;
        for (int k=0;k<indice;k++){
            actual=actual.next;
        }
        System.out.println("este es el objeto: "+actual.valor);
        if (actual==primero){
            primero=nuevo;
        }

        else if (actual==ultimo){
            ultimo.prev.next=nuevo;
            ultimo=nuevo;
            ultimo.next=null;
        }else{
            actual.prev.next=nuevo;
            actual.next.prev=nuevo;
            nuevo.prev = actual.prev;
            nuevo.next = actual.next;
            actual=nuevo;
        }

    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.primero=lista.primero;
        this.ultimo=lista.ultimo;
        
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> lista_copia=new ListaEnlazada<>();
        Nodo actual=this.primero;
        int k=0;
        while (k<longitud()){
            actual=actual.next;
        }

        return lista_copia;
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }



}
