package appBancoAsociacion;
//import java.util.InputMismatchException;
import javax.swing.*;

public class Dialogo {
	private static final String I_MSG = "<html><p style=\"color: red; font-size: 20px; font-weight: normal; font-family: Verdana;\">";
	private static final String F_MSG = "</p></html>";
	//https://www.youtube.com/watch?v=6YyV8XbBlP8	
	
	public static String inputStr(String mensaje, String titulo) {
		String text  = I_MSG + mensaje + F_MSG + " ";
		String texto = "";
	    boolean correcto = false;
	
	    do {
	        try {
	        	texto = JOptionPane.showInputDialog(null, text, titulo, JOptionPane.QUESTION_MESSAGE);	       
	        	if (texto.isEmpty()) {
	        		Dialogo.mensaje("Introduce un string", "#ERROR: indica un valor", "E");
	        	} else {
	        		correcto = true;
				}
	        } catch (Exception ex) {
	        	Dialogo.mensaje("Introduce un string", "#ERROR: tipo datos incorrecto", "E");
	        }
	    } while (!correcto);
	    return texto;
	}
	
	public static int inputInt(String mensaje, String titulo) {
		String text  = I_MSG + mensaje + F_MSG + " ";
		int valor = 0;
	    boolean correcto = false;
	
	    do {
	        try {
	        	valor = Integer.parseInt(JOptionPane.showInputDialog(null, text, titulo, JOptionPane.QUESTION_MESSAGE));	       
	        	correcto = true;
	        } catch (Exception ex) {
	        	Dialogo.mensaje("Introduce un número entero", "#ERROR: tipo datos incorrecto", "E");
	        }
	    } while (!correcto);
	    return valor;
	}	
	
	public static float inputFloat(String mensaje, String titulo) {
		String text  = I_MSG + mensaje + F_MSG + " ";
		float valor = 0;
	    boolean correcto = false;
	
	    do {
	        try {
	        	valor = Float.parseFloat(JOptionPane.showInputDialog(null, text, titulo, JOptionPane.QUESTION_MESSAGE));	       
	        	correcto = true;
	        } catch (Exception ex) {
	        	Dialogo.mensaje("Introduce un número decimal", "#ERROR: tipo datos incorrecto", "E");
	        }
	    } while (!correcto);
	    return valor;
	}	
	
	public static double inputDouble(String mensaje, String titulo) {
		String text  = I_MSG + mensaje + F_MSG + " ";
		double valor = 0;
	    boolean correcto = false;
	
	    do {
	        try {
	        	valor = Double.parseDouble(JOptionPane.showInputDialog(null, text, titulo, JOptionPane.QUESTION_MESSAGE));	       
	        	correcto = true;
	        } catch (Exception ex) {
	        	Dialogo.mensaje("Introduce un número decimal", "#ERROR: tipo datos incorrecto", "E");
	        }
	    } while (!correcto);
	    return valor;
	}
	
	public static byte inputByte(String mensaje, String titulo) {
		String text  = I_MSG + mensaje + F_MSG + " ";
		byte valor = 0;
	    boolean correcto = false;
	
	    do {
	        try {
	        	valor = Byte.parseByte(JOptionPane.showInputDialog(null, text, titulo, JOptionPane.QUESTION_MESSAGE));	       
	        	correcto = true;
	        } catch (Exception ex) {
	        	Dialogo.mensaje("Introduce un número entero entre -127 y 128", "#ERROR: tipo datos incorrecto", "E");
	        }
	    } while (!correcto);
	    return valor;
	}
	
	public static String seleccionar(Object[] opciones, String mensaje, String titulo, int predeterminada) {
		String text  = I_MSG + mensaje + F_MSG + " ";		
		
		String s = (String)JOptionPane.showInputDialog(
		                    null,
		                    text,
		                    titulo,
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    opciones,
		                    opciones[predeterminada]
		                    );
		return s;
	}
	

	public static Boolean confirmar(String mensaje) {
		String text  = I_MSG + mensaje + F_MSG + " ";
		// En caso de cerrar el cuadro de diálogo, n = -1
		
		String titulo = "CONFIRMA (Sí/No). Cerrar equivale a No";
		
		int n = JOptionPane.showConfirmDialog(null, text, titulo, 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		
		return (n==0) ? true : false;
	}
	
	
	public static void mensaje(String mensaje, String titulo, String boton) {
		int icono;
		String text = I_MSG + mensaje + F_MSG + " ";
		
		try {
			switch (boton.toUpperCase()) {
				case "I":
					icono = JOptionPane.INFORMATION_MESSAGE;
					break;
				case "E":
					icono = JOptionPane.ERROR_MESSAGE;
					break;
				case "P":
					icono = JOptionPane.QUESTION_MESSAGE;
					break;
				case "A":
					icono = JOptionPane.WARNING_MESSAGE;
					break;			
				default:
					icono = JOptionPane.PLAIN_MESSAGE;
					break;
			}
		} catch (Exception ex) {
			icono = JOptionPane.PLAIN_MESSAGE;
		}
		JOptionPane.showMessageDialog(null, text, titulo, icono);
	}
	
	
} //Fin de la clase

