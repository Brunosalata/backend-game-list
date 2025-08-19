# 🎮 Games API

Aplicação **Spring Boot (Java 21)** que fornece endpoints REST para gerenciamento de jogos.  
O projeto utiliza perfis de configuração separados (`development` e `production`) e suporta execução em contêiner Docker.

---

## 🚀 Tecnologias utilizadas
- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Spring Web**
- **PostgreSQL** (padrão, mas adaptável a outros bancos)
- **Docker**

---

## 📂 Estrutura do projeto
```
    src/
    ├─ main/
    │ ├─ java/com/seuprojeto/games/ # Código-fonte da aplicação
    │ └─ resources/
    │ ├─ application-dev.properties # Configuração para desenvolvimento
    │ ├─ application-prod.properties # Configuração para produção
    │ └─ application.properties # Configurações comuns
    └─ test/ # Testes automatizados
```

---

## ⚙️ Perfis de ambiente

- **Desenvolvimento (`dev`)**  
  Usado localmente, com configurações simples (por exemplo, banco local).  
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
- **GET** `/api/games` → Lista todos os jogos
- **GET** `/api/games/{id}` → Busca um jogo por ID

### ✏️ Manipulação
- **POST** `/api/games` → Cria um novo jogo
- **PUT** `/api/games/{id}` → Atualiza os dados de um jogo
- **DELETE** `/api/games/{id}` → Remove um jogo

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
Desenvolvedor Fullstack | Java, Spring, Vue.js, PostgreSQL

🔗 [LinkedIn](https://www.linkedin.com/in/brunosalatalima)  
🐙 [GitHub](https://github.com/Brunosalata)
