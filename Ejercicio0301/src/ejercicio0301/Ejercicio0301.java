/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio0301;

import ejercicio0301.modelo.CajaAhorros;
import ejercicio0301.modelo.CajaAhorrosBasica;
import ejercicio0301.modelo.CajaAhorrosGold;
import ejercicio0301.modelo.CajaAhorrosPlatinum;
import java.util.Scanner;

/**
 *
 * @author george
 */
public class Ejercicio0301 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Opción elegida
        int opcion;
        // Scanner para manejar la entrada
        Scanner sc = new Scanner(System.in);
        // Cuentas disponibles
        CajaAhorros[] cuentas = new CajaAhorros[]{
            new CajaAhorrosBasica("200/12345-3"),
            new CajaAhorrosGold("200/32145-8"),
            new CajaAhorrosPlatinum("200/111546-5")
        };
        // Cuenta con la que se está trabajando
        CajaAhorros cuentaActual = null;
        // Menú principal
        do {

            System.out.println("Bienvenido a BanQuito, el mejor banco de Ecuador!");
            System.out.println("=================================================");

            // Mostramos las cuentas
            for (int i = 1; i <= cuentas.length; i++) {
                System.out.println(i + ") " + cuentas[i - 1]);
            }

            System.out.println("Seleccione La cuenta (0 para salir): ");
            opcion = sc.nextInt();
            // Selección de la cuenta
            int indice = opcion - 1;
            // Se quita la cuenta seleccionada actualmente
            cuentaActual = null;
            // Si se seleccionó una cuenta disponible
            if (indice >= 0 && indice < cuentas.length) {
                // La cuenta actual pasa a ser la seleccionada
                cuentaActual = cuentas[indice];
                // Paso al menú de cuenta
                menuCuenta(cuentaActual);
            }

            
        } while (opcion != 0);

    }

    private static void menuCuenta(CajaAhorros cuentaActual) {
        // Opción elegida
        int opcion;
        // Scanner para manejar la entrada
        Scanner sc = new Scanner(System.in);
        // Menú principal
        do {

            System.out.println(cuentaActual.getNroCuenta() + " - Saldo: $" + cuentaActual.getSaldo());
            System.out.println("=================================================");

            // Mostramos las opciones
            System.out.println("1) Depositar");
            System.out.println("2) Extraer");
            System.out.println("3) Comprar");
            System.out.println("Seleccione la operación (0 para volver): ");
            opcion = sc.nextInt();
            // Operación
            if (opcion >= 1 && opcion <= 3) {
                boolean exito = false;
                System.out.println("Ingrese el monto de la operación: $ ");
                float montoOperacion = sc.nextFloat();
                switch (opcion) {
                    case 1: {
                        exito = cuentaActual.depositar(montoOperacion);
                        break;
                    }
                    case 2: {
                        exito = cuentaActual.extraer(montoOperacion);
                        break;
                    }
                    case 3: {
                        exito = cuentaActual.compra(montoOperacion);
                        break;
                    }

                }
                // Si la operación fue exitosa...
                if (exito) {
                    System.out.println("Operación exitosa!");
                    System.out.println("Nuevo saldo: $" + cuentaActual.getSaldo());
                } else {
                    System.out.println("La operación no pudo ser completada...");
                }
            } else {
                System.out.println("Opción inválida...");
            }

        } while (opcion != 0);

    }

}
