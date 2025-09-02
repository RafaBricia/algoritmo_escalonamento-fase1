public class CPU {
    private Escalonador escalonador;
    private int quantidadeCiclos = 0;
    private int limiteInterrupcao;

    public CPU(Escalonador escalonador, int limiteInterrupcao) {
        this.escalonador = escalonador;
        this.limiteInterrupcao = limiteInterrupcao;
    }

    public void executar() {
        while (escalonador.temProcessos()) {
            String resultado = escalonador.executar();
            System.out.println("Ciclo " + quantidadeCiclos + ": " + resultado);

            quantidadeCiclos++;

            try {
                Thread.sleep(300); // simula tempo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (quantidadeCiclos % limiteInterrupcao == 0) {
                System.out.println(">>> Interrupção de clock <<<");
            }
        }

        System.out.println("Todos os processos foram finalizados!");
    }
}
