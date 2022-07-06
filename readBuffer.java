package Arquivos.Thread.MultiThreads;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class readBuffer implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final buffer sharedLocation;

    public readBuffer(buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    // VETORES DO TIPO FLOAT
    List<Float> vetorFloatLista = new ArrayList<Float>();
    Vector<Float> vectFloat = new Vector<Float>(vetorFloatLista);

    public void run() {

        int multi = 0;
        int aux = 0;
        float sum = 0;

        for (int count = 0; count < 10; count++) {

            try {
                Thread.sleep(generator.nextInt(3000));
                aux += sharedLocation.getBuffer(count) * 100;
                multi += aux;
                System.out.printf("\t\t\t (INT) %2d%n", multi);

                // FLOAT
                vectFloat.add(sharedLocation.getBufferFloat());
                sum += vectFloat.get(count);
                System.out.println("\n(FLOAT) A soma até agora é: " + sum);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            String[] cores = {"AMARELO", "VERDE", "VERMELHO"};

            int numeroSelecionado = sharedLocation.getPosicaoString();

            if (cores[numeroSelecionado].equals("AMARELO")) {
                System.out.println("Amarelo: Opa! Atenção aí, hein?! Não vai matar ninguém hoje. Desacelera!");
            } else if (cores[numeroSelecionado].equals("VERDE")) {
                System.out.println("Verde: Aee! A espera valeu a pena! Andalê! Pode avançar!");
            } else
                System.out.println("Vermelho: Ei! Cuidado! Vai matar alguém se continuar. Pare!");

            System.out.println("------------------------------------------------------------------------");
        }

        // INT
        System.out.printf("%n%s %d%n%s%n",
                "(INT) Leitura do total de valores: ",
                multi, "Leitura finalizada!");

        // FLOAT
        Iterator<Float> lista = vectFloat.iterator();
        System.out.println("TODOS OS NÚMEROS RECEBIDOS:");
        while (lista.hasNext()) {
            Float novaLista = lista.next();
            System.out.println(novaLista);
        }

    }
}

