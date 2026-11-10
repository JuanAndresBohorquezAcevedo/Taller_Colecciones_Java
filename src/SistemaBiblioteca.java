import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemaBiblioteca {
    private final Map<String, Material> catalogo = new HashMap<>();
    private final Map<String, List<String>> listaEspera = new HashMap<>();
    private final Set<String> miembros = new HashSet<>();

    public void registrarMaterial(Material material) {
        if (material == null) {
            throw new IllegalArgumentException("El material no puede ser null.");
        }
        catalogo.put(material.getCodigo(), material);
    }

    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo);
    }

    public void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }

        for (Map.Entry<String, Material> entrada : catalogo.entrySet()) {
            System.out.print(entrada.getKey() + " -> ");
            entrada.getValue().mostrarInfo();
        }
    }

    public void agregarEspera(String codigoMaterial, String usuario) {
        if (!catalogo.containsKey(codigoMaterial)) {
            System.out.println("No se puede agregar a la espera: el material no existe.");
            return;
        }

        listaEspera.computeIfAbsent(codigoMaterial, codigo -> new ArrayList<>())
                .add(usuario);
    }

    public String siguienteEnEspera(String codigoMaterial) {
        List<String> espera = listaEspera.get(codigoMaterial);

        if (espera == null || espera.isEmpty()) {
            return null;
        }

        String siguiente = espera.remove(0);

        if (espera.isEmpty()) {
            listaEspera.remove(codigoMaterial);
        }

        return siguiente;
    }

    public boolean registrarMiembro(String usuario) {
        return miembros.add(usuario);
    }

    public boolean tieneMembresia(String usuario) {
        return miembros.contains(usuario);
    }
}
