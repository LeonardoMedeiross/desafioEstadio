public class SomaIndicie {public static void main(String[] args) {
    int INDICE = 13;
    int SOMA = 0;
    int K = 0;

    // Loop para somar os valores de K
    while (K < INDICE) {
        K = K + 1;
        SOMA = SOMA + K;
    }

    // Exibe o valor final da SOMA
    System.out.println("O valor de SOMA é: " + SOMA);
}
}
