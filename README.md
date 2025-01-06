# ChallengeAutomation - Framework de Pruebas Automatizadas
## Descripción del Proyecto
Este proyecto está diseñado para realizar pruebas automatizadas en aplicaciones web y servicios RESTful. Basado en Selenium, Cucumber, Java, Maven y TestNG.
## Configuración inicial
Antes de comenzar con el proyecto, es necesario realizar una serie de configuraciones iniciales para garantizar que el entorno de pruebas esté correctamente configurado.

# Configuración Git y Clonado de Repositorio
1. Posicionate en la carpeta donde se alojará el proyecto.
2. Clona el repositorio desde [LINK](https://github.com/Luisgaranton/ChallengeAutomation.git) 

## configuracion local
1. Abre el ide a elección, nosotros usaremos intellij.
2. File/Project Structure... Project/SDK : java 17.
3. Asegúrate de que Maven esté configurado correctamente: 3.6.0 o superior.

## navegadores soportados
1. Google Chrome
2. Mozilla Firefox
3. Microsoft Edge
  
## Como ejecutar por primera vez
1. Abre el IDE a eleccion (para este ejemplo esta basado en el IDE: intellij).
2. Ingresa a la carpeta raiz del proyecto (Challenge-Crowdar).
3. Dirigete a Menu/Run/edit configurations... Agrega una configuracion nueva, de tipo TestNG.
4. Completa lo siguiente:
* Class:  runners.TestRunner
* VM options:(puedes ajustar los valores según tus necesidades) :

      -Dcucumber.filter.tags="@Login" 
      -Ddataproviderthreadcount=1 
      -DSELENIUM_GRID_ENABLED=off 
      -DSELENIUM_GRID_BROWSER=Edge

5. Ejecuta con boton Run.

## Etiquetas Disponibles
1. @Login
2. @Shopping
3. @Api
4. @LOGIN_001
5. @CART_001
6. @TC-API-001

## Reporte
1. Luego de ejecutar tu prueba se generara un archivo en formato HTML.
2. Dirigete a: target/cucumber-reports.html.
3. Abre el reporte en tu navegador de preferencia.

¡Ya estás listo para comenzar a trabajar en el proyecto! \
¡Gracias!