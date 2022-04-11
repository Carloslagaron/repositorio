#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
   	
    float *p,mayor;
    int N,i;
    
	
	do {
	printf("Dame la cantidad: ");
	scanf("%d",&N);
	 } while (N<1 || N>10);
	printf("\n");
	
	p=(float*)malloc(N*sizeof(float));
	
	for (i=0; i<N; i++) {
		printf("Dame un float: "); 
		scanf("%f",&p[i]);  
   	}
 
   	
   	mayor=p[0];
   	
	for (i=1;i<N;i++) {
   		if (p[i]>mayor)
   			mayor = p[i];
	}
	
	printf("El mayor es %.2f\n", mayor);
	
	for(i=0;i<N;i++){
		printf("%8.3f",p[i]);
	}
   		
   		
	
	return 0;

}
