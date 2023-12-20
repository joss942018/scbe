# scbe
## Instalación
correr el siguiente comando: <br>
./mvnw spring-boot:run
# Arquitectura
La arquitectura que se empleó para este proyecto es Domain-Driven Design (DDD) que se centra en modelar el dominio del negocio y estructurar el código en torno a este dominio, es especialmente útil para aplicaciones empresariales
## Capas del proyecto
### Config
- **Objetivo**: Gestiona la configuración general de la aplicación.
- **Responsabilidades**: Incluye clases para configurar aspectos cruciales del sistema, como la seguridad, la base de datos y la integración con otras herramientas o servicios.
- **Características Clave**: Centraliza la configuración, facilitando la gestión y el mantenimiento.
### Controller
- **Propósito**: Actúa como el punto de entrada para las interacciones del usuario o las solicitudes API.
- **Funciones Principales**: Mapea las solicitudes entrantes a acciones específicas en la aplicación, retornando las respuestas adecuadas.
- **Importancia**: Esencial para el manejo de solicitudes y respuestas en una arquitectura basada en API REST.
### Domain
- **Enfoque**: Modela los conceptos del dominio empresarial, sus datos y reglas de negocio.
- **Elementos**: Incluye entidades, objetos de valor y otros elementos del dominio.
- **Relevancia**: Es el núcleo de la aplicación, donde se define la lógica de negocio.
### Exception
- **Finalidad**: Define las excepciones personalizadas para manejar errores específicos de la aplicación.
- **Utilización**: Permite una mejor gestión de errores y una respuesta más clara a situaciones excepcionales.
- **Ventajas**: Facilita la depuración y mejora la experiencia del usuario al proporcionar mensajes de error más descriptivos.
### Repository
- **Función**: Abstrae el acceso a los datos, proporcionando una manera de consultar y modificar entidades del dominio.
- **Características**: Puede incluir métodos para operaciones CRUD y consultas más complejas.
- **Beneficios**: Desacopla la lógica del negocio de los detalles de acceso a datos, promoviendo la separación de responsabilidades.
### Service
- **Propósito**: Contiene la lógica de negocio que no pertenece naturalmente a entidades de dominio o repositorios.
- **Roles**: Orquesta entre diferentes componentes de dominio y maneja casos de uso de negocio.
- **Importancia**: Proporciona una capa de abstracción que ayuda a mantener el código del dominio y los controladores limpios y enfocados.


