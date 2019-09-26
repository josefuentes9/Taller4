package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Test;

import model.data_structures.MaxPQ;
import model.data_structures.PrioridadQueue;

public class PruebaColaPrioridad {
	
	private PrioridadQueue Cola;
	private MaxPQ ColaH;
	private final static int cantidad=10;
	private int size;
	
	@Before
	public void setUp1() {
		Cola=new PrioridadQueue();
		size++;
	}

	public void setUp2() {
		for(int i =0; i<cantidad; i++){
			Cola.enqueue(i);
			ColaH.insert(i);
			size++;
		}
	}
	@Test
	public void TestQueue(){
		size=0;
		assertTrue(Cola!=null);
		assertEquals(0, Cola.size());
	}
	@SuppressWarnings("unchecked")
	@Test
	public void TestPush(){
		setUp2();
		Cola.enqueue(7);
		size++;
		assertTrue("no se modifico el tamaño de la pila ",size==Cola.size());
		int dato=0;
		while(size!=0){
			dato=(Integer)Cola.dequeue();
		}
		assertTrue("no se agrego correctamente a la pila", dato==7);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void TestPush2(){
		setUp1();
		Cola.enqueue(7);
		assertTrue("no se modifico el tamaño de la pila ",size==Cola.size());
		assertFalse("no se agrego correctamente a la pila", (Integer)Cola.dequeue()==1);
		
		
	}
	
	public void TestDequeue(){
	setUp2();
	int i=0;
	while(size!=0){
	assertTrue("no salio correctamente a la pila",(Integer) Cola.dequeue()==i);
	
	i++;
	}
	}
	
	public void TestDequeue2(){
		setUp1();
		Cola.enqueue(7);
		assertTrue("no salio correctamente a la pila", (Integer)Cola.dequeue()==7);
		assertTrue("La pila no quedo vacia ",Cola.isEmpty());
		
		}
	public void Testinsert(){
		setUp1();
		ColaH.insert(1);
		ColaH.insert(2);
		ColaH.insert(3);
		assertTrue("No se agregaron correctamente",ColaH.size()==3);
	}
	public void TestDequeueMax(){
		setUp2();
		assertTrue("La cola no saco el maximo",Cola.dequeueMax().compareTo(9)==0);
	}
	public void TestDelMax(){
		setUp2();
		assertTrue("La cola no saco el maximo",ColaH.max().equals(ColaH.delMax()));
	}
}
