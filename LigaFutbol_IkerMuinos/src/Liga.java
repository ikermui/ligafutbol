import java.util.ArrayList;
import java.util.Scanner;

public class Liga {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList personas = new ArrayList();
    public static void main(String[] args) {
        String opcion = "10";
        do{
            menu();
            System.out.print("Escoge opcion del 1-10: ");
            opcion = teclado.next();
            switch (opcion){
                case "1":
                    System.out.println("Escogiste el 1");
                    insertaJugador();
                    break;
                case "2":
                    System.out.println("Escogiste el 2");
                    insertaArbitro();
                    break;
                case "3":
                    System.out.println("Escogiste el 3");
                    System.out.println(muestraPersonas(0));
                    break;
                case "4":
                    System.out.println("Escogiste el 4");
                    int[] orden = new int[personas.size()];
                    rellenaOrden(orden, 0);
                    ordenaVelocidades(orden);
                    System.out.println("----------------------");
                    ordenaVelocidadesRecursivo(orden, 0, 1, 0);
                    break;
                case "5":
                    System.out.println("Escogiste el 5");
                    muestraJugadores(0);
                    break;
                case "6":
                    System.out.println("Escogiste el 6");
                    break;
                case "7":
                    System.out.println("Escogiste el 7");
                    buscaPersona(0);
                    break;
                case "8":
                    System.out.println("Escogiste el 8");
                    mayorRegate(0, null);
                    break;
                case "9":
                    System.out.println("Escogiste el 9");
                    sumaVelocidades(0, 0);
                    break;
                case "10":
                    System.out.println("Escogiste el 10");
                    System.out.println("Terminando programa...");
                    break;
                default:
                    System.out.println("Tienes que poner un numero del 1-10");
                    break;
            }
        } while (!opcion.equals("10"));
    }

    private static void sumaVelocidades(int i, int suma) {
        if (i < personas.size()){
            if (personas.get(i) instanceof Jugador){
                suma += ((Jugador) personas.get(i)).getVelocidad();
            } else if (personas.get(i) instanceof Arbitro) {
                suma += ((Arbitro) personas.get(i)).getVelocidad();
            }
        }
        System.out.println("El total de todas las velocidades es " + suma);
    }

    private static void mayorRegate(int i, Jugador mayor) {
        if (i < personas.size()){
            if (personas.get(i) instanceof Jugador){
                if (mayor == null || ((Jugador) personas.get(i)).getRegate() > mayor.getRegate()){
                    mayor = (Jugador) personas.get(i);
                }
            }
            mayorRegate(i + 1, mayor);
        } else {
            if (mayor != null) {
                System.out.println("El jugador con mas regate es " + mayor.getNombre() + " con " + mayor.getRegate() + " de regate");
            }
        }
    }

    private static void buscaPersona(int i) {
        String nombre = "";
        boolean correcto = false;
        if (i == 0) {
            System.out.print("Pon nombre: ");
            nombre = teclado.next();
        }
        if (i < personas.size() && !correcto){
            if (personas.get(i) instanceof Jugador){
                if (nombre.equalsIgnoreCase(((Jugador) personas.get(i)).getNombre())){
                    correcto = true;
                }
            } else if (personas.get(i) instanceof Arbitro) {
                if (nombre.equalsIgnoreCase(((Arbitro) personas.get(i)).getNombre())){
                    correcto = true;
                }
            }
        }
        if(correcto){
            System.out.println("La persona con el nombre \"" + nombre + "\"" + " existe");
        }
    }

    private static void muestraJugadores(int i) {
        if (i < personas.size()){
            if (personas.get(i) instanceof Jugador) {
                System.out.println("Persona: " + i + ": " + personas.get(i).toString());
            }
            muestraJugadores(i+1);
        }
    }

    private static int[] rellenaOrden(int[] orden, int i) {
        if (i >= orden.length){
            return orden;
        }
        else {
            if (personas.get(i) instanceof Jugador) {
                orden[i] = ((Jugador) personas.get(i)).getVelocidad();
                return rellenaOrden(orden, i + 1);
            } else if (personas.get(i) instanceof Arbitro) {
                orden[i] = ((Arbitro) personas.get(i)).getVelocidad();
                return rellenaOrden(orden, i + 1);
            } else {
                return null;
            }
        }
    }

    private static void ordenaVelocidades(int[] orden) {
        for (int i = 0; i < orden.length - 1; i++){
            for (int j = i + 1; j < orden.length; j++){
                if (orden[i] > orden[j]){
                    int aux = orden[i];
                    orden[i] = orden[j];
                    orden[j] = aux;
                }
            }
        }
        for (int i = 0; i < orden.length; i++){
            System.out.println(i + 1 + ": " + orden[i]);
        }
    }

    private static void ordenaVelocidadesRecursivo(int[] orden, int i, int j, int x) {
        if (i >= orden.length - 1){
            if (x < orden.length) {
                System.out.println(x + 1 + ": " + orden[x]);
                ordenaVelocidadesRecursivo(orden, i, j, x + 1);
            }
        } else {
            if (j >= orden.length){
                ordenaVelocidadesRecursivo(orden, i + 1, j + 1, x);
            } else {
                if (orden[i] > orden[j]){
                    int aux = orden[i];
                    orden[i] = orden[j];
                    orden[j] = aux;
                }
                ordenaVelocidadesRecursivo(orden, i, j + 1, x);
            }
        }
    }

    private static String muestraPersonas(int i) {
        if (i >= personas.size()){
            return "";
        } else {
            return "Persona " + (i+1) + ": " + personas.get(i).toString() + "\n" + muestraPersonas(i + 1);
        }
    }

    private static void insertaArbitro() {
        Arbitro a = new Arbitro();
        boolean correcto = true;
        System.out.print("Pon el nombre del arbitro: ");
        a.setNombre(teclado.next());
        System.out.print("Pon el colegio del arbitro: ");
        a.setColegio(teclado.next());
        do {
            System.out.print("¿Esta activo? (S/N): ");
            String activo = teclado.next();
            if (activo.equalsIgnoreCase("S")){
                correcto = true;
                a.setActivo(true);
            } else if (activo.equalsIgnoreCase("N")) {
                correcto = true;
                a.setActivo(false);
            } else {
                correcto = false;
                System.out.println("Tienes que poner S si esta activo o N si no lo esta");
            }
        } while (!correcto);
        a.setVelocidad((int) Math.floor(Math.random() * (100 - 0 + 1) + 0));
        a.setAcierto((int) Math.floor(Math.random() * (100 - 0 + 1) + 0));
        personas.add(a);
    }

    private static void insertaJugador() {
        Jugador j = new Jugador();
        boolean correcto = true;
        System.out.print("Pon el nombre del jugador: ");
        j.setNombre(teclado.next());
        System.out.print("Pon la posicion del jugador: ");
        j.setPosicion(teclado.next());
        do {
            System.out.print("¿Esta lesionado? (S/N): ");
            String lesion = teclado.next();
            if (lesion.equalsIgnoreCase("S")){
                correcto = true;
                j.setLesionado(true);
            } else if (lesion.equalsIgnoreCase("N")) {
                correcto = true;
                j.setLesionado(false);
            } else {
                correcto = false;
                System.out.println("Tienes que poner S si esta lesionado o N si no lo esta");
            }
        } while (!correcto);
        j.setVelocidad((int) Math.floor(Math.random() * (100 - 0 + 1) + 0));
        j.setRegate((int) Math.floor(Math.random() * (100 - 0 + 1) + 0));
        personas.add(j);
    }

    private static void menu() {
        System.out.println("1) Inserta Jugador\n2) Inserta Arbitro\n3) Mostrar Todo El Vector\n4) Ordenar Personas por velocidad\n5) Mostrar Solo Jugadores\n7) Buscar Jugador o Arbitro por Nombre\n8) Jugador con más Regate\n9) Suma Todas Las Velocidades\n10) Terminar Programa");
    }

    public static int leerInt(String pregunta){
        boolean correct = true;
        int respuesta = 0;
        do {
            try {
                correct = true;
                System.out.print(pregunta);
                String p = teclado.next();
                respuesta = Integer.parseInt(p);
            } catch (Exception ex) {
                System.out.println("Eso no es un numero entero");
                correct = false;
            }
        } while (!correct);
        return respuesta;
    }
}