package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.data_structures.PrioridadQueue;
import model.logic.MVCModelo;
import model.logic.TravelTime;
import view.MVCView;
import com.opencsv.CSVReader;
public class Controller 
{

	/* Instancia del Modelo*/
	private static MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;


	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}

	public void run()
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \n Cargando Viajes ");
				modelo = new MVCModelo();
				try
				{
					modelo.crearLista();
				}
				catch(Exception e)
				{
					//
				}
				break;

			case 2:
				view.printMessage("--------- \n Seleccione n:");
				int n = lector.nextInt();

				ArrayList<TravelTime> hollman=modelo.generarMuestra(n);
				for(int i=0;i<hollman.size();i++){
					view.printMessage("Tiempo promedio:"+ hollman.get(i).getMean_travel_time());
				}
				break;

			case 3:
				view.printMessage("--------- \\n Seleccione la zona inicial>");
				int zonai = lector.nextInt();
				view.printMessage("--------- \\n Seleccione la zona final>");
				int zonao = lector.nextInt();
				view.printMessage("--------- \\n Seleccione el numero de viajes que desea consultar>");
				int N = lector.nextInt();
				double tiempoCola= modelo.nTiemposMasRapidosCola(N, zonai, zonao);
				double tiempoHeap= modelo.nTiemposMasRapidosHeap(N, zonai, zonao);
				view.printMessage("El tiempo que se demora en realizar la operacion con la implementacion de cola es: "+tiempoCola);
				view.printMessage("El tiempo que se demora en realizar la operacion con la implementacion de Heap es: "+tiempoHeap);
				
				break;

			case 4: 
				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}

		}	

	}
}