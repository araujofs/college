package br.edu.ifpb.pweb2.springioc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.edu.ifpb.pweb2.springioc.paragrafo.GeradorParagrafoIntf;
import br.edu.ifpb.pweb2.springioc.paragrafo.GeradorParagrafoTexto;

@Configuration
@ComponentScan("br.edu.ifpb.pweb2.springioc")
public class DocumentGeneratorConf {

  @Bean
  GeradorParagrafoIntf geradorParagrafoTexto() {
    return new GeradorParagrafoTexto();
  }

}
