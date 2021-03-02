/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m09_uf2_actividad2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arsenbasha
 */
public class Sync {

    private boolean Turnodado1 = true;

    ArrayList<Integer> arrayList = new ArrayList(250);

    /**
     * mientras no tenga el turno se esperará hasta que sea su turno y
     * mostraremos el resutaldo por pantalla
     *
     * @param dado
     */
    public synchronized void recogerDado(int tirada, int dado) {

        if (Thread.currentThread().getName().equals("dado1")) {

            while (!Turnodado1) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sync.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (arrayList.size() < 250) {
                arrayList.add(dado);
                System.out.println("Numero dado 1: " + dado);
            } else {
                if (tirada < 300) {
                    for (int i = 200; i < arrayList.size(); i++) {
                        if (arrayList.get(i) % 2 != 0) {
                            int numero= (int) (Math.random() * 6 + 1);
                            arrayList.remove(i);
                            arrayList.add(i, numero);
                        }
                    }
                }
            }
            Turnodado1 = false;

        } else if (Thread.currentThread().getName().equals("dado2")) {
            while (Turnodado1) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sync.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (arrayList.size() < 250) {
                arrayList.add(dado);
                System.out.println("Numero dado 2: " + dado);
            } else {
                if (tirada < 300) {
                    for (int i = 200; i < arrayList.size(); i++) {
                        if (arrayList.get(i) % 2 != 0) {
                            int numero= (int) (Math.random() * 6 + 1);
                            arrayList.remove(i);
                            arrayList.add(i, numero);
                        }
                    }
                }
            }
            Turnodado1 = true;
        }
        int pos;
        int valor;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                valor = arrayList.get(i);
                pos = i + 1;
                for (int j = pos; j < arrayList.size(); j++) {
                    if (arrayList.get(j) == valor) {
                        arrayList.remove(i);
                        arrayList.add(i, valor + valor);
                        arrayList.remove(j);
                    }
                }
            }
        }
        notify();
    }
}
