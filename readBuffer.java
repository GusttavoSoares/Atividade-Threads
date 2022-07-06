package Arquivos.Thread.MultiThreads;

import java.security.SecureRandom;

public class readBuffer implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final buffer sharedLocation;

    public readBuffer(buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    public void run() {

        int multi = 0;
        int aux = 0;

        for (int count = 1; count <= 10; count++) {

            try {
                Thread.sleep(generator.nextInt(3000));
                aux += sharedLocation.getBuffer(count) * 100;
                multi += aux;
                System.out.printf("\t\t\t%2d%n", multi);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            System.out.println("------------------------------------------------------------------------");
            String[] cores = {"AMARELO", "VERDE", "VERMELHO"};

            int numeroSelecionado = sharedLocation.getPosicaoString();

            if (cores[numeroSelecionado].equals("AMARELO")) {
                System.out.println("Amarelo: Opa! Atenção aí, hein?! Não vai matar ninguém hoje. Desacelera!");
                System.out.println("------------------------------------------------------------------------");
            } else if (cores[numeroSelecionado].equals("VERDE")) {
                System.out.println("Verde: Aee! A espera valeu a pena! Andalê! Pode avançar!");
                System.out.println("------------------------------------------------------------------------");
            } else
                System.out.println("Vermelho: Ei! Cuidado! Vai matar alguém se continuar. Pare!");
            System.out.println("------------------------------------------------------------------------");
        }

        System.out.printf("%n%s %d%n%s%n",
                "Leitura do total de valores: ",
                multi, "Leitura finalizada!");
    }

    }

