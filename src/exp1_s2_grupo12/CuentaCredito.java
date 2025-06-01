/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s2_grupo12;

/**
 * Subclase CuentaCredito de Cuentas
 * 
 * @author jennifer y guiselle
 */
// Limite credito
public class CuentaCredito extends Cuentas {

    // Constructor
    public CuentaCredito(String numeroCuenta) {
        super(numeroCuenta);
    }

    // Métodos heredados de la clase abstracta
    @Override
    public void depositar(int monto) {
        saldoCuenta += monto;
        System.out.println("¡Depósito realizado con éxito en su Cuenta de Crédito!");
        System.out.println("Su saldo actual es $" + saldoCuenta + " pesos.");
    }

    @Override
    public void girar(int monto) {
        saldoCuenta -= monto;
        System.out.println("¡Giro realizado con éxito desde su Cuenta de Crédito!");
        System.out.println("Su saldo actual es $" + saldoCuenta + " pesos.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("El saldo actual de su Cuenta de Crédito es de $" + saldoCuenta + " pesos.");
    }

}
