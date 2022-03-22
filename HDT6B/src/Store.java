import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Store {
	Vista vista = new Vista();
	Map<String, String> map;
	
	public void run() {
		this.factory();			
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
}
