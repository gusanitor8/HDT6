import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Vista {
	Scanner input = new Scanner(System.in);	
	
	/**
	 * Abreviacvcion para hacer un print
	 * @param text Cadena de texto que se mostrara en la consola
	 */
	private void print(String text) {
		System.out.println(text);
	}
	
	/**
	 * Le pregunta al usuario la implementacion que quiere usar con el programa 
	 * @return numero entero de 1 a 3 (inclusivos)
	 */
	public int askImplementation() {
		int option = 0;
		try {
			print("Con que implementacion le gustaria trabajar?: ");
			print("1. HashMap");
			print("2. TreeMap");
			print("3. LinkedHashMap");
			
			option = input.nextInt();
			input.nextLine();
					
			if ((option < 1) || (option > 3)) {
				throw new IndexOutOfBoundsException();
			}
			
		}catch(IndexOutOfBoundsException e) {
			print("La opcion esta fuera de las opciones, intente de nuevo\n");
			option = askImplementation();
			
		}catch(InputMismatchException e) {
			print("La opcion ingresada es incorrecta, intente de nuevo\n");
			input.nextLine();
			option = askImplementation();
			
		}
		return option;
	}
	
	
	/**
	 * Lee cada linea del archivo de texto y las devuelve en un ArrayList
	 * @return ArrayList con cada linea del archivo 
	 */
	public ArrayList toRead() {
		ArrayList<String> strings = new ArrayList<String>();
		
		try {
			File texto = new File("src/ListadoProducto.txt");
			Scanner scan = new Scanner(texto);
			
			while (scan.hasNextLine()) {
		        String data = scan.nextLine();
		        strings.add(data);
			}
		scan.close();
		}catch(FileNotFoundException e) {
			System.out.println("An error occurred.");
		}
		
		return strings;
	}
	
	
}
