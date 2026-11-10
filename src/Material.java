public abstract class Material implements Catalogable {
    private String codigo;
    private String titulo;
    private int año;
    private boolean disponible;

    public Material(String codigo, String titulo, int año, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.año = año;
        this.disponible = disponible;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAño() {
        return año;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract String getTipo();

    public void mostrarInfo() {
        String estado = disponible ? "disponible" : "prestado";
        System.out.println("[" + getTipo() + "] " + titulo + " (" + año + ") — " + estado);
    }
}
