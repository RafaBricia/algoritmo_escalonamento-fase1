public class Main {
    public static void main(String[] args) {

        // Cria processos
        Processo p1 = GeradorDeProcesso.gerarProcesso();
        Processo p2 = GeradorDeProcesso.gerarProcesso();
        Processo p3 = GeradorDeProcesso.gerarProcesso();

        // Cria escalonador único
        Escalonador escalonador = new Escalonador("RR", 3);
        escalonador.adicionarProcesso(p1);
        escalonador.adicionarProcesso(p2);
        escalonador.adicionarProcesso(p3);

        CPU cpu = new CPU(escalonador, 5);

        // Executa Round Robin
        System.out.println("=== Executando RR ===");
        cpu.executar();

        // Reinicia processos para novos testes
        escalonador.adicionarProcesso(GeradorDeProcesso.gerarProcesso());
        escalonador.adicionarProcesso(GeradorDeProcesso.gerarProcesso());
        escalonador.adicionarProcesso(GeradorDeProcesso.gerarProcesso());

        escalonador.setAlgoritmo("FCFS");
        System.out.println("=== Executando FCFS ===");
        cpu.executar();

        escalonador.adicionarProcesso(GeradorDeProcesso.gerarProcesso());
        escalonador.adicionarProcesso(GeradorDeProcesso.gerarProcesso());
        escalonador.adicionarProcesso(GeradorDeProcesso.gerarProcesso());

        escalonador.setAlgoritmo("SJF");
        System.out.println("=== Executando SJF ===");
        cpu.executar();
    }
}
