package Arquivos.Thread.MultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class mainMultiThreads {

    public static void main(String[] args)
            throws InterruptedException {
        // TODO Auto-generated method stub
        ExecutorService threadRun =
                Executors.newCachedThreadPool();
        buffer sharedLocation = new unsysnchronizedBuffer();

        System.out.printf("Thread running\t\tValue\t "
                + "Sum write\tSum read\n");
        System.out.println("-------------------------------------------------------------------");
        threadRun.execute(new writeBuffer(sharedLocation));
        threadRun.execute(new readBuffer(sharedLocation));
        threadRun.shutdown();
        threadRun.awaitTermination(1, TimeUnit.MINUTES);
    }
}

/*
(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 0,000000	
(FLOAT) A soma até agora é: 0.0
Amarelo: Opa! Atenção aí, hein?! Não vai matar ninguém hoje. Desacelera!
------------------------------------------------------------------------

(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 0,000000	
(FLOAT) A soma até agora é: 0.0
Amarelo: Opa! Atenção aí, hein?! Não vai matar ninguém hoje. Desacelera!
------------------------------------------------------------------------

(INT) - Count Escrevendo valor: 0	 (INT) 0

(FLOAT) Número sorteado: 14,00 

(STRING) Valor da cor passado: 2
------------------------------------------------------------------------


(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 14,000000	
(FLOAT) A soma até agora é: 14.0
Vermelho: Ei! Cuidado! Vai matar alguém se continuar. Pare!
------------------------------------------------------------------------

(INT) - Count Escrevendo valor: 1	 (INT)100

(FLOAT) Número sorteado: 15,00 

(STRING) Valor da cor passado: 1
------------------------------------------------------------------------


(INT) - Count Escrevendo valor: 2	 (INT)400

(FLOAT) Número sorteado: 3,00 

(STRING) Valor da cor passado: 0
------------------------------------------------------------------------


(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 3,000000	
(FLOAT) A soma até agora é: 17.0
Amarelo: Opa! Atenção aí, hein?! Não vai matar ninguém hoje. Desacelera!
------------------------------------------------------------------------

(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 3,000000	
(FLOAT) A soma até agora é: 20.0
Amarelo: Opa! Atenção aí, hein?! Não vai matar ninguém hoje. Desacelera!
------------------------------------------------------------------------

(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 3,000000	
(FLOAT) A soma até agora é: 23.0
Amarelo: Opa! Atenção aí, hein?! Não vai matar ninguém hoje. Desacelera!
------------------------------------------------------------------------

(INT) - Count Escrevendo valor: 3	 (INT)1000

(FLOAT) Número sorteado: 2,00 

(STRING) Valor da cor passado: 2
------------------------------------------------------------------------


(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 2,000000	
(FLOAT) A soma até agora é: 25.0
Vermelho: Ei! Cuidado! Vai matar alguém se continuar. Pare!
------------------------------------------------------------------------

(INT) - Count Escrevendo valor: 4	 (INT)2000

(FLOAT) Número sorteado: 18,00 

(STRING) Valor da cor passado: 0
------------------------------------------------------------------------


(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 18,000000	
(FLOAT) A soma até agora é: 43.0
Amarelo: Opa! Atenção aí, hein?! Não vai matar ninguém hoje. Desacelera!
------------------------------------------------------------------------

(INT) - Count Escrevendo valor: 5	 (INT)3500

(FLOAT) Número sorteado: 16,00 

(STRING) Valor da cor passado: 1
------------------------------------------------------------------------


(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 16,000000	
(FLOAT) A soma até agora é: 59.0
Verde: Aee! A espera valeu a pena! Andalê! Pode avançar!
------------------------------------------------------------------------

(INT) - Count Escrevendo valor: 6	 (INT)5600

(FLOAT) Número sorteado: 7,00 

(STRING) Valor da cor passado: 2
------------------------------------------------------------------------


(INT) - Count Leitura valor: 0			 (INT)  0

(FLOAT) Leitura valor: 7,000000	
(FLOAT) A soma até agora é: 66.0
Vermelho: Ei! Cuidado! Vai matar alguém se continuar. Pare!
------------------------------------------------------------------------

(INT) Leitura do total de valores:  0
Leitura finalizada!
TODOS OS NÚMEROS RECEBIDOS:
0.0
0.0
14.0
3.0
3.0
3.0
2.0
18.0
16.0
7.0

(INT) - Count Escrevendo valor: 7	 (INT)8400

(FLOAT) Número sorteado: 3,00 

(STRING) Valor da cor passado: 2
------------------------------------------------------------------------


(INT) - Count Escrevendo valor: 8	 (INT)12000

(FLOAT) Número sorteado: 13,00 

(STRING) Valor da cor passado: 0
------------------------------------------------------------------------


(INT) - Count Escrevendo valor: 9	 (INT)16500

(FLOAT) Número sorteado: 6,00 

(STRING) Valor da cor passado: 0
------------------------------------------------------------------------

(FLOAT) Soma total de todos os valores escritos: 570.0

Process finished with exit code 0



*/
