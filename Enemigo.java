public class Enemigo extends Combatiente {
    private String tipo;
    private boolean esJefe;

    public Enemigo(String nombre, String tipo, boolean esJefe) {
        super(nombre, esJefe ? 100 : 70, esJefe ? 25 : 15);
        this.tipo = tipo;
        this.esJefe = esJefe;
    }

    public void usarHabilidadEspecial(Batalla batalla) {
        if (esJefe) {
            System.out.println(nombre + " activa su habilidad especial de jefe.");
            // Lógica adicional
        } else {
            System.out.println(nombre + " usa su habilidad de tipo " + tipo + ".");
        }
    }

    @Override
    public void tomarTurno(Batalla batalla) {
        // IA simple: atacar al jugador
        mensajeInicio();
        atacar(batalla.getJugador());
    }

    @Override
    public void mensajeInicio() {
        System.out.println(nombre + " (" + tipo + ") entra en combate.");
    }

    @Override
    public void mensajeFinal() {
        System.out.println(nombre + " ha sido derrotado.");
    }
}