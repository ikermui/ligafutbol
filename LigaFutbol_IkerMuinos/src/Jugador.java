// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Jugador {
    private String nombre;
    private String posicion;
    private int velocidad;
    private int regate;
    private boolean lesionado;

    @Override
    public String toString() {
        return "Jugador {" +
                "Nombre = '" + nombre + '\'' +
                ", Posicion = '" + posicion + '\'' +
                ", Velocidad = " + velocidad +
                ", Regate = " + regate +
                ", ¿Esta Lesionado? = " + lesionado +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getRegate() {
        return regate;
    }

    public void setRegate(int regate) {
        this.regate = regate;
    }

    public boolean isLesionado() {
        return lesionado;
    }

    public void setLesionado(boolean lesionado) {
        this.lesionado = lesionado;
    }
}