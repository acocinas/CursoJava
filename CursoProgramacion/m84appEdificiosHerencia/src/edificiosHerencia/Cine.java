package edificiosHerencia;

public class Cine extends Edificio {
	private int capacity = 0, price = 0;

	public Cine(String name, int floors, int area, int capacity, int price) {
		super(name, floors, area);
		this.capacity = capacity;
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}


	public int getPrice() {
		return price;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int screenSession(int attendees, int price) {
		//String boxOffice = "";
		int money = 0;
//		if (attendees > capacity) {
//			boxOffice = " Error, no pueden asistir tantas personas, su capacidad máxima es de " + capacity;
	//	} else {
			money = price * attendees;
	//		boxOffice =  money + " €";
	//	}
		return money;
	}

	public double costSecurityCine() {
		int guards = (int) Math.ceil(this.area / 3000.0);
		double cost = guards * 1300;
		return cost;
	}

	@Override
	public String toString() {
		String message = "";
		message = "El Cine " + super.toString() +" tiene un coste de seguridad de "+costSecurityCine()+ " €."
				+ "\nEsta sala tiene un aforo de " + capacity + " personas, un precio por entrada de " 
				+ price + " €,\ncon la asistencia registrada de hoy la recaudación ha sido de ";
		return message;
	}
	
}
