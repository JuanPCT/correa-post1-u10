Repositorio GitHub: https://github.com/JuanPCT/correa-post1-u10

# Unidad 10 — Calidad de envíos

`ServicioCalculoEnvio` inicia con un método intencionalmente complejo: mezcla tarifa por tipo, peso, distancia, fragilidad, cliente y temporada. La primera versión contiene dos pruebas de tarifa base.

## Ejecutar

```bash
mvn clean verify
```

JaCoCo publica HTML y XML en `target/site/jacoco/`.

## Hallazgo y refactorización

El baseline separa las decisiones por tipo de envío en un solo método con 19 decisiones explícitas, CC inicial 20 (1 más 19). La refactorización extrae Strategy por tipo y deja el servicio como selector del algoritmo; las decisiones propias de cada precio permanecen localizadas y se prueban con límites. JaCoCo cubre los branches de la tarifa genérica con casos base y de recargos. `diagnostico-estatico.md` registra el cálculo estático reproducible y los datos medidos de JaCoCo antes y después.

## Análisis SonarQube

El análisis local quedó registrado con el perfil y gate Estándar Laboratorio. La cobertura combinada pasó de 50,0 % a 100,0 % y la ejecución final aprobó el gate. Consulta la [comparación antes y después](docs/sonarqube.md) y las exportaciones de SonarQube en `docs/`.
