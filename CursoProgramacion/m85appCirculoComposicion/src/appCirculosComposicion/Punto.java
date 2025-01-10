package appCirculosComposicion;

public class Punto {
	double positionX = 0, positionY = 0;
	
//Constructor
	public Punto(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public double getPositionX() {
		return positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	@Override
	public String toString() {
		return  "(" + positionX + "," + positionY + ")" ;
	}
	
	

}
