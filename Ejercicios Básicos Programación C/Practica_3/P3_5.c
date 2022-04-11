#include <stdio.h>

int main () {
	
	int x,i,j;
	
	fprintf(stdout,"Introduce un numero entero: ");
	fscanf(stdin,"%d",&x);
	for (j=0; j<x; j++) {
		
		for (i=0; i<60; i++) {
			fprintf(stdout,"+");
		}	
		fprintf(stdout,"\n");
	}
	
	
	
	
	return 0;
}
