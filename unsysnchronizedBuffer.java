package Arquivos.Thread.MultiThreads;

public class unsysnchronizedBuffer implements buffer {

    private int posicao = 0;
    private int[] buffer = new int[15];

    public int getPosicaoString() {
        return this.posicao;
    }
    public void putPosicaoString(int valor) {
        this.posicao = valor;
    }

    public void putBuffer(int value, int position)
            throws InterruptedException{
        System.out.printf("\nEscrevendo valor: " +value);
        buffer[position] = value;
    }
    public int getBuffer(int position) throws InterruptedException{
        System.out.printf("\nLeitura valor: " +buffer[position]);
        return buffer[position];
    }

}
