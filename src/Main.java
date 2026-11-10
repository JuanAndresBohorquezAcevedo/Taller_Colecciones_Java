public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();

        System.out.println("========== 1. REGISTRO DE MATERIALES ==========");

        Libro libro1 = new Libro(
                "BK-2024-001", "Cien años de soledad", 1967, true,
                "Gabriel García Márquez", "978-0307474728"
        );

        Libro libro2 = new Libro(
                "BK-2023-002", "El principito", 1943, true,
                "Antoine de Saint-Exupéry", "978-0156012195"
        );

        Revista revista1 = new Revista(
                "RV-2025-001", "Tecnología Hoy", 2025, true,
                15, "Tecnología"
        );

        Revista revista2 = new Revista(
                "RV-2024-002", "Ciencia y Vida", 2024, true,
                8, "Ciencias"
        );

        biblioteca.registrarMaterial(libro1);
        biblioteca.registrarMaterial(libro2);
        biblioteca.registrarMaterial(revista1);
        biblioteca.registrarMaterial(revista2);

        System.out.println("\n========== 2. BÚSQUEDA EN EL CATÁLOGO ==========");

        Material encontrado = biblioteca.buscarMaterial("BK-2024-001");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        } else {
            System.out.println("Material no encontrado.");
        }

        Material inexistente = biblioteca.buscarMaterial("CODIGO-999");
        if (inexistente == null) {
            System.out.println("La búsqueda de CODIGO-999 no encontró resultados.");
        }

        System.out.println("\n========== 3. LISTA DE ESPERA ==========");

        // El libro queda prestado y tres usuarios esperan por él.
        libro1.setDisponible(false);
        biblioteca.agregarEspera("BK-2024-001", "Laura");
        biblioteca.agregarEspera("BK-2024-001", "Carlos");
        biblioteca.agregarEspera("BK-2024-001", "Andrés");

        System.out.println("Primer usuario en espera: "
                + biblioteca.siguienteEnEspera("BK-2024-001"));
        System.out.println("Segundo usuario en espera: "
                + biblioteca.siguienteEnEspera("BK-2024-001"));

        System.out.println("Tercer usuario en espera: "
                + biblioteca.siguienteEnEspera("BK-2024-001"));

        System.out.println("Lista vacía: "
                + (biblioteca.siguienteEnEspera("BK-2024-001") == null));

        System.out.println("\n========== 4. MEMBRESÍAS ==========");

        System.out.println("Registrar Laura: "
                + biblioteca.registrarMiembro("Laura"));
        System.out.println("Registrar Carlos: "
                + biblioteca.registrarMiembro("Carlos"));
        System.out.println("Registrar Andrés: "
                + biblioteca.registrarMiembro("Andrés"));

        // Se intenta registrar nuevamente un usuario existente.
        System.out.println("Registrar Laura otra vez: "
                + biblioteca.registrarMiembro("Laura"));

        System.out.println("¿Laura tiene membresía? "
                + biblioteca.tieneMembresia("Laura"));
        System.out.println("¿Pedro tiene membresía? "
                + biblioteca.tieneMembresia("Pedro"));

        System.out.println("\n========== 5. CATÁLOGO COMPLETO ==========");
        biblioteca.mostrarCatalogo();

        System.out.println("\n========== FIN DE LAS PRUEBAS ==========");
    }
}
