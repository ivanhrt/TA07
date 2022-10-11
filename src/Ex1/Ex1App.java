package Ex1;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Ex1App {
	
	static Hashtable<String,String> alumnoNota = new Hashtable<String,String>();
	static int totalAlumnos=0;
	
	public static void main(String[] args) {
		int opcio=0;
		
		do {
			String res = JOptionPane.showInputDialog("\n1-Introducir alumnos y notas\n2-Mostrar alumnos y notas\n3-Salir");
			opcio = Integer.parseInt(res);
			
			switch(opcio) {
			case 1:
				listaAlumnos();
			break;
			case 2:
				mostrarAlumnos();
			break;
			case 3:
				break;
			}
			
		}while(opcio!=3);
	}
	
	public static void listaAlumnos() {
			
		double media=0, nota=0, suma=0, i=0;
		String nombre = JOptionPane.showInputDialog("Como se llama el alumno?"); 
		
		do {
			String n = JOptionPane.showInputDialog("Nota del alumno (0 para salir)"); 
			alumnoNota.put(nombre, n); 
			nota = Double.parseDouble(n);
			suma+=nota;
			i++;
		}while(nota!=0);
		i--;
		media = suma/i;
		String mediaS = String.valueOf(media);
		alumnoNota.put(nombre, mediaS);
		
		totalAlumnos ++;
		
	}

	public static void mostrarAlumnos() {		
		System.out.println("Alumno - Nota");
		for(String i : alumnoNota.keySet()) {	
			System.out.println(i + " - " + alumnoNota.get(i));	
		}
	}
	
}