#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/wait.h>
#include <unistd.h>

void bubble_sort(int a[], int n)
{
    int i, j;
    for (i = 0; i < n - 1; i++)
    {
        for (j = 0; j < n - i - 1; j++)
        {
            if (a[j] > a[j + 1])
            {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
}

void quickSort(int valor[], int esquerda, int direita)
{
    int i, j, x, y;
    i = esquerda;
    j = direita;
    x = valor[(esquerda + direita) / 2];
    while (i <= j)
    {
        while (valor[i] < x && i < direita)
        {
            i++;
        }
        while (valor[j] > x && j > esquerda)
        {
            j--;
        }
        if (i <= j)
        {
            y = valor[i];
            valor[i] = valor[j];
            valor[j] = y;
            i++;
            j--;
        }
    }
    if (j > esquerda)
    {
        quickSort(valor, esquerda, j);
    }
    if (i < direita)
    {
        quickSort(valor, i, direita);
    }
}

void mostrarArray(int v[], int n) {
    int i;
    for(i = 0; i < n; i++) printf("%d ", v[i]);
    printf("\n");
}

int main(int argc, char *argv[])
{
    clock_t c2, c1;
    double tmp;
    int v[10] = {0, 5, 78, 10, 15, 30, 40, 20, 3, 5};

    /*for (i = 1; i < 11; i++)
    {
        v[i - 1] = atoi(argv[i]);
    }*/

    int pid = fork();
    if (pid == 0)
    {
        
        c1 = clock();
        quickSort(v, 0, 9);
        c2 = clock();
        tmp = (c2 - c1)*1000/CLOCKS_PER_SEC;
        printf("Vetor ordenado no filho: ");
        mostrarArray(v, 10);
        printf("Tempo percorrido no filho: %lf\n", tmp);

        exit(0);
    } 

    c1 = clock();
    bubble_sort(v, 10);
    c2 = clock();
    tmp = (c2 - c1)*1000/CLOCKS_PER_SEC;

    printf("Vetor ordenado no pai: ");
    mostrarArray(v, 10);
    printf("Tempo percorrido no pai: %lf\n", tmp);

    wait(NULL);
}
