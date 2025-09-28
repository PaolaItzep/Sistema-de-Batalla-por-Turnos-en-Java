public class Jugador extends Combatiente {
    private String rol;
    private List<Item> items;

    public Jugador(String nombre, String rol) {
        super(nombre, rol.equals("Guerrero") ? 120 : 90, rol.equals("Guerrero") ? 30 : 20);
        this.rol = rol;
        this.items = new ArrayList<>();
    }

    public void usarItem(Item item, Combatiente objetivo) {
        item.usar(objetivo);
        item.reducirCantidad();
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    @Override
    public void tomarTurno(Batalla batalla) {
        // Menú interactivo por consola (simulado)
        mensajeInicio();
        // Aquí iría la lógica de selección de acción
    }

    @Override
    public void mensajeInicio() {
        System.out.println(nombre + " se prepara para actuar como " + rol + ".");
    }

    @Override
    public void mensajeFinal() {
        System.out.println(nombre + " ha sido derrotado.");
    }
}