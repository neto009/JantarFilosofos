import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recursion {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = config();
        List<Funcionario> currentFuncionarios = getParents(funcionarios);
    }

    public static List<Funcionario> config() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario(1L, "Joao", null));
        funcionarios.add(new Funcionario(2L, "Maria", 1L));
        funcionarios.add(new Funcionario(3L, "Jose", 1L));
        funcionarios.add(new Funcionario(4L, "Marcos", 2L));
        funcionarios.add(new Funcionario(5L, "Antonio", 3L));
        funcionarios.add(new Funcionario(6L, "Alfredo", null));
        funcionarios.add(new Funcionario(7L, "Luci", 1L));
        return funcionarios;
    }

    public static List<Funcionario> getParents(List<Funcionario> funcionarios) {
        List<Funcionario> currentList = new ArrayList<>();
        funcionarios.forEach(funcionario -> {
            if(funcionario.getFk_id() == null) {
                currentList.add(funcionario);
            }
        });
        List<Funcionario> funcionarioList = recursion(currentList, funcionarios);
        return funcionarioList;
    }

    public static List<Funcionario> recursion(List<Funcionario> father, List<Funcionario> funcionarios) {
        father.forEach(func ->{
            var current = funcionarios.stream()
                    .filter(funcionario -> funcionario.getFk_id() != null && funcionario.getFk_id() == func.getId()).collect(Collectors.toList());
            if(current != null && !current.isEmpty()) {
                current = recursion(current, funcionarios);
            }
            func.setSons(current);
        });
        return father;
    }
}
