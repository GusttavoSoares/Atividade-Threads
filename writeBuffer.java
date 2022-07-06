package Arquivos.Thread.MultiThreads;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class writeBuffer implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final buffer sharedLocation;

    // VETORES DO TIPO FLOAT
    List<Float> vetorFloatLista = new ArrayList<Float>();
    Vector<Float> vectFloat = new Vector<Float>(vetorFloatLista);

    public writeBuffer(buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    public void run() {
        float sum = 0;
        int multi = 0;
        int aux = 0;
        for (int count = 0; count < 10; count++) {
            try {

                // INT
                Thread.sleep(generator.nextInt(3000));
                sharedLocation.putBuffer(count, count);
                aux += count * 100;
                multi += aux;
                System.out.printf("\t (INT)%2d\n", multi);

                // FLOAT
                float numeroSorteadoFloat = (float) Math.floor(Math.random() * 20);
                sharedLocation.putBufferFloat(numeroSorteadoFloat);
                vectFloat.add(numeroSorteadoFloat);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // STRING
            int numeroSorteado = (int) Math.floor(Math.random() * 3);

            if (numeroSorteado == 1) {
                sharedLocation.putPosicaoString(0);
            } else if (numeroSorteado == 2) {
                sharedLocation.putPosicaoString(1);
            } else {
                sharedLocation.putPosicaoString(2);
            }


            // PERCORRE O VETOR DO TIPO FLOAT FAZENDO A SOMA DOS ELEMENTOS
            Iterator<Float> lista = vectFloat.iterator();

            while (lista.hasNext()) {
                Float novaLista = lista.next();
                sum += novaLista;
            }
            System.out.println("\n------------------------------------------------------------------------\n");

        }
        System.out.println("(FLOAT) Soma total de todos os valores escritos: " + sum);
    }
}



