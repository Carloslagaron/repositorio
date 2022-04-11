#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
   	
    int N,i;
    float *p,mayor;
    
	srand(time(NULL));
	
	do {
	printf("Introduce un valor entre 1-10: ");
	scanf("%d",&N);
	
	p=malloc(N*sizeof(int));
	
	if (1>N || 10<N) {
		fprintf(stdout,"Valor no valido.\n");
	}
	if (N>=1 && N<=10) {
	
    	for (i=0; i<N; i++) {
        	p[i] = -10+rand()%20; 
			fprintf(stdout,"%d\t",p[i]);   
   		}
   		break;
	}
	}
	while (1>N || 1<N);
	
		


    return 0;

}
