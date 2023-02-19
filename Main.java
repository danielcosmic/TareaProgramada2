import java.util.*;
public class Main{

    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Bienvenidxs al juego"); //fijo puede cambiar este mensaje kk-R
        System.out.println("Ingrese 1 para crear una nueva partida o 2 para cargar una partida existente:");
        String opcionP = in.nextLine();
        if (opcionP.equals("1")){
            //creacion de objetos de la clase Jugador con los nombres ingresados
            System.out.println("Ingrese el nombre del jugador 1:");
            String nombre1 = in.nextLine();
            Jugador jug1 = new Jugador(nombre1, 0);
            System.out.println("Ingrese el nombre del jugador 2:");
            String nombre2 = in.nextLine();
            Jugador jug2 = new Jugador(nombre2, 0);

            System.out.println("A " + jug1.getNombre + " le corresponderan los numeros impares.");
            System.out.println("A " + jug2.getNombre + " le corresponderan los numeros pares.");

            //creacion de variable tablero
            int[][] tablero = new int[10][10];
            //se genera el tablero hasta que la cantidad de pares e impares sea la misma
            do {
            tablero = Matriz.crearMatriz();
            } while (Matriz.verificarMatriz(tablero));

            //pruebita
            Matriz.imprimirMatriz(tablero);
            //método prueba para verificar que los pares e impares tengan la misma cantidad
            Matriz.prueba(tablero);
        }//fin if

    }//fin main
}//fin clase