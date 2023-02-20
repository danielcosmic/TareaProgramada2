import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo{

    public static void guardarDatosJugadores(String nombreArchivo, Jugador jugador1, Jugador jugador2, int fallosJ1, int fallosJ2){
        try{
            FileWriter archivo = new FileWriter(nombreArchivo);
            BufferedWriter buffWrite;
            buffWrite = new BufferedWriter (archivo);

            buffWrite.write(jugador1.getNombre()+"\n");//linea 1 nombre jugador 1
            buffWrite.write(Integer.toString(fallosJ1)+"\n");//linea 2 fallos jugador 1
            buffWrite.write(jugador2.getNombre()+"\n");//linea 3 nombre jugador 2
            buffWrite.write(Integer.toString(fallosJ2)+"\n");//linea 4 fallos jugador 2
            buffWrite.close();
        }catch (IOException ex) {
        System.out.println(ex.toString());
        }
    }//fin guardarDatosJugadores

    public static void guardarTableroEnCSV(int[][] tablero, String nombreArchivo){
        //
        try {
            FileWriter archivo = new FileWriter(nombreArchivo);
            BufferedWriter buffWrite;
            buffWrite = new BufferedWriter(archivo);
            for (int i=0; i<tablero.length; i++){
                for (int j=0; j<tablero[i].length; j++){
                    if (j < tablero[i].length-1){
                        //validamos que no sea la última columna
                        buffWrite.write(Integer.toString(tablero[i][j])+",");
                    }
                    else{
                        //cuando se llega a la última columna se imprime un cambio de línea
                        buffWrite.write(Integer.toString(tablero[i][j])+"\n");
                    }
                }//for con j que recorre las columnas
            }//for con i que recorre las filas
            buffWrite.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }//fin guardarTablerotEnCSV
}//fin clase