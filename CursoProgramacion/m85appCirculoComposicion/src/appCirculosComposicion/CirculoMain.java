package appCirculosComposicion;

import java.util.Scanner;

public class CirculoMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double coordX = 0, coordY = 0, radius = 0;

		System.out.println("Ingresa los valores del primer círculo: \n" + "Valor de la coordenada X:");
		coordX = sc.nextDouble();
		System.out.println("Valor de la coordenada Y");
		coordY = sc.nextDouble();
		System.out.println("Tamaño del radio");
		radius = sc.nextDouble();

		Circulo circulo1 = new Circulo(new Punto(coordX, coordY), radius);
		System.out.println("Circulo1 " + circulo1);

		System.out.println("Ingresa los valores del segundo círculo: \n" + "Valor de la coordenada X:");
		coordX = sc.nextDouble();
		System.out.println("Valor de la coordenada Y");
		coordY = sc.nextDouble();
		System.out.println("Tamaño del radio");
		radius = sc.nextDouble();

		Circulo circulo2 = new Circulo(new Punto(coordX, coordY), radius);
		System.out.println("Circulo2 " + circulo2 + "\n");

		System.out.println("La distancia entre los centros es de " + circulo1.centerDistance(circulo2));
		System.out.println("Los circulos " + ((circulo1.concentric(circulo2)) ? "si" : "no") + " son concentricos");
		System.out
				.println("Los circulos " + ((circulo1.equalRadius(circulo2)) ? "si" : "no") + " tienen el mismo radio");
		System.out.println("Los circulos " + ((circulo1.equals(circulo2)) ? "si" : "no") + " son iguales");
		System.out.println("Los circulos " + ((circulo1.tangents(circulo2)) ? "si" : "no") + " son tangentes");
		System.out.println("Los circulos " + ((circulo1.secants(circulo2)) ? "si" : "no") + " son secantes");
		System.out.println("Los circulos " + ((circulo1.touch(circulo2)) ? "si" : "no") + " se tocan");
		sc.close();
	}

}
