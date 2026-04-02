package locadora;

public class Basico extends Classificacao {

  @Override
  public Double getValorLocacao(Integer diasAlugado) {
    return diasAlugado * 90.0;
  }

  @Override
  public Integer getCodigoDoPreco() {
    return 0;
  }

}
