<div id="top"></div>

<!-- PROJECT LOGO -->
<br />
<div align="center">

  <h3 align="center">Projeto Final - Fundamentos da Programação</h3>

  <p align="center">
    Projeto que tem como objetivo administrar um estacionamento.
    <br />
    <a href="https://github.com/RubensOriginal/TrabalhoFinalFundamentos/issues">Reporte uma Falha</a>
    ·
    <a href="https://github.com/RubensOriginal/TrabalhoFinalFundamentos/issues">Solicite uma Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Índice</summary>
  <ol>
    <li>
      <a href="#sobre-o-projeto">Sobre o Projeto</a>
      <ul>
        <li><a href="#construido-com">Construido Com</a></li>
      </ul>
    </li>
    <li>
      <a href="#como-iniciar">Como Iniciar</a>
      <ul>
        <li><a href="#pré-requisitos">Pré-requisitos</a></li>
        <li><a href="#instalação">Installation</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Sobre o Projeto

O projeto tem como objetivo administrar um estacionamento com vagas em multiplas fileiras. Essas fileiras são indicadas por letras de A a J. Cada fileira possui 8 vagas, exceto a H, I e J, que possuem 11 vagas cada uma. Exemplos de vagas são A1, B5, F8 e J10. O sistema armazena os dados das vagas indicando se ela está ou não ocupada e os dados do veículo que está na vaga, como cor predominante, placa e motorista.

Entre as funcionalidades do sistema estão: Gerar um mapa mostrando o estado da vaga, se está livre ou ocupada. Ocupar uma vaga informando a vaga, placa, cor do carro e motorista. Liberar a vaga, removendo os dados anteriores. Encontrar a primeira vaga livre. Exibir as estatística sobre o estacionamento, apresentando em porcentagem e numero de vagas livres e ocupadas. E por último, procurar todos os veículos com uma determinada cor.

Observação: Por uma solicitação do cliente, as vagas são iniciadas com 70% da ocupação, sendo as informações geradas de forma aleatória.

### Contruido Com

Esse projeto foi construido utilizando o Java 11. 
Como IDE oficial do projeto, foi utilizado o BlueJ.

* [Java 11](https://www.java.com/en/)
* [BlueJ](https://www.bluej.org/)

<p align="right">(<a href="#top">voltar para o início</a>)</p>



<!-- GETTING STARTED -->
## Como Iniciar

Para rodar o projeto localmente, siga as seguintes instruções:

### Pré-requisitos

Para rodar o projeto pela primeira vez, é necessário ter na máquina o Java JDK 11.
Após a primeira vez, somente é necessário o Java JRE 11, pacote já incluso no JDK.

### Instalação

Para executar o projeto, execute os seguintes comandos:

1. Faça uma cópia do repositório
   ```sh
   git clone https://github.com/RubensOriginal/TrabalhoFinalFundamentos
   ```
3. Compile os arquivos utilizando os seguintes comandos
   ```sh
   javac App.java
   javac DataManager.java
   javac ParkingSpot.java
   javac Parking.java
   javac StatisticData.java
   ```
4. Execute o App
   ```sh
   java App
   ```

<p align="right">(<a href="#top">voltar para o início</a>)</p>


<!-- ROADMAP -->
## Roadmap

- [x] Base do Projeto
- [x] Ocupador de Vagas
- [x] Visualizador de Vagas
- [x] Função de Ocupar Vagas
- [x] Liberar uma Vaga
- [x] Encontrar a Primeira Vaga Livre
- [x] Exibir Estatísticas do Estacionamento
- [x] Localizar Veículo por Cor

Para ver futuras implementações não adicionadas aqui, verifique as [Issues abertas](https://github.com/RubensOriginal/TrabalhoFinalFundamentos/issues) no Github.

<p align="right">(<a href="#top">voltar para o início</a>)</p>
