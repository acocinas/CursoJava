package edificiosHerencia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CrudEdificios {
	
	public static void createHospital(ArrayList<Hospital> hospitals) {// Creamos los hoteles y los guardamos en el
		// ArrayList
		String name = "";
		int floors = 0, area = 0, beds = 0, patients = 0, position = 0;
		name = JOptionPane.showInputDialog("Nombre del hospital");
		position = findHospital(hospitals, name);
		if (position == -1) {
			floors = Integer.parseInt(JOptionPane.showInputDialog("Número de plantas del hospital"));
			area = Integer.parseInt(JOptionPane.showInputDialog("Superficie en metros cuadrados del hospital"));
			beds = Integer.parseInt(JOptionPane.showInputDialog("Número de camas en el hospital"));
			hospitals.add(new Hospital(name, floors, area, beds, patients));
			JOptionPane.showMessageDialog(null, "El hospital " + name + " ha sido creado correctamente");
		} else {
			JOptionPane.showMessageDialog(null,
					"El hospital " + name + " ya está en la aplicación, no puede volver a crearlo");
		}
	}

	public static void createHotel(ArrayList<Hotel> hotels) {// Creamos los hoteles y los guardamos en el ArrayList
		String name = "";
		int floors = 0, area = 0, rooms = 0, position = 0;
		name = JOptionPane.showInputDialog("Nombre del hotel");
		position = findHotel(hotels, name);
		if (position == -1) {
			floors = Integer.parseInt(JOptionPane.showInputDialog("Número de plantas del hotel"));
			area = Integer.parseInt(JOptionPane.showInputDialog("Superficie en metros cuadrados del hotel"));
			rooms = Integer.parseInt(JOptionPane.showInputDialog("Número de habitaciones del hotel"));
			hotels.add(new Hotel(name, floors, area, rooms));
			JOptionPane.showMessageDialog(null, "El hotel " + name + " ha sido creado correctamente");
		} else {
			JOptionPane.showMessageDialog(null,
					"El hotel " + name + " ya está en la aplicación, no puede volver a crearlo");
		}
	}

	public static void createCine(ArrayList<Cine> cinemas) {// Creamos los hoteles y los guardamos en el ArrayList
		String name = "";
		int floors = 0, area = 0, capacity = 0, price = 0, position = 0;
		name = JOptionPane.showInputDialog("Nombre del cine");
		position = findCine(cinemas, name);
		if (position == -1) {
			floors = Integer.parseInt(JOptionPane.showInputDialog("Número de plantas del cine"));
			area = Integer.parseInt(JOptionPane.showInputDialog("Superficie en metros cuadrados del cine"));
			capacity = Integer.parseInt(JOptionPane.showInputDialog("Aforo total del cine"));
			price = Integer.parseInt(JOptionPane.showInputDialog("Precio de las entradas"));
			cinemas.add(new Cine(name, floors, area, capacity, price));
			JOptionPane.showMessageDialog(null, "El cine " + name + " ha sido creado correctamente");
		} else {
			JOptionPane.showMessageDialog(null,
					"El cine " + name + " ya está en la aplicación, no puede volver a crearlo");
		}
	}

	public static void seeHospital(ArrayList<Hospital> hospitals) {
		String name = "", message = "";
		int patients = 0, position = 0;
		name = JOptionPane.showInputDialog("Nombre del hospital");
		position = findHospital(hospitals, name);
		if (position != -1) {
			patients = Integer.parseInt(JOptionPane.showInputDialog("Número de pacientes actual"));
			if (hospitals.get(position).getBeds() < patients) {
				JOptionPane.showMessageDialog(null,
						"Ahora mismo hay más pacientes que camas, esto provoca algunas incomodidades");
				hospitals.get(position).setPatients(patients);
				message = hospitals.get(position).toString();
				JOptionPane.showMessageDialog(null, message);
			} else {
				hospitals.get(position).setPatients(patients);
				message = hospitals.get(position).toString();
				JOptionPane.showMessageDialog(null, message);
			}
		} else {
			JOptionPane.showMessageDialog(null, "El hospital " + name + " no existe, vaya al menú principal a crearlo");
		}
	}

	public static void seeHotel(ArrayList<Hotel> hotels) {
		String name = "", message = "";
		int position = 0;
		name = JOptionPane.showInputDialog("Nombre del hotel");
		position = findHotel(hotels, name);
		if (position != -1) {
			message = hotels.get(position).toString();
			JOptionPane.showMessageDialog(null, message);
		} else {
			JOptionPane.showMessageDialog(null, "El hotel " + name + " no existe, vaya al menú principal a crearlo");
		}
	}

	public static void seeCine(ArrayList<Cine> cinemas) {
		String name = "", message = "";
		int attendees = 0, position = 0;
		boolean audience = false;
		name = JOptionPane.showInputDialog("Nombre del cine");
		position = findCine(cinemas, name);
		if (position != -1) {
			do {
				attendees = Integer.parseInt(JOptionPane.showInputDialog("Número de asistentes al cine hoy"));
				if (cinemas.get(position).getCapacity() < attendees) {
					JOptionPane.showMessageDialog(null, "El número de espectadores no puede ser mayor que el aforo "
							+ "el cual es de " + cinemas.get(position).getCapacity() + " personas");
				} else {
					cinemas.get(position).screenSession(attendees, cinemas.get(position).getPrice());
					audience = true;
					message = cinemas.get(position).toString();
					JOptionPane.showMessageDialog(null, message
							+ cinemas.get(position).screenSession(attendees, cinemas.get(position).getPrice()) + " €.");
				}
			} while (!audience);
		} else {
			JOptionPane.showMessageDialog(null, "El cine " + name + " no existe, vaya al menú principal a crearlo");
		}
	}

	public static void removeHospital(ArrayList<Hospital> hospitals) {
		String name = "";
		int position = 0;
		name = JOptionPane.showInputDialog("Nombre del hotel");
		position = findHospital(hospitals, name);
		if (position != -1) {
			hospitals.remove(position);
			JOptionPane.showMessageDialog(null, "El hospital " + name + " ha sido eliminado de la aplición");
		} else {
			JOptionPane.showMessageDialog(null,
					"El hospital " + name + " no está en la aplicación, no hace falta borrarlo");
		}
	}

	public static void removeHotel(ArrayList<Hotel> hotels) {
		String name = "";
		int position = 0;
		name = JOptionPane.showInputDialog("Nombre del hotel");
		position = findHotel(hotels, name);
		if (position != -1) {
			hotels.remove(position);
			JOptionPane.showMessageDialog(null, "El hotel " + name + " ha sido eliminado de la aplición");
		} else {
			JOptionPane.showMessageDialog(null,
					"El hotel " + name + " no está en la aplicación, no hace falta borrarlo");
		}
	}

	public static void removeCine(ArrayList<Cine> cinemas) {
		String name = "";
		int position = 0;
		name = JOptionPane.showInputDialog("Nombre del hotel");
		position = findCine(cinemas, name);
		if (position != -1) {
			cinemas.remove(position);
			JOptionPane.showMessageDialog(null, "El cine " + name + " ha sido eliminado de la aplición");
		} else {
			JOptionPane.showMessageDialog(null,
					"El cine " + name + " no está en la aplicación, no hace falta borrarlo");
		}
	}

	public static int findHospital(ArrayList<Hospital> hospitals, String check) {
		boolean toLook = false;
		int position = -1;
		int i = 0;
		int turn = hospitals.size();
		while (i < turn && !toLook) {
			if (check.equalsIgnoreCase(hospitals.get(i).getName())) {
				position = i;
				toLook = true;
			}
			i++;
		}
		return position;
	}

	public static int findHotel(ArrayList<Hotel> hotels, String check) {

		boolean toLook = false;
		int position = -1;
		int i = 0;
		int turn = hotels.size();
		while (i < turn && !toLook) {
			if (check.equalsIgnoreCase(hotels.get(i).getName())) {
				position = i;
				toLook = true;
			}
			i++;
		}
		return position;
	}

	public static int findCine(ArrayList<Cine> cinemas, String check) {

		boolean toLook = false;
		int position = -1;
		int i = 0;
		int turn = cinemas.size();
		while (i < turn && !toLook) {
			if (check.equalsIgnoreCase(cinemas.get(i).getName())) {
				position = i;
				toLook = true;
			}
			i++;
		}
		return position;
	}

}