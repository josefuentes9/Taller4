package model.data_structures;

public interface IMaxCP <T extends Comparable<T>> extends Iterable<T>  {

	public int darNumElementos();
	
	public void agregar(T elemento);
	
	public T sacarMax();
	
	public T darMax();
	
	public boolean isEmpty();
	
}
