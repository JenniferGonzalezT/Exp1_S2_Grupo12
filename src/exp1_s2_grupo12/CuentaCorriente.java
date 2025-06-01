/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s2_grupo12;

/**
 * Subclase CuentaCorriente de Cuentas
 * 
 * @author jennifer y guiselle
 */

public class CuentaCorriente extends Cuentas {

    // Constructor
    public CuentaCorriente(String numeroCuenta) {
        super(numeroCuenta);
    }

    // Métodos heredados de la clase abstracta
    @Override
    public void depositar(int monto) {
        saldoCuenta += monto;
        System.out.println("¡Depósito realizado con éxito en su Cuenta Corriente!");
        System.out.println("Su saldo actual es $" + saldoCuenta + " pesos.");
    }

    @Override
    public void girar(int monto) {
        saldoCuenta -= monto;
        System.out.println("¡Giro realizado con éxito desde su Cuenta Corriente!");
        System.out.println("Su saldo actual es $" + saldoCuenta + " pesos.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("El saldo actual en su Cuenta Corriente es de $" + saldoCuenta + " pesos.");
    }

}
