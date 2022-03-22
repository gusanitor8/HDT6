import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
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
	
	/**
	 * Le pregunta al ususario por algun producto en la coleccion
	 * @param listaProductos lista de todos los productos en la coleccion
	 * @return devuelve el producto que el usuarioo ingreso si es que existe 
	 */
	public String askProduct(String[] listaProductos) {
		String producto = "";
		
		try {
			print("Ingrese el producto: ");
			producto = input.nextLine();			
			
			
			if (isInArray(listaProductos, producto) == false) {
				throw new IndexOutOfBoundsException();
			}
			
			
		}catch(IndexOutOfBoundsException e) {
			print("Ese producto no se encuentra en la coleccion");
		}
		
		return producto;
				
	}
	
	/**
	 * Verifica si el elemento esta en la lista
	 * @param array lista a verificar
	 * @param element elemento a encontrar
	 * @return booleano, devuelve true si el elemento esta en el array
	 */
	public boolean isInArray(String[] array, String element) {
		boolean isInArray = false;
		
		for (String value : array) {
			if(value.equals(element)) {
				isInArray = true;
			}
		}
		
		
		return isInArray;
	}
	
	
	/**
	 * Menu de opciones
	 * @return devuelve un numero entero de 1 a 5 (inclusivo)
	 */
	public int menuOpiones() {
		print("Bienvenido a la tienda");
		print("1. Agregar producto a mi coleccion");
		print("2. Mostrar categoria de un producto");
		print("3. Mostrar datos de un producto");
		print("4. Mostrar categoria y cantidad de productos en mi coleccion");
		print("5. Mostrar producto y categoria del inventario");
		print("6. Salir");
		print("Ingrese una opcion: ");
		
		
		int option = 0;
		try {
			option = input.nextInt();
			input.nextLine();
					
			if ((option < 1) || (option > 6)) {
				throw new IndexOutOfBoundsException();
			}
			
		}catch(IndexOutOfBoundsException e) {
			print("La opcion esta fuera de las opciones, intente de nuevo\n");
			option = menuOpiones();
			
		}catch(InputMismatchException e) {
			print("La opcion ingresada es incorrecta, intente de nuevo\n");
			input.nextLine();
			option = menuOpiones();
			
		}
		return option;
	}
	
	
	public void productAddedFeedback(String product, int quant) {
		print("Se agrego: " + product + " a su coleccion, y ahora cuenta con: " + quant + " de ese producto e su coleccion");		
	}
	
	public void categoryFeedback(String product, String cat) {
		print("El producto: " + product + " entra en la categoria: " + cat);
	}
	
	public void productInfoFeedback(String product, String can, String category) {
		print("El producto: " + product + " pertenece a la categoria: " +category + " y cuenta con: " + can + " elementos en su coleccion");
		
	}
	
	public void productNotFound() {
		print("El producto que ingreso no existe, intente escribirlo EXACTAMENTE como esta indicado en el txt \n");
	}
	
	
	
}
