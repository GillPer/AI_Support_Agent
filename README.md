# AI_Support_Agent

# 🤖 AI Support Agent

A lightweight AI-driven IT Support Agent built with **Java and Spring Boot** that demonstrates **agentic AI concepts, intelligent decision-making, prompt engineering, workflow orchestration, confidence-based routing, and automated support actions**.

The project is designed as an entry-level implementation of an AI-powered virtual assistant without relying on paid external AI APIs. The current implementation uses a **local rule-based AI engine**, while the AI capability is abstracted behind an `AIService` interface so that an LLM provider such as OpenAI or Azure OpenAI can be integrated later without changing the core agent workflow.

---

## 📌 Project Overview

Traditional IT support systems require users to manually submit tickets and wait for support engineers to analyze and route them.

This project demonstrates how an intelligent support agent can automate the initial analysis and routing process.

### Traditional workflow

```text
User
  ↓
IT Support Ticket
  ↓
Support Engineer
  ↓
Manual Analysis
  ↓
Manual Resolution / Escalation
```

### AI Support Agent workflow

```text
User
  ↓
REST API
  ↓
Support Agent
  ↓
Issue Analysis
  ↓
Classification
  ↓
Confidence Evaluation
  ↓
Decision Engine
  ↓
Tool Selection
  ↓
Automated Resolution / Escalation
```

The agent can identify common IT support issues such as:

* VPN/network problems
* Password/account issues
* Hardware problems
* Security incidents
* Unknown or ambiguous requests

---

## 🎯 Problem Statement

Organizations receive a large number of repetitive IT support requests.

Many requests can be categorized and resolved using predefined workflows, while security-sensitive or ambiguous issues should be escalated to human support.

The goal of this project is to build a lightweight intelligent support assistant capable of:

1. Understanding the user's support request.
2. Classifying the issue.
3. Determining its priority.
4. Calculating a confidence score.
5. Selecting an appropriate action.
6. Executing a corresponding support tool.
7. Escalating low-confidence or security-sensitive requests.

---

## 🏗️ Architecture

```text
                    ┌──────────────────────┐
                    │      User / Postman  │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │   SupportController  │
                    │     REST API         │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │ SupportAgentService  │
                    │    Orchestrator      │
                    └──────────┬───────────┘
                               │
                    ┌──────────▼──────────┐
                    │      AIService      │
                    │      Analysis       │
                    └──────────┬──────────┘
                               │
                    ┌──────────▼──────────┐
                    │   LocalAIService    │
                    │ Classification      │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │   Decision Engine    │
                    └──────────┬───────────┘
                               │
              ┌────────────────┼────────────────┐
              │                │                │
              ▼                ▼                ▼
        ┌──────────┐    ┌────────────┐    ┌────────────┐
        │ VPN Tool │    │  Password  │    │ Escalation │
        │          │    │    Tool    │    │    Tool    │
        └──────────┘    └────────────┘    └────────────┘
              │                │                │
              └────────────────┼────────────────┘
                               ▼
                    ┌──────────────────────┐
                    │    Final Response    │
                    └──────────────────────┘
```

---

## 🧠 Agentic Workflow

The project implements a lightweight agentic workflow:

```text
1. Analyze
      ↓
2. Classify
      ↓
3. Evaluate confidence
      ↓
4. Decide action
      ↓
5. Invoke tool
      ↓
6. Return response
```

### Example

For:

```text
"My VPN is not connecting."
```

the system determines:

```text
Category: NETWORK
Priority: MEDIUM
Action: TROUBLESHOOT_VPN
Confidence: 0.92
Escalate: false
```

The agent then invokes the VPN troubleshooting tool.

For:

```text
"Someone is attempting unauthorized access to my account."
```

the system determines:

```text
Category: SECURITY
Priority: CRITICAL
Action: ESCALATE
Confidence: 0.98
Escalate: true
```

The agent routes the request to the escalation workflow.

---

## 🧩 Key Features

### 1. Issue Classification

The system classifies support requests into categories such as:

```text
NETWORK
ACCOUNT
HARDWARE
SECURITY
SOFTWARE
OTHER
```

---

### 2. Priority Detection

Requests are assigned priorities:

```text
LOW
MEDIUM
HIGH
CRITICAL
```

Security-related issues are treated as critical and escalated.

---

### 3. Confidence-Based Decision Making

The AI service returns a confidence score.

Example:

```json
{
  "category": "NETWORK",
  "confidence": 0.92
}
```

If confidence falls below the configured threshold, the system automatically escalates the request instead of attempting an uncertain resolution.

This demonstrates a basic guardrail around intelligent decision-making.

---

### 4. Tool-Based Actions

The agent can select different tools depending on the issue.

Available tools include:

```text
TROUBLESHOOT_VPN
RESET_PASSWORD
PROVIDE_INFORMATION
ESCALATE
```

The agent determines which action should be executed, while the actual tool execution remains deterministic application logic.

---

### 5. Prompt Engineering

The project contains a structured prompt template defining:

* Agent role
* Objective
* Supported categories
* Priority levels
* Decision rules
* Available actions
* User input

Example:

```text
ROLE:
You are an enterprise IT support agent.

OBJECTIVE:
Analyze the user's IT issue.

CATEGORIES:
NETWORK, ACCOUNT, HARDWARE, SECURITY, SOFTWARE, OTHER

PRIORITIES:
LOW, MEDIUM, HIGH, CRITICAL

RULES:
- Security issues require escalation.
- Critical issues require escalation.
- Password issues should use password reset.
- VPN issues should use VPN troubleshooting.
- Unknown issues should be escalated.
```

The prompt is separated from the orchestration logic so that the decision instructions can be modified independently.

---

## 🛠️ Technology Stack

### Backend

* Java 21
* Spring Boot
* Spring Web
* Maven

### AI / Intelligent Automation

* Local rule-based AI engine
* Prompt engineering
* Agentic workflow concepts
* Confidence-based routing
* Tool orchestration
* Intelligent decision logic

### Development Tools

* IntelliJ IDEA
* Git
* GitHub
* Postman

---

## 📂 Project Structure

```text
ai-support-agent
│
├── .gitignore
├── README.md
├── pom.xml
│
└── src
    └── main
        ├── java
        │   └── com.example.aisupport
        │       │
        │       ├── AiSupportApplication.java
        │       │
        │       ├── controller
        │       │   └── SupportController.java
        │       │
        │       ├── dto
        │       │   ├── SupportRequest.java
        │       │   └── SupportResponse.java
        │       │
        │       └── service
        │           ├── AIService.java
        │           ├── LocalAIService.java
        │           ├── PromptTemplateService.java
        │           ├── SupportAgentService.java
        │           └── SupportTools.java
        │
        └── resources
            └── application.properties
```

---

## 🔌 API

### Ask the Support Agent

```http
POST /api/support/ask
```

### Request

```json
{
  "message": "My VPN is not connecting"
}
```

### Response

```json
{
  "category": "NETWORK",
  "priority": "MEDIUM",
  "action": "TROUBLESHOOT_VPN",
  "resolution": "VPN Troubleshooting Steps...",
  "escalate": false,
  "confidence": 0.92
}
```

---

## 🔐 Security Incident Example

### Request

```json
{
  "message": "Someone hacked my account and I see unauthorized login attempts"
}
```

### Response

```json
{
  "category": "SECURITY",
  "priority": "CRITICAL",
  "action": "ESCALATE",
  "resolution": "Security issue detected. Escalate immediately to the security team.",
  "escalate": true,
  "confidence": 0.98
}
```

---

## 🧪 Test Scenarios

### Scenario 1 — VPN

**Input**

```text
My VPN is not connecting.
```

**Expected**

```text
Category: NETWORK
Action: TROUBLESHOOT_VPN
Escalate: false
```

---

### Scenario 2 — Password

**Input**

```text
I forgot my company password.
```

**Expected**

```text
Category: ACCOUNT
Action: RESET_PASSWORD
Escalate: false
```

---

### Scenario 3 — Security

**Input**

```text
Someone is trying to access my account.
```

**Expected**

```text
Category: SECURITY
Priority: CRITICAL
Action: ESCALATE
Escalate: true
```

---

### Scenario 4 — Hardware

**Input**

```text
My laptop keyboard is not working.
```

**Expected**

```text
Category: HARDWARE
Action: PROVIDE_INFORMATION
```

---

### Scenario 5 — Unknown Request

**Input**

```text
Something is wrong with my system.
```

**Expected**

```text
Low confidence
↓
ESCALATE
```

---

## 🚀 Getting Started

### Prerequisites

Install:

* Java 21
* Maven
* Git
* IntelliJ IDEA or another Java IDE
* Postman (optional)

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

### Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/ai-support-agent.git
```

Move into the project:

```bash
cd ai-support-agent
```

---

### Build the Project

```bash
mvn clean install
```

---

### Run the Application

```bash
mvn spring-boot:run
```

The application starts on:

```text
http://localhost:8080
```

---

## 📮 Testing with Postman

Create a POST request:

```text
http://localhost:8080/api/support/ask
```

Set:

```text
Content-Type: application/json
```

Body:

```json
{
  "message": "My VPN is not connecting"
}
```

Send the request and inspect the JSON response.

---

## 💡 Design Decisions

### Why use an AIService interface?

The AI capability is abstracted behind:

```java
public interface AIService {
    SupportResponse analyze(String message);
}
```

The current implementation is:

```text
AIService
    ↓
LocalAIService
```

This keeps the agent orchestration independent of the underlying AI implementation.

A future implementation could be:

```text
AIService
    ├── LocalAIService
    ├── OpenAIService
    └── AzureOpenAIService
```

The `SupportAgentService` would not need to change when the AI provider changes.

---

### Why separate AI decisions from tool execution?

The AI component is responsible for interpretation and recommendation.

The application controls actual execution.

```text
AI
 ↓
Recommendation
 ↓
Validation / Business Logic
 ↓
Tool Execution
```

This provides a basic guardrail against blindly executing AI-generated actions.

---

## 🤖 Agentic AI Concepts Demonstrated

This project demonstrates the fundamentals of an agentic architecture:

### Autonomous decision flow

The agent determines which support action should be performed.

### Multi-step workflow

```text
Analyze
 ↓
Classify
 ↓
Evaluate
 ↓
Decide
 ↓
Act
```

### Tool orchestration

The agent selects tools based on the identified issue.

### Confidence-based routing

Low-confidence requests are escalated rather than automatically resolved.

### Human-in-the-loop

Security-sensitive and ambiguous issues are routed to human support.

---

## 🔮 Future Improvements

The project can be extended into a production-grade AI support platform by adding:

* OpenAI / Azure OpenAI integration
* LangChain or Semantic Kernel orchestration
* LLM-based intent classification
* Function/tool calling
* Conversation memory
* PostgreSQL ticket persistence
* Authentication with Spring Security
* Retrieval-Augmented Generation (RAG)
* Vector database
* Company knowledge-base integration
* Azure AI services
* Chat UI using React
* Kafka-based event processing
* Docker deployment
* Kubernetes deployment
* AI observability and tracing
* Prompt/version management
* Human approval workflows

---

## ⚠️ Current Implementation

This repository intentionally uses a **local rule-based AI engine** rather than a paid external LLM API.

This makes the project:

* Free to run
* Independent of API keys
* Easy to reproduce
* Suitable for learning agentic architecture
* Suitable for demonstrating AI-driven workflow concepts

The `AIService` abstraction allows the local implementation to be replaced with an external LLM provider in the future.

---

## 📈 Learning Outcomes

This project demonstrates practical understanding of:

* AI service abstraction
* Prompt engineering concepts
* Agentic AI architecture
* Workflow orchestration
* Intelligent decision systems
* Confidence-based routing
* Tool-based automation
* Human-in-the-loop workflows
* REST API development
* Spring Boot dependency injection
* Interface-based design
* Separation of concerns
* Extensible AI architecture

---

## 👨‍💻 Author

**Geep**

Full Stack Software Engineer

**Core Technologies:** Java | Spring Boot | REST APIs | Microservices | AI/ML | Agentic AI | Cloud | Docker | Kubernetes
