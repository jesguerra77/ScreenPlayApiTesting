#Api Testing Java - Screen Play

El framework de Automatización esta compuesto de las siguientes herramientas

`Cucumber`

`Gherkin`

`Java 8`

`Screen play pattern`

`Serenity BDD`

`Junit`

`Serenity Rest`

##Compilación proyecto
 Descargar el proyecto como build Maven (Asegurarse de descargar todas la dependencias correspondientes)
     
    ` mvn clean`
    
    ` mvn compile`
     
    ` mvn install`
    
##Instalar complementos
 Instalar los siguientes puglings

    `a) Cucumber for java`
    
     `c) Gherkin for java` 
     
     `b) Lombok for java`
     
    Asegurese de que las versiones instaladas sean compatibles con su versión de intellij
    
##Ejecución
 Ejecución de los escenarios espeficicados en **BDD**    

 `cd ApiTesting / mvn clean verify -Dcucumber.filter.tags="backend"`
 
 Econtrará tags de cucumber que hacen referencia a los comportamientos de cada escenarios por ejemplo:
 
` @backend : todos los escenarios de intreacciones API`
 
 `@createUser : escenarios con interacciones de creación de usuarios`
 
` @updateUser : escenarios correspondientes a la interacciones de actualizar usuarios`
 
` @deleteUser : escenarios correspondientes a la eliminación de usuarios`
 
 `@queryUser : escenarios correspondientes a la consulta de usuarios.` 
 
` @un-happyPath  : escenarios que validan exepciones `
 
 `@dataBaseTest : escenarios que contienen interacción con BD`
 


 Tambien podra generar un runner de intellij con la herramienta Junit con los siguientes parámetros
 
` class : ApiRestAutomation.runners.Runner`
  
`  VM -OPTIONS -ea -Dcucumber.filter.tags="@createUsers"  `

##generación de reporte de pruebas

EL reporte generado por serenity puede ser consultado en la ruta : `target/site/serenity` Abrir archivo index.html

en caso de requerir generar reporte ejecutar : `mvn serenity:aggregate`

##Escenarios BDD

Los escenarios especificados en BDD se encuentran en la siguiente ruta 

`src/test/resources/features`

##Ejecución Contenedor Docker - jenkis

Se encuentra en construcción, ya se logró despluegar jenkins en el contendedor local docker, se esta trabajando en la ejecución
de la imagen maven donde correran los diferentes escenarios.
