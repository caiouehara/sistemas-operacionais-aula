//Exercício 1

#include <stdio.h>
#include <time.h>
#include <unistd.h>
#include <stdlib.h>

void printArray(int array[], int n){
    int i;
    for(i=0; i<n;i++){
        printf("%d ", array[i]);
    }
}

void quickSort(int valor[], int esquerda, int direita){
    int i, j, x, y;

    i = esquerda;
    j = direita;
    x = valor[(esquerda + direita) / 2];

    while(i <= j){
        while(valor[i] < x && i < direita){
            i++;
        }
        while(valor[j] > x && j > esquerda){
            j--;
        }
        if(i <= j){
            y = valor[i];
            valor[i] = valor[j];
            valor[j] = y;
            i++;
            j--;
        }
    }
    if(j > esquerda){
        quickSort(valor, esquerda, j);
    }
    if(i < direita){
        quickSort(valor, i, direita);
    }
}

void insertionSort(int valor[], int n){
    int i,j,x;

    for (i=0; i < n; i++){
        x = valor[i];
        j = i - 1;
        
        while(j>=0 && valor[j] > x){
            valor[j+1] = valor[j];
            j = j - 1;
        }

        valor[j+1] = x;
    }
}

int main(){
    clock_t c2, c1;
    float tmp;

    int pid = fork();
    int array[] = {0, 5, 78, 10, 15, 30, 40, 20, 3, 5, 10, 15, 23, 43, 45, 
    50, 120, 1230, 42141, 41214, 113, 1313 ,512};
    int n = sizeof(array) / sizeof(array[0]);

    if(pid < 0){
	    printf("Erro: não foi possível criar o processo");
    }
    if(pid == 0){
        c1 = clock();
        quickSort(array, 0, n - 1);
    } else{
        wait(NULL);
        c1 = clock();
        insertionSort(array, n);
    }

    c2 = clock();
    tmp = (c2 - c1)*1000/CLOCKS_PER_SEC; // tempo de execução em milissegundos

    printArray(array, n);
    printf("[PID %d] Processo encerrado, tempo de execução: %f \n", pid, tmp);
	
    exit(0);
}