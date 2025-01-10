package appBancoAsociacion;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class CrudBanco {
//creamos cliente, primero comprobamos con el método find que no esté ya en la aplicación. 
	public static void createCustomer(ArrayList<Cliente> customers) {
		String dni = "", name = "", surname = "";
		int position = 0;
		dni = JOptionPane.showInputDialog("Introduzca su DNI");
		position = findCustomer(customers, dni);
		if (position == -1) {
			name = JOptionPane.showInputDialog("Introduzca su nombre");
			surname = JOptionPane.showInputDialog("Introduzca su apellido");
			customers.add(new Cliente(dni, name, surname));
			JOptionPane.showMessageDialog(null, customers.get(position)+ " añadido correctamente");
		} else {
			JOptionPane.showMessageDialog(null,
					"El cliente " + customers.get(position) + " ya está en la aplicación, no puede volver a crearlo");
		}
	}

//este método, buscamos al cliente, y si lo encuentra lo elimina.
	public static void removeCustomer(ArrayList<Cliente> customers) {
		String dni = "";
		int position = 0;
		dni = JOptionPane.showInputDialog("Introduzca su DNI");
		position = findCustomer(customers, dni);
		if (position != -1) {
			customers.remove(position);
			JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "El cliente no está en la aplicación");
		}

	}

//en este método primero comprobamos que exista el cliente, si existe, comprobamos que no exista la cuenta introducida asignada ya al cliente, si no está se crea.
	public static void createAccount(ArrayList<Cliente> customers) {
		String dni = "";
		int position = 0, accountNumber = 0, accountPosition = 0;
		Cliente customer;
		dni = JOptionPane.showInputDialog("Introduzca su DNI");
		position = findCustomer(customers, dni);
		if (position != -1) {
			customer = customers.get(position);
			accountNumber = Integer
					.parseInt(JOptionPane.showInputDialog("Introduzca nuevo número de cuenta"));
			accountPosition = findDuplicateAccount(customers, accountNumber);
			if (accountPosition == -1) {
				customer.addAccount(accountNumber);
				JOptionPane.showMessageDialog(null,
						"Cuenta añadida correctamente" + customers.get(position) + "cuenta" + accountNumber);
			} else {
				JOptionPane.showMessageDialog(null, "La cuenta ya existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Primero debe crear el cliente, y luego la cuenta");
		}
	}

//en este método comprobamos que el cliente existe, luego que la cuenta le pertenece, y si es así puede hacer el depósito
	public static void depositAccount(ArrayList<Cliente> customers) {
		String dni = "";
		int accountNumber = 0, position = 0, amount = 0, accountPosition = 0;
		Cliente customer;
		Cuenta account;
		dni = JOptionPane.showInputDialog("Introduzca su DNI");
		position = findCustomer(customers, dni);
		if (position != -1) {
			customer = customers.get(position);
			accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cuenta donde ingresar"));
			accountPosition = findAccount(customer.getAccounts(), accountNumber);
			if (accountPosition != -1) {
				account = customer.getAccounts().get(accountPosition);
				amount = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad a ingresar:"));
				account.deposit(amount);
				JOptionPane.showMessageDialog(null, "El deposito de " + amount
						+ " € se ha realizado correctamente y el saldo actual es  " + account.getBalance() + " €");
			} else {
				JOptionPane.showMessageDialog(null, "Cuenta no encontrada para el cliente con dni " + dni);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Cliente con dni " + dni + " no ha está en la aplicación");
		}
	}

	// en este método comprobamos que el cliente existe, luego que la cuenta le
	// pertenece, y si es así puede hacer el retiro, si la cantidad es menos que el
	// balance de la cuenta
	public static void withdrawAccount(ArrayList<Cliente> customers) {
		String dni = "";
		int accountNumber = 0, position = 0, amount = 0, accountPosition = 0;
		double newBalance = 0;
		Cliente customer;
		Cuenta account;
		dni = JOptionPane.showInputDialog("Introduzca su DNI");
		position = findCustomer(customers, dni);
		if (position != -1) {
			customer = customers.get(position);
			accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cuenta donde retirar"));
			accountPosition = findAccount(customer.getAccounts(), accountNumber);
			if (position != -1) {
				account = customer.getAccounts().get(accountPosition);
				amount = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad a retirar:"));
				newBalance = account.withdraw(amount);
				if (newBalance >= 0) {
					JOptionPane.showMessageDialog(null, "La retirada de " + amount
							+ " € se ha realizado correctamente y el saldo actual es  " + account.getBalance() + " €");
				} else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente ");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Cuenta no encontrada para el cliente con dni " + dni);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Cliente con dni " + dni + " no ha está en la aplicación");

		}
	}

	// find para controlar los clientes
	public static int findCustomer(ArrayList<Cliente> customers, String check) {
		boolean toLook = false;
		int position = -1;
		int i = 0;
		int turn = customers.size();
		while (i < turn && !toLook) {
			if (check.equalsIgnoreCase(customers.get(i).getDni())) {
				position = i;
				toLook = true;
			}
			i++;
		}
		return position;
	}

	// segundo find para controlar las cuentas duplicadas
	public static int findDuplicateAccount(ArrayList<Cliente> customers, int check) {
		boolean toLook = false;
		int position = -1;
		int i = 0, j = 0;
		int checkClient = customers.size(), checkAccount;
		Cliente currentCustomer;

		while (i < checkClient && !toLook) {
			currentCustomer = customers.get(i);
			checkAccount = currentCustomer.getAccounts().size();
			j = 0;
			while (j < checkAccount && !toLook) {
				if (check == currentCustomer.getAccounts().get(j).getAccountNumber()) {
					position = j;
					toLook = true;
				}
				j++;
			}
			i++;
		}
		return position;
	}

	// tercer find para trabajar sobre las cuentas y usar los métodos deposit y
	// withdraw
	public static int findAccount(ArrayList<Cuenta> accounts, int check) {
		boolean toLook = false;
		int position = -1;
		int i = 0;
		int turn = accounts.size();
		while (i < turn && !toLook) {
			if (check == accounts.get(i).getAccountNumber()) {
				position = i;
				toLook = true;
			}
			i++;
		}
		return position;
	}

//creamos unos clientes de prueba
	public static void loadClientes(ArrayList<Cliente> customers) {
		Cliente cliente1 = new Cliente("0001", "Alfonso", "Cocinas");
		Cliente cliente2 = new Cliente("0002", "Marta", "San Millán");
		Cliente cliente3 = new Cliente("0003", "Gonzalo", "Ferrero");
		Cliente cliente4 = new Cliente("0004", "Gala", "Ferrero");
		Collections.addAll(customers, cliente1, cliente2, cliente3, cliente4);
	}

}
