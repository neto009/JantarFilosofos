public class Garfo {
    private Integer id;
    private boolean sendoUsado = false;

    public Garfo(Integer id) {
        this.id = id;
    }

    public boolean isSendoUsado() {
        return sendoUsado;
    }

    public void setSendoUsado(boolean sendoUsado) {
        this.sendoUsado = sendoUsado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
