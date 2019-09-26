package model.logic;

import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import model.data_structures.MaxPQ;
import model.data_structures.PrioridadQueue;



/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private PrioridadQueue<TravelTime> datosCola;
	private MaxPQ<TravelTime> datosHeap;
	
	private int tamano;
	private TravelTime viaje;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datosCola = new PrioridadQueue<TravelTime>();
		datosHeap=new MaxPQ<>();		
	}
	
	public void crearLista() throws Exception
	{
		CSVReader reader=null;
		reader = new CSVReader(new FileReader("/data/bogota-cadastral-2018-1-All-HourlyAggregate.csv"));
		String [] nextLine=reader.readNext();
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line

			datosCola.enqueue(new TravelTime(1, nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
			datosHeap.insert(new TravelTime(1, nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));

		}
		reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-HourlyAggregate.csv"));
		nextLine=reader.readNext();
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line

			datosCola.enqueue(new TravelTime(2, nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
			datosHeap.insert(new TravelTime(2, nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));

		}
		reader.close();
	}

	
	
	public ArrayList<TravelTime> generarMuestra(int n) {
		// TODO Auto-generated method stub
		PrioridadQueue a=datosCola;
		ArrayList<TravelTime> uribe=new ArrayList<TravelTime>();
		uribe.add((TravelTime) a.dequeue());
		for (int i=0;i<a.size()&&uribe.size()<n;i++){
			for (int j=0+1;j<uribe.size();j++){
				TravelTime hola=(TravelTime) a.dequeue();
				if(hola.compareTo(uribe.get(j))!=0){
					uribe.add(hola);
				}
			}
		}
		
		return uribe;
	}

	public double nTiemposMasRapidosCola(int n, int zonai, int zonao) {
		ArrayList<TravelTime> viajes=new ArrayList<>();
		long startTime= System.currentTimeMillis();
		for(int i=0; i<datosCola.size()&&i<n;i++)
		{
			viajes.add(datosCola.dequeueMax());
		}
		long endTime= System.currentTimeMillis();
		return endTime-startTime;
		// TODO Auto-generated method stub
		
	}

	public double nTiemposMasRapidosHeap(int n, int zonai, int zonao) {
		ArrayList<TravelTime> viajes=new ArrayList<>();
		long startTime= System.currentTimeMillis();
		for(int i=0; i<datosHeap.size()&&i<n;i++)
		{
			viajes.add(datosHeap.delMax());
		}
		long endTime= System.currentTimeMillis();
		return endTime-startTime;
	}	
	

}