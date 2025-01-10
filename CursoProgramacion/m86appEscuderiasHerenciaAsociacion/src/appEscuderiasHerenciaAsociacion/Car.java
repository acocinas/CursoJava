package appEscuderiasHerenciaAsociacion;

public class Car {
	private String model = "", colour = "";
	private int power = 0, topSpeed = 0;
	private double price = 0;

	public Car(String model, int power, int topSpeed, String colour, double price) {
		this.model = model;
		this.power = power;
		this.topSpeed = topSpeed;
		this.colour = colour;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public String getColour() {
		return colour;
	}

	public int getPower() {
		return power;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public double getPrice() {
		return price;
	}

//	public void setModel(String model) {
//		this.model = model;
//	}
//
//	public void setColour(String colour) {
//		this.colour = colour;
//	}
//
//	public void setPower(int power) {
//		this.power = power;
//	}
//
//	public void setTopSpeed(int topSpeed) {
//		this.topSpeed = topSpeed;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}

	@Override
	public String toString() {
		String message = "";
		message = " el modelo " + model + ",\n tiene una potencia de " + power
				+ " CV, alcanzando una velocidad máxima de " + topSpeed + " Km/h,\ncon un nada despreciable coste de "
				+ price + " Millones de € por unidad. Este año los colores del monoplaza para competición son " + colour;
		return message;
	}

}
