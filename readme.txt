INSTRUCCIONES DE EJECUCIÓN

Este proyecto automatiza el flujo de compra E2E en https://www.demoblaze.com/ usando Serenity BDD y Java.

REQUISITOS:
- Java JDK 17
- Maven 3.8 o superior
- Google Chrome (última versión recomendada)

PASOS PARA EJECUCIÓN:
1. Clonar el repositorio:
   git clone <URL_DEL_REPOSITORIO>
2. Ingresar al directorio del proyecto:
   cd automatizacion
3. Ejecutar las pruebas:
   mvn clean verify
4. Visualizar el reporte Serenity:
   Abrir target/site/serenity/index.html en el navegador.

TECNOLOGÍAS Y VERSIONES:
- Serenity BDD: 4.2.34
- JUnit Jupiter: 5.10.2
- AssertJ: 3.25.3
- SLF4J: 2.0.12

NOTAS:
- Si hay problemas de dependencias, ejecute primero: mvn clean install
- El flujo es estable y reproduce el proceso de compra real, incluyendo manejo de alertas y sincronización de elementos.
