public class Batalla {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private Deque<String> historialAcciones;

    public Batalla(Jugador jugador, List<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
        this.historialAcciones = new ArrayDeque<>();
    }

    public void iniciar() {
        jugador.mensajeInicio();
        enemigos.forEach(Enemigo::mensajeInicio);

        while (!verificarFin()) {
            jugador.tomarTurno(this);
            registrarAccion(jugador.getNombre() + " tomó su turno.");

            for (Enemigo enemigo : enemigos) {
                if (enemigo.estaVivo()) {
                    enemigo.tomarTurno(this);
                    registrarAccion(enemigo.getNombre() + " atacó.");
                }
            }

            mostrarEstado();
        }

        System.out.println("Fin del combate.");
    }

    public void siguienteTurno() {
        // lógica de turnos
    }

    public void mostrarEstado() {
        System.out.println("Estado actual:");
        System.out.println(jugador);
        enemigos.forEach(System.out::println);
        System.out.println("Últimas acciones:");
        historialAcciones.forEach(System.out::println);
    }

    public void registrarAccion(String accion) {
        if (historialAcciones.size() == 3) historialAcciones.removeFirst();
        historialAcciones.addLast(accion);
    }

    public boolean verificarFin() {
        return !jugador.estaVivo() || enemigos.stream().noneMatch(Combatiente::estaVivo);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public List getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(List enemigos) {
        this.enemigos = enemigos;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Deque getHistorialAcciones() {
        return historialAcciones;
    }

    public void setHistorialAcciones(Deque historialAcciones) {
        this.historialAcciones = historialAcciones;
    }
}