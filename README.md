# Simulador de Escalonamento de Processos em Java

## 🎯 Descrição

Este projeto simula a execução de processos em uma CPU utilizando diferentes **algoritmos de escalonamento**:

- **FCFS (First Come, First Served)** – o primeiro processo a chegar é o primeiro a ser executado.  
- **SJF (Shortest Job First)** – o processo com menor quantidade de instruções restantes é executado primeiro.  
- **RR (Round Robin)** – cada processo recebe um quantum de tempo; se não terminar, volta para o final da fila.

O projeto permite que **uma única CPU** e **um único escalonador** sejam usados, alternando dinamicamente entre os algoritmos.

---

## 🏗 Estrutura do Projeto

- **Main.java** – ponto de entrada do programa; cria processos, escalonador e CPU, e executa os diferentes algoritmos.  
- **Processo.java** – representa um processo com ID e quantidade de instruções; possui o método `cicloDeClock()` que simula a execução de uma instrução por ciclo.  
- **GeradorDeProcesso.java** – gera processos aleatórios com instruções entre 10 e 50.  
- **Escalonador.java** – gerencia a fila de prontos e executa os processos de acordo com o algoritmo escolhido. Possui métodos:  
  - `executarFCFS()`  
  - `executarSJF()`  
  - `executarRoundRobin()`  
  - `removerProcesso()`  
  - `setAlgoritmo()` para mudar o algoritmo dinamicamente.  
- **CPU.java** – simula a CPU que consome os processos do escalonador e imprime o estado a cada ciclo. Suporta interrupções de clock simuladas.  

---

## ⚙ Como funciona

1. Crie processos usando `GeradorDeProcesso`.  
2. Adicione-os à fila do **Escalonador**.  
3. Crie uma **CPU** e passe o escalonador como parâmetro.  
4. Execute a CPU com `cpu.executar()`.  
5. Para mudar o algoritmo, use `escalonador.setAlgoritmo("FCFS"|"SJF"|"RR")`.  
6. Reinicie a fila com novos processos se desejar testar outro algoritmo.  

---

## 🖥 Exemplo de Saída

```
=== Executando RR ===
Ciclo 0: Processo 1 executando. Restam 49 instruções.
Processo 1 executando. Restam 48 instruções.
Processo 1 executando. Restam 47 instruções.
>>> Interrupção de clock <<<

=== Executando FCFS ===
Ciclo 0: Processo 4 executando. Restam 23 instruções.
Ciclo 1: Processo 4 executando. Restam 22 instruções.
...
Processo 4 finalizado e removido da fila de prontos.

=== Executando SJF ===
Executando SJF
Ciclo 0: Processo 7 executando. Restam 12 instruções.
...
Todos os processos foram finalizados!

```


> Cada algoritmo imprime seu comportamento próprio e a fila de processos muda de acordo com as regras.

---

## 💡 Funcionalidades Extras

- Suporte a **interrupções de clock** a cada N ciclos (`limiteInterrupcao`).  
- Possibilidade de alternar **dinamicamente entre algoritmos** usando uma única CPU e um único escalonador.  
- Relatórios detalhados de execução de cada ciclo, mostrando quantas instruções restam.  

---

## 🚀 Como Rodar

1. Compile todos os arquivos Java:

```bash
javac *.java
```

2. Execute o programa:

```bash
java Main
```

Observe no console a execução dos processos em cada algoritmo.