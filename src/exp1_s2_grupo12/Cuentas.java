/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s2_grupo12;

/**
 * Clase abstracta Cuentas
 * 
 * @author jennifer y guiselle
 */

public abstract class Cuentas {
    // Atributos
    private String numeroCuenta;
    protected int saldoCuenta;

    // Contructores sobrecargados
    public Cuentas() {
    }

    public Cuentas(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldoCuenta = 0;
    }

    public Cuentas(String numeroCuenta, int saldoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldoCuenta = saldoCuenta;
    }

    // Métodos Getter and Setter
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(int saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    // Métodos abstractos
    public abstract void depositar(int monto);

    public abstract void girar(int monto);

    public abstract void consultarSaldo();
}
