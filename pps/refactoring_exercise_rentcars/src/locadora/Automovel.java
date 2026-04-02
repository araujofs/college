package locadora;

public class Automovel implements Alugavel {
  public static final int BASICO = 0; // Carros hatch
  public static final int FAMILIA = 1; // Carros Sedan ou SUV básico
  public static final int LUXO = 2; // Carros padrão luxo

  private String descricao;
  private String placa;
  private int ano; // Ano de fabricacao
  private Classificacao classificacao;

  public Automovel(String descricao, int ano, String placa, int codigoDoPreco) {
    this.descricao = descricao;
    this.placa = placa;
    this.ano = ano;
    setCodigoDoPreco(codigoDoPreco);
  }

  @Override
  public String getDescricao() {
    return descricao;
  }

  public String getPlaca() {
    return placa;
  }

  @Override
  public Integer getAno() {
    return ano;
  }

  public int getCodigoDoPreco() {
    return classificacao.getCodigoDoPreco();
  }

  public void setCodigoDoPreco(int codigoDoPreco) {
    switch (codigoDoPreco) {
      case Automovel.BASICO:
        this.classificacao = new Basico();
        break;

      case Automovel.FAMILIA:
        this.classificacao = new Familia();
        break;

      case Automovel.LUXO:
        this.classificacao = new Luxo();
        break;

    } // switch
  }

  @Override
  public Double getValorLocacao(Integer diasAlugado) {
    return classificacao.getValorLocacao(diasAlugado);
  }

  @Override
  public Integer getPontosAlugadorFrequente(Integer diasAlugado) {
    return classificacao.getPontosAlugadorFrequente(diasAlugado);
  }
}
