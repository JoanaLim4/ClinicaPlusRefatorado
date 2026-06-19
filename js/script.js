function mostrarMensagem(id, texto, tipo) {
  const elemento = document.getElementById(id);
  if (!elemento) return;
  elemento.textContent = texto;
  elemento.className = 'mensagem ' + tipo;
}

function campoVazio(valor) {
  return !valor || valor.trim() === '';
}

function cpfValido(cpf) {
  return /^\d{11}$/.test(cpf);
}

const formLogin = document.getElementById('formLogin');
if (formLogin) {
  formLogin.addEventListener('submit', function(event) {
    event.preventDefault();
    const identificacao = document.getElementById('identificacao').value;
    const senha = document.getElementById('senha').value;

    if (campoVazio(identificacao) || campoVazio(senha)) {
      mostrarMensagem('mensagemLogin', 'Preencha CPF/CRM e senha.', 'erro');
      return;
    }

    mostrarMensagem('mensagemLogin', 'Login validado. Redirecionando...', 'sucesso');
    setTimeout(() => window.location.href = 'dashboard.html', 900);
  });
}

const formPaciente = document.getElementById('formPaciente');
if (formPaciente) {
  formPaciente.addEventListener('submit', function(event) {
    event.preventDefault();
    const nome = document.getElementById('nomePaciente').value;
    const cpf = document.getElementById('cpfPaciente').value;
    const telefone = document.getElementById('telefonePaciente').value;

    if (campoVazio(nome) || campoVazio(cpf) || campoVazio(telefone)) {
      mostrarMensagem('mensagemPaciente', 'Preencha todos os campos do paciente.', 'erro');
      return;
    }

    if (!cpfValido(cpf)) {
      mostrarMensagem('mensagemPaciente', 'CPF deve conter 11 números.', 'erro');
      return;
    }

    const tabela = document.getElementById('tabelaPacientes');
    tabela.innerHTML += `<tr><td>${nome}</td><td>${cpf}</td><td>${telefone}</td></tr>`;
    formPaciente.reset();
    mostrarMensagem('mensagemPaciente', 'Paciente cadastrado na tabela da página.', 'sucesso');
  });
}

const formMedico = document.getElementById('formMedico');
if (formMedico) {
  formMedico.addEventListener('submit', function(event) {
    event.preventDefault();
    const nome = document.getElementById('nomeMedico').value;
    const crm = document.getElementById('crmMedico').value;
    const especialidade = document.getElementById('especialidadeMedico').value;
    const email = document.getElementById('emailMedico').value;

    if (campoVazio(nome) || campoVazio(crm) || campoVazio(especialidade) || campoVazio(email)) {
      mostrarMensagem('mensagemMedico', 'Preencha todos os campos do médico.', 'erro');
      return;
    }

    const tabela = document.getElementById('tabelaMedicos');
    tabela.innerHTML += `<tr><td>${nome}</td><td>${crm}</td><td>${especialidade}</td><td>${email}</td></tr>`;
    formMedico.reset();
    mostrarMensagem('mensagemMedico', 'Médico cadastrado na tabela da página.', 'sucesso');
  });
}

const formConsulta = document.getElementById('formConsulta');
if (formConsulta) {
  formConsulta.addEventListener('submit', function(event) {
    event.preventDefault();
    const cpf = document.getElementById('cpfConsulta').value;
    const crm = document.getElementById('crmConsulta').value;
    const data = document.getElementById('dataConsulta').value;
    const hora = document.getElementById('horaConsulta').value;

    if (campoVazio(cpf) || campoVazio(crm) || campoVazio(data) || campoVazio(hora)) {
      mostrarMensagem('mensagemConsulta', 'Preencha todos os dados da consulta.', 'erro');
      return;
    }

    if (!cpfValido(cpf)) {
      mostrarMensagem('mensagemConsulta', 'CPF deve conter 11 números.', 'erro');
      return;
    }

    const tabela = document.getElementById('tabelaConsultas');
    tabela.innerHTML += `<tr><td>${cpf}</td><td>${crm}</td><td>${data}</td><td>${hora}</td><td>Agendada</td></tr>`;
    formConsulta.reset();
    mostrarMensagem('mensagemConsulta', 'Consulta agendada na tabela da página.', 'sucesso');
  });
}
