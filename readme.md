# Automatización E2E - Demoblaze con Serenity BDD

## Descripción
Este proyecto implementa una prueba funcional automatizada (E2E) del flujo de compra en [demoblaze.com](https://www.demoblaze.com/) utilizando Serenity BDD y Java. El flujo automatizado cubre:
- Agregar dos productos diferentes al carrito
- Visualizar el carrito
- Completar el formulario de compra
- Finalizar la compra

## Requisitos
- **Java JDK 17**
- **Maven 3.8+**
- **Google Chrome** (última versión recomendada)

## Instalación y ejecución
1. Clona el repositorio:
   ```sh
   git clone <URL_DEL_REPOSITORIO>
   cd automatizacion
   ```
2. Ejecuta las pruebas:
   ```sh
   mvn clean verify
   ```
3. Visualiza el reporte Serenity:
   - Abre `target/site/serenity/index.html` en tu navegador.

## Tecnologías utilizadas
- Serenity BDD: 4.2.34
- JUnit Jupiter: 5.10.2
- AssertJ: 3.25.3
- SLF4J: 2.0.12

## Notas
- Si encuentras problemas de dependencias, ejecuta primero:
  ```sh
  mvn clean install
  ```
- El flujo es robusto ante cambios menores en la UI y sincronización de elementos.

## Autor
Nathaly Moncayo

