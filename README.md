# ClinicaPlusRefatorado

Projeto Java criado para a Etapa 6 do Projeto Integrador, com refatoração do sistema desktop Clínica Plus.

## Objetivo
Separar regras de negócio da interface Swing, deixando as classes de domínio reutilizáveis em um futuro sistema web.

## Estrutura
- `model`: entidades do sistema (`Paciente`, `Medico`, `Consulta`, `Usuario`).
- `repository`: interfaces de persistência.
- `repository.memory`: implementação em memória para testes.
- `service`: regras de negócio e validações.
- `exception`: exceção de validação.

## Como testar no NetBeans
1. Abra o projeto como projeto Maven no NetBeans.
2. Execute a classe `clinicaplus.ClinicaPlusRefatorado`.
3. O método `main()` cadastra paciente, médico, agenda consulta e testa autenticação.

## Como testar pelo terminal
Se o Maven estiver instalado:

```bash
mvn compile exec:java
```

Sem Maven:

```bash
find src/main/java -name "*.java" > sources.txt
javac -d target/classes @sources.txt
java -cp target/classes clinicaplus.ClinicaPlusRefatorado
```
