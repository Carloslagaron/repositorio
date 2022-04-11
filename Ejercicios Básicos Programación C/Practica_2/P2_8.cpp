#include <stdio.h>

int main () {
	
	float n1,n2,resultado;
	char op;
	
	fprintf(stdout,"Dame una operacion (n1 n2 op): ");
	fscanf(stdin,"%f %f %s",&n1,&n2,&op);
	
	switch(op) {
		
		case '+':
			resultado= n1 + n2; break;
		case '-':
			resultado= n1 - n2; break;
		case '*':
			resultado= n1 * n2; break;
		case '/':
			resultado= n1 / n2; break;
	}
	fprintf(stdout,"Resultado: %f", resultado);
}
