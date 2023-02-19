public class Main{

    public static void main (String args[]){

        int[][] tablero = new int[10][10];

        //se genera el tablero hasta que la cantidad de pares e impares sea la misma
        do {
            tablero = Matriz.crearMatriz();
        } while (Matriz.verificarMatriz(tablero));

        Matriz.imprimirMatriz(tablero);


        //método prueba para verificar que los pares e impares tengan la misma cantidad
        Matriz.prueba(tablero);

    }//fin main

}//fin clase