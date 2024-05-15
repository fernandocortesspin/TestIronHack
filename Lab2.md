
**Lab 2**

Las clases se encuentran en este repo en la ruta/package src/main/java/com/fernando/lab/two

Crear Entity y  Enums

<img width="1188" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/ac143715-b7c6-406d-947c-6c692d6204ee">

Crear interfaces, 

Interface e implementación de una Orden (Single responsability,  Segregation interface, Inversion de control ya que esta interface ProcessOrder no le importa como está implementado el pago ))
<img width="923" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/b5d3433d-00ad-4278-a89c-704f0792d14a">


La implementación anterior hace uso de un Factory para determinar instancia de un Pago Express o Pago Standard por medio del type (Single responsability) 

<img width="1025" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/d0b44e2e-80f4-45ff-8541-9a4ae7347b73">


Aqui las implementaciones especificas de pago Express o Standard (Single responsability), usando un repository interno para el proceso atomico
<img width="1473" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/f4ae5e9c-f09d-41c5-96fb-05adede5e9c9">


Una capa repository, para el pago en especifico, si lo hiciera un API de terceros seria un FeignClient interface, o si lo hiciera el mismo microservicio las mismas clases StandardPaymentServiceImpl, y ExpressPaymentServiceImpl tendrían la logica del pago 

<img width="1462" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/74bad053-432c-43a1-95a6-470af84f2e2e">





