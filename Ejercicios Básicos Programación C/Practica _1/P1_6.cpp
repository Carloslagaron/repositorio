#include <stdio.h>

int main () {
	
	int num,cubo;
	
	fprintf(stdout,"Dame un entero: "); fscanf(stdin,"%i",&num);
	cubo= (num*num*num);
	fprintf(stdout,"Cubo: %i", cubo);
	
	return 0;
}
