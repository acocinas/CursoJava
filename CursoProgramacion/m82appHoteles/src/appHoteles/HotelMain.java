package appHoteles;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HotelMain {
//private static ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
	public static void main(String[] args) {
		//Declaramos las variables y el ArrayList de hotel. Creo el array de objetos para usar la clase dialogo
		String message = "", hotel = "";
		Object[] choice = new Object[0];
		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
		CrudHotel.loadHotel(hoteles);
		do {//este bucle garantiza el realizar al menos una vez la pregunta y continuaremos dentro hasta que seleccionen salir del programa
			choice = new Object[] { "Crear hotel", "Ver hotel", "Modificar hotel", "Eliminar hotel",
					"Salir del programa" };
			hotel = Dialogo.seleccionar(choice, "Hotel", "Menú", 0);
			switch (hotel) {//con el entramos a cada una de las opciones que damos en el desplegable y llamamos a sus métodos
			case "Crear hotel":
				CrudHotel.createHotel(hoteles);
				break;
			case "Ver hotel":
				CrudHotel.seeHotel(hoteles);
				break;
			case "Modificar hotel":
				CrudHotel.modificationHotel(hoteles);
				break;
			case "Eliminar hotel":
				CrudHotel.removeHotel(hoteles);
				break;
			case "Salir del programa":
				message = "Gracias por su visita";
				JOptionPane.showMessageDialog(null, message);
				break;

			}
		} while (!"Salir del programa".equals(hotel));
	}

//	public static void createHotel(ArrayList<Hotel> hoteles) {//Creamos los hoteles y los guardamos en el ArrayList
//		String message = "", name = "";
//		int rooms = 0, floors = 0, area = 0;
//		name = JOptionPane.showInputDialog("Nombre del hotel");
//		rooms = Integer.parseInt(JOptionPane.showInputDialog("Número de habitaciones del hotel"));
//		floors = Integer.parseInt(JOptionPane.showInputDialog("Número de plantas del hotel"));
//		area = Integer.parseInt(JOptionPane.showInputDialog("Superficie en metros cuadrados del hotel"));
//		hoteles.add(new Hotel(name, rooms, floors, area));
//		message = "Hotel " + name + " creado correctamente";
//		JOptionPane.showMessageDialog(null, message);
//	}

//	public static void seeHotel(ArrayList<Hotel> hoteles) {//aquí usamos los getter para ver la info guardada del hotel si existe
//		String check = "";
//		int position = 0;
//
//		check = JOptionPane.showInputDialog("Nombre del hotel");
//		position = find(hoteles, check);
//
//		if (position != -1) {
//			JOptionPane.showMessageDialog(null,
//					hoteles.get(position) + "\n" + hoteles.get(position).maintenance(hoteles.get(position).getRooms()));
//			//esta línea nos dice que en esa posición del array, usamos el método de mantenimiento para esa posición del array y que en esa posición
//			//use ese número de habitaciones que son las guardadas en la misma posición
//		} else {
//			JOptionPane.showMessageDialog(null, "El hotel " + check +" no está en la aplicación, debe escribirse igual para ser encontrado");
//		}
//	}
//
//	public static void modificationHotel(ArrayList<Hotel> hoteles) {//otro desplegable, para las modificaciones del hotel. 
//		String check = "", modificationHotel = "";
//		int position = 0, rooms = 0, floors = 0, area = 0;
//
//		Object[] modification = new Object[0];
//		check = JOptionPane.showInputDialog("Nombre del hotel");
//		position = find(hoteles, check);
//		if (position != -1) {
//			modification = new Object[] { "Modificar número de habitaciones", "Modificar número de plantas",
//					"Modificar área" };
//			modificationHotel = Dialogo.seleccionar(modification, "Cambios", "Hotel " + check, 0);
//			if ("Modificar número de habitaciones".equals(modificationHotel)) {
//				rooms = Integer.parseInt(JOptionPane.showInputDialog("Diga la nueva cantidad de habitaciones"));
//				hoteles.get(position).setRooms(rooms);
//				JOptionPane.showMessageDialog(null, "Las habitaciones del hotel" + check + " han sido modificadas correctamente.");
//				
//			} else if ("Modificar número de plantas".equals(modificationHotel)) {
//				floors = Integer.parseInt(JOptionPane.showInputDialog("Diga la nueva cantidad de plantas"));
//				hoteles.get(position).setFloors(floors);
//				JOptionPane.showMessageDialog(null, "Las plantas del hotel "+check+" han sido modificadas correctamente.");
//			} else if ("Modificar área".equals(modificationHotel)) {
//				area = Integer.parseInt(JOptionPane.showInputDialog("Diga el nuevo área"));
//				hoteles.get(position).setArea(area);
//				JOptionPane.showMessageDialog(null, "El área del hotel "+check+ " ha sido actualizado correctamente.");
//			}
//
//		}else {
//			JOptionPane.showMessageDialog(null, "El hotel"+ check+ " no está en la aplicación, debe escribirse igual para ser encontrado");
//		}
//	}
//	public static void removeHotel(ArrayList<Hotel> hoteles) {//en este método eliminamos el hotel en caso de existir. 
//		String check = "";
//		int position = 0;
//
//		check = JOptionPane.showInputDialog("Nombre del hotel");
//		position = find(hoteles, check);
//
//		if (position != -1) {
//			hoteles.remove(position);
//			JOptionPane.showMessageDialog(null, "El hotel "+ check +" ha sido eliminado de la aplicación.");
//		} else {
//			JOptionPane.showMessageDialog(null, "Ese hotel "+check +" no está en la aplicación, debe escribirse igual para ser encontrado.");
//		}
//	}
//	public static void loadHotel(ArrayList<Hotel>hoteles) {
//		hoteles.add(new Hotel("casa2", 250, 50, 3050));
//		hoteles.add(new Hotel("Melia Castilla", 250, 25, 25000));
//		hoteles.add(new Hotel("Hilton", 195, 20, 10000));
//		hoteles.add(new Hotel("Hilton Tibidabo", 295, 18, 17500));
//	}
//
//	public static int find(ArrayList<Hotel> hoteles, String check) {//este método se usa en todos menos en el de crear hotel, para saber
//		//si el hotel está en la aplicación o no. 
//		boolean toLook = false;
//		int position = -1;
//		int i = 0;
//		int turn = hoteles.size();
//		while (i < turn && !toLook) {
//			if (check.equalsIgnoreCase(hoteles.get(i).getName())) {
//				position = i;
//				toLook = true;
//			}
//			i++;
//		}
//		return position;
//	}
}
