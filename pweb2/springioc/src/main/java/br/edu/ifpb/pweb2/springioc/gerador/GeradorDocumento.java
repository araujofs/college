package br.edu.ifpb.pweb2.springioc.gerador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.springioc.paragrafo.GeradorParagrafoIntf;

@Component
public class GeradorDocumento implements GeradorDocumentIntf {
  @Autowired
  // @Qualifier("geradorParagrafoTexto")
  // @Qualifier("geradorParagrafoHTML")
  @Qualifier("geradorParagrafoLibreOffice")
  // @Qualifier("geradorParagrafoPDF")
  GeradorParagrafoIntf genParagrafo;

  @Override
  public void addTexto(String texto) {
    genParagrafo.addParagrafo(texto);
  }
}
