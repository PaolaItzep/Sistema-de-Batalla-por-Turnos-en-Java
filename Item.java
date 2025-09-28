public class Item {
    private String nombre;
    private String efecto;
    private int cantidad;

    public Item(String nombre, String efecto, int cantidad) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.cantidad = cantidad;
    }

    public void usar(Combatiente objetivo) {
        switch (efecto) {
            case "curar":
                objetivo.recibirDanio(-20); // cura
                break;
            case "boost":
                // aplicar boost temporal
                break;
        }
        System.out.println(nombre + " usado sobre " + objetivo.getNombre());
    }

    public void reducirCantidad() {
        cantidad--;
    }

    public boolean disponible() {
        return cantidad > 0;
    }

    @Override
    public String toString() {
        return nombre + " [" + efecto + ", x" + cantidad + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }
}