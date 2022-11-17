import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<String> filosofos;
    public static List<Integer> garfos;
    public static List<Integer> pensando;
    public static List<Integer> garfosPegos;


    public static void main(String[] args) throws InterruptedException {
        filosofos = Collections.synchronizedList(Arrays.asList("Socrates", "Aristóteles", "Hegel", "Kant", "Nietzsche"));
        garfos = Collections.synchronizedList(Arrays.asList(1, 2, 3, 4, 5));
        MeuRunnable meuRunnable = new MeuRunnable();
        Thread t0 = new Thread(meuRunnable);
        Thread t1 = new Thread(meuRunnable);
        t0.start();
        t1.start();
    }

    public static class MeuRunnable implements Runnable {
        @Override
        public void run() {
            while(true){

            }
        }
    }

    public void pegarGarfo(Integer posiFilosofo){
        if(posiFilosofo == 5){
            garfosPegos.add(posiFilosofo - 1);
            garfosPegos.add(posiFilosofo);
        } else{
            garfosPegos.add(posiFilosofo + 1);
            garfosPegos.add(posiFilosofo);
        }
    }

    public void comer(Integer posiFilosofo){
        if(garfosPegos) {
            System.out.println(filosofos.get(posiFilosofo) + "comeu!");
            soltarGarfo();
        }
    }

    public void soltarGarfo(){
        //left//right
    }
}
