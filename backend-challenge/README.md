
# Desafio Back-end do Green Team

Aqui vou explicar algumas das ideias por de trás das escolhas  desse projeto.


## Stack Utilizada
- Java com Spring Boot (uma stack muito usada e que eu tive interesse de utilizar)
- MySQL (projetos simples são bem atendidos por bancos relacionais)
- Argon2id (melhor algoritmo de criptografia que conheço)
- JWT (padrão para autenticação)
- Swagger (para facilitar no teste da API)
- Lombok (para reduzir código boilerplate)
## Estrutura de pastas
### Application

A ideia dessa camada é conter as partes de acesso a API e a lógica de implementação dos services. Ela é dividida em:

- Contracts: DTOs das requests e das responses dos endpoints onde for necessário o uso para padronizar entradas e saídas.
- Controllers: endpoints da aplicação.
- Exceptions: exceções personalizadas para os erros de bad request, nesse caso.
- Services: aqui tem toda a lógica da aplicação concentrando o uso dos repositories, das entities e do que for necessário para o funcionamento da aplicação.

### Configurations
As configurações da aplicação se concentram aqui.

- CryptographyConfig: Indica a implementação do Argon2id para criptografia de senhas na aplicação.
- OpenApiConfig: Configura o Swagger para funcionar com JWT tokens.
- SecurityConfig: Configura o JWT Security mostrando as requisições que precisam de autenticação e como deve ser feito o processo de autorização por meio do UserAuthorizationFilter.
- TokenConfig: Indica a implementação do JWT para tokens.

### Domain
Aqui temos o coração da aplicação. Por não haver muitas regras de negócio esse domínio pode ser considerado anêmico.

- Entities: O modelo das entidades da aplicação.
- Repositories: Interface de acesso aos dados do BD.

### Infra
Contém todo acesso a sistemas externos a aplicação e a lógica interna dela. Nesse caso o único uso foi para a parte de segurança.

- Auth: Tudo relacionado a autenticação e autorização que é integrado com o Spring Security.
- Cryptography: Lógica de implementação do serviço de criptografia do projeto.
## Rodando localmente
É recomendado o uso do Docker para baixar uma imagem do MySQL 8.4.6, ou versão similar.

Clone o projeto

```bash
  git clone https://github.com/MatheusMacedoDev/green-team-challenge.git
```

Entre no diretório do projeto

```bash
  cd green-team-challenge/backend-challenge/
```

Utilize o Maven para baixar dependências

```bash
  mvn dependency:copy-dependencies
```

Duplique o arquivo .env.example e mude seu nome para .env. Após isso preencha com seus dados locais:
```
DB_HOSTNAME=hostname
DB_PORT=port
DB_DATABASE=database
DB_USER=root
DB_PASSWORD=password

JWT_SECRET=some_secret
```

Execute a aplicação

```bash
  mvn spring-boot:run
```


