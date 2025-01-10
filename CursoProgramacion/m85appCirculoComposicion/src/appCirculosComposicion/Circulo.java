package appCirculosComposicion;

public class Circulo {
	Punto center;
	double radius = 0;

	public Circulo(Punto center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public Punto getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}

	public void setCenter(Punto center) {
		this.center = center;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double centerDistance(Circulo circulo) {
		double distance = 0;
		double subtractionX2 = Math.pow(this.center.positionX - circulo.center.positionX, 2);
		double subtractionY2 = Math.pow(this.center.positionY - circulo.center.positionY, 2);
		distance = Math.sqrt(subtractionX2 + subtractionY2);
		return distance;
	}

	public boolean concentric(Circulo circulo) {
		boolean areConcentric = false;
		if (this.center.positionX == circulo.center.positionX && this.center.positionY == circulo.center.positionY) {
			areConcentric = true;
		}
		return areConcentric;
	}

	public boolean equalRadius(Circulo circulo) {
		boolean sameRadius = false;
		if (this.radius == circulo.radius) {
			sameRadius = true;
		}
		return sameRadius;
	}

	public boolean equals(Circulo circulo) {
		boolean twins = false;
		if (concentric(circulo) && equalRadius(circulo)) {
			twins = true;
		}
		return twins;
	}

	public boolean tangents(Circulo circulo) {
		boolean areTangent = false;
		if (centerDistance(circulo) == this.radius + circulo.radius) {
			areTangent = true;
		}
		return areTangent;
	}

	public boolean secants(Circulo circulo) {
		boolean areSecants = false;
		if (centerDistance(circulo) < this.radius + circulo.radius) {
			areSecants = true;
		}
		return areSecants;
	}

	public boolean touch(Circulo circulo) {
		boolean touching = false;
		if (!tangents(circulo) && !secants(circulo)) {
			touching = true;
		}
		return touching;
	}

	@Override
	public String toString() {
		return "punto " + center.toString() + " , radio " + radius ;
	}
	
}
