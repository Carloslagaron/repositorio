#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define TAM 60
#define APLICACION "CARTAAS"
#define CAR_CAJA
#define ESPACIO ' '

int main () {
	
	char opcion,opcion2;
	int j,i,num,tamc;
	
	tamc=strlen(APLICACION);
	num= (TAM-2-tamc)/2;
	
	
	for (j=0; j<60; j++) {
		fprintf(stdout,"+");		//PRINT DE LOS 60 PRIMEROS '+'	
	}
		fprintf(stdout,"\n");
	
	fprintf(stdout,"+");		// '+' DEL COMIENZO DE LA SEGUNDA LINEA
	
	for (i=0; i<num;i++) {
		fprintf(stdout,"%c",ESPACIO);	//PRIMERA SUCESION DE ESPACIOS ANTES DE APLICACION
	}
	
	fprintf(stdout,"%s", APLICACION); //APLICACION
	
	for (i=0; i<num;i++) {
		fprintf(stdout,"%c",ESPACIO);	//SEGUNDA SUCESION DE ESPACIOS
	}
	
	fprintf(stdout,"+\n");	// SEGUNDA '+' AL FINAL DE LA LINEA
	
	
	for (j=0; j<60; j++) {
	fprintf(stdout,"+");		// SEGUNDA LINEA DE '+' EN LA TERCERA LINEA
	}
	fprintf(stdout,"\n");
	
	
	
	do {
	fprintf(stdout,"\nA) Dar de alta a un abonado\nE) Escribir un mensaje\nL) Listar abonados\nB) Borrar un mensaje\nS) Salir del programa\nElige una opcion: ");
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
		
		fprintf(stdout,"Seguro que quieres salir? (s/n): ");
		fscanf(stdin,"%s",&opcion2);
		
		opcion2=toupper(opcion2);
		
		do {
			switch(opcion2) {
				case 'N':
					do {
					fprintf(stdout,"\nA) Dar de alta a un abonado\nE) Escribir un mensaje\nL) Listar abonados\nB) Borrar un mensaje\nS) Salir del programa\nElige una opcion: ");
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
		
				fprintf(stdout,"Seguro que quieres salir? (s/n): ");
				fscanf(stdin,"%s",&opcion2);
				opcion2=toupper(opcion2);
			}	
		}	while (opcion2 !='S');									
}

