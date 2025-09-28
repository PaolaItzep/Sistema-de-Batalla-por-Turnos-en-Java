import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bienvenida
        System.out.println("🎮 Bienvenida al sistema de batalla por turnos");
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();

        // Selección de rol
        String rol = "";
        while (!rol.equals("Guerrero") && !rol.equals("Explorador")) {
            System.out.print("Selecciona tu rol (Guerrero / Explorador): ");
            rol = scanner.nextLine();
        }

        // Crear jugador
        Jugador jugador = new Jugador(nombre, rol);

        // Generar enemigos aleatorios (1 a 3)
        Random rand = new Random();
        int cantidad = rand.nextInt(3) + 1;
        List<Enemigo> enemigos = new ArrayList<>();

        for (int i = 1; i <= cantidad; i++) {
            boolean esJefe = rand.nextBoolean();
            String tipo = rand.nextBoolean() ? "Orco" : "Mago";
            enemigos.add(new Enemigo("Enemigo" + i, tipo, esJefe));
        }

        // Iniciar batalla
        Batalla batalla = new Batalla(jugador, enemigos);
        batalla.iniciar();

        scanner.close();
    }
}