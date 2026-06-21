package br.com.clinicaplus.controller;

import br.com.clinicaplus.model.Medico;
import br.com.clinicaplus.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("medico", new Medico());
        model.addAttribute("medicos", service.listar());
        return "medicos";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Medico medico, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("medicos", service.listar());
            return "medicos";
        }
        service.salvar(medico);
        return "redirect:/medicos";
    }
}
