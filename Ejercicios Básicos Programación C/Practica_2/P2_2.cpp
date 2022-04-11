#include <stdio.h>
#include <string>

int main ()	{
	
char opcion;
	
	fprintf(stdout,"Seguro que desea salir del programa? (s/n): ");
	fscanf(stdin,"%c",&opcion);
	
	opcion=tolower(opcion);
	
	if (opcion == 's') {
		fprintf(stdout,"Has seleccionado 'Si'.");
	}
	else fprintf(stdout,"Has seleccionado 'No.'");
	
	return 0;
}
