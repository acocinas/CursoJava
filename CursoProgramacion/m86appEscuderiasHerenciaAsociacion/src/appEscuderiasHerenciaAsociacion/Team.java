package appEscuderiasHerenciaAsociacion;

import java.util.*;

public class Team {
	private String name = "", country = "";
	private double budget = 0;
	ArrayList<Mechanic> mechanics = new ArrayList<Mechanic>();
	ArrayList<Pilot> pilots = new ArrayList<Pilot>();
	ArrayList<Car> cars = new ArrayList<Car>();

	public Team(String name, String country, double budget) {
		this.name = name;
		this.country = country;
		this.budget = budget;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public double getBudget() {
		return budget;
	}

	public ArrayList<Mechanic> getMechanics() {
		return mechanics;
	}

	public ArrayList<Pilot> getPilots() {
		return pilots;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	public void setBudget(double budget) {
//		this.budget = budget;
//	}

	public void setMechanics(ArrayList<Mechanic> mechanics) {
		this.mechanics = mechanics;
	}

	public void setPilots(ArrayList<Pilot> pilots) {
		this.pilots = pilots;
	}

//	public void setCars(ArrayList<Car> cars) {
//		this.cars = cars;
//	}
	public void addPilot(String name, String surname, String dni, int age, int experienceTeam, double height,
			double weight) {
		Pilot newPilot = new Pilot(name, surname, dni, age, experienceTeam, height, weight);
		this.pilots.add(newPilot);
	}

	public void addMechanic(String name, String surname, String dni, int age, int experienceTeam, boolean studiesSup) {
		Mechanic newMechanic = new Mechanic(name, surname, dni, age, experienceTeam, studiesSup);
		this.mechanics.add(newMechanic);
	}

//	public void addCar(String model, int power, int topSpeed, String colour, double price) {
//		Car newCar = new Car(model, power, topSpeed, colour, price);
//		this.cars.add(newCar);
//	}
	public void addCars(Car cars) {
		getCars().add(cars);
	}

	public static String showTeamName(ArrayList<Team> teams) {
		int i;
		String currentName = "";
		for (i = 0; i < teams.size(); i++) {
			currentName += teams.get(i).getName() + "\n";
		}
		return currentName;
	}

	@Override
	public String toString() {
		String message = "";
		message = "La escudería " + name + ", fundada en " + country
				+ ",\nactualmente para esta temporada cuenta con un presupuesto de " + budget + " millones de €"
				+ ",\nen sus filas podemos ver como " + mechanics
				+ ",\ny cuentan con los servicios " + pilots + ", este año los monoplazas son " + cars;
		return message;
	}

	public static void loadData(ArrayList<Team> teams) {
		Team team1 = new Team("Ferrari", "Italia", 15250);
		Team team2 = new Team("Red Bull", "Austria", 15500);
		Team team3 = new Team("Mercedes", "Alemania", 15100);
		Team team4 = new Team("McLaren", "Reino Unido", 15200);
		Team team5 = new Team("Aston Martin", "Reino Unido", 14900);
		Team team6 = new Team("Alpine", "Francia", 14750);
		Collections.addAll(teams, team1, team2, team3, team4, team5, team6);
		// teams.add(new Team("Salir","",0));
		Car car1 = new Car("Ferrari 066/12", 1015, 348, " rojo ", 18.5);
		Car car2 = new Car("Ferrari 066/12+", 1019, 350, " rojo ", 19.75);
		Car car3 = new Car("Honda RBPTH002", 1019, 349, " azul oscuro y rayas amarillo claro ", 19.25);
		Car car4 = new Car("Honda RBPTH003", 1021, 351, " azul oscuro y rayas amarillo oscuro ", 20);
		Car car5 = new Car("Mercedes-AMG F1 M15", 1012, 345, " gris oscuro ", 17.95);
		Car car6 = new Car("Mercedes-AMG F1 M15+", 1014, 346, " gris claro ", 18.05);
		Car car7 = new Car("Mercedes-AMG F1 M15", 1012, 345, " naranja y negro ", 17.95);
		Car car8 = new Car("Mercedes-AMG F1 M15+", 1014, 346, " gris y gris ", 18.05);
		Car car9 = new Car("Mercedes-AMG F1 M15+", 1014, 346, " verde Oscuro ", 18.05);
		Car car10 = new Car("Mercedes-AMG F1 M15", 1012, 345, " verde Oscuro y negro ", 17.95);
		Car car11 = new Car("Renault E-Tech RE24", 1011, 347, " azul y rosa ", 18.25);
		Car car12 = new Car("Renault E-Tech RE24+", 1011, 347, " rosa y azul ", 18.25);
		// (String model, int power, int topSpeed, String colour, double price)
		team1.addCars(car1);
		team1.addCars(car2);
		team2.addCars(car3);
		team2.addCars(car4);
		team3.addCars(car5);
		team3.addCars(car6);
		team4.addCars(car7);
		team4.addCars(car8);
		team5.addCars(car9);
		team5.addCars(car10);
		team6.addCars(car11);
		team6.addCars(car12);
	}

}
