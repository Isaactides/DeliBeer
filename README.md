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

- **Pagina principal**:Aquí podremos encontrar los diferentes packs de cerveza que se pueden comprar, y haciendo click en cada imagen nos redireccionará a la pagina de cada pack en concreto. 
<img width="1437" alt="Portada" src="https://user-images.githubusercontent.com/78824934/110464023-eba6d980-80d2-11eb-86ce-1c19dac6237a.png">


- **Pack pareja**: En esta página podrán adquirir el pack de 2 cervezas los mas tímidos. Tiene asignada una seccion de comentarios y valoración para que los clientes pueden basarse en la opinión de anteriores compradores del pack. Además existen 2 botones, uno para volver hacia atrás en la navegación y otro para comprar el producto.
<img width="1440" alt="Screen Shot 2021-03-09 at 13 01 14" src="https://user-images.githubusercontent.com/78824934/110467731-a638db00-80d7-11eb-89b0-9d8bf5d12064.png">

- **Pack inicial**:En esta página podrán adquirir el pack de 5 cervezas los que ya están metidos en el mundillo de la cerveza. Tiene asignada una seccion de comentarios y valoración para que los clientes pueden basarse en la opinión de anteriores compradores del pack. Además existen 2 botones, uno para volver hacia atrás en la navegación y otro para comprar el producto.
<img width="1440" alt="Inicial" src="https://user-images.githubusercontent.com/78824934/110464208-2a3c9400-80d3-11eb-96af-0cab3ce8f2aa.png">

- **Pack profesional**:En esta página podrán adquirir el pack de 8 cervezas los que se aventuran a tener un día movidito. Tiene asignada una seccion de comentarios y valoración para que los clientes pueden basarse en la opinión de anteriores compradores del pack. Además existen 2 botones, uno para volver hacia atrás en la navegación y otro para comprar el producto.
<img width="1440" alt="Profesional" src="https://user-images.githubusercontent.com/78824934/110464288-404a5480-80d3-11eb-98e8-3043baf4b6cc.png">

- **Pack fiesta**:En esta página podrán adquirir el pack de 10 cervezas los que están dispuestos a tener la mejor fiesta de la historia. Tiene asignada una seccion de comentarios y valoración para que los clientes pueden basarse en la opinión de anteriores compradores del pack. Además existen 2 botones, uno para volver hacia atrás en la navegación y otro para comprar el producto.
<img width="1440" alt="Screen Shot 2021-03-09 at 13 01 26" src="https://user-images.githubusercontent.com/78824934/110467760-adf87f80-80d7-11eb-8aa5-62f1cb85122a.png">

- **Pagina compra**: A esta página podremos acceder desde las pestañas de cada uno de los packs para realizar el pedido de ese pack. El usuario debera rellenar un formulario con sus datos que se añadiran al pedido.
<img width="1440" alt="CompraPareja" src="https://user-images.githubusercontent.com/78824934/110464374-59530580-80d3-11eb-9248-dda1116b9342.png">

- **Pagina resumen pedido**: En esta página se mostraran los datos ue ha introducido el usuario en el formulario de la compra, además del tipo de pack que ha seleccionado.
<img width="1440" alt="ResumenPedido" src="https://user-images.githubusercontent.com/78824934/110464543-899aa400-80d3-11eb-9871-46d9d7476c19.png">

### Diagrama de Navegacion

![image](https://user-images.githubusercontent.com/60182691/110465082-44c33d00-80d4-11eb-9bcd-49c775e96591.png)


Integrantes del equipo de desarrollo: (Isaac Timón de Santos - i.timon.2017@alumnos.urjc.es) ( Angel Colliga Garcia - aj.colliga.2017@alumnos.urjc.es) (Iván López Vázquez - i.lopezv.2017@alumnos.urjc.es) https://github.com/Isaactides/DeliBeer.git
