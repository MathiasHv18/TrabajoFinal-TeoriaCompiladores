abrir terminal en la ruta del proyecto y ejecutar los siguientes comandos:

docker build -t trabajofinal .

docker run -it -v 'RUTADELPROYECTO\TrabajoFinal-TeoriaCompiladores:/app' trabajofinal

Ejemplo:

docker run -it -v 'C:\Users\faboa\Documents\GitHub\TrabajoFinal-TeoriaCompiladores:/app' trabajofinal

ejecutar:

dos2unix app.sh
y luego
./app.sh

Recomendaciones:

Si se desea editar o crear un nuevo script lo puede hacer desde la carpeta test/
Poner la imagen a procesar en el directorio raiz.
