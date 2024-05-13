#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/wait.h>
#include <stdint.h>


/** Essa questao nao esta muito coerente, para os requisitos de aleatoriedade e unicidade dos elementos,
 * nao ha a possibilidade de nao encontrar um elemento. Alem disso, o maior gasto de tempo acaba ficando nesse ponto
 * ao inves do uso de processos. O unico caso em que o elemento nao seria encontrado seria quando o usuario inserisse algum valor fora do intervalo [0, n-1]
*/

#ifdef __linux__
    #include <unistd.h>
    #define WAIT_TIME_BASIS 1000
#elif _WIN32
    #include <windows.h>
    #define WAIT_TIME_BASIS 1
#else

#endif

int8_t buscaEsquerdaDireita(int v[], int n, int busca) {
    for(int8_t i = 0; i < n; i++) {
        if(busca == v[i]) return i;
    }
    return -1;
}

int8_t buscaDireitaEsquerda(int v[], int n, int busca) {
    for(int8_t i = n-1; i > -1; i--) {
        if(busca == v[i]) return i;
    }
    return -1;
}

void mostrarArray(int v[], int n) {
    for(int i = 0; i < n; i++) printf("%d ", v[i]);
    printf("\n");
}

void randomShuffle(int v[], int tam) {
    if (tam > 1) {
        int i;
        for (i = 0; i < tam - 1; i++) {
          int j = i + rand() / (RAND_MAX / (tam - i) + 1);
          int t = v[j];
          v[j] = v[i];
          v[i] = t;
        }
    }
}

void gerarVetorComValoresUnicos(int v[], int tam) {
    for(int i = 0; i < tam; i++) {
        v[i] = i;
    }
    randomShuffle(v, tam);
}

int main(int argc, char* argv[]) {
    srand(time(NULL));

    if(argc != 3) {
        printf("Voce deve inserir apenas o tamanho do array desejado e o valor a ser buscado\n");
        exit(1);
    }

    int tamanho = atoi(argv[1]);
    int busca = atoi(argv[2]);

    int* v = (int *) malloc(sizeof(int) * tamanho);

    gerarVetorComValoresUnicos(v, tamanho);

    puts("O array gerado foi: ");
    mostrarArray(v, tamanho);

    float tempoEspera = (rand() % 1000) / (float) WAIT_TIME_BASIS;

    int pid_primeiro = fork();
    int pid_segundo = fork();

    if(pid_primeiro == 0) {
        sleep(tempoEspera);
        int8_t indexBusca = buscaEsquerdaDireita(v, tamanho, busca);
        exit(indexBusca);
    }
    
    if (pid_segundo == 0) {
        int8_t indexBusca = buscaDireitaEsquerda(v, tamanho, busca);
        exit(indexBusca);
    }

    int statusPrimeiroTerminar, status_segundo;

    pid_t primeiroTerminar = wait(&statusPrimeiroTerminar);
    int8_t retornoPrimeiroTerminar = WEXITSTATUS(statusPrimeiroTerminar);

    if(retornoPrimeiroTerminar == -1) {
        puts("Nao encontrado");
    } else {
        printf("Encontrado pelo filho %d na posicao %d\n", (primeiroTerminar == pid_primeiro) ? 1 : 2, retornoPrimeiroTerminar);
    }

    return 0;
}