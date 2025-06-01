/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s2_grupo12;

/**
 * Subclase CuentaAhorro de Cuentas
 * 
 * @author jennifer y guiselle
 */

public class CuentaAhorro extends Cuentas {

    // Constructor
    public CuentaAhorro(String numeroCuenta) {
        super(numeroCuenta);
    }

    // Métodos heredados de la clase abstracta
    @Override
    public void depositar(int monto) {
        saldoCuenta += monto;
        System.out.println("¡Depósito realizado con éxito en su Cuenta de Ahorro!");
        System.out.println("Su saldo actual es $" + saldoCuenta + " pesos.");
    }

    @Override
    public void girar(int monto) {
        saldoCuenta -= monto;
        System.out.println("¡Giro realizado con éxito en su Cuenta de Ahorro!");
        System.out.println("Su saldo actual es $" + saldoCuenta + " pesos.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("El saldo actual en su Cuenta de Ahorro es de $" + saldoCuenta + " pesos.");
    }

}
