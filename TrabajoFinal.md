Trabajo Final Java Intermedio 2020
==================================

Este documento describe los primeros requisitos para el Trabajo Final Práctico de la materia. Este documento será actualizado durante el transcurso de las siguientes clases.

Descripción del Trabajo
------------------------ 

El trabajo plantea el desarrollo de la aplicación de soporte para una tienda de aplicaciones (al estilo de Google Play, Apple Store, etc.). 

Para esta aplicación, existen los siguientes conceptos:

Usuarios
--------

Los usuarios pueden ser desarrolladores o consumidores. Todos los usuarios son consumidores al registrarse y se convierten en Desarrolladores en el momento que suben su primera aplicación. Si un usuario se convierte en desarrollador, en ese momento se le asigna un "e-shop" personal en el cuál podrá gestionar las aplicaciones que publica.

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


Requerimientos iniciales
------------------------

El sistema debe:

1.	Permitir el login de un usuario a la aplicación mediante el uso de nombre de usuario y contraseña. Si el usuario no posee una cuenta registrada, debe permitir el registro de una cuenta.
2.	Permitir las operaciones de modificación de nombre de usuario y de password (siempre que el usuario se haya logueado exitosamente)
3.	Presentar la pantalla principal para el usuario con un mensaje de bienvenida que incluya su nombre
4.	Presentar a los usuarios un listado de aplicaciones disponibles para la compra permitiendo, además, filtrar por nombre (aquellas que contengan cierto cadena) y las que son más baratas que cierto valor cargado.
5.	Brindar la posibilidad de publicar una aplicación para su venta.
