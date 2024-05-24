import java.util.*;

public class PruebasListasEnlazada {
    private Node primero;
    private Node ultimo;


    private class Node{
        Node next;
        Node prev;
        String valor;
        Node(String valor){
            this.valor=valor;
            this.next=null;
            this.prev=null;
        }
       

    }

public PruebasListasEnlazada(){
   this.primero =null;
   this.ultimo=null;
   
}

public int longitud(){
    Node actual=primero;
    int indice=0;
  
    while (actual!=null) {
        actual=actual.next;
        indice++;
        
    }
    return indice;
}


public void agregarAdelante(String valor){
    Node nuevo=new Node(valor);
    if (primero == null) {
        primero = nuevo;
        ultimo = nuevo;
    } else {
        nuevo.next = primero;
        primero.prev=nuevo;
        primero = nuevo;

    }
   
}

public Node elUltimoPrimero(){
    Node actual=primero;
    while (actual!=null) {
        actual=actual.next;
    }
    return actual;
}
public void agregarAtras(String valor){
    Node nuevo= new Node(valor);
        if (ultimo ==primero || ultimo==null){
            ultimo=nuevo;
            primero=nuevo;
        }else{
            nuevo.prev=ultimo;
            ultimo.next=nuevo;
            ultimo=nuevo;
        }
    
}

public String obtener(int i){
    Node actual=primero;
    int indice=0;
    while (indice!=i && i<=longitud()){
       actual=actual.next;
       indice++;
        
    }
    return actual.valor;

}


public void eliminar(int i){
    int count=0;
    Node actual=primero;
    Node otro = primero;

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


public void modificarPosicion(int i, String elem) {
    Node nuevo=new Node(elem);
    Node actual = primero;
    for (int k=0;k<i;k++){
        actual=actual.next;
    }
    if (actual==primero){
        primero=nuevo;
    }

    if (actual==ultimo){
        ultimo.prev.next=nuevo;
        ultimo=nuevo;
        ultimo.next=null;
    }
    if (nuevo!=primero && nuevo!=ultimo){
        nuevo.prev = actual.prev;
        nuevo.next = actual.next;

    }
    
}
  public static void main(String[] args) {
      PruebasListasEnlazada lista=new PruebasListasEnlazada();
      lista.agregarAtras("obj0");
      lista.agregarAdelante("obj1");
      lista.agregarAdelante("ob2");
      lista.agregarAdelante("obj3");
      lista.agregarAtras("obj5");
      lista.agregarAtras("obj6");
      lista.agregarAtras("obj7");
    System.out.println(lista.longitud());
      
      lista.modificarPosicion(6,"Nuevo");
      System.out.println(lista.obtener(6));

  }
}