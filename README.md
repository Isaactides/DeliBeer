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

### Diagrama de clases UML
<img width="996" alt="Screen Shot 2021-03-08 at 13 52 57" src="https://user-images.githubusercontent.com/78824934/110324135-de77e500-8015-11eb-9530-cf7d71823cd1.png">

### Capturas de las principales paginas 
-**Pagina principal**
<img width="1437" alt="Portada" src="https://user-images.githubusercontent.com/78824934/110464023-eba6d980-80d2-11eb-86ce-1c19dac6237a.png">
---------------------------------------------------------------------------------------
-**Pack pareja**
<img width="1440" alt="Pareja" src="https://user-images.githubusercontent.com/78824934/110464091-feb9a980-80d2-11eb-9284-b578616b773d.png">
---------------------------------------------------------------------------------------
-**Pack inicial**
<img width="1440" alt="Inicial" src="https://user-images.githubusercontent.com/78824934/110464208-2a3c9400-80d3-11eb-96af-0cab3ce8f2aa.png">
---------------------------------------------------------------------------------------
-**Pack profesional**
<img width="1440" alt="Profesional" src="https://user-images.githubusercontent.com/78824934/110464288-404a5480-80d3-11eb-98e8-3043baf4b6cc.png">
---------------------------------------------------------------------------------------
-**Pack fiesta**
<img width="1440" alt="Fiesta" src="https://user-images.githubusercontent.com/78824934/110464320-493b2600-80d3-11eb-8880-8cd805497034.png">
---------------------------------------------------------------------------------------
-**Pagina compra**
<img width="1440" alt="CompraPareja" src="https://user-images.githubusercontent.com/78824934/110464374-59530580-80d3-11eb-9248-dda1116b9342.png">
---------------------------------------------------------------------------------------
-**Pagina resumen pedido**
<img width="1440" alt="ResumenPedido" src="https://user-images.githubusercontent.com/78824934/110464543-899aa400-80d3-11eb-9871-46d9d7476c19.png">
---------------------------------------------------------------------------------------

Integrantes del equipo de desarrollo: (Isaac Timón de Santos - i.timon.2017@alumnos.urjc.es) ( Angel Colliga Garcia - aj.colliga.2017@alumnos.urjc.es) (Iván López Vázquez - i.lopezv.2017@alumnos.urjc.es) https://github.com/Isaactides/DeliBeer.git
