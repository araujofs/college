package br.edu.ifpb.pweb2.springioc.paragrafo;

public class GeradorParagrafoTexto implements GeradorParagrafoIntf {

  @Override
  public void addParagrafo(String texto) {
    System.out.println("{Texto}" + texto + "{/Texto}");
  }

}
