# Unidad 10 — Calidad de envíos

`ServicioCalculoEnvio` inicia con un método intencionalmente complejo: mezcla tarifa por tipo, peso, distancia, fragilidad, cliente y temporada. La primera versión contiene dos pruebas de tarifa base.

## Ejecutar

```bash
mvn clean verify
```

JaCoCo publica HTML y XML en `target/site/jacoco/`.

## Hallazgo y refactorización

El baseline separa las decisiones por tipo de envío en un solo método con 19 decisiones explícitas, CC inicial 20 (1 más 19). La refactorización extrae Strategy por tipo y deja el servicio como selector del algoritmo; las decisiones propias de cada precio permanecen localizadas y se prueban con límites. `diagnostico-estatico.md` registra el cálculo estático reproducible y los datos medidos de JaCoCo antes y después.

## Límites de evidencia

El proyecto genera el reporte JaCoCo que puede importar SonarQube, pero aquí no hay URL, token ni Quality Profile/QG del curso para ejecutar análisis remoto. Por tanto, no se reportan ratings, deuda, seguridad ni estado de gate como si fueran resultados de Sonar. Para cerrar esa evidencia se debe enlazar este repo en el servidor autorizado y confirmar el gate del perfil activo; mientras tanto, solo son verificables los datos locales.
