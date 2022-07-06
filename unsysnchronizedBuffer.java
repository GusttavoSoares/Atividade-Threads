package Arquivos.Thread.MultiThreads;

public class unsysnchronizedBuffer implements buffer {

    private int posicao = 0;
    private int[] buffer = new int[15];

    private float bufferFloat = 0;


    // VARIAVEIS PARA MANIPULAR OS VETORES DO TIPO STRING
    public int getPosicaoString() {
        return this.posicao;
    }

    public void putPosicaoString(int valor) {
        System.out.printf("\n(STRING) Valor da cor passado: " + valor);
        this.posicao = valor;
    }


    // BUFFER INT[]
    public void putBuffer(int value, int position)
            throws InterruptedException {
        System.out.printf("\n(INT) - Count Escrevendo valor: " + value);
        buffer[position] = value;
    }

    public int getBuffer(int position) throws InterruptedException {
        System.out.printf("\n(INT) - Count Leitura valor: " + buffer[position]);
        return buffer[position];
    }

    // BUFFER DO TIPO FLOAT
    public void putBufferFloat(float value) throws InterruptedException {
        System.out.printf("\n(FLOAT) Número sorteado: %.2f %n", value);
        bufferFloat = value;
    }

    public float getBufferFloat() throws InterruptedException {
        System.out.printf("\n(FLOAT) Leitura valor: %f\t", bufferFloat);
        return bufferFloat;
    }

}
