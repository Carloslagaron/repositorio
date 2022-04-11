#include <stdio.h>

int main () {
	
	int ID;
	char Nombre[20],cadena[50];
	char a,extra;
	int caso=1;
	do {
	
	fprintf(stdout,"Introduce la cadena con el formato dado (ID Ejemplo_Nombre): ");
	fgets(cadena,50,stdin);
	sscanf(cadena,"%d%c%s%c",&ID,&a,&Nombre,&extra);
	caso=2;
	if (ID== 0) {
		fprintf(stdout,"Formato no valido.\n");
	} 
	else {
		if (a != ' ') {
			fprintf(stdout,"Formato no valido. \n");
		} 
		else {
			if (extra == ' ') {
				fprintf(stdout,"Formato no valido\n");
			} 
			else {
			caso = 1;
			}
		}
	}
	
	}while (caso!= 1);
	
	fprintf(stdout,"ID: %d \nNombre: %s", ID, Nombre);
	return 0;
	
}

