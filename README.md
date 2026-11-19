# fixgo-execution-service

Microservicio de ejecución técnica de FixGo: confirmación de propiedad, informe de servicio y garantía.

**Fase 1:** RF4.3 (verificación de propiedad), RF4.4 (informe de servicio) y RF4.9 (garantía) del SRS 3.1.

| Dato | Valor |
|---|---|
| Puerto | 8085 |
| Base de datos | `fixgo_execution` (MySQL) |
| Migraciones | Flyway (`src/main/resources/db/migration`) |
| Hibernate | `ddl-auto=validate` |
| Swagger | http://localhost:8085/swagger-ui.html |
| Responsable | Gabriel Tijaro Jiménez |

##
1. Base de datos vacía `fixgo_execution` en MySQL.
2. Variables de entorno (CMD): `set DB_PORT=3306` y `set DB_PASSWORD=su_clave`.
3. `mvnw.cmd spring-boot:run` (Linux: `./mvnw spring-boot:run`).

## Reglas

- Solo se guardan ids de otros servicios (`requestId`, `professionalId`); no hay consultas a otras bases.
- Una confirmación de propiedad por solicitud.
- Un informe por ciclo: `UNIQUE(request_id, cycle)`. El ciclo lo calcula el servicio (1 para el primer informe, +1 por cada reapertura).
- Un nuevo ciclo solo se abre si el informe anterior tiene garantía vigente (días mayores a 0 y sin vencer).
- Garantía de 0 a 365 días; valor final mayor o igual a 0; trabajo realizado obligatorio.

## Endpoints

| Método | Ruta | Qué hace |
|---|---|---|
| GET | `/api/ownership-confirmations` | Listar confirmaciones |
| GET | `/api/ownership-confirmations/request/{requestId}` | Confirmación de una solicitud |
| POST | `/api/ownership-confirmations` | Confirmar propiedad |
| GET | `/api/service-reports` | Listar informes |
| GET | `/api/service-reports/{id}` | Buscar por id |
| GET | `/api/service-reports/request/{requestId}` | Historial de ciclos |
| GET | `/api/service-reports/request/{requestId}/latest` | Último informe |
| POST | `/api/service-reports` | Registrar informe (calcula el ciclo) |

Errores: 400 (datos inválidos), 404 (no existe), 409 (duplicado o garantía no vigente).
