#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
	
	int M[5][3];
	int x,y;
 	 
	srand(time(0));
  	for(x=0;x<5;x++){
    	for(y=0;y<3;y++){
      	M[x][y]=-10+rand()%20;   
    	}	   
  	}
 
  	
  	for(x=0;x<5;x++){
  		fprintf(stdout,"\n");
    	for(y=0;y<3;y++){
      	printf(" %d ",M[x][y]);
    	}   
  	}

    return 0;

} 

