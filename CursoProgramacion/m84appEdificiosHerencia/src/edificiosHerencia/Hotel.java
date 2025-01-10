package edificiosHerencia;

public class Hotel extends Edificio {
	private int rooms = 0;

	public Hotel(String name, int floors, int area, int rooms) {
		super(name, floors, area);
		this.rooms = rooms;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public double costSecurityHotel() {
		int guards = (int) Math.ceil(this.area / 1000.0);
		double cost = guards * (1300 + 500);
		return cost;
	}

	public String roomService(int rooms) {
		String costService = "";
		int people = 0, salaries = 0;
		people = (int) Math.ceil(this.rooms / 20.0);
		salaries = people * 1000;
		costService = "\nPara las " + rooms + " habitaciones que tiene, se necesitan " + people
				+ " personas para el servicio de habitaciones y el coste es de " + salaries + " €.";
		return costService;
	}

	@Override
	public String toString() {
		String message = "";
		message = "El Hotel " + super.toString() + roomService(rooms) + "\n Tiene un coste de seguridad de "
				+ costSecurityHotel() + " € debido a su dimensión.";
		return message;
	}

}
