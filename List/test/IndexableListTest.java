import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IndexableListTest {

    //Criação de objetos do tipo ArrayList para serem utilizados nos testes
    static ArrayList<String> listaCarrosNovos = new ArrayList<String>();
    static ArrayList<String> listaCarrosVelhos = new ArrayList<String>();
    static ArrayList<String> listaVaziaEsquerda = new ArrayList<String>();
    static ArrayList<String> listaVaziaDireita= new ArrayList<String>();
    static String carroVelho1 = "Marea";
    static String carroVelho2 = "Opala";
    static String carroNovo1 = "Aventador";
    static String carroNovo2 = "Gallardo";
    static String carroVelho = "Santana";
    static String carroNovo = "SLK-250";

    //Metodo auxiliar para imprimir valores dos Arrays
    void ImprimirArrays(IndexableList lista){
        Print(Arrays.toString(lista.arrayEsquerda));
        Print(Arrays.toString(lista.arrayDireita));
    }

    //Metodo criado como uma alternativa ao System.out.println para facilitar debugs
    void Print(Object o){
        System.out.println(o);
    }

    //Criação de um metodo de setup para ser executado antes de cada teste
    @BeforeAll
    public static void setUp(){
        listaCarrosNovos.add(carroNovo1);
        listaCarrosNovos.add(carroNovo2);
        listaCarrosVelhos.add(carroVelho1);
        listaCarrosVelhos.add(carroVelho2);
    }

    //Verificar se é possivel adicionar um novo elemento na lista da direita
    //Validar se o retorno da função acrescentar é true
    @Test
    void testAcrescentar() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);
        boolean retorno = lista.acrescentar(carroVelho);

        assertTrue(retorno);
    }

    //Verificar se o elemento adicionado consta na posição correta
    @Test
    void testPosicaoAcrescentar(){
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);
        lista.acrescentar(carroVelho);

        for(int i=0; i< lista.arrayDireita.length; i++){
            if(i == 2){
                assertEquals(carroVelho, lista.arrayDireita[i]);
            }
        }
    }

    //Verificar se é possivel adicionar um novo elemento na lista da esquerda
    //Validar se o retorno da função acrescentar é true
    @Test
    void testPrefixar() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        boolean retorno = lista.prefixar("abc");

        //ImprimirArrays(lista);

        assertTrue(retorno);
    }

    //Verificar se o elemento adicionado consta na posição correta
    @Test
    void testPosicaoPrefixar(){
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);
        lista.prefixar(carroNovo);

        for(int i=0; i< lista.arrayEsquerda.length; i++){
            if(i == 2){
                assertEquals(carroNovo, lista.arrayEsquerda[i]);
            }
        }
    }

    //Verificar se o metodo add funciona para o array da esquerda
    @Test
    void testAddEsquerda() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);
        lista.add(1, carroNovo);

        for(int i=0; i< lista.arrayEsquerda.length; i++){
            if(i == 1){
                assertEquals(carroNovo, lista.arrayEsquerda[i]);
            }
        }
    }

    //Verificar se o metodo add funciona para o array da direita
    //Bug No GET dentro do ADD -> linha 139 (foi removido o -1 da posição do array)
    @Test
    void testAddDireita() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);
        //Index 3 da lista completa corresponde a posição 1 da lista da direita (index - numElem1)
        lista.add(3, carroVelho);

        for(int i=0; i< lista.arrayDireita.length; i++){
            if(i == 1){
                assertEquals(carroVelho, lista.arrayDireita[i]);
            }
        }
    }

    //Aumenta a lista da esquerda em duas unidades e verifica novo tamanho
    @Test
    void testAumentarEsquerdaArray() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);
        lista.aumentarEsquerdaArray(2);

        assertEquals(4, lista.arrayEsquerda.length);
    }

    //Aumenta a lista da direita em duas unidades e verifica novo tamanho
    @Test
    void testAumentarDireitaArray() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);
        lista.aumentar(2);

        assertEquals(4, lista.arrayDireita.length);
    }

    //Bug encontrado no primeiro return do metodo contem (linha 119)
    //Verifica se elemento esta contido na lista da esquerda
    @Test
    void testContemListaEsquerda() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertTrue(lista.contem(carroNovo1));
    }

    //Verifica se elemento esta contido na lista da direita
    @Test
    void  testContemListaDireita(){
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertTrue(lista.contem(carroVelho2));
    }

    //Verifica se elemento retornado da lista da esquerda condiz com o inserido
    @Test
    void testGetEsquerda() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertEquals(lista.get(1), carroNovo2);
    }

    //Verifica se elemento retornado da lista da direita condiz com o inserido
    @Test
    public void testGetDireita(){
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertEquals(lista.get(2), carroVelho1);
    }

    //Verifica a posição de um elemento da lista da esquerda
    @Test
    void testIndexOfEsquerda() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertEquals(1, lista.indexOf(carroNovo2));
    }

    //Verifica a posição de um elemento da lista da direita
    @Test
    void testIndexOfDireita() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertEquals(2,lista.indexOf(carroVelho1));
    }

    //Verifica a retorno -3 para um elemento não existente da lista
    @Test
    void testIndexOfNotFound() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertEquals(-3, lista.indexOf(carroNovo));
    }

    //Verifica se uma lista vazia retorna True
    @Test
    void testListaVazia() {
        IndexableList lista = new IndexableList<>(listaVaziaEsquerda, listaVaziaDireita);

        assertTrue(lista.verificarListaVazia());
    }

    //Verifica se uma lista com elementos retorna False
    @Test
    void testListaPopulada() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertFalse(lista.verificarListaVazia());
    }

    //Função remover com bug na linha 179
    //Verifica o funcionamento da função remover, onde deve retornar o nome do item removido
    @Test
    void testRemoverEsquerda() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertEquals(carroNovo1, lista.remover(0));
    }

    //Verifica o funcionamento da função remover da lista da direita
    @Test
    void testRemoverDireita() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertEquals(carroVelho2, lista.remover(3));
    }

    //Verifica se um elemento pode ser adicionado na lista da esquerda
    @Test
    void testSetEsquerda() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);
        lista.set(1, carroNovo);

        for(int i=0; i < lista.arrayEsquerda.length; i++ ){
            if(i == 0){
                assertEquals(carroNovo, lista.arrayEsquerda[i]);
            }
        }
    }

    //Verifica se um elemento pode ser adicionado na lista da direita
    @Test
    void testSetDireita() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);
        lista.set(2, carroVelho);

        for(int i=0; i < lista.arrayDireita.length; i++ ){
            if(i == 0){
                assertEquals(carroVelho, lista.arrayDireita[i]);
            }
        }
    }

    //Verifica o tamanho da lista total (Esquerda + direita)
    @Test
    void testSize() {
        IndexableList lista = new IndexableList<>(listaCarrosNovos, listaCarrosVelhos);

        assertEquals(4,lista.size());
    }
}