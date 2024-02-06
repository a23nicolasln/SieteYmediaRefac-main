package sieteymedia;

import java.util.Scanner;
import recursos.Carta;

public class InterfaceConsola {
        Scanner sc = new Scanner(System.in);

        void presentarJuego() {
                System.out.println("- El usuario es el jugador y el ordenador la  banca.");
                System.out.println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.");
                System.out.println(
                                "- las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.");
                System.out.println(
                                "- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.");
                System.out.println("- El jugador va pidiendo cartas a la banca de una en una.");
                System.out.println("- El jugador puede plantarse en cualquier momento.");
                System.out.print("- Si la suma de los valores de las cartas sacadas es superior ");
                System.out.println("a 7 y medio, el jugador 'se pasa de siete y medio' y  pierde.");
                System.out.println(
                                "- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta  está obligada a sacar cartas hasta empatar o superar al jugador.");
                System.out.println(
                                "- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.");
                System.out.println(
                                "- La banca no se puede plantar y tiene que empatar o superar la puntuación del  jugador sin pasarse.");
                System.out.println(
                                "- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.");
                System.out.println("\nEmpecemos!!!\n");
        }

        void fin() {
                System.out.println("Adios");
        }

        char interfacejugador(String instruccion, double valor) {
                switch (instruccion) {
                        case "minimo 1 carta":
                                System.out.println(
                                                "Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte");
                                break;
                        case "tus cartas":
                                System.out.println("Éstas son tus cartas jugador:");
                                break;
                        case "valor cartas":
                                System.out.println("\n\tValor de cartas: " + valor);
                                break;
                        case "C o P":
                                System.out.println("\n¿Pides [C]arta o te [P]lantas?");
                                break;
                        case "lectura caracter":
                                return sc.next().trim().toUpperCase().charAt(0);
                        default:
                                break;
                }
                return 'P';
        }

        void interfacebanca(String instruccion, double valor) {
                switch (instruccion) {
                        case "mas de 7.5":
                                System.out.println("Jugador, te has pasado en tu jugada anterior, gana la banca");
                                break;
                        case "turno banca":
                                System.out.println("\n\nTurno de banca ...");
                                break;
                        case "cartas banca":
                                System.out.println("Estas son mis cartas:");
                                break;
                        case "valor banca":
                                System.out.println("\nValor de  mis cartas(banca): " + valor);
                                break;
                        case "ganador":
                                System.out.println("Gana la banca");
                                break;
                        case "perdedor":
                                System.out.println("Me pasé, ganas tú,jugador");
                                break;

                        default:
                                break;
                }

        }

        void mostrarCartas(Carta[] cartas) {
                for (int i = 0; i < cartas.length; i++) {
                        if (cartas[i] != null) {
                                System.out.print("\t" + cartas[i].toString());
                        }
                }
                System.out.println();
        }

        public static void main(String[] args) {
                new SieteYMedia();
        }
}
