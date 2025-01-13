package appOrdenadores;

public class Ordenador {
	//atributos
	private String brand, model, processor;
	private int ram, hardDisc;
//Constructores, primero solo con los dos datos, y luego con todos los datos
public Ordenador(String brand, String model) {
	this.brand = brand;
	this.model = model;
	this.processor = "unknown";
}
public Ordenador(String brand, String model, String processor, int ram, int hardDisc) {
	this.brand = brand;
	this.model = model;
	this.processor = processor;
	this.ram = ram;
	this.hardDisc = hardDisc;
	
}
//creamos los getter para consulta
public String getBrand() {
	String brandStr = "Marca: "+ brand + " ; ";
	return brandStr;
}
public String getModel() {
	String modelStr = " Modelo: "+ model + " ; ";
	return modelStr;
}
public String getProcessor() {
	String processorStr = "Procesador "+ processor + " ; ";
	return processorStr;
}
public String getRam() {
	String ramGb = ram + " GB de RAM; ";
	return ramGb;
}
public String getHardDisc() {
	String hardDiscGb = hardDisc + " TB de almacenamiento.";
	return hardDiscGb;
}
//creamos los setter para modificar

public void setProcessor(String processor) {
	this.processor = processor;
}
public void setRam(int ram) {
	this.ram = ram;
}
public void setHardDisc(int hardDisc) {
	this.hardDisc = hardDisc;
}
//creamos métodos de la clase
public static String programRun(String programName) {
	String message = "Se está ejecutando " + programName;
	return message;
}
@Override //generamos el toString para printar el objeto
public String toString() {
	String message = "Este ordenador es: \n";
	message += "marca: " + this.brand + " ; modelo: " + this.model + " ; procesador: "+ this.processor +" ; Memoria RAM: "+ this.ram +"GB ; Disco Duro de "+ this.hardDisc + " TB\n";
	return message;
}


}
