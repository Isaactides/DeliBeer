# DeliBeer
## Practica de Desarrollo de aplicaciones distribuidas


El nombre de nuestra aplicación web es el de "DeliBeer", en la cual se podrán comprar diferentes packs de cervezas de 2, 5, 8 y 10 unidades. Estas cervezas, según el mes, irán variando, para que así los clientes puedan tener una oferta más variada de distintos tipos de cervezas del mundo. Cada pack de cerveza tendrá asociado un tablón de comentarios donde los usuarios que han realizado un pedido con ese pack podrán dejar sus valoraciones.

Se podrá visualizar el catálogo de la tienda sin estar registrado en la página web, pero para poder acceder a comentarios y valoraciones del producto y realizar un pedido, es necesario registrarse.

En esta web existirán dos tipos de usuarios:
 - **Usuario lite**: Será un usuario gratuito y podrá realizar compras de packs de cervezas predeterminados que irán variando cada mes. Los gastos de envío correrán a cuenta del usuario.
 - **Usuario premium**: Para poder ser un usuario premium se debera pagar una cuota anual de 20 euros y este usuario podrá realizar una selección de las cervezas que querrá incluir en su pack, teniendo acceso a todo el catálogo de cervezas. Además de tener las mismas ventajas que el usuario premium. Los gastos de envío serán gratuitos.

Como administradores de la página web tendremos acceso a la creación de los packs mensuales y a la modificación de la base de datos de cervezas.

Los pack de cervezas serán los siguientes:

 - **1.** ***Pack pareja*** (2 cervezas).
 - **2.** ***Pack inicial*** (5 cervezas).
 - **3.** ***Pack profesional*** (8 cervezas).
 - **4.** ***Pack fiesta*** (10 cervezas).
 
 Exisitirá una aplicación complementaria que se encargará de generar PDFs con el resumen del pedido realizado y que se enviará a la dirección de correo del usuario.

### Entidades:
- **Productos:** Diferentes packs de cerveza ofertados en la Web.
- **Usuarios:** Cliente que realiza pedidos y escribe comentarios del producto.
- **Pedidos:** Productos del catálago que han sido comprados por un usuario.
- **PDFs:** Resumen del pedido realizado por el usuario.
- **Comentario**: Comentario de los usuario sobre los packs de cerveza donde dejaran sus valoraciones sobre ellos.

### Descripcion del servicio interno.
- Se generará un PDF con el resumen del pedido y se enviará al correo de los usuarios.
- Se notificará mediante un correo electrónico a los usuarios cada vez que se actualice el catálogo mensual de los packs.

Integrantes del equipo de desarrollo: (Isaac Timón de Santos - i.timon.2017@alumnos.urjc.es) ( Angel Colliga Garcia - aj.colliga.2017@alumnos.urjc.es) (Iván López Vázquez - i.lopezv.2017@alumnos.urjc.es) https://github.com/Isaactides/DeliBeer.git
