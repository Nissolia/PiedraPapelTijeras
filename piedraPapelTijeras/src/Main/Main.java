package Main;

import java.util.Scanner;

/**
 * Este es un juego simple de piedra, papel o tijeras en Java. Creado por Noelia
 * Baños.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al juego de Piedra, Papel o Tijeras!");

        while (true) {
            System.out.println("Por favor, elige una opción: piedra, papel, tijeras o salir para terminar el juego.");
            String jugador = scanner.nextLine().toLowerCase(); // La opción elegida por el jugador

            if (jugador.equals("salir")) {
                System.out.println("Gracias por jugar. ¡Hasta la próxima!");
                break;
            }

            // Validación de la opción del jugador
            if (!jugador.equals("piedra") && !jugador.equals("papel") && !jugador.equals("tijeras")) {
                System.out.println("Opción inválida. Por favor, elige entre piedra, papel, tijeras o salir.");
                continue;
            }

            String computadora = PiedraPapelTijeras.generarJugadaComputadora(); // Genera la jugada de la computadora
            System.out.println("La computadora eligió: " + computadora);

            int resultado = PiedraPapelTijeras.jugar(jugador, computadora); // Obtiene el resultado del juego

            // Imprime el resultado del juego
            if (resultado == 0) {
                System.out.println("Es un empate!");
            } else if (resultado == 1) {
                System.out.println("¡Felicidades! ¡Has ganado!");
            } else {
                System.out.println("Lo siento, la computadora gana esta vez.");
            }
        }
        scanner.close();
    }
}

/**
 * Clase PiedraPapelTijeras que contiene las funciones del juego.
 */
class PiedraPapelTijeras {

    /**
     * Esta función representa la lógica principal del juego.
     * 
     * @param jugador     La opción elegida por el jugador.
     * @param computadora La opción generada por la computadora.
     * @return El resultado del juego (0 si es empate, 1 si gana el jugador, -1 si
     *         gana la computadora).
     */
    public static int jugar(String jugador, String computadora) {
        // Comprobamos si hay un empate
        if (jugador.equals(computadora)) {
            return 0;
        }
        // Lógica para determinar el ganador
        if ((jugador.equals("piedra") && computadora.equals("tijeras"))
                || (jugador.equals("papel") && computadora.equals("piedra"))
                || (jugador.equals("tijeras") && computadora.equals("papel"))) {
            return 1; // Jugador gana
        } else {
            return -1; // Computadora gana
        }
    }

    /**
     * Esta función genera la jugada de la computadora.
     * 
     * @return La jugada de la computadora.
     */
    public static String generarJugadaComputadora() {
        int randomNum = (int) (Math.random() * 3); // Genera un número aleatorio entre 0 y 2
        // Asigna una jugada según el número aleatorio generado
        switch (randomNum) {
            case 0:
                return "piedra";
            case 1:
                return "papel";
            default:
                return "tijeras";
        }
    }
}
