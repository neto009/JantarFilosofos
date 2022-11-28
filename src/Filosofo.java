public class Filosofo {

    private Integer id;
    private String name;
    private Integer garfoDireito;
    private Integer garfoEsquerdo;

    private boolean pensando = false;

    public Filosofo(Integer id,String name) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isPensando() {
        return pensando;
    }

    public void setPensando(boolean pensando) {
        this.pensando = pensando;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGarfoDireito() {
        return garfoDireito;
    }

    public void setGarfoDireito(Integer garfoDireito) {
        this.garfoDireito = garfoDireito;
    }

    public Integer getGarfoEsquerdo() {
        return garfoEsquerdo;
    }

    public void setGarfoEsquerdo(Integer garfoEsquerdo) {
        this.garfoEsquerdo = garfoEsquerdo;
    }
}
