/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp1_s2_grupo12;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Proyecto Gestion de cuentas Bank Boston
 * 
 * @author jennifer y guiselle
 */

public class Exp1_S2_Grupo12 {

    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡BIENVENID@ A BANK BOSTON!");

        int opcion;

        do {
            opcion = mostrarMenu(scanner);
            switch (opcion) {
                case 0:
                    System.out.println("\n\n==================== SALIR =====================");
                    System.out.println("Saliendo...\n¡Muchas gracias por su visita!");
                    System.exit(0);
                    break;
                case 1:
                    registrarCliente(scanner);
                    break;
                case 2:
                    verDatosCliente(scanner);
                    break;
                case 3:
                    depositar(scanner);
                    break;
                case 4:
                    girar(scanner);
                    break;
                case 5:
                    consultarSaldo(scanner);
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    static int mostrarMenu(Scanner scanner) {
        System.out.println("\n\n===================== MENÚ =====================");
        System.out.println("(1) Registrar cliente");
        System.out.println("(2) Ver datos cliente");
        System.out.println("(3) Depositar");
        System.out.println("(4) Girar");
        System.out.println("(5) Consultar saldo");
        System.out.println("(0) Salir");

        final int CANT_OPCIONES = 6;
        int opcion = 0;
        boolean opcionValida = false;
        String mensajeError = "La opción ingresada no es válida.\nRecuerde ingresar un número de 0 a "
                + (CANT_OPCIONES - 1);

        while (!opcionValida) {
            System.out.print("\nIngrese el número correspondiente a su opción: ");
            try {
                String input = scanner.nextLine().trim();
                opcion = Integer.parseInt(input);
                if (opcion >= 0 && opcion < CANT_OPCIONES) {
                    opcionValida = true;
                } else {
                    System.out.println(mensajeError);
                }
            } catch (NumberFormatException e) {
                System.out.println(mensajeError);
            }
        }

        return opcion;
    }

    static void registrarCliente(Scanner scanner) {
        System.out.println("\n\n=============== REGISTRAR CLIENTE ==============");
        System.out.println("¿Qué tipo de cuenta desea registrar?");
        System.out.println("(1) Cuenta Corriente");
        System.out.println("(2) Cuenta de Ahorro");
        System.out.println("(3) Cuenta de Crédito");

        final int CANT_OPCIONES = 3;
        int opcion = 0;
        boolean opcionValida = false;
        String mensajeError = "La opción ingresada no es válida.\nRecuerde ingresar un número de 1 a " + CANT_OPCIONES;

        while (!opcionValida) {
            System.out.print("\nIngrese el número correspondiente a su opción: ");
            try {
                String input = scanner.nextLine().trim();
                opcion = Integer.parseInt(input);
                if (opcion > 0 && opcion <= CANT_OPCIONES) {
                    opcionValida = true;
                } else {
                    System.out.println(mensajeError);
                }
            } catch (NumberFormatException e) {
                System.out.println(mensajeError);
            }
        }

        System.out.println("\nPara registrarse deberá ingresar los siguientes datos:");

        String rut = "";
        String nombre;
        String apellidoPaterno;
        String apellidoMaterno;
        String domicilio;
        String comuna;
        String telefono = "";
        String numeroCuenta = "";
        boolean datoValido = false;

        // Rut
        mensajeError = "El Rut ingresado no es válido. Intente nuevamente.";
        while (!datoValido) {
            System.out.print("\n-> Rut (ej: 12.345.678-9): ");
            try {
                rut = scanner.nextLine().trim();
                if (rut.length() >= 11 && rut.length() <= 12) {

                    for (Cliente cliente : clientes) {
                        if (cliente.getRut().equals(rut)) {
                            System.out.println("Ya existe un cliente registrado con el Rut " + rut + ".");
                            System.out.println("Ahora regresará al menú.");
                            return;
                        }
                    }
                    datoValido = true;
                } else {
                    System.out.println(mensajeError);
                }
            } catch (Exception e) {
                System.out.println(mensajeError);
            }
        }

        // Nombre
        System.out.print("\n-> Nombre: ");
        nombre = scanner.nextLine().trim();

        // Apellido Paterno
        System.out.print("\n-> Apellido Paterno: ");
        apellidoPaterno = scanner.nextLine().trim();

        // Apellido Materno
        System.out.print("\n-> Apellido Materno: ");
        apellidoMaterno = scanner.nextLine().trim();

        // Domicilio
        System.out.print("\n-> Domicilio: ");
        domicilio = scanner.nextLine().trim();

        // Comuna
        System.out.print("\n-> Comuna: ");
        comuna = scanner.nextLine().trim();

        // Telefono
        datoValido = false;
        mensajeError = "El Número de Teléfono ingresado no es válido. Intente nuevamente.";
        while (!datoValido) {
            System.out.print("\n-> Teléfono (ej: 123456789): ");
            try {
                telefono = scanner.nextLine().trim();
                if (telefono.length() == 9 && telefono.matches("\\d+")) {
                    datoValido = true;
                } else {
                    System.out.println(mensajeError);
                }
            } catch (Exception e) {
                System.out.println(mensajeError);
            }
        }

        // Número de cuenta
        datoValido = false;
        mensajeError = "El Número de Cuenta ingresado no es válido. Intente nuevamente.";
        while (!datoValido) {
            System.out.print("\n-> Número de cuenta (ej: 123456789): ");
            try {
                numeroCuenta = scanner.nextLine().trim();
                if (numeroCuenta.length() == 9 && numeroCuenta.matches("\\d+")) {
                    boolean cuentaExiste = false;
                    for (Cliente cliente : clientes) {
                        if (cliente.getCuenta().getNumeroCuenta().equals(numeroCuenta)) {
                            System.out.println("Ya existe una cuenta con el número " + numeroCuenta + ".");
                            cuentaExiste = true;
                            break;
                        }
                    }
                    if (!cuentaExiste) {
                        datoValido = true;
                    }
                } else {
                    System.out.println(mensajeError);
                }
            } catch (Exception e) {
                System.out.println(mensajeError);
            }
        }

        Cuentas cuenta = null;
        switch (opcion) {
            case 1:
                cuenta = new CuentaCorriente(numeroCuenta);
                break;
            case 2:
                cuenta = new CuentaAhorro(numeroCuenta);
                break;
            case 3:
                cuenta = new CuentaCredito(numeroCuenta);
                break;
        }

        Cliente cliente = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono,
                cuenta);
        clientes.add(cliente);
        System.out.println("\n¡Cliente registrado con éxito!");
    }

    static Cliente buscarCliente(Scanner scanner) {
        String rut;
        boolean rutValido = false;
        String mensajeError = "El Rut ingresado no es válido. Intente nuevamente.";

        while (!rutValido) {
            System.out.print("\nIngrese su Rut (ej: 12.345.678-9): ");
            try {
                rut = scanner.nextLine().trim();
                if (rut.length() >= 11 && rut.length() <= 12) {
                    for (Cliente cliente : clientes) {
                        if (cliente.getRut().equals(rut)) {
                            return cliente;
                        }
                    }
                    System.out.println("No se encontró cliente con el Rut: " + rut);
                    return null;
                } else {
                    System.out.println(mensajeError);
                }
            } catch (Exception e) {
                System.out.println(mensajeError);
            }
        }
        return null;
    }

    static void verDatosCliente(Scanner scanner) {
        System.out.println("\n\n=============== VER DATOS CLIENTE ==============");

        if (clientes.isEmpty()) {
            System.out.println("Aún no hay clientes registrados. Volverá al menú.");
            return;
        }

        Cliente cliente = buscarCliente(scanner);
        if (cliente != null) {
            cliente.mostrarInformacion();
        } else {
            System.out.println("Cliente no encontrado.\nAhora regresará al menú.");
        }
    }

    static void depositar(Scanner scanner) {
        System.out.println("\n\n=================== DEPOSITAR ==================");

        if (clientes.isEmpty()) {
            System.out.println("Aún no hay clientes registrados. Volverá al menú.");
            return;
        }

        Cliente cliente = buscarCliente(scanner);
        if (cliente != null) {
            boolean depositoValido = false;
            int monto = 0;

            while (!depositoValido) {
                System.out.println("\nIngrese el monto que desea depositar (ej: 25000)");
                System.out.print("$ ");
                try {
                    String input = scanner.nextLine().trim();
                    monto = Integer.parseInt(input);
                    if (monto > 0) {
                        depositoValido = true;
                    } else {
                        System.out.println("No se permiten montos menores o iguales a $0. Intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("El valor ingresado no es válido. Intente nuevamente.");
                }
            }

            cliente.getCuenta().depositar(monto);
        } else {
            System.out.println("Cliente no encontrado.\nAhora regresará al menú.");
        }
    }

    static void girar(Scanner scanner) {
        System.out.println("\n\n===================== GIRAR ====================");

        if (clientes.isEmpty()) {
            System.out.println("Aún no hay clientes registrados. Volverá al menú.");
            return;
        }

        Cliente cliente = buscarCliente(scanner);
        if (cliente != null) {
            if (cliente.getCuenta().getSaldoCuenta() <= 0) {
                System.out.println("No tiene dinero en su cuenta para realizar un giro.");
                System.out.println("Regresará nuevamente al menú.");
                return;
            }

            boolean giroValido = false;
            int monto = 0;

            while (!giroValido) {
                System.out.println("\nIngrese el monto que desea girar (ej: 25000)");
                System.out.print("$ ");
                try {
                    String input = scanner.nextLine().trim();
                    monto = Integer.parseInt(input);
                    if (monto > 0 && monto <= cliente.getCuenta().getSaldoCuenta()) {
                        giroValido = true;
                    } else {
                        System.out.println("El monto debe ser mayor a $0 y menor o igual a su saldo actual ($"
                                + cliente.getCuenta().getSaldoCuenta() + ").");
                        System.out.println("Intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("El valor ingresado no es válido. Intente nuevamente.");
                }
            }

            cliente.getCuenta().girar(monto);
        } else {
            System.out.println("Cliente no encontrado.\nAhora regresará al menú.");
        }
    }

    static void consultarSaldo(Scanner scanner) {
        System.out.println("\n\n================ CONSULTAR SALDO ===============");

        if (clientes.isEmpty()) {
            System.out.println("Aún no hay clientes registrados. Volverá al menú.");
            return;
        }

        Cliente cliente = buscarCliente(scanner);
        if (cliente != null) {
            cliente.getCuenta().consultarSaldo();
        } else {
            System.out.println("Cliente no encontrado.\nAhora regresará al menú.");
        }
    }

}
