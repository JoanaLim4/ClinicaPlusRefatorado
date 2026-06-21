package br.com.clinicaplus.controller;

import br.com.clinicaplus.model.Consulta;
import br.com.clinicaplus.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("consultas", service.listar());
        return "consultas";
    }

    @PostMapping
    public String agendar(@Valid @ModelAttribute Consulta consulta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("consultas", service.listar());
            return "consultas";
        }
        try {
            service.agendar(consulta);
            return "redirect:/consultas";
        } catch (IllegalArgumentException erro) {
            model.addAttribute("erro", erro.getMessage());
            model.addAttribute("consultas", service.listar());
            return "consultas";
        }
    }

    @PostMapping("/{id}/cancelar")
    public String cancelar(@PathVariable Long id) {
        service.cancelar(id);
        return "redirect:/consultas";
    }
}
