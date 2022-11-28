import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private Long id;
    private String name;
    private Long fk_id;
    private List<Funcionario> sons = new ArrayList<>();

    public Funcionario(Long id, String name, Long fk_id) {
        this.id = id;
        this.name = name;
        this.fk_id = fk_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFk_id() {
        return fk_id;
    }

    public void setFk_id(Long fk_id) {
        this.fk_id = fk_id;
    }

    public List<Funcionario> getSons() {
        return sons;
    }

    public void setSons(List<Funcionario> sons) {
        this.sons = sons;
    }
}
