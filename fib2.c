#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(int argc, char *argv[]){
    if(argc != 2 || atoi(argv[1]) < 1){
        printf("[Error] Parâmetros passados incorretamente. <nro_int_posivito>");
        exit(-1);
    }

    int pid = fork();
    if(pid < 0){
	    printf("Erro: não foi possível criar o processo");
    }
    if(pid == 0){
	execlp("./fib1.o", "Fibo1", argv[1], NULL);

	exit(0);
        printf("[Child %d] Processo encerrado \n", pid);
    } else{
        wait(NULL);
        printf("[Parent %d] Processo encerrado \n", pid);
	exit(0);
    }
}
