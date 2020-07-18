Trabajo Final Java Intermedio 2020
==================================

Este documento describe los primeros requisitos para el Trabajo Final Práctico de la materia. Este documento será actualizado durante el transcurso de las siguientes clases.

Descripción del Trabajo
------------------------ 

El trabajo plantea el desarrollo de la aplicación de soporte para una tienda de aplicaciones (al estilo de Google Play, Apple Store, etc.). Se recomienda tomar como base el proyecto "AppStore" de este mismo repositorio, sin embargo, tienen la libertad para iniciar un proyecto desde cero, sin ningún problema.

Para esta aplicación, existen los siguientes conceptos:

Usuarios
--------

Los usuarios pueden ser desarrolladores o consumidores. Todos los usuarios son consumidores al registrarse y se convierten en Desarrolladores en el momento que suben su primera aplicación. 

Los usuarios se identifican por un nombre de usuario (que debe ser único en el sistema) y tienen asociada una contraseña pero, además, la plataforma conoce de ellos:

*	Nombre y Apellido
*	DNI
*	Email (Debe ser único en el sistema)


Aplicaciones
------------

Las aplicaciones son siempre publicadas por un usuario. Para publicar una aplicación, el usuario debe cargar (al menos):

*	Nombre de la aplicación
* 	Descripción
*	Precio para adquirirla

Adicionalmente, durante la vida de una aplicación en la tienda, la misma irá ganando un puntaje (en base a la gente que decida dejar su puntaje y opinión). 


Requerimientos 
--------------

El sistema debe:

1.	Permitir el login de un usuario a la aplicación mediante el uso de nombre de usuario y contraseña. Si el usuario no posee una cuenta registrada, debe permitir el registro de una cuenta.
* Se recomienda que pongan un botón en la pantalla de Login que diga "Registrarse". Este botón abriría otra ventana para que el usuario cargue sus datos y se almacenen en la base de datos
* Se debe verificar que no exista otro usuario con el mismo nombre antes de permitir que se registre
2.	Presentar la pantalla principal para el usuario con un mensaje de bienvenida que incluya su nombre
3.	Permitir las operaciones de modificación de nombre de usuario y de password (siempre que el usuario se haya logueado exitosamente)
* Una opción podría ser que (una vez logueado), el usuario haga click en su nombre y le permita actualizar sus datos.
4.	Presentar a los usuarios un listado de aplicaciones disponibles para la compra.
* Se considera que está disponible para la compra si el usuario logueado no es quién la publicó.
* Se debe permitir filtrar estas aplicaciones por nombre (aquellas que contengan cierto texto en la cadena).
5. Permitir al usuario comprar una aplicacioń. Comprar una aplicación significa que quedará un registro en la base de datos indicando que el usuario "x" compró la aplicación "y". La tabla de la DB será similar a la de "aplicaciones_usuario".
6. Permitir al usuario ver las aplicaciones que compró y calificarlas (seleccionar un valor entre 1 a 5 estrellas para la misma). No es necesario que se registre el histórico de estas calificaciones, se admite actualizar un campo en la tabla "aplicaciones" con el promedio de las calificaciones.
7.	Brindar la posibilidad de publicar una aplicación para su venta.
* Publicar una aplicación significa que se presenta una pantalla donde el usuario puede ingresar los detalles de la aplicación que quiere publicar


