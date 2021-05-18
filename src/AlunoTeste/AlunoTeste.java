package AlunoTeste;

import Model.Aluno;

import org.junit.jupiter.api.*;

public class AlunoTeste {

    private Aluno a1;

    @BeforeEach
    private void instanciar() {
        a1 = new Aluno();
    }

    /**
     * Objetivo: Verificar se Classe Aluno método 'setNome' está aceitando nomes vazios.
     */
    @Test
    public void AvaliaNomeAlunoVazio() {
        Assertions.assertThrows(RuntimeException.class, ()->a1.setNome(""));
    }

    /**
     * Objetivo: Verificar se Classe Aluno método 'setNome' está aceitando nomes com mais de 100 caracteres.
     */
    @Test
    public void AvaliaNomeAlunoGrande() {
        String entrada = "estaleiro da empresa britânica J. and G. Rennie em Greenwich, Inglaterra, e era líder de sua classe, que também contava com o Colombo. Foi lançado ao mar em 1865 e incorporado à armada em 15 de setembro de 1866. O encouraçado era inteiramente construído de ferro e deslocava 858, 1 033 ou 1050 toneladas, a depender da fonte de referência. Possuía dois motores a vapor que desenvolviam até 750 hp de potência, impulsionando a embarcação a cerca de 20 km/h. Sua estrutura compreendia uma casamata dupla com oito bocas de fogo. A marinha teve grandes dificuldades com este navio, que era de difícil navegabilidade e, devido ao modelo de sua casamata, que deixava";
        Assertions.assertThrows(RuntimeException.class, ()->a1.setNome(entrada));
    }

    /**
     * Objetivo: Verificar se Classe Aluno método 'entraNota' está aceitando notas menores que zero (0).
     */
    @Test
    public void AvaliaValorNotaMenorZero() {
        Assertions.assertThrows(RuntimeException.class, ()->a1.entraNota(-2.0));
    }

    /**
     * Objetivo: Verificar se Classe Aluno método 'entraNota' está aceitando notas maiores que 30.
     */
    @Test
    public void AvaliaValorNotaMaior30() {
        Assertions.assertThrows(RuntimeException.class, ()->a1.entraNota(50.0));
    }

    /**
     * Objetivo: Verificar se Classe Aluno método 'retornaNotaTotal' está retornando notas maiores que 100.
     */
    @Test
    public void AvaliaTotalNotas() {
        for(int i = 0; i < 4; i++) {
            a1.entraNota(27.5);
        }
        Assertions.assertThrows(RuntimeException.class, ()->a1.retornaNotaTotal());
    }

    /**
     * Objetivo: Verificar se Classe Aluno método 'retornaNotaTotal' está retornando zero (0) quando o aluno não tem nota lançada.
     */
    @Test
    public void AvaliaAlunoSemNotaLancada() {
        Double resultadoEsperado = 0.0;
        Double resultadoObtido = a1.retornaNotaTotal();
        Assertions.assertEquals(resultadoEsperado, resultadoObtido, 0.001);
    }
}