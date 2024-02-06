package sieteymedia;

import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia {
    Baraja baraja;
    public Carta[] cartasJugador;
    Carta[] cartasBanca;
    
    InterfaceConsola InterfaceConsola = new InterfaceConsola();

    public SieteYMedia() {
        baraja = new Baraja();
        baraja.barajar();
        // se van pidiendo cartas al jugar pero matemáticamente a partir de 15 siempre
        // nos pasamos
        // hay 12 cartas de medio puntos, si sacara estas 12 luego cartas con valor 1
        // vemos que a partir de 15 cartas siempre se pasas
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
        InterfaceConsola.presentarJuego();
        jugar();
    }





    void jugar() {
        turnoJugador();
        turnoBanca();
        InterfaceConsola.fin();
    }

    void turnoJugador() {
        char opc = 'C';
        double valor = valorCartas(cartasJugador);
        // obligamos a que como mínimo se tenga 1 carta
        InterfaceConsola.interfacejugador("minimo 1 carta",valor);
        while (valorCartas(cartasJugador) < 7.5 && opc == 'C') {
            Carta c = baraja.darCartas(1)[0];
            // insertamos c en las cartas del jugador
            insertarCartaEnArray(cartasJugador, c);
            // mostramos cartas y su valor, si se pasa se sale del bucle
            InterfaceConsola.interfacejugador("tus cartas",valor);
            InterfaceConsola.mostrarCartas(cartasJugador);
            valor = valorCartas(cartasJugador);
            InterfaceConsola.interfacejugador("valor cartas",valor);
            if (valor < 7.5) {
                // suponemos que el usuario teclea bien !!!
                InterfaceConsola.interfacejugador("C o P",valor);
                opc = InterfaceConsola.interfacejugador("lectura caracter",valor);
            }

        }

    }

    void turnoBanca() {
        // lo primero es consultar el valor que alcanzó el jugador en su turno
        double valorCartasJugador = valorCartas(cartasJugador);
        if (valorCartasJugador > 7.5) {
            InterfaceConsola.interfacebanca("mas de 7.5",0);
            return;
        }
        InterfaceConsola.interfacebanca("turno banca",0);

        // juega hasta empatar o superar
        while (valorCartas(cartasBanca) < valorCartasJugador) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }

        InterfaceConsola.interfacebanca("cartas banca",0);
        InterfaceConsola.mostrarCartas(cartasBanca);
        InterfaceConsola.interfacebanca("valor banca",valorCartas(cartasBanca));
        if (valorCartas(cartasBanca) > 7.5) {
            InterfaceConsola.interfacebanca("perdedor",0);
        } else {
            InterfaceConsola.interfacebanca("ganador",0);
        }
    }

    double valorCartas(Carta[] cartas) {
        double total = 0.0;
        int val;
        int i = 0;
        while (cartas[i] != null) {
            val = cartas[i].getNumero();
            total += (val > 7) ? 0.5 : val;
            i++;
        }

        return total;
    }

    void insertarCartaEnArray(Carta[] cartas, Carta c) {
        // inserta al final detectando el primer null
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;

    }

}
