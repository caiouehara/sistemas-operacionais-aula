#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(int argc, char *argv[]){
    int seq = 0;
    int aux1 = 0;
    int aux2 = 1;
    int limit = atoi(argv[1]); 

    seq = aux1 + aux2;
    while(seq < limit){
	 printf("%d \n", seq);
	 aux1 = aux2;
   	 aux2 = seq;
   	 seq = aux1 + aux2;
    }
    exit(0);
}
