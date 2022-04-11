#include <stdio.h>
#include <string.h>
int main () {
	
	char cadena[15];
	int longitud;
	
	fprintf(stdout,"Dame una cadena (1-15 car): "); fscanf(stdin,"%s",&cadena);
	longitud=strlen(cadena);
	if (longitud <= 15) {
	fprintf(stdout,"La cadena tiene %i caracteres.", longitud);
	}
	else fprintf(stdout,"Longitud excesiva");
	return 0;
}
