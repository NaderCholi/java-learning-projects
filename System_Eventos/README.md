# Sistema de Gerenciamento de Eventos e Ingressos

Projeto em Java, executado pelo terminal, para cadastrar clientes e eventos, vender e cancelar ingressos e consultar relatórios simples de vendas.

Desenvolvi este trabalho ao longo de alguns dias, como continuação de um exercício anterior da disciplina de Programação Orientada a Objetos, em que eu havia feito um sistema de venda de ingressos com apenas uma classe de evento. Aqui o problema foi ampliado: passaram a existir clientes, vários eventos, regras de venda mais completas e um menu para usar tudo isso.

**Autor:** Nader Iad Choli

## Funcionalidades

- Cadastro de clientes (nome, e-mail, CPF e se é estudante)
- Cadastro de eventos (nome, local, data, capacidade máxima e preço)
- Venda de ingressos
- Cancelamento de ingressos
- Consulta dos ingressos de um cliente
- Consulta das vagas restantes de um evento
- Total arrecadado por evento e total geral

## Regras do sistema

1. Um evento não pode vender mais ingressos do que a sua capacidade máxima.
2. Um mesmo cliente (identificado pelo CPF) não pode ter dois ingressos do mesmo evento.
3. Não é possível cadastrar dois clientes com o mesmo CPF.
4. Estudantes pagam meia-entrada, ou seja, 50% do preço do evento.
5. O preço de um evento só pode ser alterado enquanto nenhum ingresso tiver sido vendido.
6. Ao cancelar um ingresso, a vaga volta a ficar disponível e o valor deixa de entrar no total arrecadado.

## Estrutura do projeto

| Classe | Responsabilidade |
|---|---|
| `Cliente` | Guarda os dados de uma pessoa: nome, e-mail, CPF e se é estudante. |
| `Ingresso` | Guarda o id, o cliente, o evento, o valor pago e o status. |
| `Evento` | Guarda os dados do evento e os ingressos vendidos. Concentra as regras de venda, cancelamento e preço. |
| `Sistema` | Guarda a lista de clientes e a de eventos. Localiza cada um deles e repassa as operações ao `Evento`. |
| `Principal` | Contém o menu e a leitura dos dados digitados. Não possui regras de negócio. |

Procurei colocar cada regra na classe que já possui as informações necessárias para decidi-la. Por exemplo, quem sabe se ainda há vagas é o próprio `Evento`, pois é ele que conhece a capacidade e a quantidade vendida. A `Principal` apenas lê o que o usuário digita e chama os métodos.

O diagrama de classes está em `architecture/diagramaClasse.png`.

Os dados são guardados em vetores (arrays) e não em listas. Por isso, o `Evento` e o `Sistema` controlam por conta própria quantas posições já estão ocupadas.

## Como executar

É necessário ter o JDK instalado (versão 8 ou superior). Com os arquivos `.java` na mesma pasta, execute no terminal:

```
javac *.java
java Principal
```

## Menu

```
1 - Cadastrar cliente
2 - Cadastrar evento
3 - Vender ingresso
4 - Cancelar ingresso
5 - Ingressos de um cliente
6 - Vagas de um evento
7 - Total de um evento
8 - Total geral
0 - Sair
```

Para vender ou cancelar um ingresso, o sistema pede o CPF do cliente e o nome do evento, que precisam ter sido cadastrados antes.

## Casos de teste

Estes foram os cenários que usei para conferir se as regras funcionavam. Em todos, o evento tem capacidade 2 e preço de R$ 50,00, e há três clientes cadastrados (Ana, Bia e Caio).

| Cenário | Resultado esperado |
|---|---|
| Vender um ingresso para a Ana | Venda realizada |
| Vender outro ingresso para a Ana, no mesmo evento | Venda recusada (CPF repetido) |
| Vender para a Bia, com o evento já com a Ana | Venda realizada; vagas restantes: 0 |
| Vender para o Caio, com o evento lotado | Venda recusada (capacidade) |
| Cancelar o ingresso da Ana | Cancelamento realizado; vagas restantes: 1 |
| Vender para o Caio após o cancelamento | Venda realizada |
| Cancelar o ingresso da Ana novamente | Cancelamento recusado (não há ingresso) |
| Vender para um cliente estudante | Valor pago de R$ 25,00 |
| Alterar o preço antes de qualquer venda | Alteração aceita |
| Alterar o preço depois da primeira venda | Alteração recusada |
| Cadastrar dois clientes com o mesmo CPF | Segundo cadastro recusado |
| Consultar o total de um evento após vendas e cancelamentos | Soma apenas dos ingressos que continuam válidos |

## Dificuldades encontradas

O ponto que mais exigiu atenção foi o cancelamento. Como os ingressos ficam em um vetor, remover um deles deixa um espaço vazio no meio. Foi preciso deslocar os ingressos seguintes uma posição para trás e diminuir a quantidade vendida uma única vez. No começo, eu diminuía esse contador duas vezes, o que fazia o evento perder uma vaga a mais.

O cancelamento também trouxe outro problema. Eu gerava o id do ingresso a partir da quantidade vendida, e depois de um cancelamento dois ingressos poderiam receber o mesmo id. Resolvi criando um contador de ids no `Evento`, que só aumenta.

Também precisei entender melhor o uso do `this` ao criar o ingresso dentro do `Evento`, e a ordem de criação do vetor no construtor: ele só pode ser criado depois de a capacidade ser definida, senão nasce com tamanho zero.

## Limitações

- Os dados ficam apenas na memória. Ao fechar o programa, tudo é perdido.
- O `Sistema` comporta até 200 clientes e 20 eventos.
- O CPF e a data são tratados como texto, sem nenhuma validação de formato.
- Se o usuário digitar uma letra onde o programa espera um número, a execução é interrompida.
- Não há como editar os dados de um cliente ou de um evento depois do cadastro, exceto o preço.

## Possíveis melhorias

- Salvar os dados em arquivo.
- Trocar os vetores por `ArrayList`.
- Validar o CPF e a data.
- Permitir a edição de clientes e eventos.
