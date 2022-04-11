#include <stdio.h>
#include <math.h>

int main () {
	
	float base,altura,area,perimetro,lado;
//En primer lugar leemos los datos del triangulo, base y altura
	
	fprintf(stdout,"Dame la base: "); fscanf(stdin,"%f",&base);
	fprintf(stdout,"Dame la altura: "); fscanf(stdin,"%f",&altura);
	
//Realizamos los calculos para obtener los lados laterales a traves del th de pitagoras
// y asi poder calcular el perimetro

	lado= sqrt((altura*altura)+(base/2*base/2));
	area= (base*altura)/2;
	perimetro= 2*lado+base;
	
	fprintf(stdout,"Altura: %f	cm\nBase: %f	 cm\n Area: %f	cm x cm\nPerimetro: %f	cm",altura,base,area,perimetro);

	return 0;
}
