package clinicaplus;

import clinicaplus.model.Consulta;
import clinicaplus.model.PerfilUsuario;
import clinicaplus.repository.ConsultaRepository;
import clinicaplus.repository.MedicoRepository;
import clinicaplus.repository.PacienteRepository;
import clinicaplus.repository.UsuarioRepository;
import clinicaplus.repository.memory.InMemoryConsultaRepository;
import clinicaplus.repository.memory.InMemoryMedicoRepository;
import clinicaplus.repository.memory.InMemoryPacienteRepository;
import clinicaplus.repository.memory.InMemoryUsuarioRepository;
import clinicaplus.service.AutenticacaoService;
import clinicaplus.service.ConsultaService;
import clinicaplus.service.MedicoService;
import clinicaplus.service.PacienteService;
import java.time.LocalDateTime;

public class ClinicaPlusRefatorado {
    public static void main(String[] args) {
        PacienteRepository pacienteRepository = new InMemoryPacienteRepository();
        MedicoRepository medicoRepository = new InMemoryMedicoRepository();
        ConsultaRepository consultaRepository = new InMemoryConsultaRepository();
        UsuarioRepository usuarioRepository = new InMemoryUsuarioRepository();

        PacienteService pacienteService = new PacienteService(pacienteRepository);
        MedicoService medicoService = new MedicoService(medicoRepository);
        ConsultaService consultaService = new ConsultaService(consultaRepository, pacienteRepository, medicoRepository);
        AutenticacaoService autenticacaoService = new AutenticacaoService(usuarioRepository);

        pacienteService.cadastrar("12345678900", "Ana Lima", "1199999-0000");
        medicoService.cadastrar("98765432100", "CRM001", "Dra. Marina", "Clínica Geral", "1188888-0000", "marina@clinicaplus.com");
        Consulta consulta = consultaService.agendar("12345678900", "CRM001", LocalDateTime.of(2026, 6, 20, 14, 30));
        PerfilUsuario perfil = autenticacaoService.autenticar("CRM001", "123");

        System.out.println("=== TESTES DO PROJETO REFATORADO ===");
        System.out.println("Paciente cadastrado: " + pacienteService.buscarPorCpf("12345678900").orElseThrow());
        System.out.println("Médico cadastrado: " + medicoService.buscarPorCrm("CRM001").orElseThrow());
        System.out.println("Consulta agendada: " + consulta);
        System.out.println("Perfil autenticado: " + perfil);
        System.out.println("Total de pacientes: " + pacienteService.listarTodos().size());
        System.out.println("Total de médicos: " + medicoService.listarTodos().size());
        System.out.println("Total de consultas: " + consultaService.listarTodas().size());
        System.out.println("Todos os testes foram executados com sucesso.");
    }
}
