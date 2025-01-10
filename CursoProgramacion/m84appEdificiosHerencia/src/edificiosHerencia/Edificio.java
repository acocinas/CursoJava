package edificiosHerencia;

public abstract class Edificio {
	// atributos comunes para todos los hijos
	protected String name = "";
	protected int floors = 0, area = 0;

	// constructor
	public Edificio(String name, int floors, int area) {
		this.name = name;
		this.floors = floors;
		this.area = area;
	}// getter para poder leer los datos

	public String getName() {
		return name;
	}

	public int getFloors() {
		return floors;
	}

	public int getArea() {
		return area;
	}
//método del padre para todos
	public double clean() {
		double minutes = 0, extraMinutes = 0, totalCost = 0;
		minutes = this.area / 5;
		if(floors > 1) {
		extraMinutes = this.floors * 0.5f;
		}else {}
		totalCost = (minutes + extraMinutes) * 30;
		return totalCost;
	}
//
	public double costSecurity() {
		int guards = (int)Math.ceil(this.area / 1000.0);
		double cost = guards * 1300;
		return cost ;
	}
	@Override
	public String toString() {
		return  name + ", con una altura de " + floors + " pisos, y con un area de " + area
				+ " m², tiene un coste de limpieza de " + clean() + " €.";
	}

}
