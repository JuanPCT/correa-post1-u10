# Diagnóstico local reproducible — Unidad 10

Ejecución: `mvn -B clean verify` con JaCoCo 0.8.13. La fuente del baseline y sus dos pruebas está en el primer commit local; el reporte posterior se genera sobre la versión con Strategy.

| Medida | Antes | Después |
|---|---:|---:|
| CC máxima de método en `ServicioCalculoEnvio` | 20 | 3 |
| CC máxima de método dentro de tarifas | Incluida en el método de servicio | 6 (`TarifaEnvio.calcular`) |
| Cobertura de líneas JaCoCo | 16/25 = 64.0% | 34/34 = 100% |
| Cobertura de ramas JaCoCo | 14/38 = 36.8% | 14/14 = 100% |

La CC inicial es el conteo de la regla de complejidad ciclomática de Sonar para Java: una ruta base más 19 decisiones explícitas en el método. El método de orquestación final conserva dos decisiones de error (peso no válido y estrategia ausente), CC 3; la fórmula común contiene cinco condiciones (CC 6). La CC máxima baja en el método de servicio, pero la lógica condicional no desaparece: queda localizada en la tarifa y cubierta en ambas ramas.

JaCoCo mide bytecode ejecutado por las pruebas, no la calidad semántica de las expectativas. Los casos finales asertan los cuatro valores base, recargos, límites y error de configuración. La métrica anterior corresponde al baseline de dos pruebas y la posterior a la suite extendida, por lo que el aumento de cobertura se debe a los casos adicionales; no se atribuye a Strategy por sí sola.

El [informe de SonarQube](docs/sonarqube.md) contiene las mediciones del servidor local y el resultado del gate.
