# Proyecto Integrador - Periodo 57

## Publicacion cientifica sobre "Covid-19"

### TEMA DEL PROYECTO

Desarrollo de una aplicación que acceda a una base de datos multidimensional utilizando herramientas de software libre.

### Descripción del Proyecto

El proyecto integrador se compone de dos partes. La primera es un sistema donde se aplicará los conocimientos de Sistemas de Información y Gestión de Base de Datos; mientras que, la segunda parte es la gestión del proyecto, el cual se manejará como si se tratara de un proyecto de Software Libre.
Se debe gestionar una base de datos multidimensional, cuya información provenga de diversas fuentes de datos. Para esto se utilizará las herramientas de Pentaho Community Server. La información sobre la cual se va a tratar, recopila data sobre papers de artículos cientificos del covid-19, la misma está contenida en una base de datos, la cual será presentada utilizando una aplicación web con reportes en PDF y gráficos estadísticos.
Todo el desarrollo del proyecto se lo realizará de manera cooperativa entre todos los miembros del grupo. Los avances, el código fuente y toda la información que se genere durante el proyecto se manejará de forma centralizada a través de un repositorio de código fuente en GitHub.



## Requerimientos Funcionales
### Módulo de Seguridad
Este módulo permite la administración de usuarios (creación de usuarios, cambio de clave, bloqueo de usuarios y consulta de usuarios). Además, en este módulo se guarda el registro de las actividades realizadas en la base de datos mediante auditoría. Existen tres tipos de usuarios: invitado quien no necesita registrarse para acceder a la información pública del portal, administrador quien tiene acceso al módulo de seguridad y usuario registrado que puede visualizar reportes especializados en el módulo de reportes.

### Módulo Reportes
Este módulo consiste en la creación y publicación de reportes avanzados, cuya fuente de información será la base de datos multidimensional (Almacén de datos), cada uno de los reportes deben ser presentados en una aplicación web, desde la cual el usuario ingresará o seleccionará los criterios de búsqueda para generar el reporte. Los reportes deberán ser para contestar las preguntas que cada grupo tendrá en el archivo de requerimientos del Datawarehouse.
Los tipos de reportes que deberán presentar son:
```
• Tipo texto
• Con gráficos de barras
• Con gráficos tipo pastel
```
Además, los reportes tienen que constar de al menos 3 ejes de análisis y deberán ser desarrollados en Pentaho Report Designer (PRD).

### Módulo de invitado
Este módulo se accede sin necesidad de autenticación. Muestra información básica de la aplicación para visitantes. Contiene un resumen de los indicadores que maneja el sistema y gráficas básicas. Los visitantes en esta parte no pueden aplicar filtros ni generar reportes. También debe mostrar información sobre los autores del sistema y los enlaces al repositorio de software.


## Requerimientos no Funcionales
### _Software Libre:_

```
• Definir una licencia para el proyecto que no sea GNU GPL y argumentar la elección.
• Crear un repositorio de software en GitHub con una página de README detallada.
• Crear una Wiki con la documentación más importante del proyecto.
• Crear una página Web del proyecto. (Investigar y utilizar GitHub para esta tarea).
• Evidenciar la participación de todos los miembros en el desarrollo del proyecto.
```

### _Sistemas de Información:_

```
• Usar como lenguaje de programación JSF- JavaServer Faces
• Usar el ciclo de vida en espiral para el desarrollo del software
• Los reportes deben exportarse en formato PDF o .xlsx
```






## Autores 


* **Lomas Alvaro** - *Documentación y Trabajo Inicial* - [Alvaro Lomas](https://github.com/AlvaroLomas)
* **Mariño Daniel** - *Documentación y Trabajo Inicial* - [Daniel Mariño](https://github.com/dmarinoz)
* **Pillajo Jhony** - *Documentación y Trabajo Inicial* - [Jhony Pillajo](https://github.com/jpillajo)
* **Sarmiento Steven** - *Documentación y Trabajo Inicial* - [Steven Sarmiento](https://github.com/StevenSarmiento1)
