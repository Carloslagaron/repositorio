#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int numeroAleatorio[5]; 
    int i;

    srand (time(NULL));
    for (i=0; i<5; i++) {
        numeroAleatorio[i] = -10+rand()%20;
        printf("%d\t",numeroAleatorio[i]);
    }


    return 0;

}

