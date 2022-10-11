package Ex3;

import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Ex3App {

public static void main(String[] args) {
		
		String respuesta;
		int opcion;
		
		Hashtable<String, Double> stock = new Hashtable<String,Double>(); //diccionario del inventario
		
		stock.put("zapatos", 20.00);
		stock.put("chanclas", 15.00);
		stock.put("calcetines", 25.00);
		stock.put("medias", 30.00);
		stock.put("zapatilla", 50.00);
		stock.put("sombrero", 10.00);
		stock.put("bufanda", 20.00);
		stock.put("guantes", 40.00);
		stock.put("sudadera", 60.00);
		stock.put("pantalones", 60.00);
		
		boolean loop = true;
		do {
			respuesta = JOptionPane.showInputDialog("1- Introducir elemento\n2- Listar artículo \n3- Listar todos\n0- Salir");
			opcion = Integer.parseInt(respuesta);
			
			
			switch(opcion) {
				case 1:
					introducirElemento(stock);
					break;
				case 2:
					String art = JOptionPane.showInputDialog("Cual quieres mostrar?");
					listarArticulo(art, stock);
					break;
				case 3:
					listarTodos(stock);
					break;
				default:
					loop = false;
					break;
			}
		}while(loop);
		
	}
	
	public static void introducirElemento(Hashtable<String,Double> stock) {
		String articulo, valor;
		
		articulo = JOptionPane.showInputDialog("Llave");
		valor = JOptionPane.showInputDialog("Valor");
		
		stock.put(articulo, Double.valueOf(valor));
	}
	
	public static void listarArticulo(String art ,Hashtable<String,Double> almacen) {
		System.out.println("Objeto - Cantidad");
		
		for(String i : almacen.keySet()) {
			if(i.equals(art)) {
				System.out.println(i + " - " + almacen.get(i));
			}
		}
	}

	public static void listarTodos(Hashtable<String,Double> almacen) {		
		System.out.println("Objeto - Cantidad");
		for(String i : almacen.keySet()) {
				System.out.println(i + " - " + almacen.get(i));
		}
	}
	
}
