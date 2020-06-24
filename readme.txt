# SimuladorContagios

El software es un simulador de contagios que permite visualizar y analizar la propagación de una enfermedad contagiosa entre la población de una cierta área. Dadas algunas condiciones iniciales (población, dimensiones del área, cantidad de enfermos, etc), el simulador funciona de la siguiente manera:
• Genera N personas en una posición (x,y) aleatoria, dentro de una cierta área, donde alguna de ellas están enfermas. 
• En cada paso, las personas se mueven aleatoriamente, y si una persona sana se encuentra cerca de una enferma, se contagia. 
• Al cabo de un cierto tiempo, las personas enfermas mueren (con una cierta probabilidad) o de lo contrario se recuperan.
Se puede visualizar en tiempo real un mapa (grilla) con la posición de cada persona y su estado (sana, enferma, recuperada o fallecida) y gráficos que muestran la curva de contagios, recuperación y fallecimientos.
Es posible cambiar el comportamiento de las personas (disminuir o aumentar su movilidad, simulando una cuarentena) , la probabilidad de fallecimiento (edad avanzada, otras enfermedades, saturación del sistema sanitario, etc) y  la forma en que se propaga la enfermedad


# Pre-requisitos: 
Para poder correr el programa, el usuario  necesita tener instalado un sistema operativo Microsoft Windows, Mac OS X, GNU/Linux, Solaris y el entorno de ejecución de Java JRE (Java Runtime Environment) actualizado a la ultima version disponible.

# Instalación:
Encontrara en el siguiente link la version mas actualizada del sistema para descargar
El archivo simulador.jar es un archivo de tipo ejecutable que  da inicio el programa
https://drive.google.com/drive/folders/19ubgpriPBDchA6j1QlIhXV7PuHbEBm-b?usp=sharing

# Licencia 
Este proyecto está bajo la Licencia GPL

# Herramientas:
GitHub - control de versiones y gestion de deefectos

Circlci - integracion continua

JUnit - pruebas unitarias

# Autores:
Rueda Horacio

Severini Montanari Alejo

Vega Cuevas Silvia Jimena

Wortley Agustina Daniela
