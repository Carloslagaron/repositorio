#include <stdio.h>

int main () {
	
	char cadena[5][100];
	int num;
	
	
	
	for (int i=0;i<5;i++) {
		fprintf(stdout,"Introduce una cadena de caracteres: ");
		fscanf(stdin,"%s", &cadena[i][0]);
	}
	
	do {
	fprintf(stdout,"Introduce un numero entre 1 y 5: ");
	fscanf(stdin,"%d",&num);
		if (num>1 && num<5){
			fprintf(stdout,"Cadena= %s",cadena[num-1]);
		}
		else fprintf(stdout,"Numero no valido.");
	}
	while(num<1 && 5>num);
	
	return 0;
}



