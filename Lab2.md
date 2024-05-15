
**Lab 2**

Crear Entity y  Enums

<img width="1188" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/ac143715-b7c6-406d-947c-6c692d6204ee">

Crear interfaces, 

Interface e implementación de una Orden (Single responsability y Liskob substitution, Segregation interface)
<img width="923" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/b5d3433d-00ad-4278-a89c-704f0792d14a">


La implementación anterior hace uso de un Factory para determinar instancia de un Pago Express o Pago Standard por medio del type (Single responsability)
<img width="917" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/d11191f0-5327-4619-8985-f5a4aab95bf6">


Aqui las implementaciones especificas de pago Express o Standard (Single responsability)
<img width="1463" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/5f32e8a6-ea5a-4122-ac90-0a73e154667c">

implementación del pago en especifico con sobrecarga de metodos, ya que uno es con prioridad y otro solo con el monto (tambien se puede hace runa interface e implementación para cada metodo, para segregarlo más) (Inversion de control , no esta acoplado el como hace el pago a las clases superiores)
<img width="774" alt="image" src="https://github.com/fernandocortesspin/TestIronHack/assets/112406656/7d520a41-6159-4a49-a915-8049d742a9f8">

