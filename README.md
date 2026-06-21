# Clínica Plus - Etapa 9

Projeto Java Web Spring MVC desenvolvido para a Etapa 9 do Projeto Integrador.

## Funcionalidades implementadas
- Cadastro e listagem de pacientes.
- Cadastro e listagem de médicos.
- Agendamento e cancelamento de consultas.
- Integração do front-end HTML/CSS/JavaScript com o back-end Spring MVC.
- Persistência com JPA e banco de dados H2.
- Testes unitários com JUnit.
- Registro de falhas em arquivo de bugtracking.

## Como executar

```bash
mvn spring-boot:run
```

Depois acesse:

```text
http://localhost:8080
```

## Banco de dados H2

Acesse:

```text
http://localhost:8080/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:clinicaplus
```

Usuário:

```text
sa
```

Senha em branco.

## Testes

```bash
mvn test
```

## Repositório GitHub

Atualize o projeto em um novo repositório ou no repositório usado nas etapas anteriores.
