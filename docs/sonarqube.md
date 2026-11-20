# Evidencia de SonarQube · Unidad 10

Mediciones del 20 de noviembre de 2026 en SonarQube Community Build 26.11.0.134175. Se analizó primero el commit `f11244e` y se usó ese análisis como referencia para medir los cambios de `edd2492`.

| Métrica en SonarQube | Inicial | Final |
|---|---:|---:|
| Cobertura combinada | 50,0 % | 100,0 % |
| Cobertura de ramas | 36,8 % | 100,0 % |
| Complejidad ciclomática total | 20 | 19 |
| Complejidad cognitiva total | 33 | 7 |
| Code Smells | 1 | 0 |
| Deuda estimada | 20 min | 0 min |
| Duplicación | 0,0 % | 0,0 % |
| Bugs y vulnerabilidades detectados | 0 y 0 | 0 y 0 |
| Quality Gate | Falló | Aprobado |

La complejidad del método objetivo pasó de 20 a 3 según el conteo del código y el contador de JaCoCo. La complejidad total de SonarQube tiene otro alcance. Los valores no son intercambiables.

El perfil Java **Estándar Laboratorio**, duplicado del perfil por defecto, activa `java:S1541` con umbral 10. El gate del mismo nombre exige cobertura total de al menos 70 %, cero smells en código nuevo y duplicación total de hasta 5 %. La primera ejecución incumplió el 70 %. Después del refactor, SonarQube registró 100 % de cobertura, cero smells nuevos y 0 % de duplicación.

Los JSON en este directorio son exportaciones de la API inmediatamente después de cada análisis. Se conservan como evidencia revisable porque el panel original es local. El informe JaCoCo se regenera con `mvn -B clean verify`.

## Decisiones

1. Docker local permite reproducir ambos análisis sin compartir el código con una cuenta de análisis externa.
2. El scanner analiza toda la fuente de producción y todas las pruebas. No se añadieron exclusiones.
3. La complejidad por método indica dónde inspeccionar. La cobertura de ramas muestra qué alternativas faltan por ejecutar.
4. Strategy representa tarifas intercambiables por tipo de envío. State exigiría transiciones y Chain of Responsibility es más apropiado para una secuencia de manejadores.
5. Los casos asertan tarifas base, recargos y rutas de error. El aumento de cobertura refleja resultados comprobados.
6. La Tabla 3.2 de la guía ubica CC 10 al final de la zona moderada. El 70 % sirve como piso del laboratorio para detectar carencias sin incentivar llamadas vacías para llegar a 100 %.

Para repetir el análisis, configura un servidor y un token local en `SONAR_HOST_URL` y `SONAR_TOKEN` y ejecuta:

```text
mvn -B clean verify org.sonarsource.scanner.maven:sonar-maven-plugin:5.5.0.6356:sonar -Dsonar.projectKey=envios-service -Dsonar.qualitygate.wait=true
```
