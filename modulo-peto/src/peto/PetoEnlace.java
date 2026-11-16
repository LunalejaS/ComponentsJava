package peto;

import core.GemaEnergia;

public class PetoEnlace {  
    public boolean escudoActivo(GemaEnergia gemaEnergia) {
        return gemaEnergia == null || gemaEnergia.tieneCarga();
    }
}