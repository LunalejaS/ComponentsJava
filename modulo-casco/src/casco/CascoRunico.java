package casco;

public class CascoRunico implements ProteccionElemental {
    @Override
    public String resistirAtaque(String elemento) {
        if ("MAGICO".equalsIgnoreCase(elemento)
                || "FUEGO".equalsIgnoreCase(elemento)
                || "ELEMENTAL".equalsIgnoreCase(elemento)) {
            return "Ataque " + elemento + " resistido";
        }
        return "CASCO RUNICO: No soporta ataques de " + elemento;
    }
}