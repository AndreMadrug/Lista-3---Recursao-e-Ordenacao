import java.util.Locale;
import java.util.Scanner;

public class Ordenacao {

    // ---------- Questão 01: Insertion Sort + mediana ----------
    public static void insertionSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
    }

    public static double mediana(int[] ordenado) {
        int n = ordenado.length;
        if (n % 2 == 1) {
            return ordenado[n / 2];
        }
        return (ordenado[n / 2 - 1] + ordenado[n / 2]) / 2.0;
    }

    public static void questao01(Scanner sc) {
        int p = sc.nextInt();
        for (int k = 1; k <= p; k++) {
            int n = sc.nextInt();
            int[] vendas = new int[n];
            for (int i = 0; i < n; i++) {
                vendas[i] = sc.nextInt();
            }
            insertionSort(vendas);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(" ");
                sb.append(vendas[i]);
            }
            System.out.println("Vendas ordenadas do produto " + k + ": " + sb);
            System.out.println("Mediana das vendas do produto " + k + ": " + mediana(vendas));
        }
    }

    // ---------- Questão 02: Selection Sort ----------
    public static void selectionSort(double[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[menor]) {
                    menor = j;
                }
            }
            double aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        }
    }

    public static void questao02(Scanner sc) {
        int s = sc.nextInt();
        for (int k = 1; k <= s; k++) {
            int n = sc.nextInt();
            double[] precos = new double[n];
            for (int i = 0; i < n; i++) {
                precos[i] = sc.nextDouble();
            }
            selectionSort(precos);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(" ");
                sb.append(String.format(Locale.US, "%.2f", precos[i]));
            }
            System.out.println("Precos ordenados da secao " + k + ": " + sb);
            System.out.println("Preco mais barato da secao " + k + ": "
                    + String.format(Locale.US, "%.2f", precos[0]));
            System.out.println("Preco mais caro da secao " + k + ": "
                    + String.format(Locale.US, "%.2f", precos[n - 1]));
        }
    }

    // ---------- Questão 03: Bubble Sort (decrescente) ----------
    public static void bubbleSortDecrescente(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] < v[j + 1]) {
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

    public static void questao03(Scanner sc) {
        int n = sc.nextInt();
        int[] notas = new int[n];
        for (int i = 0; i < n; i++) {
            notas[i] = sc.nextInt();
        }
        bubbleSortDecrescente(notas);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(" ");
            sb.append(notas[i]);
        }
        System.out.println("Avaliacoes ordenadas: " + sb);
        System.out.println("Melhor avaliacao: " + notas[0]);
        System.out.println("Pior avaliacao: " + notas[n - 1]);
    }

    // ---------- Menu ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // decimais com ponto (19.99)

        System.out.println("Escolha a questão (1, 2 ou 3):");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> questao01(sc);
            case 2 -> questao02(sc);
            case 3 -> questao03(sc);
            default -> System.out.println("Opção inválida.");
        }
        sc.close();
    }
}
