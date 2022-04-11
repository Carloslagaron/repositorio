#include <stdio.h>

#include <string.h>


int main () {
  char cadena [100];
  int longi;
  int intentos;
do
  {
  fprintf (stdout, "\nDame una cadena (1-15 car):\n");
  fscanf (stdin, "%s", cadena);
  longi = strlen(cadena);
  if(longi>15){
    fprintf (stdout, "Longitud excesiva\n");
    intentos=intentos+1;
  }
  else{
  fprintf (stdout,"La cadena tiene %i caracteres\n", longi);
  break;
  }
  if(intentos==5){
    fprintf(stdout, "\nNúmero de intentos superado\n");
    break;
  }
  }
 while (longi>15);
  
  return 0;
}
