# -Horas

## Descrição
Esse projeto tem por objetivo o desenvolvimento e a gestão de uma aplicação voltada à venda de passagens aéreas e marítmicas. Por meio dele, o processo de compra dessas passagens será facilitado e otimizado, sendo possível a utilização a qualquer hora em qualquer lugar.


## Integrantes do grupos:
-Beatriz Manaia Lourenço Berto RA:22.125.060-8 <br>
-Letizia Baptistella 22.125.063-2 <br>
-Manuella Filipe Peres 22.224.029-3 <br>
-Nuno Martins Guilhermino da Silva RA:22.126.099-5 <br>
-Rafaela Altheman de Campos 22.125.062-4 <br>

# Sistema de Passagens — Arquitetura por Componentes

## Descrição do Projeto

Este projeto implementa parte de um sistema de compra de passagens utilizando **arquitetura baseada em componentes e comunicação por interfaces**.

Foram implementados dois componentes principais:

* **Componente de Passagens**
* **Componente de Carrinho**

O objetivo é demonstrar como dois componentes podem interagir **sem depender diretamente da implementação um do outro**, utilizando **interfaces como contrato de comunicação**.

A implementação foi realizada em **Java**, aplicando princípios de **baixo acoplamento e injeção de dependência**.

---

# Componentes Implementados

## 1. Componente de Passagens

O componente de Passagens é responsável por gerenciar as passagens disponíveis no sistema.

Neste projeto foi implementado o tipo **PassagemAerea**, conforme definido no modelo arquitetural do sistema.

### Responsabilidades

* Armazenar passagens aéreas disponíveis
* Listar passagens aéreas
* Filtrar passagens com base em critérios
* Buscar uma passagem pelo seu ID

### Classes relacionadas

* `Passagem` → classe base que representa uma passagem
* `PassagemAerea` → implementação concreta das passagens aéreas
* `PassagemService` → interface que define os serviços oferecidos pelo componente

---

## 2. Componente de Carrinho

O componente de Carrinho é responsável por gerenciar as passagens selecionadas por um usuário antes da compra.

### Responsabilidades

* Adicionar passagens ao carrinho de um usuário
* Listar os itens presentes no carrinho
* Remover itens do carrinho
* Calcular o valor total do carrinho

### Classes relacionadas

* `Carrinho` → implementação do carrinho de compras
* `CarrinhoService` → interface que define os serviços do carrinho

---

# Interfaces Fornecidas

As interfaces fornecidas representam os **serviços que cada componente disponibiliza para outros componentes do sistema**.

## Interface `PassagemService`

Fornecida pelo componente de Passagens.

Métodos disponíveis:

* `listarPassagensAereas()`
* `listarPassagensMaritimas()`
* `filtrarPassagens(Map<String,String> filtros)`
* `obterPassagemPorId(int idPassagem)`

Essa interface permite que outros componentes consultem e manipulem informações sobre passagens sem depender da implementação concreta.

---

## Interface `CarrinhoService`

Fornecida pelo componente de Carrinho.

Métodos disponíveis:

* `adicionarItem(int idUsuario, int idPassagem, int qtd)`
* `listarItens(int idUsuario)`
* `removerItem(int idUsuario, int idItem)`
* `calcularTotal(int idUsuario)`

Essa interface permite que outras partes do sistema manipulem o carrinho de compras do usuário.

---

# Interfaces Requeridas

Interfaces requeridas são aquelas que **um componente precisa utilizar para acessar funcionalidades de outro componente**.

Neste projeto:

### O componente Carrinho requer:

`PassagemService`

Isso ocorre porque o carrinho precisa buscar informações de uma passagem antes de adicioná-la ao carrinho.

Exemplo de uso no código:

```java
private PassagemService passagemService;
```

---

# Comunicação entre os Componentes

A comunicação entre os componentes ocorre da seguinte forma:

```
Carrinho  --->  PassagemService
                   ▲
                   │
             PassagemAerea
```

Fluxo simplificado:

1. O usuário solicita a adição de uma passagem ao carrinho.
2. O componente `Carrinho` solicita a passagem ao serviço `PassagemService`.
3. A implementação concreta (`PassagemAerea`) retorna a passagem correspondente.
4. O carrinho adiciona a passagem à lista de itens do usuário.

Assim, o carrinho não precisa saber como as passagens são armazenadas ou gerenciadas.

---

# Evitando Acoplamento Direto

O acoplamento direto entre componentes foi evitado através do uso de **interfaces e injeção de dependência**.

O componente Carrinho **não depende diretamente da classe `PassagemAerea`**, mas apenas da interface `PassagemService`.

Exemplo:

```java
private PassagemService passagemService;
```

A implementação concreta é fornecida externamente através do construtor:

```java
PassagemService passagemService = new PassagemAerea();
CarrinhoService carrinho = new Carrinho(passagemService);
```

Isso permite que a implementação do serviço de passagens seja trocada futuramente sem alterar o componente Carrinho.

---

# Estrutura do Projeto

```
componentes-interfaces/

Carrinho.java
CarrinhoService.java

Passagem.java
PassagemAerea.java
PassagemService.java

Main.java
```

---

# Instruções para Execução

## 1. Clonar o repositório

```bash
git clone https://github.com/seu-repositorio/projeto-topicos-avancados-engenharia-de-software.git
```

Entrar na pasta do projeto:

```bash
cd componentes-interfaces
```

---

## 2. Compilar o projeto

```bash
javac *.java
```

---

## 3. Executar o programa

```bash
java Main
```

O programa irá executar alguns testes demonstrando:

* criação de passagens
* filtragem de passagens
* adição de itens ao carrinho
* listagem de itens
* cálculo do total do carrinho
* remoção de itens

---

