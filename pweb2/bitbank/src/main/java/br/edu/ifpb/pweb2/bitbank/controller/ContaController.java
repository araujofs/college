package br.edu.ifpb.pweb2.bitbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.bitbank.model.Conta;
import br.edu.ifpb.pweb2.bitbank.model.Correntista;
import br.edu.ifpb.pweb2.bitbank.service.ContaService;
import br.edu.ifpb.pweb2.bitbank.service.CorrentistaService;

@Controller
@RequestMapping("/contas")
public class ContaController {

  @Autowired
  private ContaService contaService;

  @Autowired
  private CorrentistaService correntistaService;

  @GetMapping("/form")
  public String getForm(Model model) {
    model.addAttribute("conta", new Conta(new Correntista()));
    return "contas/form";
  }

  @ModelAttribute("correntistaItems")
  public List<Correntista> getCorrentistas() {
    return correntistaService.findAll();
  }

  @PostMapping
  public String adicioneConta(Conta conta, Model model, RedirectAttributes flash) {
    contaService.save(conta);
    model.addAttribute("contas", contaService.findAll());
    flash.addFlashAttribute("mensagem", "Conta cadastrada!");
    return "contas/list";
  }

  @GetMapping
  public String liste(Model model) {
    model.addAttribute("contas", contaService.findAll());
    return "contas/list";
  }

  @GetMapping("/{id}")
  public String getCorrentistaById(@PathVariable(value = "id") Integer id, Model model) {
    model.addAttribute("conta", contaService.findById(id));
    return "contas/form";
  }
}
