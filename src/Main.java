import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<Filosofo> filosofos = new ArrayList<>();
    public static List<Garfo> garfos = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {

        filosofos.add(new Filosofo(0,"Socrates"));
        filosofos.add(new Filosofo(1, "Aristóteles"));
        filosofos.add(new Filosofo(2,"Hegel"));
        filosofos.add(new Filosofo(3, "Kant"));
        filosofos.add(new Filosofo(4, "Nietzsche"));

        garfos.add(new Garfo(0));
        garfos.add(new Garfo(1));
        garfos.add(new Garfo(2));
        garfos.add(new Garfo(3));
        garfos.add(new Garfo(4));

        MeuRunnable meuRunnable = new MeuRunnable();
        Thread t0 = new Thread(meuRunnable);
        Thread t1 = new Thread(meuRunnable);
        Thread t2 = new Thread(meuRunnable);
        t0.start();
        t1.start();
        t2.start();
    }

    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            while(true){
                try {
                    pensando();
                    pegarGarfo();
                    comer();
                    soltarGarfo();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public synchronized void pensando() throws InterruptedException {
            for(int i = 0; i < filosofos.size(); i++) {
                if(!filosofos.get(i).isPensando()) {
                    System.out.println(filosofos.get(i).getName() + " está pensando!");
                    filosofos.get(i).setPensando(true);
                }
            }
            Thread.sleep(2000);
        }

        public synchronized void pegarGarfo(){
            for (int i = 0; i < filosofos.size(); i++) {
                if (i == 4 && filosofos.get(i).getGarfoDireito() == null
                        || i == 4 && filosofos.get(i).getGarfoEsquerdo() == null) {

                    if(!garfos.get(0).isSendoUsado()){
                        filosofos.get(i).setGarfoDireito(0);
                        garfos.get(0).setSendoUsado(true);
                        pegarGarfo();
                        System.out.println(filosofos.get(i).getName() + " pegou o garfo Direito!");
                    }else if (!garfos.get(i).isSendoUsado()){
                        filosofos.get(i).setGarfoEsquerdo(i);
                        garfos.get(i).setSendoUsado(true);
                        pegarGarfo();
                        System.out.println(filosofos.get(i).getName() + " pegou o garfo Esquerdo!");
                    }
                } else if(filosofos.get(i).getGarfoEsquerdo() == null
                        || filosofos.get(i).getGarfoDireito() == null) {

                    if (!garfos.get(i).isSendoUsado()){
                        filosofos.get(i).setGarfoEsquerdo(i);
                        garfos.get(i).setSendoUsado(true);
                        pegarGarfo();
                        System.out.println(filosofos.get(i).getName() + " pegou o garfo Esquerdo!");
                    }else if(!garfos.get(i + 1).isSendoUsado()){
                        filosofos.get(i).setGarfoDireito(i + 1);
                        garfos.get(i + 1).setSendoUsado(true);
                        pegarGarfo();
                        System.out.println(filosofos.get(i).getName() + " pegou o garfo Direito!");
                    }
                }
            }
        }

        public synchronized void comer(){
            for(int i = 0; i < filosofos.size(); i++) {
                if(filosofos.get(i).getGarfoDireito() != null && filosofos.get(i).getGarfoEsquerdo() != null) {
                    System.out.println(filosofos.get(i).getName() + " comeu!");
                }
            }
        }

        public synchronized void soltarGarfo() throws InterruptedException {
            for(int i = 0; i < filosofos.size(); i++) {
                if(filosofos.get(i).getGarfoDireito() != null && filosofos.get(i).getGarfoEsquerdo() != null) {
                    filosofos.get(i).setGarfoDireito(null);
                    filosofos.get(i).setGarfoEsquerdo(null);
                    if(i == 4) {
                        garfos.get(i).setSendoUsado(false);
                        garfos.get(0).setSendoUsado(false);
                    } else {
                        garfos.get(i).setSendoUsado(false);
                        garfos.get(i + 1).setSendoUsado(false);
                    }
                    System.out.println(filosofos.get(i).getName() + " soltou os garfos!");
                    pensando();
                }
            }
        }
    }

}
