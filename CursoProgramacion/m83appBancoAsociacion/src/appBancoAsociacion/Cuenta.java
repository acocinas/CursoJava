package appBancoAsociacion;

public class Cuenta {
	// Atributos de la cuenta
	private double  balance = 0;
	private int accountNumber = 0;

	// constructor de la cuenta, con el saldo inicial en 0
	public Cuenta(Integer accountNumber) {// , Integer balance, Cliente customer) {
		this.accountNumber = accountNumber;
		this.balance = 0;
	}

//getter para ver lo que necesitamos
	public Integer getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

//setter para modificar los datos
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// método para poder ingresar dinero
	public double deposit(double amount) {

		balance = balance + amount;

		return balance;
	}

	// método para poder retirar dinero
	public double withdraw(double amount) {
		double result = balance - amount;
		if(result >= 0) {
		balance = result;
		}
		return result;
	}

}
