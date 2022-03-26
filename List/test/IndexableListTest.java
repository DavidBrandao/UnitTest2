import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IndexableListTest {

    //Primeira Lista
    ArrayList<String> carros = new ArrayList<String>();
    ArrayList<String> carros2 = new ArrayList<String>();


    @Test
    void acrescentar() {

        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        boolean retorno = ind.acrescentar("abc");

        System.out.println(Arrays.toString(ind.arrayEsquerda));
        System.out.println(Arrays.toString(ind.arrayDireita));

        assertTrue(retorno);
    }

    //Prefixo no "final" do array
    //Array esquerda sendo lido de tras pra frente
    @Test
    void prefixar() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        boolean retorno = ind.prefixar("abc");

        System.out.println(Arrays.toString(ind.arrayEsquerda));
        System.out.println(Arrays.toString(ind.arrayDireita));

        assertTrue(retorno);
    }


    @Test
    void add() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        ind.add(1, "carroInserido");

        System.out.println(Arrays.toString(ind.arrayEsquerda));
        System.out.println(Arrays.toString(ind.arrayDireita));

        assertEquals("carroInserido", ind.get(1));
    }

    @Test
    void aumentarEsquerdaArray() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        ind.aumentarEsquerdaArray(2);

        System.out.println(Arrays.toString(ind.arrayEsquerda));
        System.out.println(Arrays.toString(ind.arrayDireita));

        System.out.println(ind.size());

        assertEquals(ind.size(), 4);
    }

    @Test
    void aumentar() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        ind.aumentar(2);

        System.out.println(Arrays.toString(ind.arrayEsquerda));
        System.out.println(Arrays.toString(ind.arrayDireita));

        assertEquals(ind.arrayDireita.length, 4);
    }

    @Test
    void contem() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        assertTrue(ind.contem("civic"));
        // Metodo deveria retornar true ao invés de falso
        assertTrue(ind.contem("bmw"));
    }

    @Test
    void get() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        assertEquals(ind.get(1), "cooper");
    }

    @Test
    void indexOf() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        assertEquals(1,ind.indexOf("cooper") );
    }

    @Test
    void indexOfNotFound() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        assertEquals(-3,ind.indexOf("civ2ic"));
    }

    @Test
    void v() {

        IndexableList ind = new IndexableList<>(carros, carros2);
        assertTrue(ind.v());
    }

    //Função remover com bug na linha 179
    @Test
    void remover() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);

        ind.remover(0);
        assertEquals("bmw", ind.remover(0));

    }

    @Test
    void set() {
        carros.add("civic");
        carros.add("cooper");

        carros2.add("bmw");
        carros2.add("lambo");

        IndexableList ind = new IndexableList<>(carros, carros2);
        ind.set(1, "mercedes");

        assertEquals("mercedes", ind.get(1));
    }

    @Test
    void size() {
        carros.add("civic");
        carros.add("cooper");

        IndexableList ind = new IndexableList<>(carros, carros2);

        assertEquals(2,ind.size());
    }
}