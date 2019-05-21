import time
from random import randint
import collections

agente = "-"
repetido = []
maiores = []
limpo = 0

ambiente = [[2,2,3,0,2,1,2],
           [2,0,3,0,2,1,2],
           [2,0,3,0,1,1,2],
           [2,0,3,0,2,1,2],
           [2,0,3,0,3,1,2],
           [2,0,3,0,2,5,2]]


def printar(ambiente):
    for secao in ambiente:
        print(secao)
    print(31*"\n")

def sujaambiente(ambiente):
    for secao in ambiente:
        atual = 0
        for local in secao:
            secao[atual] = randint(0,4)
            atual += 1
    return ambiente

printar(ambiente)

#Limpar Tela

time.sleep(0.5)

def aspirador(ambiente):
    for secao in ambiente:
        atual = 0
        for local in secao:
            if local != limpo:
                repetido.append(local)
                secao[atual] = agente
                printar(ambiente)
                time.sleep(0.5)
                secao[atual] = limpo
                atual += 1
            
            else:
                salva = secao[atual]
                secao[atual] = agente
                printar(ambiente)
                secao[atual] = salva
                time.sleep(0.5)

                atual += 1
                continue
    maior = 0
    quem = 0
    if repetido.count(1) > maior:
        maior = repetido.count(1)
        quem = 1
    if repetido.count(2) > maior:
        maior = repetido.count(2)
        quem = 2
    if repetido.count(3) > maior:
        maior = repetido.count(3)
        quem = 3
    if repetido.count(4) > maior:
        maior = repetido.count(4)
        quem = 4

    maiores.append(quem)    
    print(maiores)
    repetido.clear()
    
    return ambiente
    
    

while True:
    printar(aspirador(ambiente))
    ambiente = sujaambiente(ambiente)
    printar(ambiente)
    time.sleep(1)
