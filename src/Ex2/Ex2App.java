package Ex2;

import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Ex2App {

	static double precioSIVA=0, precioIVA=0, precioTotalSIVA=0, precioTotalIVA=0, cambio=0;
	static String IVA;
	
	public static void main(String[] args) {
		
		int cont=0;
		
		Hashtable<String, Double> caja = new Hashtable<String,Double>();
		
		// productes
		caja.put("1", 11.00);
		caja.put("2", 12.50);
		caja.put("3", 13.99);
		caja.put("4", 1.00);
		caja.put("5", 2.50);
		caja.put("6", 3.99);
		
		String quantS = JOptionPane.showInputDialog("Quantos productos diferentes lleva en el carro de la compra?");
		int cantTotal = Integer.parseInt(quantS);
		
		do {
			String cod = JOptionPane.showInputDialog("Código producto");
			String cant = JOptionPane.showInputDialog("Cantidad");
			int quant = Integer.parseInt(cant);
			
			precioSIVA = calcularPrecio(caja, cod, quant);
			
			precioTotalSIVA += precioSIVA;
			
			String IVA = JOptionPane.showInputDialog("Que IVA tiene el el producto introducido?\n1 - 21%\n2 - 4%");
			
			precioIVA = calcularIVA(precioSIVA, IVA);
			
			precioTotalIVA += precioIVA;
			
			cont++;
		}while(cont!=cantTotal);
		
		System.out.println("Usted ha comprado un total de " + cont + " articulo/s");
		System.out.println("El precio total sin IVA es de " + precioSIVA);
		System.out.println("El precio total con IVA es de " + precioIVA);
		
		String cantPag = JOptionPane.showInputDialog("Usted tiene que pagar " + precioIVA + "€ cuanto va a pagar?");
		double pagado = Double.valueOf(cantPag);
		
		cambio = cambioPag(pagado, precioTotalIVA);
		
		System.out.println("El cambio es de " + cambio + "€");
	}

	public static double calcularPrecio(Hashtable<String,Double> ref, String cod, int quant) { //Calculamos el precio sin IVA
		double precio=0;
		
		for(String i : ref.keySet()) {
			if(i.equals(cod)) {
				precio = ref.get(i);	
			}		
		}
		precio = precio * quant;
		
		return precio;
	}
	
	public static double calcularIVA(double precio, String IVA) {
		double resultado = 0;
		
		if(IVA == "1") {
			resultado = precio + (precio * 0.21);
		}else if(IVA == "2"){
			resultado = precio + (precio * 0.04);
		}
		
		return resultado;
	}
	
	public static double cambioPag(double pagado, double precioTotalIVA) {
		double vuelta=0;
		vuelta = pagado - precioTotalIVA;
		
		return vuelta;
	}
	
}