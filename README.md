# Operaciones con Numeros Complejos
Aqui se encuentra una calculadora para operar numeros complejos.
Se tiene un main para hacer la entrada desde teclado y unos tests para validar que todas las funcionalidades esten correctas.

## Funcionalidades
Esta calculadora ofrece las siguientes operaciones:
* Suma
* Resta
* Multiplicacion
* Division
* Modulo
* Conjugado
* Conversion entre representaciones polar y cartesiano
* Fase
* Adición de vectores complejos.
* Inversa de vectores complejos.
* Multiplicación escalar de vectores complejos.
* Adición de matrices complejos.
* Inversa de matrices complejos.
* Multiplicación escalar de matrices complejas.
* Matriz transpuesta
* Matriz conjugada
* Matriz adjunta
* Función para calcular la "acción" de una matriz sobre un vector.
* Norma de matrices
* Distancia entrematrices
* Revisar si es unitaria
* Revisar si es Hermitian
* Producto tensor.

## Empezando 
Para usar esta calculadora, clone el repositorio o descargue el archivo zip del repositorio.

## Prerrequisitos
Debes tener maven para compilar este proyecto. Vaya a https://maven.apache.org/ y siga las instrucciones para instalarlo.

## Usando la Calculadora
- Abrir un cmd en el folder de esta calculadora
- Compilarlo en el cmd:
  ```
  mvn package
  ```
- Ejemplo para el uso de la suma de 2 numeros complejos:
  ```
  CalcuComple.suma(numeroComplejo1, numeroComplejo2);
- Ejemplo para el uso de la resta de 2 numeros complejos:
  ```
  CalcuComple.resta(numeroComplejo1, numeroComplejo2);
- Ejemplo para el uso de la multiplicacion de 2 numeros complejos:
  ```
  CalcuComple.multiplicacion(numeroComplejo1, numeroComplejo2);
- Ejemplo para el uso de la division de 2 numeros complejos:
  ```
  CalcuComple.division(numeroComplejo1, numeroComplejo2);
- Ejemplo para el uso del modulo de un numero complejo:
  ```
  numeroComplejo.modulo();
- Ejemplo para el uso del conjugado de un numero complejo:
  ```
  numeroComplejo.conjugado();
- Ejemplo para el uso de la fase de un numero complejo:
  ```
  numeroComplejo.getFase();
- Ejemplo para el uso de conversion de coordenadas cartesianas a polares de un numero complejo:
  ```
  CalcuComple.cartesianaAPolar(numeroComplejo1);
- Ejemplo para el uso de conversion de coordenadas polares a cartesianas de un numero complejo:
  ```
  CalcuComple.polarACartesiana(Math.sqrt(2), Math.PI / 4.0);
  ```

## Correr las Pruebas
Para ejecutar las pruebas, puede abrir el cmd en la carpeta de este proyecto y ejecutar.
```
mvn test
```

## Pruebas
Estas pruebas certifican la correcta implementación de las diferentes operaciones.
```
@Test
	public void sumsTest() {
		NumComple c1 = new NumComple(3, -1);
		NumComple c2 = new NumComple(1, 4);
		NumComple result = CalcuComple.suma(c1, c2);
		NumComple expected = new NumComple(4, 3);
		assertEquals(expected, result);
	}
```
## Lenguaje de Programacion
Esta calculadora esta hecha en el lenguaje de programacion Java.

## Autor
- Sergio Alejandro Peña Pinto

