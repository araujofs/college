package br.edu.ifpb.pweb2.springioc.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.ifpb.pweb2.springioc.configuration.DocumentGeneratorConf;
import br.edu.ifpb.pweb2.springioc.gerador.GeradorDocumentIntf;

public class GeradorTextosApp {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DocumentGeneratorConf.class);
    GeradorDocumentIntf gerador = context.getBean(GeradorDocumentIntf.class);

    gerador.addTexto("As fronteiras da minha linguagem são as fronteiras do meu mundo.");
    gerador.addTexto("Sobre o que não se pode falar, deve-se calar.");
    gerador.addTexto("-- Ludwig Wittgenstein");

    context.close();
  }

}
