
//***** import para rodar o codigo original da lista1.2.1-GRASP-refactoring
import locadora.Automovel;
import locadora.Cliente;
import locadora.Locacao;

//***** import para rodar o codigo alterado pela lista01.2.2-GRASP-refactoring
// refactoring 1
//import locadora.Locacao;
//import locadora.Automovel;
//import refactoring1.Cliente;

//***** import para executar o codigo conforme modificacoes da lista01.2.3-GRASP-refactoring
//import locadora.Automovel;
//import refactoring2.Cliente;
//import refactoring2.Locacao;

//********** import para executar o codigo conforme modificacoes da lista01.2.4-GRASP-refactoring
//import refactoring3.*;

// Tarefa refactoring4
// import refactoring4.Automovel;
// import refactoring4.Cliente;
// import refactoring4.Locacao;

// Usando a classe cliente do pacote "refactoring1" : Lista 1.2.1
//import refactoring1.Cliente;

//Usando a classe cliente do pacote "refactoring2"  : Lista 1.2.2
//import refactoring2.Cliente;
//import refactoring2.Locacao;

//Usando a classe cliente do pacote "refactoring3"  : Lista 1.2.3
//import refactoring3.Cliente;
//import refactoring3.Locacao;
//import refactoring3.Automovel;

public class Locadora {
  public static void main(String[] args) {
    Cliente c1 = new Cliente("Alex Sandro");

    c1.adicionaLocacao(new Locacao(new Automovel("Toyota Corolla xEi", 2021, "PLN0525", Automovel.LUXO), 10));
    c1.adicionaLocacao(new Locacao(new Automovel("Fiat Mobi", 2021, "JPA2464", Automovel.BASICO), 2));
    c1.adicionaLocacao(new Locacao(new Automovel("BMW Série 7", 2022, "UBA0808", Automovel.LUXO), 30));
    c1.adicionaLocacao(new Locacao(new Automovel("Fiat Siena", 2023, "ABC0001", Automovel.FAMILIA), 4));
    c1.adicionaLocacao(new Locacao(new Automovel("Honda HRV", 2024, "KJD9745", Automovel.FAMILIA), 10));
    c1.adicionaLocacao(new Locacao(new Automovel("Volkswagen Gol", 2024, "JJJ0055", Automovel.BASICO), 3));

    System.out.println(c1.extrato());

  }
}
