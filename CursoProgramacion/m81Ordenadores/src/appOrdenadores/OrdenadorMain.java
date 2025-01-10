package appOrdenadores;

import java.util.Scanner;

public class OrdenadorMain {

	public static void main(String[] args) {

		// Crear o instanciar un objeto
		String brand = "", model = "", processor = "", programRunSend = "";
		int ram = 0, hardDisc = 0;
		Scanner sc = new Scanner(System.in);
		Ordenador element1 = new Ordenador("Lenovo", "IDEAPAD", "AMD RYZEN 7000 Series", 16, 1);
		Ordenador element2 = new Ordenador("HP", "250 G10");
		System.out.println(element1.toString());
		System.out.println(element2.toString());

		Ordenador element3 = new Ordenador("HP", "250 G10 Plus");
		Ordenador element4 = new Ordenador("Lenovo", "LEGION PRO 5", "AMD RYZEN 9000 Series", 32, 2);
		System.out.println(element1.getProcessor());
		System.out.println(element2.getBrand());
		System.out.println(element3.getModel());
		System.out.println(element4.getRam());
		System.out.println(element4.getHardDisc());
		
		System.out.println("\n¿Qué programa está trabajando?");
		programRunSend = sc.nextLine();
		System.out.println(Ordenador.programRun(programRunSend));

		System.out.println("\nVolvemos a los ordenadores introduce la marca");
		brand = sc.nextLine();
		System.out.println("Introduce el modelo");
		model = sc.nextLine();
		Ordenador element5 = new Ordenador(brand, model);
		System.out.println("elemento5 "+element5.toString());
		
		System.out.println("\nIntroduce la marca");
		brand = sc.nextLine();
		System.out.println("Introduce el modelo");
		model = sc.nextLine();
		System.out.println("Introduce la procesador");
		processor = sc.nextLine();
		System.out.println("Introduce el memoria RAM en Gb");
		ram = sc.nextInt();
		System.out.println("Introduce la capacidad del disco duro en TB");
		hardDisc = sc.nextInt();
		sc.nextLine();
		Ordenador element6 = new Ordenador(brand, model, processor, ram, hardDisc);
		
		System.out.println("\nelemento1 "+element1.toString());
		element1.setProcessor("Intel Core i7");
		element2.setRam(8);
		element5.setProcessor("AMD RYZEN 5");
		element5.setRam(16);
		element5.setHardDisc(1);
		
		System.out.println("elemento1 modificado"+element1);
		System.out.println("elemento2 más la RAM añadida "+element2);
		System.out.println("elemento3 "+element3);
		System.out.println("elemento4 "+element4);
		System.out.println("elemento5 completo "+element5.toString());
		System.out.println("elemento6 "+element6.toString());
		
		sc.close();
	}

}
