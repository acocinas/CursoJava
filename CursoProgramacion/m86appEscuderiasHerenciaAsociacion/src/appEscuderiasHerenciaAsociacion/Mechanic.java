package appEscuderiasHerenciaAsociacion;

public class Mechanic extends Worker {
	protected boolean studiesSup = false;
	
	public Mechanic(String name, String surname,String dni, int age, int experienceTeam, boolean studiesSup) {
		super(name, surname,dni, age, experienceTeam);
		this.studiesSup = studiesSup;
	}

	public boolean isStudies() {
		return studiesSup;
	}

	public void setStudies(boolean studiesSup) {
		this.studiesSup = studiesSup;
	}

	public double salaryMechanic(double salary, int experienceTeam) {
		double realSalary = 0;
		realSalary = salary + (10000*experienceTeam) ;
		return realSalary;
	}
	
	
	@Override
	public String toString() {
		String message = "";
		message = super.toString() + " años,\ndesarrolla su carrera como mecánico " + (studiesSup? "si":"no") 
				+ "tiene estudios superiores y un sueldo de " + salaryMechanic(salary, experienceTeam) + " € anuales\n.";
		return message;
	}
	

}
