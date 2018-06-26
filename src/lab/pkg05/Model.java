/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg05;

/**
 * * @author Arthur Igor Morais do Nascimento
 * Matricula: 161080219
 * @author Artu
 */
public class Model {

    public int[] insertionSort(int[] vetor) {
        int aux, a;//aux para interar os valores do vetor

        for (int j = 1; j < vetor.length; j++) {
            aux = vetor[j];//passa o segundo valor do vetor para aux
            for (a = j - 1; (a >= 0) && (vetor[a] > aux); a--) {
                vetor[a + 1] = vetor[a];
            }
            vetor[a + 1] = aux;//atribui o proximo valor do vetor para aux
        }

        return vetor;
    }

    public int[] bubbleSort(int veto[]) {//bubblesort
        for (int i = veto.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (veto[j - 1] > veto[j]) {
                    int aux = veto[j];
                    veto[j] = veto[j - 1];
                    veto[j - 1] = aux;
                }
            }
        }
        return veto;

    }

    public int[] quickSort(int[] vetor, int ini, int fim) {// quicksort
        if (ini < fim) {
            int posicaoAux = separar(vetor, ini, fim);// atribui a var auxilizar o elemto divisivel das duas listas
            quickSort(vetor, ini, posicaoAux - 1);
            quickSort(vetor, posicaoAux + 1, fim);
        }
        return vetor;
    }

    private static int separar(int[] vetor, int ini, int fim) {//retorna a variavel aux com o elemento divisivel entra as duas listas
        int aux = vetor[ini];
        int i = ini + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= aux) {
                i++;
            } else if (aux < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[ini] = vetor[f];
        vetor[f] = aux;
        return f;
    }

    static int[] mergeSort(int[] esq, int[] dir) {//mergesort
        int[] aux = new int[esq.length + dir.length];

        int indexDir = 0, indexEsq = 0, indexAux = 0;

        while (indexEsq < esq.length || indexDir < dir.length) {
            if (indexEsq < esq.length && indexDir < dir.length) {
                if (esq[indexEsq] <= dir[indexDir]) {
                    aux[indexAux] = esq[indexEsq];
                    indexAux++;
                    indexEsq++;
                } else {
                    aux[indexAux] = dir[indexDir];
                    indexAux++;
                    indexDir++;
                }
            } else if (indexEsq < esq.length) {
                aux[indexAux] = esq[indexEsq];
                indexAux++;
                indexEsq++;
            } else if (indexDir < dir.length) {
                aux[indexAux] = dir[indexDir];
                indexAux++;
                indexDir++;
            }
        }
        return aux;
    }

    public static int[] sort(int[] vetor) {

        if (vetor.length <= 1) {

            return vetor;
        }
        int meio = vetor.length / 2;
        int[] dir = vetor.length % 2 == 0 ? new int[meio] : new int[meio + 1];
        int[] esq = new int[meio];

        int[] aux = new int[vetor.length];

        System.arraycopy(vetor, 0, esq, 0, meio);

        int auxIndex = 0;
        for (int i = meio; i < vetor.length; i++) {
            dir[auxIndex] = vetor[i];
            auxIndex++;
        }

        esq = sort(esq);
        dir = sort(dir);

        aux = mergeSort(esq, dir);

        return aux;
    }

    public void mostrarQuick() {
        int quantidade = 10000;
        int[] vetor = new int[quantidade];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * quantidade);
        }

        long tempoInicial = System.currentTimeMillis();

        quickSort(vetor, 0, vetor.length - 1);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("\nQuickSort executado em = " + (tempoFinal - tempoInicial) + " ms\n");

    }

    public void mostrarInserion() {
        int quantidade = 10000;
        int[] vetor = new int[quantidade];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * quantidade);
        }

        long tempoInicial = System.currentTimeMillis();

        insertionSort(vetor);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("\n IInsertionSort executado em = " + (tempoFinal - tempoInicial) + " ms\n ");
    }

    public void mostrarBubble() {
        int quantidade = 10000;
        int[] vetor = new int[quantidade];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * quantidade);
        }

        long tempoInicial = System.currentTimeMillis();

        bubbleSort(vetor);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("\n BubbleSort executado em = " + (tempoFinal - tempoInicial) + " ms \n");
    }

    public void mostrarMerge() {
        int quantidade = 10000;
        int[] vetor = new int[quantidade];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * quantidade);
        }

        long tempoInicial = System.currentTimeMillis();

        sort(vetor);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("\nMergeSort executado em = " + (tempoFinal - tempoInicial) + " ms \n");
    }
}
