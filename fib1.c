#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(int argc, char *argv[]){
    int seq = 0;
    int aux1 = 1;
    int aux2 = 0;
    int limit = atoi(argv[1]); 

    seq = aux1 + aux2;
    while(seq < limit){
	 printf("%d", seq);
	 aux1 = aux2;
   	 aux2 = seq;
   	 seq = aux1 + aux2;
    }
    exit(0);
}
