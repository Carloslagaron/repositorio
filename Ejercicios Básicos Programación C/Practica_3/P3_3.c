#include <stdio.h>
#include <string.h>
int main () {
	
	char cadena[20],caracter;
	int longitud,i,numcar;
	
		do {
	
		fprintf(stdout,"Dame una cadena (1-20 caracteres): "); 
		fscanf(stdin,"%s",cadena);
		
		longitud=strlen(cadena);
	
		if (longitud <= 20 && longitud >=1) {
			fprintf(stdout,"Dame un caracter: ");
			fscanf(stdin," %c",&caracter);
		}
		else {
			if (longitud> 20 || longitud <1) {
				fprintf(stdout,"Longitud excesiva\n");
			}	
		}
		} while (longitud> 20 || longitud <1);
		
		for (i=0;i<longitud;i++) {
			if (caracter == cadena[i]-1) {
					numcar= numcar+1;
			}
		}
		
		fprintf(stdout,"El caracter %c esta repetido %i veces.", caracter,numcar);
	
	
	
	return 0;		
}

