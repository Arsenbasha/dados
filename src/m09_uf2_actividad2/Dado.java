/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m09_uf2_actividad2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arsenbasha
 */
public class Dado implements Runnable {

    Sync sync;
    int cont = 0;

    /**
     * Inicializamos el constructor con el observador y iniciamos el hilo
     * "dado1"
     *
     * @param s
     */
    public Dado(Sync s) {
        this.sync = s;
    }

    /**
     * mientras la array no sea mayor a 250 dormira el hilo 1 decima cogera un
     * numero aleatorio entre 1-6 y lo añadirá a la array una vez llegue a a los
     * los 300 tiradas haremos un break para salga del while
     *
     */
    @Override
    public void run() {
        while (cont < 300) {
            try {
                Thread.sleep(100);
                int numero = (int) (Math.random() * 6 + 1);
                cont++;
                sync.recogerDado(numero);
                cont++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Dado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
