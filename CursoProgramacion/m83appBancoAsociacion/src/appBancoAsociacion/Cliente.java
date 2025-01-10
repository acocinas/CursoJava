package appBancoAsociacion;

import java.util.ArrayList;

public class Cliente {
	//Atributos de cliente y el ArrayList de las cuentas asociadas
	private String  dni = "", name = "", surname = "";
	ArrayList <Cuenta> accounts = new ArrayList<Cuenta>();
	
	//Constructor de cliente
	public Cliente(String dni, String name, String surname) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
	}
//getter para leer información
	public String getDni() {
		return dni;
	}
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	public ArrayList<Cuenta> getAccounts(){
		return accounts;
	}
//setter para modificar información
	public void setDni(String dni) {
		this.dni = dni;
	}	
	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	//método para sumar cuentas en el ArrayList
	public void addAccount(Integer accountNumber) {//usamos el constructor de Cuenta 
		Cuenta newAccount = new Cuenta (accountNumber);
		accounts.add(newAccount);
	}

	@Override
	public String toString() {
		String message = "";
		message = " Cliente " + dni + ", " + name +" "+ surname+ " ";
		return message;
	}


}
