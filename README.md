# Extracción de conocimiento con la herramienta TIKA
---

## Resumen

Este proyecto consiste en aprender los conceptos básicos de la extracción de conocimiento de un **sistema de recuperación de información**. Por ello se utiliza **TIKA**, una herramienta con un gran número de funcionalidades y a su vez sencilla de explorar desde un punto básico de conocimiento.

En concreto la información que se extrae con TIKA no es más que las ocurrencias de unos libros, en diferentes idiomas para poder realizar comparaciones, además se extraen los Links, en caso de que los hubiera, y los metadatos de los ficheros.

[Documentación](https://github.com/ivancete/InformationRetrieval-TIKA/blob/master/documentacion.pdf)
## Extracción de ocurrencias

La parte principal de este mini proyecto consiste en la extracción de ocurrencias, y para ello debemos en primer lugar de **Tokenizar** el texto y almacenar en una estructura de datos los términos resultantes. 

[Código fuente](https://github.com/ivancete/InformationRetrieval-TIKA/tree/master/src)

## Extracción de gráficas

En esta sección, una vez almacenados los términos con sus ocurrencias en una estructura de datos, debemos de obtener una serie de gráficas. Las gráficas a obtener son:

 1. En el eje Y el número de ocurrencias y en el eje X el término en concreto.

 2. En el eje Y el número de ocurrencias y en el eje X el término en concreto. Pero en este caso los datos tanto del eje Y como del eje X en forma logarítimica. 
 
 3. En el eje Y el número de ocurrencias y en el eje X el término en concreto. Pero en este caso los datos tanto del eje Y como del eje X en forma logarítimica y con un ajuste lineal para obtener las constantes **a** y **b** de la ecuación **y = ax + b**.
 
Esto se hace por la **Ley de Zipf**.

[Script de Gnuplot](https://github.com/ivancete/InformationRetrieval-TIKA/blob/master/p.gnu)

### Nota final

Los libros han sido extraídos del proyecto Gutenberg. 

[Libros en formato EPUB](https://github.com/ivancete/InformationRetrieval-TIKA/tree/master/datosEntrada)

## Bibliografía

>## Ley de Zipf
>https://es.wikipedia.org/wiki/Ley_de_Zipf

>## Proyecto Gutenberg
>https://www.gutenberg.org/browse/languages/es
