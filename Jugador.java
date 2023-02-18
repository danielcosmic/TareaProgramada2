public class Jugador{

    //atributos clase
    private String nombre;
    private int fallos;

    //constructor
    public Jugador(String nombre, int fallos){
        this.nombre = nombre;
        this.fallos = fallos;
    }

    //setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setFallos(int fallos){
        this.fallos = fallos;
    }

    //getters
    public String getNombre(){
    return nombre;
    }
    public int getFallos(){
    return fallos;
    }

}//fin clase