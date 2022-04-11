#include <stdio.h>

int main () {
	
	int num,cubo;
	
	fprintf(stdout,"Dame un entero [1-25]: "); 
	fscanf(stdin,"%i",&num);
	
	while (1>num && num>25) {
		fprintf(stdout,"Dame un entero [1-25]: "); fscanf(stdin,"%i",&num);
		cubo= (num*num*num);
	
		if (1 <= num && num <= 25) {
			fprintf(stdout,"Cubo: %d", cubo);
		}		else fprintf(stdout,"Valor incorrecto");
	}
	
	
	return 0;
}
