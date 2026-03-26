package br.edu.ifpb.pweb2.bitbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.pweb2.bitbank.model.Correntista;
import br.edu.ifpb.pweb2.bitbank.repository.CorrentistaRepository;

@Controller
@RequestMapping("/correntistas")
public class CorrentistaController {

  @Autowired
  private CorrentistaRepository repo;

  @RequestMapping("/form")
  public String getForm(Correntista correntista, Model model) {
    model.addAttribute("correntista", correntista);
    return "correntistas/form";
  }

  @RequestMapping("/save")
  public String postForm(Correntista correntista, Model model) {
    var mensagem = "";
    if (correntista.getNome() == null || correntista.getNome().isEmpty()) {
      mensagem += "Nome é obrigatório!\n";
    }

    if (correntista.getNome().length() > 50) {
      mensagem += "Nome deve ter 50 caracteres ou menos!\n";
    }

    if (correntista.getEmail() == null || correntista.getEmail().isEmpty()) {
      mensagem += "Email é obrigatório!\n";
    }

    if (correntista.getSenha() == null || correntista.getSenha().isEmpty()) {
      mensagem += "Senha é obrigatória!\n";
    }

    if (!mensagem.isEmpty()) {
      model.addAttribute("correntista", correntista);
      model.addAttribute("mensagem", mensagem);
      return "correntistas/form";
    }

    repo.save(correntista);
    model.addAttribute("correntistas", repo.findAll());
    return "correntistas/list";
  }

}
