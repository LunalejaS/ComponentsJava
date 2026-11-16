package app;

import armas.EspadaExplorador;
import botas.BotasEnlace;
import casco.CascoRunico;
import peto.PetoEnlace;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== COMPONENT QUEST: PRUEBA FINAL ===");

        // Ronda 1: ataque limpio de la espada
        EspadaExplorador espada = new EspadaExplorador();
        System.out.println("Ataque con espada: " + espada.atacar() + " pts");

        // Ronda 2: el peto mantiene el escudo aunque retiren las botas
        PetoEnlace peto = new PetoEnlace();
        BotasEnlace botas = new BotasEnlace();

        System.out.println("Escudo con botas: " + peto.escudoActivo(botas));
        botas = null; // Se retiran las botas durante el combate
        System.out.println("Escudo sin botas: " + peto.escudoActivo(botas));

        // Ronda 4: casco rúnico contra fuego
        CascoRunico casco = new CascoRunico();
        System.out.println("Defensa contra fuego: "
                + casco.resistirAtaque("FUEGO"));
    }
}