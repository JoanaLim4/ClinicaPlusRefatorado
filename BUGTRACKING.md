# Registro de Falhas - Etapa 9

| ID | Falha encontrada | Severidade | Status | Correção aplicada |
|---|---|---|---|---|
| BUG-001 | Sistema aceitava horário fora do expediente | Média | Corrigido | Criada regra `RegraConsulta.horarioValido()` e teste JUnit |
| BUG-002 | Formulários permitiam envio de campos vazios | Alta | Corrigido | Incluídas validações HTML/JavaScript e Bean Validation |
| BUG-003 | Front-end não estava integrado ao back-end | Alta | Corrigido | Criados controllers Spring MVC e templates Thymeleaf |
| BUG-004 | Dados não eram persistidos no projeto web | Alta | Corrigido | Adicionada camada Repository com Spring Data JPA e banco H2 |
