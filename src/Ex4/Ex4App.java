package Ex4;

import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Ex4App {

	static double precio = 0, precioIVA = 0, precioSIVA = 0, totalSinIVA = 0, totalConIVA = 0, resultado = 0,
			cambio = 0;

	public static void main(String[] args) {

		String respuesta;
		int opcion;

		Hashtable<String, Double> stock = new Hashtable<String, Double>();

		stock.put("zapatos", 50.80);
		stock.put("chanclas", 20.99);
		stock.put("calcetines", 2.99);
		stock.put("medias", 4.89);
		stock.put("zapatilla", 10.99);
		stock.put("sombrero", 7.99);
		stock.put("bufanda", 4.99);
		stock.put("guantes", 8.00);
		stock.put("sudadera", 20.00);
		stock.put("pantalones", 15.00);

		do {
			respuesta = JOptionPane.showInputDialog(
					"1 - Introducir elemento\n2 - Listar artículo"
					+ "\n3 - Listar todos\n4 - Calcular el precio\n5 - Pagar");
			opcion = Integer.parseInt(respuesta);

			switch (opcion) {
				case 1:
					introducirElemento(stock);
					break;
				case 2:
					String art = JOptionPane.showInputDialog("Cual quieres mostrar?");
					listarUno(art, stock);
					break;
				case 3:
					listarTodos(stock);
					break;
				case 4:
					String que = JOptionPane.showInputDialog("Artículo");
					String cant = JOptionPane.showInputDialog("Cantidad");
					int quant = Integer.parseInt(cant);
	
					precioSIVA = calcularPrecio(stock, que, quant);
					totalSinIVA += precioSIVA;
					String IVA = JOptionPane.showInputDialog("De cuanto es el IVA?\n1- 21%\n2- 4%");
					precioIVA = calcularIVA(precioSIVA, IVA);
					totalConIVA += precioIVA;
					
					System.out.println("Producto - Precio");
					System.out.println(que + " " + precioIVA);
					break;
				case 5:
					String aPagar = JOptionPane.showInputDialog("El total serian " + totalConIVA + "€\nCuanto va a pagar?");
					int pagado = Integer.parseInt(aPagar);
					while(pagado < totalConIVA) {
						System.out.println("Falta dinero!");
						aPagar = JOptionPane.showInputDialog("El total serian " + totalConIVA + "€\nCuanto va a pagar?");
						pagado = Integer.parseInt(aPagar);
					}
					cambio = cambio(pagado, totalConIVA);
					JOptionPane.showMessageDialog(null, "El cambio es de: " + cambio + "€");
					break;
				default:
					break;

			}

		} while (opcion != 5);

	}

	public static void introducirElemento(Hashtable<String, Double> stock) {
		String articulo, valor;
		double cantidad;

		articulo = JOptionPane.showInputDialog("Introducir artículo");
		if(stock.containsKey(articulo)) {
			System.out.println("Artículo ya existe!");
			return;
		}
		
		valor = JOptionPane.showInputDialog("Introducir precio");
		cantidad = Double.valueOf(valor);

		stock.put(articulo, cantidad);
	}

	public static void listarUno(String art, Hashtable<String, Double> almacen) {
		System.out.println("Objeto - Precio");
		for (String i : almacen.keySet()) {
			if (i.equals(art)) {
				System.out.println(i + " - " + almacen.get(i));
			}
		}
	}

	public static void listarTodos(Hashtable<String, Double> almacen) {
		System.out.println("Objeto - Cantidad");
		for (String i : almacen.keySet()) {
			System.out.println(i + " - " + almacen.get(i));
		}
	}

	public static double calcularPrecio(Hashtable<String, Double> almacen, String cod, int quant) {
		double precio = 0;
		for (String i : almacen.keySet()) {
			if (i.equals(cod)) {
				precio = almacen.get(i);
			}
		}
		precio = precio * quant;

		return precio;
	}

	public static double calcularIVA(double precio, String IVA) {
		double resultado = 0;
		if (IVA == "1") {
			resultado = precio + (precio * 0.21);
		} else {
			resultado = precio + (precio * 0.04);
		}

		return resultado;
	}

	public static double cambio(double pagado, double precioTotalIVA) {
		double vuelta = 0;
		vuelta = pagado - precioTotalIVA;

		return vuelta;
	}
}
