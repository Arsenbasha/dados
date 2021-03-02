/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m09_uf2_actividad2;

/**
 *
 * @author arsenbasha
 */
public class M09_uf2_actividad2 {

    /**
     * @param args the command line arguments inicializamos los constructores
     * tanto de los dados como del observador
     *
     */
    public static void main(String[] args) {
        Sync sync = new Sync();
        Dado d1 = new Dado(sync);
        Dado d2 = new Dado(sync);

        Thread dado1 = new Thread(d1, "dado1");
        Thread dado2 = new Thread(d2,"dado2");
        dado1.start();
        dado2.start();
    }

}
