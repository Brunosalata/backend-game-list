# 🎮 Games API

Aplicação **Spring Boot (Java 21)** que fornece endpoints REST para gerenciamento de jogos.  
O projeto utiliza perfis de configuração separados (`test`, `development` e `production`) e suporta execução em container Docker.

---

## 🚀 Tecnologias utilizadas
- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Data JPA / Hibernate**
- **Spring Web**
- **Maven**
- **PostgreSQL** (padrão, mas adaptável a outros bancos)
- **Docker**

---

## 📂 Estrutura do projeto
```
    src/
    ├── main/
    │   ├── br/com/brunosalata/backend_game_list       # Código-fonte da aplicação
    │   │   ├── controllers                                        
    │   │   │   ├── GameController                                    # Controlador de Game
    │   │   │   └── GameListController                                # Controlador de GameList
    │   │   ├── dto                                                # Objetos para transferência de dados
    │   │   │   ├── GameDTO                                           # Carrega todos os atributos de Game
    │   │   │   ├── GameListDTO                                       # Carrega todos os atributos de GameList
    │   │   │   ├── GameMinDTO                                        # Carrega alguns atributos de Game
    │   │   │   └── ReplacementDTO                                    # Carrega alguns dados de Belonging e Game
    │   │   ├── entities                                           # Representações dos objetos
    │   │   │   ├── Belonging                                         # Entidade que define posição do jogo na lista
    │   │   │   ├── BelongingPK                                       # Entidade que relaciona jogo à lista
    │   │   │   ├── Game                                              # Entidade que representa Jogo
    │   │   │   └── GameList                                          # Entidade que representa Lista de Jogos
    │   │   ├── infra                                              
    │   │   │   └── WebConfig                                         # Configuração de Permissões e CORS 
    │   │   ├── projections                                        
    │   │   │   └── GameMinProjection                                 # Interface para Recuperação de subconjunto de dados 
    │   │   ├── repositories                                        
    │   │   │   ├── GameListRepository                                # Interface para acesso aos dados de Game
    │   │   │   └── GameRepository                                    # Interface para acesso aos dados de GameList
    │   │   ├── service                                             # Serviçoes intermediam a camada Controller e Repository
    │   │   │   ├── GameListService                                   # Encapsula lógica de negócio de Game
    │   │   │   └── GameService                                       # Encapsula lógica de negócio de GameList
    │   │   └── BackendGameListApplication.java                    # Classe Main
    │   └──  resources/
    │       ├── application-test.properties                        # Configuração para teste
    │       ├── application-dev.properties                         # Configuração para desenvolvimento
    │       ├── application-prod.properties                        # Configuração para produção
    │       ├── application.properties                             # Configurações comuns
    │       └── import.sql                                         # Script para popular o banco H2
    └── test/
```

---

## ⚙️ Perfis de ambiente

- **Teste (`test`)**  
  Usado localmente, com configurações para o H2 database.  
  Arquivo: `application-test.properties`

- **Desenvolvimento (`dev`)**  
  Usado localmente, com configurações para conexão com o postgres via Docker.  
  Arquivo: `application-dev.properties`

- **Produção (`prod`)**  
  Usado em ambiente real, com banco remoto, segurança e otimizações.  
  Arquivo: `application-prod.properties`

Para escolher o perfil, use a propriedade `spring.profiles.active`:

```bash
# Exemplo: rodar com perfil de desenvolvimento
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## 📌 Endpoints principais

Base URL: `http://localhost:8080/api/games`

### 🔍 Consultas
- **GET** `/games` → Lista todos os jogos
- **GET** `/games/{id}` → Busca um jogo por ID
- **GET** `/lists` → Lista todas as listas
- **GET** `/lists/{listId}` → Busca uma lista por ID
- **GET** `/lists/{listId}/games` → Lista todos os jogos em uma lista por ID

### ✏️ Manipulação
- **POST** `/lists/{listId}/replacement` → Altera a posição de um jogo na lista

## 🐳 Executando com Docker
1. Construir a imagem
```bash 
docker build -t games-api . 
```
2. Rodar o container
```bash
docker run -p 8080:8080 --name games-api games-api
```
---
## 📜 Licença
Este projeto está sob a licença MIT.

---

## 👨‍💻 Autor

**Bruno Salata Lima**  
Desenvolvedor Fullstack | Java, Spring, Angular, Vue.js, PostgreSQL, SQLite

🔗 [LinkedIn](https://www.linkedin.com/in/brunosalatalima)  
🐙 [GitHub](https://github.com/Brunosalata)
