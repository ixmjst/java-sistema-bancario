# 🏦 Sistema Bancário Java

Sistema de gerenciamento bancário desenvolvido em Java com suporte a contas correntes e poupança, transações e gestão de clientes.

## 📋 Índice
- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tecnologias](#tecnologias)
- [Como Executar](#como-executar)
- [Uso do Sistema](#uso-do-sistema)
- [Documentação](#documentação)

---

## 📖 Sobre o Projeto

Sistema bancário orientado a objetos que simula operações bancárias básicas, incluindo criação de contas, depósitos, saques, transferências e geração de extratos. O projeto demonstra conceitos fundamentais de Programação Orientada a Objetos (POO) em Java.

### Conceitos de POO Aplicados
- **Abstração**: Classe abstrata `ContaBancaria`
- **Herança**: `ContaCorrente` e `ContaPoupanca` herdam de `ContaBancaria`
- **Polimorfismo**: Métodos abstratos implementados de forma específica
- **Encapsulamento**: Atributos privados com getters/setters
- **Exceções Customizadas**: Tratamento de erros específicos do domínio

---

## ✨ Funcionalidades

### Gestão de Contas
- ✅ Criação de conta corrente (saldo mínimo: 20.000 Kz)
- ✅ Criação de conta poupança (saldo mínimo: 10.000 Kz)
- ✅ Ativação/Desativação de contas
- ✅ Consulta de informações da conta

### Operações Bancárias
- ✅ Depósitos
- ✅ Saques
- ✅ Transferências entre contas
- ✅ Cálculo de rendimento (poupança)
- ✅ Histórico de transações

### Gestão de Clientes
- ✅ Cadastro de clientes
- ✅ Múltiplas contas por cliente
- ✅ Consulta de dados do cliente

---

## 📁 Estrutura do Projeto

```
java-sistema-bancario/
│
├── ao.com.banco.app/
│   ├── Main.java                          # Ponto de entrada do sistema
│   │
│   └── ao/com/banco/
│       │
│       ├── model/                         # Modelos de domínio
│       │   ├── Cliente.java               # Entidade Cliente
│       │   ├── ContaBancaria.java         # Classe abstrata base
│       │   ├── ContaCorrente.java         # Conta corrente com limite
│       │   ├── ContaPoupanca.java         # Conta poupança com juros
│       │   └── Transacao.java             # Registro de transações
│       │
│       ├── service/                       # Lógica de negócio
│       │   └── BancoService.java          # Serviços bancários
│       │
│       ├── enums/                         # Enumerações
│       │   ├── StatusConta.java           # ATIVA, INATIVA
│       │   └── TipoTransacao.java         # DEPOSITO, SAQUE, TRANSFERENCIA
│       │
│       └── exceptions/                    # Exceções customizadas
│           ├── ContaInativaException.java
│           └── SaldoInsuficienteException.java
│
├── README.md                              # Este arquivo
├── ANALISE_CODIGO.md                      # Análise detalhada do código
└── java-sistema-bancario.iml             # Configuração IntelliJ
```

---

## 🛠️ Tecnologias

- **Java** (JDK 11+)
- **IntelliJ IDEA** (IDE recomendada)
- Bibliotecas padrão Java:
  - `java.util` (Collections, Scanner, Random)
  - `java.time` (LocalDate)

---

## 🚀 Como Executar

### Pré-requisitos
- JDK 11 ou superior instalado
- IDE Java (IntelliJ IDEA, Eclipse, VS Code) ou terminal

### Passos

#### Usando IntelliJ IDEA
1. Clone ou baixe o repositório
2. Abra o projeto no IntelliJ IDEA
3. Aguarde a indexação do projeto
4. Execute o arquivo `Main.java`

#### Usando Terminal
```bash
# Navegue até o diretório do projeto
cd java-sistema-bancario

# Compile o projeto
javac -d out ao.com.banco.app/Main.java ao.com.banco.app/ao/com/banco/**/*.java

# Execute o programa
java -cp out Main
```

---

## 💻 Uso do Sistema

### Menu Principal
```
Menu:
1 - Aderir Serviços Bancários
2 - Aderir Serviços de Cliente
3 - Sair (0)
```

### Criando uma Conta

1. Selecione a opção `1` no menu principal
2. Escolha o tipo de conta:
   - `1` - Conta Corrente (limite de cheque especial)
   - `2` - Conta Poupança (rendimento com juros)
3. Informe os dados solicitados:
   - Nome do titular
   - Bilhete de Identidade (BI)
   - Telefone
   - Valor de abertura

### Exemplo de Uso
```
Tipo de conta:
1-Corrente
2-Poupanca
> 1

Nome do Titular:
> João Silva

Bilhete de Identidade:
> 123456789LA

Telefone:
> +244 923 456 789

Valor de Abertura (>=20.000,kz):
> 50000

✓ Conta criada com sucesso!
```

---

## 📚 Documentação

### Classes Principais

#### ContaBancaria (Abstrata)
Classe base para todos os tipos de conta.

**Atributos:**
- `numero`: Número único da conta
- `titular`: Nome do titular
- `saldo`: Saldo atual
- `status`: Status da conta (ATIVA/INATIVA)
- `transacoes`: Histórico de transações

**Métodos Abstratos:**
- `depositar(double valor)`
- `sacar(double valor)`
- `transferir(ContaBancaria destino, double valor)`
- `calcularRendimento()`
- `gerarExtrato()`

#### ContaCorrente
Conta com limite de cheque especial.

**Atributos Específicos:**
- `limite`: Valor do limite de crédito

#### ContaPoupanca
Conta com rendimento de juros.

**Atributos Específicos:**
- `taxaJuros`: Taxa de rendimento

#### Cliente
Representa um cliente do banco.

**Atributos:**
- `id`: Identificador único
- `nome`: Nome completo
- `BI`: Bilhete de Identidade
- `telefone`: Número de telefone
- `contas`: Lista de contas do cliente

---

## ⚠️ Problemas Conhecidos

Consulte o arquivo [ANALISE_CODIGO.md](ANALISE_CODIGO.md) para uma lista detalhada de erros e melhorias sugeridas.

### Principais Issues
- ArrayList de clientes não inicializado
- Método `buscarPorNumero()` com lógica incorreta
- Tipo de transação errado em depósitos
- Métodos `transferir()` e `gerarExtrato()` não implementados no service
- Limite de conta corrente não utilizado

---

## 🔄 Roadmap

### Versão 1.1 (Correções Críticas)
- [ ] Corrigir inicialização do ArrayList de clientes
- [ ] Corrigir método `buscarPorNumero()`
- [ ] Corrigir tipo de transação em depósitos
- [ ] Implementar métodos vazios

### Versão 1.2 (Melhorias)
- [ ] Implementar uso do limite em conta corrente
- [ ] Adicionar taxa de juros padrão em conta poupança
- [ ] Melhorar validações de operações
- [ ] Adicionar geração sequencial de números de conta

### Versão 2.0 (Novas Funcionalidades)
- [ ] Persistência de dados (arquivo/banco de dados)
- [ ] Interface gráfica (JavaFX ou Swing)
- [ ] Relatórios gerenciais
- [ ] Sistema de autenticação com senha
- [ ] Testes unitários (JUnit)

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

---

## 📝 Licença

Este projeto é de código aberto e está disponível para fins educacionais.

---

## 👥 Autores

Desenvolvido como projeto educacional de Programação Orientada a Objetos em Java.

---

## 📞 Suporte

Para dúvidas ou sugestões, consulte a documentação ou abra uma issue no repositório.

---

## 🎓 Aprendizados

Este projeto demonstra:
- Estruturação de projetos Java
- Aplicação de conceitos de POO
- Tratamento de exceções
- Uso de collections (ArrayList)
- Enumerações e tipos customizados
- Organização em pacotes
- Separação de responsabilidades (Model-Service)

---

**Última atualização**: Fevereiro 2026
