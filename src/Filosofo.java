public class Filosofo {

    private Integer posicao;
    private String nome;
    private Garfo direito, esquerdo;

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + posicao + " está pensando");
        Thread.sleep(2000);
    }

    public Filosofo(Integer posicao, Garfo direito, Garfo esquerdo) {
        this.posicao = posicao;
        this.nome = nome;
        this.direito = direito;
        this.esquerdo = esquerdo;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Garfo getDireito() {
        return direito;
    }

    public void setDireito(Garfo direito) {
        this.direito = direito;
    }

    public Garfo getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(Garfo esquerdo) {
        this.esquerdo = esquerdo;
    }
}
