import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Store {
	Vista vista = new Vista();
	Map<String, String[]> map;
	String[] products; //keys
	boolean toRun = true;

	/**
	 * metodo que se manda a llamar en el driver program
	 */
	public void run() {
		this.factory();			
		ArrayList<String> lista = vista.toRead();
		this.toMap(lista);

	}
	
	/**
	 * Metodo constructor
	 */
	public Store() {
		switch(vista.askImplementation()) {
		case 1:
			map = new HashMap<String, String[]>();
			break;
		case 2:
			map = new TreeMap<String, String[]>();
			break;
		case 3:
			map = new LinkedHashMap<String, String[]>();
			break;
		}
	}
	
	
	/**
	 * Metodo que implementa el patron de disenio Factory
	 * para las clases que implementan la interfaz mapa	
	 */
	public void factory() {	
		String product;						
		toMap(vista.toRead());
		
		while (toRun) {
			long start;
			long end;
			switch(vista.menuOpiones()) {
				case 1:
					
					product = vista.askProduct(products);
					addProductToCollection(product);
					break;
				case 2:
					product = vista.askProduct(products);
				    getCategory(product);
					break;
				case 3:
					
					product = vista.askProduct(products);
					start = System.currentTimeMillis();
					productInfo(product);
					end = System.currentTimeMillis();
					
					System.out.println(end-start);
					break;
				case 4:
					start = System.currentTimeMillis();
					collectionInfo();
					end = System.currentTimeMillis();
					System.out.println(end-start);
					break;
				case 5:
					start = System.currentTimeMillis();
					showInventory();
					end = System.currentTimeMillis();
					System.out.println(end-start);
					break;
				case 6:
					toRun = false;
					break;
			}
		}
	}
	
	/**
	 * Pone los artiulos en un Mapa
	 * @param list ArrayList que contiene cada linea del txt
	 */
	public void toMap(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String[] valueKey = list.get(i).split("\\|");
			valueKey[0] = valueKey[0].strip();
			valueKey[1] = valueKey[1].strip();
			
			String[] valueArray = {valueKey[0], "0"};							
			//System.out.println("Llave: " + valueKey[1] + " Valor: " + valueKey[0]); //BORRAR LINEA
			
			map.put(valueKey[1], valueArray);
			products = map.keySet().toArray(new String[map.size()]); //array de las llaves (productos)
						
		}
		
		
	}
	
	/**
	 * Agrega el producto ingresado por el usuario a su coleccion
	 * @param product producto ingresado por el usuario
	 */
	public void addProductToCollection(String product) {
		String[] valueArray = map.get(product);
		int quantity = Integer.parseInt(valueArray[1]) + 1; 
		//System.out.println("cantidad: "+ quantity);			//Borrar linea
		String cantidad = String.valueOf(quantity);
		valueArray[1] = cantidad;
		
		map.put(product, valueArray);
		
		vista.productAddedFeedback(product, quantity);
	}
	
	/**
	 * Obtiene el valor de una llave
	 * @param product la llave del mapa
	 */
	public void getCategory(String product) {
		String category = map.get(product)[0];
		vista.categoryFeedback(product, category);
	}
	
	/**
	 * Despliega la informacion de todo la coleccion
	 */
	public void collectionInfo() {
		for (String key: products) {
			String[] valueArray = map.get(key);
			
			if(valueArray[1].equals("0") == false) {
				String cantidad = valueArray[1];
				String categoria = valueArray[0];
				
				vista.productInfoFeedback(key, cantidad, categoria);
			}
			
		}
	}
	
	
	/**
	 * despliega informacion de un producto en especifico
	 * @param product
	 */
	public void productInfo(String product) {
		boolean productFound = false;
		
		for (String key: products) {
			String[] valueArray = map.get(key);
			
			if(key.equals(product)) {
				String cantidad = valueArray[1];
				String categoria = valueArray[0];
				
				vista.productInfoFeedback(key, cantidad, categoria);
			}			
		}
		
		if (productFound == false) {
			vista.productNotFound();
		}
	}
	
	/**
	 * Muestra todo el inventario
	 */
	public void showInventory() {
		for (String key: products) {
			String[] valueArray = map.get(key);
			String cantidad = valueArray[1];
			String categoria = valueArray[0];	
			
			vista.productInfoFeedback(key, cantidad, categoria);
		}
	}
	

}
