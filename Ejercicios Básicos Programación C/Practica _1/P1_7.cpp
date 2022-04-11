#include <stdio.h>
#include <string.h>
int main () {
	
	char cadena[100];
	int longitud;
	
	fprintf(stdout,"Introduce una cadena: "); fscanf(stdin,"%s",&cadena);
	longitud=strlen(cadena);
	fprintf(stdout,"La cadena tiene %i caracteres.", longitud);
	
	return 0;
}
