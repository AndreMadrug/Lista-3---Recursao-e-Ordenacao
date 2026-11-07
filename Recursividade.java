public class Recursividade {

    // Questão 04 — Fatorial
    public static long fatorial(int n) {
        if (n <= 1) return 1;
        return n * fatorial(n - 1);
    }

    // Questão 05 — Decimal para binário
    public static String decimalParaBinario(int n) {
        if (n < 0) return "-" + decimalParaBinario(-n);
        if (n < 2) return String.valueOf(n);
        return decimalParaBinario(n / 2) + (n % 2);
    }

    // Questão 06 — Potência recursiva (n >= 0)
    public static int potencia(int x, int n) {
        if (n == 0) return 1;
        return x * potencia(x, n - 1);
    }

    // Questão 07 — Número primo (chamar com divisor = 2)
    public static boolean ehPrimo(int n, int divisor) {
        if (n < 2) return false;
        if (divisor * divisor > n) return true;
        if (n % divisor == 0) return false;
        return ehPrimo(n, divisor + 1);
    }

    // Questão 08 — Soma de 1 até N
    public static int somaAteN(int n) {
        if (n <= 0) return 0;
        return n + somaAteN(n - 1);
    }

    // Questão 09 — Soma dos inversos: 1 + 1/2 + ... + 1/N
    public static double somaInversos(int n) {
        if (n <= 0) return 0;
        return 1.0 / n + somaInversos(n - 1);
    }

    // Questão 10 — x^k usando apenas multiplicação (k >= 0)
    public static long potenciaMultiplicacao(int x, int k) {
        if (k == 0) return 1;
        return x * potenciaMultiplicacao(x, k - 1);
    }

    // Questão 11 — Tribonacci (mostra e retorna o N-ésimo)
    public static long tribonacci(int n) {
        long resultado = tribonacciRec(n);
        System.out.println("Tribonacci(" + n + ") = " + resultado);
        return resultado;
    }

    private static long tribonacciRec(int n) {
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        return tribonacciRec(n - 1) + tribonacciRec(n - 2) + tribonacciRec(n - 3);
    }

    // Questão 12 — Pell
    public static long pell(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return 2 * pell(n - 1) + pell(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Q04 fatorial(5) = " + fatorial(5));                       // 120
        System.out.println("Q05 binário(10) = " + decimalParaBinario(10));            // 1010
        System.out.println("Q06 potencia(2, 10) = " + potencia(2, 10));               // 1024
        System.out.println("Q07 ehPrimo(17) = " + ehPrimo(17, 2));                    // true
        System.out.println("Q07 ehPrimo(18) = " + ehPrimo(18, 2));                    // false
        System.out.println("Q08 soma(10) = " + somaAteN(10));                         // 55
        System.out.println("Q09 inversos(4) = " + somaInversos(4));                   // 2.0833...
        System.out.println("Q10 potenciaMult(3, 4) = " + potenciaMultiplicacao(3, 4)); // 81
        tribonacci(10);                                                               // 81
        System.out.println("Q12 pell(9) = " + pell(9));                               // 985
    }
}
