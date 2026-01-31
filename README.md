# AddressFinder – ViaCEP

Aplicação de console desenvolvida em Java que consome a API pública **ViaCEP** para realizar consultas de endereços no Brasil.

O projeto permite buscar informações por CEP ou por nome da rua de forma simples e interativa. Foi criado com foco em **boas práticas**, **organização de código** e **separação de responsabilidades**, servindo como objeto de estudo e portfólio.

---

## Funcionalidades

- **Consulta por CEP:** Busca precisa de endereço dado um CEP.
- **Consulta por Logradouro:** Busca de endereços utilizando UF, Cidade e nome da rua.
- **Validação:** Verificação e normalização do formato do CEP.
- **Tratamento de Erros:** Gestão de entradas inválidas e exceções da API.
- **Interatividade:** Menu em loop no console para múltiplas consultas.

---

## Estrutura do Projeto

A arquitetura segue uma organização em camadas para facilitar a manutenção e leitura:

```text
src/
 └── br.com.iurexavier.viacep
     ├── Main.java
     ├── exception
     │   └── InvalidCepException.java
     ├── model
     │   ├── Address.java
     │   └── AddressRecord.java
     ├── service
     │   └── ViaCepService.java
     └── util
         └── MenuUtil.java
```
---

## Responsabilidades das Camadas

- **Main:** Ponto de entrada e controle do fluxo principal da aplicação.
- **MenuUtil:** Responsável pela interação com o usuário (inputs e outputs no console).
- **ViaCepService:** Contém a lógica de consumo da API ViaCEP e regras de negócio.
- **Model:** Representação dos dados (Classes e Records).
- **Exception:** Tratamento de erros específicos do domínio da aplicação.

---

## Tecnologias Utilizadas

- **Java 17+**
- **API ViaCEP**
- **HttpClient (java.net.http)**
- **Gson**
- **POO**
- **Java Records**

---

## Como Executar

### Pré-requisitos

- Java JDK 17 ou superior
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)
- Dependência do Gson configurada (via Maven, Gradle ou JAR)
  
### Passos

- Clone o repositório

```text
git clone [https://github.com/seu-usuario/addressfinder-viacep.git](https://github.com/seu-usuario/addressfinder-viacep.git)
```
- Abra o projeto na sua IDE
- Execute a classe **Main**: Localize o arquivo src/br/com/iurexavier/viacep/Main.java e execute-o.

---

## Exemplo de uso

```text
== AddressFinder - ViaCEP ==
1. Consultar endereço por CEP
2. Consultar endereço pela rua
0. Sair

Escolha uma opção: 1
Informe o CEP: 89201000

Resultado:
Rua Blumenau, Centro - Joinville, SC (89201-000)

```

---

## Aprendizados

- Consumo de APIs REST em Java
- Tratamento de exceções personalizadas
- Organização de projeto em camadas
- Uso do HttpClient moderno
- Boas práticas para aplicações de console

---

Desenvolvido por **Iure Xavier**