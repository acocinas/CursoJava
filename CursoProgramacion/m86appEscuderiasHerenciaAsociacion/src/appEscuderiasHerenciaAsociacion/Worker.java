package appEscuderiasHerenciaAsociacion;

public abstract class Worker {
	protected String name = "", surname = "", dni = "";
	protected int age = 0, experienceTeam = 0;
	protected final double salary = 50000;
	
	public Worker(String name, String surname, String dni, int age, int experienceTeam) {
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.age = age;
		this.experienceTeam = experienceTeam;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	public String getDni() {
		return dni;
	}

	public int getAge() {
		return age;
	}

	public int getExperienceTeam() {
		return experienceTeam;
	}

	public double getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	

	public void setAge(int age) {
		this.age = age;
	}

	public void setExperienceTeam(int experienceTeam) {
		this.experienceTeam = experienceTeam;
	}


	@Override
	public String toString() {
		String message = "";
		message =  name + " " + surname + ", de "
		+ age + " años, y una antigüedad en la escudería de " + experienceTeam;
		return message;
	}
}
