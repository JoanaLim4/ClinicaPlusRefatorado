# Plano de Teste Básico - Clínica Plus

## 1. Objetivo
Validar as principais funcionalidades do sistema Clínica Plus refatorado, garantindo que as regras de negócio funcionem corretamente após a separação de responsabilidades.

## 2. Escopo dos testes
Serão testadas funcionalidades de cadastro, autenticação, agendamento e regras simples de consulta.

## 3. Teste unitário com JUnit
Classe testada: `RegraConsultaTest`.

Funcionalidades testadas:
- cálculo da duração da consulta em minutos;
- validação de horário comercial;
- lançamento de exceção quando o horário final é anterior ao inicial.

Comando para executar:

```bash
mvn test
```

## 4. Plano de testes manuais

| ID | Funcionalidade | Procedimento | Resultado esperado |
|---|---|---|---|
| CT01 | Cadastro de paciente | Informar CPF, nome e telefone válidos | Paciente cadastrado com sucesso |
| CT02 | Cadastro de médico | Informar CPF, CRM, nome, especialidade, telefone e e-mail válidos | Médico cadastrado com sucesso |
| CT03 | Agendamento de consulta | Informar CPF de paciente cadastrado, CRM de médico cadastrado e data/hora válida | Consulta criada e listada |
| CT04 | Cancelamento de consulta | Selecionar uma consulta existente e cancelar | Consulta marcada como cancelada |
| CT05 | Autenticação | Informar login e senha cadastrados | Sistema retorna o perfil correto do usuário |
| CT06 | Validação de campos obrigatórios | Tentar cadastrar paciente ou médico com campos vazios | Sistema apresenta erro de validação |
| CT07 | Regra de duração da consulta | Informar início 09:00 e fim 09:30 | Sistema retorna 30 minutos |
| CT08 | Horário comercial | Testar consulta às 10:00 e às 19:00 | 10:00 válido; 19:00 inválido |

## 5. Evidência do repositório
Repositório GitHub: https://github.com/JoanaLim4/ClinicaPlusRefatorado

## 6. Conclusão
O projeto passou a contar com testes unitários em JUnit e com um plano de testes manuais, atendendo à proposta da Etapa 7.
