# ComponentsJava

Proyecto educativo en Java sobre arquitectura de componentes. Usa el escenario de *Component Quest* para mostrar cómo las dependencias innecesarias y los ciclos entre módulos dificultan la compilación, el empaquetado y la reutilización. La versión refactorizada separa los módulos y los conecta mediante archivos JAR e interfaces.

## Componentes

| Proyecto | Responsabilidad | Dependencias principales |
|---|---|---|
| `modulo-core` | Define el contrato `core.GemaEnergia`. | Ninguna |
| `modulo-espada` | Proporciona `armas.EspadaExplorador`, con un ataque de 50 puntos. | Ninguna |
| `modulo-peto` | Proporciona `peto.PetoEnlace`; mantiene activo el escudo cuando la gema es `null` o tiene carga. | `modulo-core` |
| `modulo-botas` | Proporciona `botas.BotasEnlace`, que implementa `GemaEnergia`. | `modulo-core` |
| `modulo-casco` | Define `ProteccionElemental`, `CascoHierroSellado` y `CascoRunico`. | Ninguna |
| `juego-principal` | Integra los componentes y ejecuta los escenarios de demostración. | Los cinco JAR |

La dependencia compartida por peto y botas pasa por `GemaEnergia`; ambos módulos ya no se importan entre sí. `juego-principal` usa la interfaz implementada por las botas al llamar a `PetoEnlace.escudoActivo(...)`.

## Estructura

```text
ComponentsJava/
├── juego-principal/src/app/Main.java
├── modulo-core/src/core/GemaEnergia.java
├── modulo-espada/src/armas/EspadaExplorador.java
├── modulo-peto/src/peto/PetoEnlace.java
├── modulo-botas/src/botas/BotasEnlace.java
└── modulo-casco/src/casco/
    ├── ProteccionElemental.java
    ├── CascoHierroSellado.java
    └── CascoRunico.java
```

Los proyectos también incluyen archivos `.jar` exportados y carpetas `bin/` con clases compiladas. Los fuentes bajo `src/` son la referencia para revisar o reconstruir el código.

## Requisitos

- JDK instalado.
- Visual Studio Code con **Extension Pack for Java**.

## Abrir y ejecutar en VS Code

1. Clona el repositorio y abre la carpeta `ComponentsJava` en VS Code.
2. En el panel **JAVA PROJECTS**, verifica que estén reconocidos los proyectos Java.
3. En `modulo-peto` y `modulo-botas`, agrega `modulo-core/core-v1.0.jar` a **Referenced Libraries**.
4. En `juego-principal`, agrega los cinco JAR a **Referenced Libraries**:
   - `modulo-core/core-v1.0.jar`
   - `modulo-espada/espada-v1.0.jar`
   - `modulo-peto/peto-v1.0.jar`
   - `modulo-botas/botas-v1.0.jar`
   - `modulo-casco/casco-v1.0.jar`
5. Abre `juego-principal/src/app/Main.java` y pulsa **Run** sobre `main`.

Si necesitas regenerar los artefactos, exporta primero `modulo-core` como `core-v1.0.jar`; después exporta peto y botas, además de espada y casco. En VS Code, usa **Export Jar** desde el proyecto en el panel **JAVA PROJECTS**. Asegúrate de que los módulos que usan `core.GemaEnergia` tengan el JAR de core referenciado antes de exportarlos.

## Salida esperada

```text
=== COMPONENT QUEST: PRUEBA FINAL ===
Ataque con espada: 50 pts
Escudo con botas: true
Escudo sin botas: true
Defensa contra fuego: Ataque FUEGO resistido
```

