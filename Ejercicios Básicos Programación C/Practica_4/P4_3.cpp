#include <stdio.h>

int main ()	{
	
	int a;
	int *b;
	
	b = &a;
	a= 5;
	fprintf(stdout, "a vale: %d\n",a);
	*b= 7;
	fprintf(stdout, "a vale: %d \n",a);
	return 0;
	
}
