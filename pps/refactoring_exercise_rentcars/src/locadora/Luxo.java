package locadora;

public class Luxo extends Classificacao {

  @Override
  Double getValorLocacao(Integer diasAlugado) {
    var valor = 0.0;

    valor += diasAlugado * 200.0;

    // Adiciona um desconto de 10% se alugar o carro por mais de 4 dias
    if (diasAlugado > 4) {
      valor *= 0.9;
    }

    return valor;
  }

  @Override
  Integer getCodigoDoPreco() {
    return 2;
  }

  @Override
  Integer getPontosAlugadorFrequente(Integer diasAlugado) {
    var pontosDeLocadorFrequente = super.getPontosAlugadorFrequente(diasAlugado);

    // adiciona bonus para locação de um carro de luxo por pelo menos 3 dias
    if (this.getCodigoDoPreco() == Automovel.LUXO && diasAlugado > 2) {
      pontosDeLocadorFrequente += 2;
    }

    return pontosDeLocadorFrequente;
  }

}
