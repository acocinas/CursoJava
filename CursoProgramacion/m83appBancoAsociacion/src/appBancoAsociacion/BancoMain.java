package appBancoAsociacion;

import java.util.*;

import javax.swing.JOptionPane;

public class BancoMain {

	public static void main(String[] args) {
		String message = "", client = "";
		Object[] choice = new Object[0];
		ArrayList<Cliente> customers = new ArrayList<Cliente>();
		CrudBanco.loadClientes(customers);
		do {
			choice = new Object[] { "Salir de la aplicación", "Crear Cliente/a", "Eliminar cliente/a", "Crear cuenta",
					"Ingresar dinero en cuenta", "Retirar dinero" };
			client = Dialogo.seleccionar(choice, "Banco", "Menú", 0);
			switch (client) {
			case "Salir de la aplicación":
				message = "Gracias por su visita";
				JOptionPane.showMessageDialog(null, message);
				break;
			case "Crear Cliente/a":
				CrudBanco.createCustomer(customers);
				break;
			case "Eliminar cliente/a":
				CrudBanco.removeCustomer(customers);
				break;
			case "Crear cuenta":
				CrudBanco.createAccount(customers);
				break;
			case "Ingresar dinero en cuenta":
				CrudBanco.depositAccount(customers);
				break;
			case "Retirar dinero":
				CrudBanco.withdrawAccount(customers);
				break;
			}
		} while (!"Salir de la aplicación".equals(client));
	}

}
