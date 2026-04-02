package locadora;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
  private String nome;
  private final String separadorLinha = System.getProperty("line.separator");
  private List<Locacao> locacoes = new ArrayList<Locacao>();

  public Cliente(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void adicionaLocacao(Locacao locacao) {
    locacoes.add(locacao);
  }

  public String extrato() {
    Integer pontosDeLocadorFrequente = 0;
    Integer sequencia = 0;

    // adiciona cabeçalho
    var resultado = "Registro de Locações de " + getNome() + separadorLinha;
    resultado += String.format("Seq Automovel             Ano  Diarias   Valor Pago" + separadorLinha);
    resultado += String.format("=== ==================== ===== ========= ===========" + separadorLinha);

    for (Locacao locacao : locacoes) {
      sequencia++;

      // trata de pontos de locador frequente
      pontosDeLocadorFrequente += locacao.getPontosAlugadorFrequente();

      // mostra o valor desta locação
      resultado += linhaLocacao(locacao, sequencia, locacao.getValor());
    } // while

    // adiciona rodapé
    resultado += "====================================================" + separadorLinha;
    resultado += String.format("Valor Acumulado em diárias............:  R$ %8.2f" + separadorLinha, getValorTotal());
    resultado += "Voce acumulou " + pontosDeLocadorFrequente +
        " pontos de locador frequente";

    return resultado;
  }

  public String extratoHTML() {
    final String fimDeLinha = System.getProperty("line.separator");
    int sequencia = 0;
    String resultado = "<html><body>" + fimDeLinha;
    resultado = String.format("<H2>Registro de Locacoes de <EM> %s</EM></H2>", getNome()) + fimDeLinha;
    resultado += "<table border=\"1\"><tr><th>Seq</th><th>Automóvel</th><th>Ano</th><th>Diárias</th><th>Valor</th></tr>"
        + fimDeLinha;

    for (Locacao locacao : locacoes) {
      // mostra valores para este Locacao
      sequencia++;
      resultado += String.format(
          "<tr><th>%02d.</th><th>%s</th><th>%4d</th><th>%2d</th><th>R$%8.2f</th></tr>" + fimDeLinha, sequencia,
          locacao.getCarro().getDescricao(), locacao.getCarro().getAno(),
          locacao.getDiasAlugado(), locacao.getValor());
    } // while
    // adiciona rodapé
    resultado += String.format(
        "<tfoot><tr><td colspan=\"4\">Valor Acumulado em diárias:</td><td><EM>R$ %8.2f</EM></td></tr></tfoot></table>" +
            fimDeLinha,
        getValorTotal());
    resultado += "<P>Voce acumulou <EM>" + getPontosTotaisDeAlugadorFrequente()
        + " pontos </EM> de alugador frequente</p></body></html> ";
    return resultado;
  }

  private String linhaLocacao(Locacao locacao, Integer sequencia, Double valorLocacao) {
    return String.format("%02d. %-20s  %d    %2d     R$ %8.2f" + separadorLinha, sequencia,
        locacao.getCarro().getDescricao(), locacao.getCarro().getAno(), locacao.getDiasAlugado(), valorLocacao);
  }

  private Double getValorTotal() {
    Double total = 0.0;
    for (Locacao locacao : locacoes) {
      total += locacao.getValor();
    }

    return total;
  }

  private Double getPontosTotaisDeAlugadorFrequente() {
    var total = 0.0;

    for (Locacao locacao : locacoes) {
      total += locacao.getPontosAlugadorFrequente();
    }

    return total;
  }
}
