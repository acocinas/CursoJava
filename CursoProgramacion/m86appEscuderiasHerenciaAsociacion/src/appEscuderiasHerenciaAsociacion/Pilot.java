package appEscuderiasHerenciaAsociacion;

public class Pilot extends Worker {
	private double height = 0, weight = 0;
	
	public Pilot(String name, String surname, String dni, int age, int experienceTeam, double height, double weight) {
		super(name, surname, dni, age, experienceTeam);
		this.height = height;
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double salaryPilot(double salary, int experienceTeam) {
		double realSalary = 0;
		double risk = 50000;
		realSalary = salary + (10000 * experienceTeam) + risk;
		return realSalary;
	}
	
	@Override
	public String toString() {
		String message = "";
		message = super.toString() + " años,\ndesarrolla su carrera como piloto."
				+"Tiene una altura de "+ height +" cm, y un peso de " + weight
				+ " kg,\npercibiendo un salario de " + salaryPilot(salary, experienceTeam) + " € anuales";
		return message;
	}
	
}
