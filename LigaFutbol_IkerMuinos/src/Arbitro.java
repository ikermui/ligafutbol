// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Arbitro {
    private String nombre;
    private String colegio;
    private int velocidad;
    private int acierto;
    private boolean activo;

    @Override
    public String toString() {
        return "Arbitro {" +
                "Nombre = '" + nombre + '\'' +
                ", Colegio = '" + colegio + '\'' +
                ", Velocidad = " + velocidad +
                ", Acierto = " + acierto +
                ", ¿Esta activo? = " + activo +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = acierto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}