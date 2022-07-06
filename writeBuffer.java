package Arquivos.Thread.MultiThreads;

import java.security.SecureRandom;

public class writeBuffer implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final buffer sharedLocation;

    public writeBuffer(buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    public void run() {
        int multi = 0;
        int aux = 0;
        for (int count = 1; count <= 10; count++) {
            try {
                Thread.sleep(generator.nextInt(3000));
                sharedLocation.putBuffer(count, count);
                aux += count*100;
                multi+=aux;
                System.out.printf("\t%2d\n",multi);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int numeroSorteado = (int) Math.floor(Math.random() * 3);

            if (numeroSorteado == 1) {
                sharedLocation.putPosicaoString(0);
            } else if (numeroSorteado == 2) {
                sharedLocation.putPosicaoString(1);
            } else {
                sharedLocation.putPosicaoString(2);
            }


            System.out.println("Escrita do buffer realizada!\n");
        }
    }
}



