import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Store {
	Vista vista = new Vista();
	Map<String, String> map;
	
	public void run() {
		this.factory();			
		ArrayList<String> lista = vista.toRead();
		this.toMap(lista);

	}
	
	
	/**
	 * Metodo que implementa el patron de disenio Factory
	 * para las clases que implementan la interfaz mapa	
	 */
	public void factory() {		 				
		switch(vista.askImplementation()) {
			case 1:
				map = new HashMap<String, String>();
				break;
			case 2:
				map = new TreeMap<String, String>();
				break;
			case 3:
				map = new LinkedHashMap<String, String>();
				break;
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
			
			//String[] valueArray = {valueKey[0]};
				
			System.out.println("Llave: " + valueKey[1] + " Valor: " + valueKey[0]);
			
			map.put(valueKey[1], valueKey[0]);
						
		}
		
		
	}
}
