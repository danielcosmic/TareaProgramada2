public class Matriz {

    public static int[][] crearMatriz(){
        int [][] matriz = new int[10][10];
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                matriz[i][j] = (int) Math.abs(Math.random()*10);
            }
        }
        return matriz;
    }// fin método crearMatriz

    //método para verififcar que la matriz tenga la misma cantidad de pares e impares (50 y 50)
    public static boolean verificarMatriz(int[][] matriz){
        boolean flag = true;
        int pares=0, impares=0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if (matriz[i][j]%2!=0) {
                    impares++;
                }else{
                    pares++;
                }
            }
        }// fin bucle de fors
        if (Math.abs(pares-impares)<=0) {
            flag = false;
        }
        return flag;
    }//fin método verificarMatriz

    public static void imprimirMatriz(int[][] matriz){
        System.out.println("Tablero de juego: "); //esto si quiere lo quita, solo agregro cosas para que parezca que avancé algo xd
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.printf("%3d", matriz[i][j]);
            }
            System.out.println();
        }
    }//fin método imprimirMatriz

    //método prueba para verificar que los pares e impares tengan la misma cantidad
    public static void prueba(int[][] matriz){
        int pares=0, impares=0, valor = 0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                valor = matriz[i][j];
                if (valor%2!=0) {
                    impares++;
                }else{
                    pares++;
                }
            }
        }// fin bucle
        System.out.println(pares);
        System.out.println(impares);
    }
}// fin clase