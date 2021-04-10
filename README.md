# REST API ZUPNANÇAS

----
### Objetivo:
    
    API capaz de fazer gerenciamento de finanças pessoais. 
    Incialmente se registra o seu saldo atual com valor e limite e seu cpf.
    Após isso, você pode registrar suas contas a pagar que será debitado automáticamente,
    atualizando o seu saldo quando a conta for atualizada como PAGO. Também pode ser feito 
    o cadastro das suas entradas de crédito e assim será feito a adição ao seu saldo atual 
    automáticamente. Abaixo maiores instruções para uso.

### Como usar:

 | EndPoint | Método HTTP | Função | Corpo |
 :-----------:|:-------------: | :--------: |:-------:|
 categorais/ | POST | Cadastrar uma categoria | JSON | 
 categorias/ | GET  | mostrar todas categorias | JSON |
 categorias/{id}/ | DELETE | deletar categoria | SEM CORPO |
 saldos/ | POST | cadastrar saldo | JSON |
 saldos/ | GET | mostrar todos saldos | SEM CORPO |
 creditos/ | POST | cadatrar um novo credito | JSON |
 creditos/ | GET | mostrar todos os creditos | SEM CORPO |
 creditos/categorias?nome={sua categoria} | GET | pesquisar créditos por um nome de categoria | SEM CORPO |
 contas/ | POST | cadastrar uma conta | CORPO |
 contas/ | PUT | atualizar uma conta | CORPO |
 contas/?status=STATUS | GET | pesquisar contas por status (AGUARDAND/ATRASADO/PAGO | SEM CORPO |

### Exemplos de requisições de JSON

1. Categoria - Cadastro de categoria
    ~~~json
    {
      "nome": "nome da categoria"
   }
    ~~~
2. Saldos - Cadastro de saldo
    ~~~json
    {
        "cpf": "seu cpf",
        "valor": 500.00,
        "limite": 8000.00
    }
   ~~~
3. Creditos - Cadastro de crédito
   1. se o id for nulo na categoria, a categoria será cadatrada
    ~~~json
    {
        "cpf": "cpf usado ao cadastrar saldo",
        "descricao": "Salário",
        "valor": 2000.00,
        "categorias": [
                {
                    "id": null,
                    "nome": "Trabalho"
                },
                {
                    "id": null,
                    "nome": "mesada"
                },
                {
                    "id": null,
                    "nome": "aumento"
                }
            ]
    }
    ~~~
4. Contas - Cadastrar Conta
    ~~~json
   {
        "descricao": "Internet",
        "valor": 204.00,
        "dataDeSaida": "11/05/2021",
        "dataDeVencimento": "14/05/2021",
        "status": "AGUARDANDO",
        "cpf": "cpf usado ao cadastrar saldo"
    
    }
    ~~~
5. Contas - atualizar conta
    ~~~json
   {
        "id": 1,
        "status": "AGUARDANDO|ATRASADO|PAGO",   
   }
   ~~~

##### Tecnologia utilizadas:

* linguagem Java 11
* Spring boot com o seus respectivos dependências:
    1. Spring Data JPA
    2. Spring Validation
    3. Spring Web
* Para persistir o dados, usamos a dependência mysql coonector J2OBC
* Para o SGDB foi utilizado o MariaDB.