import java.util.*;
public class Main{
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Bienvenidxs al juego");
        System.out.println("Ingrese 1 para crear una nueva partida o 2 para cargar una partida existente:");
        String opcionP = in.nextLine();

        //if para comenzar una nueva patida o cargar una existente
        if (opcionP.equals("1")){
            //partida nueva
            System.out.println(" ");
            System.out.println("Nueva partida");

            //creacion de objetos de la clase Jugador con los nombres ingresados
            System.out.println("-Ingrese el nombre del jugador 1:");
            String nombre1 = in.nextLine();
            int fallosJ1 = 0;
            Jugador jug1 = new Jugador(nombre1);
            System.out.println("-Ingrese el nombre del jugador 2:");
            String nombre2 = in.nextLine();
            int fallosJ2 = 0;
            Jugador jug2 = new Jugador(nombre2);

            System.out.println(" ");
            System.out.println("*A " + jug1.getNombre() + " le corresponderan los numeros impares y a " + jug2.getNombre() + " los pares.");

            //creacion de variable tablero
            int[][] tablero = new int[10][10];
            //se genera el tablero hasta que la cantidad de pares e impares sea la misma
            do {
            tablero = Matriz.crearMatriz();
            } while (Matriz.verificarMatriz(tablero));

            //PRUEBA
            Matriz.imprimirMatriz(tablero);
            //método prueba para verificar que los pares e impares tengan la misma cantidad
            Matriz.prueba(tablero);

            System.out.println(" ");
            System.out.println("-En cada turno deberan ingresar coordenadas correspondientes a posiciones en el tablero.");
            System.out.println("-El tablero es de 10x10 por lo que la coordenada estara compuesta por dos numeros del 1 al 10 separados por una coma.");
            System.out.println("-Ejemplo de coordenada: 1,2");
            System.out.println(" ");

            jugarPartida(tablero, jug1, jug2, fallosJ1, fallosJ2);

        }else if (opcionP.equals("2")){
            Archivo.cargarDatosGuardados("Jugadores");
            Archivo.cargarTableroGuardado("Tablero");
            jugarPartida(tablero, jug1, jug2, fallosJ1, fallosJ2);
        }else{
            System.out.println("Opción Inválida.");
        }

        in.close();
    }//fin main

    //metodo para verificar si todos los espacios del tablero han sido usados
    public static boolean verificarTablero(int[][] tablero){
        boolean flag = true;
        int usados = 0;
        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero[i].length; j++){
                if (tablero[i][j]<0){
                    usados++;
                }
            }
        }// fin bucle de fors
        if (usados == 100){
            flag = false;
        }
        return flag;
    }//fin metodo verificarTablero

    //metodo para convertir las coordenadas a un arreglo de enteros
    public static int[] convertirCoordenada (String coordenadaString){
        String[] coordenadaArrayString = coordenadaString.split(",");
        int x = Integer.parseInt(coordenadaArrayString[0]);
        int y = Integer.parseInt(coordenadaArrayString[1]);
        int[] coordenada = new int[coordenadaArrayString.length];
            coordenada[0] = x-1;
            coordenada[1] = y-1;
        return coordenada;
    }//fin metodo convertirCoordenada

    //metodo para jugar las partidas
    public static void jugarPartida (int[][] tablero, Jugador jug1, Jugador jug2, int fallosJ1, int fallosJ2){
        Scanner in = new Scanner(System.in);
        do{
            //for para jugar 6 partidas y luego preguntar si se desea guardar la partida
            for (int i=0; i<6; i++){

                //turno jugador1
                System.out.println(jug1.getNombre() + ", ingrese una coordenada:");
                String c1 = in.nextLine();
                int[] coordenada1 = convertirCoordenada(c1);
                System.out.println("El numero que se encuentra en esa posicion es " + tablero[coordenada1[0]][coordenada1[1]]);
                //if para verificar si es par, impar o si ya se escogio antes
                if (tablero[coordenada1[0]][coordenada1[1]] < 0){
                    //ya se escogio esa posicion antes
                }else if ((tablero[coordenada1[0]][coordenada1[1]] > 0) && (((tablero[coordenada1[0]][coordenada1[1]] % 2) != 0) && (tablero[coordenada1[0]][coordenada1[1]]!=0))){
                    tablero[coordenada1[0]][coordenada1[1]] = -1;
                }else if ((tablero[coordenada1[0]][coordenada1[1]] > 0) && (((tablero[coordenada1[0]][coordenada1[1]] % 2) == 0))){
                    tablero[coordenada1[0]][coordenada1[1]] = -3;
                    fallosJ1+=1;
                    //PRUEBA
                    System.out.println("fallos: " + fallosJ1);
                }else{
                    tablero[coordenada1[0]][coordenada1[1]] = -3;
                    fallosJ1+=1;
                    //PRUEBA
                    System.out.println("fallos: " + fallosJ1);
                }// fin todos los if -----------------------------------
                if(fallosJ1>=5){
                    break;
                }//fin if

                //turno jugador2
                System.out.println(jug2.getNombre() + ", ingrese una coordenada:");
                String c2 = in.nextLine();
                int[] coordenada2 = convertirCoordenada(c2);
                System.out.println("El numero que se encuentra en esa posicion es " + tablero[coordenada2[0]][coordenada2[1]]);
                //if para verificar si es par, impar o si ya se escogio antes
                if (tablero[coordenada2[0]][coordenada2[1]] < 0){
                    //ya se escogio esa posicion antes
                }else if ((tablero[coordenada2[0]][coordenada2[1]] > 0) && (((tablero[coordenada2[0]][coordenada2[1]] % 2) == 0) || (tablero[coordenada2[0]][coordenada2[1]] == 0))){
                    tablero[coordenada2[0]][coordenada2[1]] = -2;
                }else if ((tablero[coordenada2[0]][coordenada2[1]] > 0) && (((tablero[coordenada2[0]][coordenada2[1]] % 2) != 0) && (tablero[coordenada2[0]][coordenada2[1]]!=0))){
                    tablero[coordenada2[0]][coordenada2[1]] = -3;
                    fallosJ2+=1;
                    //PRUEBA
                    System.out.println("fallos: " + fallosJ2);
                }// fin todos los if -----------------------------------
                if(fallosJ2>=5){
                    break;
                }//fin if
            }//fin for

            if((fallosJ1>=5)||(fallosJ2>=5)){
                if(fallosJ1>=5){
                    System.out.println("Fin de la partida");
                    System.out.println("El ganador es: " + jug2.getNombre());
                    break;
                }else{
                    System.out.println("Fin de la partida");
                    System.out.println("El ganador es: " + jug1.getNombre());
                    break;
                }//fin if
            }//fin if

            if(!verificarTablero(tablero)){
                if(fallosJ1<fallosJ2){
                    System.out.println("Fin de la partida");
                    System.out.println("El ganador es: " + jug1.getNombre());
                    break;
                }else if(fallosJ2<fallosJ1){
                    System.out.println("Fin de la partida");
                    System.out.println("El ganador es: " + jug2.getNombre());
                    break;
                }else if(fallosJ2==fallosJ1){
                    System.out.println("Fin de la partida");
                    System.out.println("Empate! Ambos ganan");
                    break;
                }
            }//fin if

            //guardar partida
            System.out.println("Desea guardar la partida? Ingrese 1 para guardar la partida o 2 para continuar jugando sin guardarla");
            String opcionG = in.nextLine();
            if (opcionG.equals("1")){
                Archivo.guardarTableroEnCSV(tablero, "Tablero");
                Archivo.guardarDatosJugadores("Jugadores", jug1, jug2, fallosJ1, fallosJ2);
                System.out.println("Partida guardada");
            }else if(opcionG.equals("2")){
                //sigue
            }else{
                System.out.println("Opcion incorrecta");
            }
        }while ( (verificarTablero(tablero)) && (fallosJ1<5) && (fallosJ2<5) );
    }//fin metodo jugarPartida

}//fin clase