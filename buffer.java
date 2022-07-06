package Arquivos.Thread.MultiThreads;

public interface buffer {

    public int getPosicaoString();

    public void putPosicaoString(int valor);

    public void putBuffer(int value, int position)
            throws InterruptedException;
    public int getBuffer(int position) throws InterruptedException;

}
