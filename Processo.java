public class Processo {
    private int id;
    private int quantidadeInstrucoes;

    public Processo(int id, int quantidadeInstrucoes) {
        this.id = id;
        this.quantidadeInstrucoes = quantidadeInstrucoes;
    }

    public int getId() {
        return id;
    }

    public int getQuantidadeInstrucoes() {
        return quantidadeInstrucoes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantidadeInstrucoes(int quantidadeInstrucoes) {
        this.quantidadeInstrucoes = quantidadeInstrucoes;
    }

    public String cicloDeClock() {
        if (quantidadeInstrucoes > 0) {
            quantidadeInstrucoes--;
            return "Processo " + id + " executando. Restam " + quantidadeInstrucoes + " instruções.";
        } else {
            return "Processo " + id + " já finalizado.";
        }
    }
}
