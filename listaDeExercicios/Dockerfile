FROM gcc:4.9

COPY ./lista1-UNB /usr/src/myapp

WORKDIR /usr/src/myapp

RUN gcc -o myapp questao1.c

CMD ["./myapp"] 
#CMD ["./myapp", "3 5 10 16 23 512 1 5 8 10 11"] 