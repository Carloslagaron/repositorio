#include <stdio.h>
#include <string>

int main ()	{
	
char opcion;
	
	fprintf(stdout,"Seguro que desea salir del programa? (s/n): ");
	fscanf(stdin,"%c",&opcion);
	
	opcion=tolower(opcion);
	
	if (opcion == 's' ) {
		fprintf(stdout,"Has seleccionado 'Si'.");
	}
	else {
		if (opcion == 'n') {
			fprintf(stdout,"Has seleccionado 'No'.");
		}
		else fprintf(stdout,"No ha seleccionado una opcion valida.");
	}

	
	return 0;
}
