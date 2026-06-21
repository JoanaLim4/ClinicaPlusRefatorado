package br.com.clinicaplus.controller;

import br.com.clinicaplus.model.Paciente;
import br.com.clinicaplus.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("paciente", new Paciente());
        model.addAttribute("pacientes", service.listar());
        return "pacientes";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Paciente paciente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pacientes", service.listar());
            return "pacientes";
        }
        service.salvar(paciente);
        return "redirect:/pacientes";
    }
}
