# 🌟 Spring AI Gemini Integration

> Intégration simple de **Google Gemini** avec **Spring Boot** via **Spring AI**.

Ce projet démontre comment créer une API REST capable de générer du texte à partir d’un *prompt* en utilisant **Spring AI** et **Google Gemini**.

---

## 🚀 Fonctionnalités

- 🔹 Intégration de **Spring AI** avec le modèle **Gemini 2.0 Flash**.  
- 🔹 API REST simple : `/ask`  
- 🔹 Validation automatique du corps de requête.  
- 🔹 Logging détaillé pour le débogage.  
- 🔹 Configuration compatible avec l’API **Google AI Studio**.

---

## 🧩 Architecture du projet

```
spring-ai-gemini/
├── src/
│   ├── main/java/com/app/spring_ai/
│   │   ├── SpringAiApplication.java
│   │   ├── ChatClientConfig.java         # Configuration du client ChatClient
│   │   ├── controllor/RestController.java # Point d'entrée API REST
│   │   ├── model/Request.java             # Modèle de la requête
│   │   └── service/GeminiService.java     # Service d'appel à l'API Gemini
│   └── resources/
│       └── application.properties
└── pom.xml
```

---

## ⚙️ Configuration

### 1️⃣ Ajouter les dépendances Maven

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.ai</groupId>
        <artifactId>spring-ai-openai-spring-boot-starter</artifactId>
        <version>1.0.0-M2</version>
    </dependency>

    <dependency>
        <groupId>jakarta.validation</groupId>
        <artifactId>jakarta.validation-api</artifactId>
    </dependency>

    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

---

### 2️⃣ Configurer `application.properties`

```properties
spring.application.name=spring-ai-gemini

# Logging
logging.level.io.modelcontextprotocol.client=DEBUG
logging.level.io.modelcontextprotocol.spec=DEBUG

# Google Gemini API Configuration (via Spring AI OpenAI proxy)
spring.ai.openai.api-key=YOUR_GOOGLE_API_KEY
spring.ai.openai.base-url=https://generativelanguage.googleapis.com/v1beta/openai
spring.ai.openai.chat.completions-path=/chat/completions
spring.ai.openai.chat.options.model=gemini-2.0-flash-exp
```

> 🔑 **Remplace** `YOUR_GOOGLE_API_KEY` par ta clé issue de  
> 👉 [https://aistudio.google.com/app/apikey](https://aistudio.google.com/app/apikey)

---

## 🧠 Exemple d’appel API

### 🔹 Endpoint : `POST /ask`

**Requête :**
```json
{
  "prompt": "Écris une courte histoire sur un petit dragon bleu."
}
```

**Réponse :**
```text
Il était une fois un petit dragon bleu nommé Azuro...
```

---

## 🧱 Composants principaux

### `RestController.java`
```java
@PostMapping("/ask")
public String generateStoryPdf(@RequestBody @Valid Request request) {
    return geminiService.generateStory(request);
}
```

### `GeminiService.java`
```java
public String generateStory(Request request) {
    return chatClient.prompt(request.getPrompt()).call().content();
}
```

### `ChatClientConfig.java`
```java
@Configuration
public class ChatClientConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }
}
```

---

## ▶️ Lancement

### Depuis un terminal :
```bash
mvn spring-boot:run
```

### Test via **cURL** :
```bash
curl -X POST http://localhost:8080/ask      -H "Content-Type: application/json"      -d '{"prompt": "Donne-moi une blague courte"}'
```

---

## 🧾 Exemple de réponse JSON complète
```json
{
  "response": "Pourquoi les plongeurs plongent-ils toujours en arrière et jamais en avant ? Parce que sinon ils tombent dans le bateau !"
}
```

---

## 🧪 Tests et Validation
- Tous les champs sont validés via `@NotBlank` et `@Valid`.
- Les erreurs de validation sont automatiquement gérées par Spring Boot (HTTP 400).

---


## 💡 Références
- 🔗 [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- 🔗 [Google AI Studio API](https://aistudio.google.com/)
- 🔗 [Spring Boot Official Docs](https://spring.io/projects/spring-boot)

---

## 👨‍💻 Auteur
**Karim Zrouga**  
📧 Contact : [LinkedIn](https:www.linkedin.com/in/karim-zrouga/) | [GitHub](https://github.com/karimzrouga)
