package anonimizacion;

/**
 * @author 	ricmart
 * @email	ricardomarsanc@gmail.com
 */

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import anonimizacion.Combination;

public class Main {

	public static void main(String args[]) throws IOException{
//		ArrayList<ArrayList<String>> tabla = readFile("src/assets_folder/prueba.txt");
//		generateFile(tabla);
		
		int maxValues[] = {1,2,3};
        Combination.printCombination(maxValues); 
        
        System.out.println("Program finished.");
	}
	
	public static void generateFile(ArrayList<ArrayList<String>> file) throws FileNotFoundException, IOException{
		String ruta = "src/assets_folder/tabla_resultado.txt";
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(ruta);
			for(ArrayList<String> fila : file) {
				for (String palabra : fila) {
					fichero.write(palabra + ", ");
				}
				fichero.write("\n");
			}
			fichero.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
	
	public static ArrayList<ArrayList<String>> readFile(String archivo) throws FileNotFoundException, IOException {
		ArrayList<ArrayList<String>> matrizResultado = new ArrayList<ArrayList<String>>();
	    String cadena;
	    FileReader f = new FileReader(archivo);
	    BufferedReader b = new BufferedReader(f);
	    int i = 0;
	    while((cadena = b.readLine())!=null) {
	    	String[] unaLinea = cadena.split("\\s"); //Separamos los valores y los guardamos en nuestra matriz (", ")
	    	ArrayList<String> lineaList = new ArrayList<>(Arrays.asList(unaLinea));
	    	matrizResultado.add(i, lineaList);
	        i++;
	    }
	    b.close();
	    return matrizResultado;
	}
}
