import java.util.ArrayList;

// Responsável por gerenciar a fila de processos e 
// decidir qual processo será executado com base no algoritmo de escalonamento definido.

public class Escalonador {
    private ArrayList<Processo> filaDeProntos = new ArrayList<>();
    private String algoritmo;
    private int quantum;

    public Escalonador(String algoritmo, int quantum){
        this.algoritmo = algoritmo;
        this.quantum = quantum;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public void adicionarProcesso(Processo p){
        filaDeProntos.add(p);
    }
    
    public String removerProcesso(Processo p){
        filaDeProntos.remove(p);
        return "Processo " + p.getId() + " finalizado e removido da fila de prontos.";
    }

    public boolean temProcessos() {
        return !filaDeProntos.isEmpty();
    }

    public String executarSJF(){

        System.out.println("Executando SJF");

        if (filaDeProntos.isEmpty()) return "Nenhum processo na fila.";
        filaDeProntos.sort((a, b) -> a.getQuantidadeInstrucoes() - b.getQuantidadeInstrucoes());
        Processo p = filaDeProntos.get(0);
        String resultado = p.cicloDeClock();
        if(p.getQuantidadeInstrucoes() == 0){
            removerProcesso(p);
        }
        return resultado;
    }

    public String executarRoundRobin(){

        System.out.println("Executando RR");

        if (filaDeProntos.isEmpty()) return "Nenhum processo na fila.";
        Processo p = filaDeProntos.remove(0);
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < quantum && p.getQuantidadeInstrucoes() > 0; i++) {
            resultado.append(p.cicloDeClock()).append("\n");
        }
        if (p.getQuantidadeInstrucoes() > 0) {
            filaDeProntos.add(p);
        } else {
            resultado.append(removerProcesso(p)).append("\n");
        }
        return resultado.toString();
    }

    public String executarFCFS(){

        System.out.println("Executando FCFS");

        if (filaDeProntos.isEmpty()) return "Nenhum processo na fila.";
        Processo p = filaDeProntos.get(0);
        String resultado = p.cicloDeClock();
        if (p.getQuantidadeInstrucoes() == 0) {
            removerProcesso(p);
        }
        return resultado;
    }

    public String executar(){
        if (algoritmo.equals("SJF")) {
            return executarSJF();
        } else if (algoritmo.equals("RR")) {
            return executarRoundRobin();
        } else if (algoritmo.equals("FCFS")) {
            return executarFCFS();
        } else {
            return "Algoritmo de escalonamento inválido.";
        }
    }
}