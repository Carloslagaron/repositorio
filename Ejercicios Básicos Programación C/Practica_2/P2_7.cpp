#include <stdio.h>

int main () {
	
	char opcion;

	fprintf(stdout,"A) Dar de alta a un abonado\nE) Escribir un mensaje\nL) Listar abonados\nB) Borrar un mensaje\nElige una opcion: ");
	fscanf(stdin,"%c",&opcion);
	
	switch(opcion) {
		case 'A':
			fprintf(stdout,"\nHas seleccionado dar de alta. "); break;
		case 'E':
			fprintf(stdout,"\nHas seleccionado escribir. "); break;
		case 'L':
			fprintf(stdout,"\nHas seleccionado listar. "); break;
		case 'B':
			fprintf(stdout,"\nHas seleccionado borrar. "); break;
		default:
			fprintf(stdout,"\nHas elegido una opcion invalida. "); break;
	}
	
	
	return 0;
}
