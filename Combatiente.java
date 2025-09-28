public abstract class Combatiente {
    protected String nombre;
    protected int vida;
    protected int ataque;

    public Combatiente(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void atacar(Combatiente objetivo) {
        objetivo.recibirDanio(ataque);
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida < 0) vida = 0;
    }

    public abstract void tomarTurno(Batalla batalla);
    public abstract void mensajeInicio();
    public abstract void mensajeFinal();

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    @Override
    public String toString() {
        return nombre + " [Vida: " + vida + ", Ataque: " + ataque + "]";
    }
}