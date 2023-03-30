Dado el programa, se han detectado que no se cumplen 2 principios SOLID. 
A continuación se listan dónde no se cumplen y sus posibles soluciones:

1.Principio de Responsabilidad Única:
    -En la clase File vemos que cumple dos funciones, por un lado vemos que maneja 
    la gestión de archivos y abajo del todo vemos dos métodos que realizan conversiones de formatos de audio.
    Esto lo podríamos solucionar creando dos interfaces, una que convierta a un formato y otra al otro y, 
    si según nuestras necesidades solo necesitamos una de las conversiones, invocamos una de estas interfaces en nuestra clase.
    Separando la responsabilidad de las conversiones de audio, podríamos dejar la gestión de ficheros tal y como está.

2.Principio de Segregación de Interfaces:
    -En la clase File este principio no se aplica ya que tenemos muchos métodos que estamos obligados a 
    implementar por implementar de la interfaz “FileSystemItem”.
    Esto lo podríamos solventar separando los métodos que no son relevantes para File en una 
    interfaz separada y así cumplir con este principio.
    -En la clase Directory tampoco se cumple este principio ya que tenemos una cantidad enorme 
    de métodos que no usaremos para gestionar directorios ya que no tiene sentido.
    
    La solución a este problema y al anterior se solucionaría agrupando todos los métodos de 
    la interfaz “FileSystemItem” por funciones e ir implementándolas según tengamos necesidad o no.
    La visión correcta para dividir estos métodos sería en estas interfaces, por ejemplo,  los siguientes:

    -INav (interfaz con la que iremos gestionando las rutas): getName(), setName(), setParent(), getParent() y getFullPath().
    -IFiles (interfaz con la que nos encargaremos de la gestión y manipulación de archivos): getExtension(), addFiles(), read(), write(), open(), close(), getSize() y setPosition().
    -IDir (interfaz con la que nos encargaremos de la gestión y manipulación de directorios): listFiles(), addFiles() y removeFiles().
