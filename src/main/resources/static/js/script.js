function campoObrigatorio(id, mensagem) {
    const campo = document.getElementById(id);
    if (!campo || campo.value.trim() === "") {
        alert(mensagem);
        if (campo) campo.focus();
        return false;
    }
    return true;
}

function validarPaciente() {
    return campoObrigatorio("cpf", "Informe o CPF do paciente.")
        && campoObrigatorio("nome", "Informe o nome do paciente.")
        && campoObrigatorio("telefone", "Informe o telefone do paciente.");
}

function validarMedico() {
    return campoObrigatorio("cpf", "Informe o CPF do médico.")
        && campoObrigatorio("crm", "Informe o CRM do médico.")
        && campoObrigatorio("nome", "Informe o nome do médico.")
        && campoObrigatorio("especialidade", "Informe a especialidade.");
}

function validarConsulta() {
    if (!campoObrigatorio("cpfPaciente", "Informe o CPF do paciente.")) return false;
    if (!campoObrigatorio("nomePaciente", "Informe o nome do paciente.")) return false;
    if (!campoObrigatorio("crmMedico", "Informe o CRM do médico.")) return false;
    if (!campoObrigatorio("horario", "Informe o horário.")) return false;

    const horario = document.getElementById("horario").value.trim();
    if (!/^\d{2}:\d{2}$/.test(horario)) {
        alert("Informe o horário no formato HH:mm.");
        return false;
    }
    return true;
}
