package model.data_structures;

import java.io.Serializable;

public class Nodo <T> implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Elemento del nodo
	 */
	private T elemento;

	/**
	 * Siguiente elemento encadenado
	 */
	private Nodo<T> sigNode;
	
	/**
     * Constructor del nodo con el elemento especificado. <br>
     * <b>post: </b> Se construy� el nodo con el elemento especificado, sigNodo= null, antNodo= null, elemento= pElemento.
     * @param pElemento Elemento del nodo
     * @param pLista Lista Encadenada a la cual pertenece el nodo
     */
	
	public Nodo(T elemento) {
		this.elemento=elemento;
		this.sigNode = null;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public Nodo<T> getSigNode() {
		return sigNode;
	}

	public void setSigNode(Nodo<T> sigNode) {
		this.sigNode = sigNode;
	}

}
