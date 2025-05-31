/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s2_grupo12;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jennifer y guiselle
 */

public class CuentaAhorro extends Cuentas {
        
    //Constructor
    public CuentaAhorro(String numeroCuenta) {    
        super(numeroCuenta);
    }

    public CuentaAhorro(String numeroCuenta, int saldoCuenta) {
        super(numeroCuenta, saldoCuenta);
    }

    
    //Métodos heredados de la clase abstracta
    @Override
    public void depositar(Scanner scanner) {
        boolean depositoValido = false;
        int deposito = 0;
        
        while (!depositoValido) {
            System.out.println("\nIngrese el monto que desea depositar (ej: 25000)");
            System.out.print("$ ");
            try {
                deposito = scanner.nextInt();
                if (deposito > 0) {
                    depositoValido = true;
                } else {
                    System.out.println("No se permiten montos menores o iguales a $0. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es válido. Intente nuevamente.");
            } finally {
                scanner.nextLine();
            }
        }
        
        saldoCuenta += deposito;
        System.out.println("¡Depósito realizado con éxito!");
        System.out.println("Su saldo actual es $" + saldoCuenta + " pesos.");
    }
    
    
    @Override
    public void girar(Scanner scanner) {
        if (saldoCuenta <= 0) {
            System.out.println("No tiene dinero en su cuenta para realizar un giro.");
            System.out.println("Regresará nuevamente al menú.");
            return;
        }
        
        boolean giroValido = false;
        int giro = 0;
        
        while (!giroValido) {
            System.out.println("\nIngrese el monto que desea girar (ej: 25000)");
            System.out.print("$ ");
            try {
                giro = scanner.nextInt();
                if (giro > 0 && giro <= saldoCuenta) {
                    giroValido = true;
                } else {
                    System.out.println("El monto debe ser mayor a $0 y menor o igual a su saldo actual ($" + saldoCuenta + ").");
                    System.out.println("Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es válido. Intente nuevamente.");
            } finally {
                scanner.nextLine();
            }
        }
        
        saldoCuenta -= giro;
        System.out.println("¡Giro realizado con éxito!");
        System.out.println("Su saldo actual es $" + saldoCuenta + " pesos.");
    }
    
    
    @Override
    public void consultarSaldo() {
        System.out.println("Su saldo actual es de $" + saldoCuenta + " pesos.");
    }

}
