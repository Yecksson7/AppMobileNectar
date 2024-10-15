Integrantes:
Matias Toth
Gaston Castro
Yecksson Colmenares

Profe aprendimos un monton realizando la app, pudimos poner en practica muchas cosas vistas durante la cursada, 
sabemos que nos quedaron cosas pendientes por pulir pero por cuestiones de tiempo no pudimos mejorarlas, por un momento
creimos que no llegabamos pero pusimos todo y pudimos entregarle esta version que tenemos hoy en dia.




¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla? 
Intentamos aplicar MVVM, si, con mas tiempo habriamos pulido detalles e implementar mejor la arquitectura

¿Tuvieron objetos stateful y stateless? ¿Cómo definen la elección de los mismos?
Si tuvimos ambos, en las pantallas en las que necesitamos mostrar informacion como la pantalla de detalle utilizamos un stateful
en las que no dependia de la interaccion anterior a la pantalla utilizamos stateless

¿Qué mejoras detectan que podrían realizarle a la app? ¿Tendrían side effect si escala el volumen de datos? Comenten al menos 2 cuestiones a refactorizar y tener en cuenta.

-Utilizar mas persistencia de objetos para poder utilizarlos en las diferentes pantallas
-Hacer una navegacion y un ruteo mas robusto y escalable 
-Ajustar detalles que nos quedaron pendientes 

Consideramos que si tendriamos side effect si escala el volumen de datos

-Refactorizariamos la navegacion
-Refactorizariamos el manejo de objetos entre pantallas 


¿Qué manejo de errores harían? ¿dónde los contemplan a nivel código? Mencionen la estrategia de mapeo que más se adecúe. 

Utilizarimos bloques try catch para controlar los errores, los contemplariamos en las llamadas a las api
en el manejo de los estados de la ui para reflejar el estado de la vista cargando exito o error, la estrategia de mapeo que creemos mas adecuada 
seria mapear datos entre la fuente de datos y un modelo , para asegurar los datos puedan ser utilizados mas facilmente y los manipulemos como objetos 



En el caso de uso de persistencia para Favoritos, ¿que estrategia sugieren?

Consideramos que podriamos establecer un listado en el cual cargariamos los objetos al ser seleccionados para que asi luego 
puedan ser utilizados en la pantalla de favoritos, en el caso de utilizar persistencia en BD creariamos una tabla y vinculariamos el listado de objetos 
bajo el id del usuario logueado


Si la tendríamos que convertir a Español y conservar el Inglés, qué estrategia utilizaría para extenderla. Y si necesitamos agregar otros idiomas?

Creariamos archivos strings.xml para español y lo mismo hariamos para agregar otros idiomas  
