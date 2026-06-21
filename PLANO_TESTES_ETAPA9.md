# Plano de Testes - Etapa 9

## Objetivo
Validar o sistema web Clínica Plus desenvolvido com Spring MVC, banco de dados H2, JPA, HTML, CSS e JavaScript.

## Casos de teste

| Caso | Funcionalidade | Procedimento | Resultado esperado |
|---|---|---|---|
| CT-01 | Cadastro de paciente | Preencher CPF, nome e telefone e salvar | Paciente deve aparecer na tabela |
| CT-02 | Cadastro de médico | Preencher CPF, CRM, nome e especialidade e salvar | Médico deve aparecer na tabela |
| CT-03 | Agendamento de consulta | Preencher dados e horário válido, como 08:30 | Consulta deve aparecer como AGENDADA |
| CT-04 | Validação de horário | Informar horário 22:00 | Sistema deve recusar o horário |
| CT-05 | Cancelamento de consulta | Clicar em cancelar | Status deve mudar para CANCELADA |
| CT-06 | Validação de campos obrigatórios | Tentar enviar formulário vazio | Sistema deve bloquear o envio |

## Ferramentas usadas
- JUnit para testes unitários.
- Navegador para testes manuais.
- BUGTRACKING.md para registro de falhas.
