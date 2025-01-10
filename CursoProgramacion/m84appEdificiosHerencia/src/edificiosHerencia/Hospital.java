package edificiosHerencia;

public class Hospital extends Edificio {
	private int beds = 0, patients = 0;

	public Hospital(String name, int floors, int area, int beds, int patients) {
		super(name, floors, area);
		this.beds = beds;
		this.patients = 0;
	}

	public int getBeds() {
		return beds;
	}

	public int getPatients() {
		return patients;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public void setPatients(int patients) {
		// if(patients <= beds) {
		this.patients = patients;
//		}else {
//			this.patients = beds;
//		}
	}

	public int food(int patients) {
		// String rations = "";
		int meals = 0;
		meals = patients * 3;
		// rations = ""+ meals ;
		return meals;
	}

//	public double costSecurityHospital() {
//		int guards = (int)Math.ceil(this.area / 1000.0);
//		double cost = guards * 1300 ;
//		return cost ;
//}

	@Override
	public String toString() {
		String message = "";
		message = "El Hospital " + super.toString() + " \nTiene un total de " + beds + " camas disponibles y "
				+ "\n actualmente tiene " + patients + " pacientes a los que se les reparte un total de "
				+ food(patients) + " comidas al día.\nEste edificio tiene un coste de seguridad mensual de "
				+ costSecurity() + " €.";
		return message;
	}

}
