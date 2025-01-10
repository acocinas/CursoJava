package appHoteles;

public class Hotel {
	// atributos
	private String name;
	private int rooms = 0, floors = 0, area = 0;

//constructor
	public Hotel(String name, int rooms, int floors, int area) {
		this.name = name;
		this.rooms = rooms;
		this.floors = floors;
		this.area = area;
	}

//getters
	public String getName() {
		return name;
	}

	public int getRooms() {
		return rooms;
	}

	public int getFloors() {
		return floors;
	}

	public int getArea() {
		return area;
	}

//setters
	public void setName(String name) {
		this.name = name;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public void setArea(int area) {
		this.area = area;
	}

//	método específico de clase 
	public String maintenance(int numberRooms) {
		String totalMaintenance = "";
		int workers = 0, costMaintenance = 0;
		workers = (int) Math.ceil(this.rooms / 20.0);//si no se pone el .0 al 20 no redondea al alza cuando hay menos de 20 habitaciones
		costMaintenance = workers * 1500;
		totalMaintenance = "Se necesitan " + workers
				+ " personas para llevar a cabo el mantenimiento total del hotel, y tiene un coste" + " de " + costMaintenance
				+ " €.";
		return totalMaintenance;
	}
	
	@Override
	public String toString() {
		String message = "";
		message = "		El Hotel " + name + "\n	dispone de " + rooms + " habitaciones \n	 repartidas en " + floors
				+ " plantas\n	 con un area de " + area
				+ " metros cuadrados\n	 todos destinados para su disfrute y descanso";
		return message;
	}
}