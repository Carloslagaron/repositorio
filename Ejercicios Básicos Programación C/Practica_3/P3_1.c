#include <stdio.h>
#include <ctype.h>

int main () {
	
	char opcion;
	do {
	fprintf(stdout,"A) Dar de alta a un abonado\nE) Escribir un mensaje\nL) Listar abonados\nB) Borrar un mensaje\nS) Salir del programa\nElige una opcion: ");
	fscanf(stdin," %c",&opcion);
	opcion=toupper(opcion);
	switch(opcion) {
		case 'A':
			fprintf(stdout,"\nHas seleccionado dar de alta.\n"); 
			break;
		case 'E':
			fprintf(stdout,"\nHas seleccionado escribir.\n"); 
			break;
		case 'L':
			fprintf(stdout,"\nHas seleccionado listar.\n"); 
			break;
		case 'B':
			fprintf(stdout,"\nHas seleccionado borrar.\n"); 
			break;
		case 'S':
			break;
		default:
			fprintf(stdout,"\nHas elegido una opcion invalida.\n"); 
			break;
	}
	} while (opcion != 'S');
	
	
	return 0;
}
