/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colecciones.arreglos;

import java.util.Scanner;

/**
 *
 * @author meschoyez
 */
public class ColeccionesArreglos {

    public static void main(String[] args) {
        int desocupadas = 0;
        boolean resultado;
        boolean[] butacas = {false, false, false};
//        boolean[] butacas = {false, true,
//            true, false, false, false, true};

        desocupadas = ContarButacasLibres(butacas);
        System.out.println("Hay" + desocupadas +
                " butacas libres");

        OcuparButaca(butacas, 0);
        desocupadas = ContarButacasLibres(butacas);
        System.out.println("Hay" + desocupadas +
                " butacas libres");
        
        OcuparButaca(butacas, 5);
        desocupadas = ContarButacasLibres(butacas);
        System.out.println("Hay" + desocupadas +
                " butacas libres");
        
        resultado = CineVacio(butacas);
        resultado = CineVacioWhile(butacas);
        resultado = CineVacioIndef(butacas);
    }

    private static int ContarButacasLibres(boolean[] butacas) {
        int desocupadas = 0;
        for (int b = 0; b < butacas.length; b++) {
            if (ButacaLibre(butacas, b)) {
                desocupadas++;
            }
        }
        return desocupadas;
    }

    private static boolean OcuparButaca(boolean[] butacas, int nro) {
        boolean libre = false;
        while (libre == false) {
            try {
                libre = ButacaLibre(butacas, nro);
                if (libre) {
                    butacas[nro] = true;
                }
            }
            catch (IllegalStateException e) {
                System.out.println("Problema 1");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("No existe la butaca " + nro);
                Scanner teclado = new Scanner(System.in);
                System.out.print("Ingrese nro butaca: ");
                nro = teclado.nextInt();            
            }
            catch (Exception e) {
                System.out.println("Error inesperado!");
            }
        }
        return libre;
    }

    private static boolean ButacaLibre(boolean[] butacas, int nro) {
        return ! butacas[nro];
    }
    
    private static boolean CineVacio(boolean[] butacas) {
        boolean vacio = true;
        for (int pos = 0; pos < butacas.length; pos++) {
//            if (butacas[pos] == true) {
            if (butacas[pos]) {
                vacio = false;
            }
        }
        return vacio;
    }

    private static boolean CineVacioWhile(boolean[] butacas) {
        boolean vacio = true;
        int pos = 0;
        while (pos < butacas.length) {
            if (butacas[pos]) {
                vacio = false;
            }
            pos++;
        }
        return vacio;
    }

    private static boolean CineVacioIndef(boolean[] butacas) {
        boolean vacio = true;
        int pos = 0;
        while (vacio && (pos < butacas.length)) {
            if (butacas[pos]) {
                vacio = false;
            }
            pos++;
        }
        return vacio;
    }


//    private static boolean CineLleno(boolean[] butacas) {
//    }

//    private static int BuscarButacaLibre(boolean[] butacas) {
 //   }
}
