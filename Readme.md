## API Busco
 
A API Busco é uma plataforma que visa facilitar a interação entre doadores, fornecedores, instituições e usuários, criando uma rede de compartilhamento de alimentos e produtos. Esta API oferece recursos para realizar operações essenciais relacionadas a doações, fornecedores, instituições, produtos e rotas. Abaixo, apresentamos uma breve visão geral dos principais recursos da API Busco.
 
Recursos Disponíveis
1. Doações
   1. Fazer Doação: Neste endpoint, os usuários podem realizar doações, fornecendo informações sobre a doação, como data, descrição e quantidade. A API registra as doações e retorna uma resposta indicando o sucesso ou falha da operação.
   2. Buscar Doações por Usuário: Os usuários podem usar esse endpoint para recuperar informações sobre as doações que realizaram. A API pesquisa as doações com base no ID do usuário e retorna os resultados.
2. Fornecedores
   1. Cadastrar Fornecedor: Os fornecedores podem se cadastrar na plataforma através deste endpoint, fornecendo informações como CNPJ, telefone, nome e e-mail. A API registra o fornecedor e retorna uma resposta indicando se o cadastro foi bem-sucedido.
   2. Buscar Fornecedor por Usuário: Os usuários podem buscar informações sobre fornecedores com base no ID do usuário. A API pesquisa os fornecedores e retorna os resultados.
3. Instituições
   1. Cadastrar Instituição: Instituições de caridade podem se cadastrar na plataforma fornecendo informações como CNPJ, CEP da sede, nome e telefone. A API registra a instituição e retorna uma resposta indicando se o cadastro foi bem-sucedido.
   2. Buscar Instituição por Usuário: Os usuários podem buscar informações sobre instituições com base no ID do usuário. A API pesquisa as instituições e retorna os resultados.
4. Produtos
   1. Listar Produtos: Este endpoint retorna uma lista de produtos disponíveis na plataforma. Cada produto inclui informações como nome, estoque, data de colheita, preço, tipo, fornecedor e foto. Isso permite que os usuários vejam quais produtos estão disponíveis para doação ou compra.
5. Rotas
   1. Buscar Rota por ID: Este endpoint permite que os usuários recuperem informações sobre rotas específicas. As rotas incluem dados como ponto de referência, horário, bairro, rua e data da rota. Isso pode ser útil para planejar a logística de entrega de doações.
6. Usuários
   1. Listar Usuários: Este endpoint retorna uma lista de todos os usuários cadastrados na plataforma, incluindo informações como e-mail, nome, CPF, data de cadastro, quantidade de doações, telefone e foto. Isso pode ser útil para ver quem mais está usando a plataforma.
   2. Login de Usuário: Permite que os usuários façam login na plataforma fornecendo seu e-mail e senha. A API verifica as credenciais do usuário e retorna uma resposta indicando se o login foi bem-sucedido
   3. Inserir Usuário: Este endpoint permite que os usuários se cadastrem na plataforma fornecendo informações como e-mail, senha, CEP, nome, CPF, data de cadastro, quantidade de doações, telefone e foto. A API registra o novo usuário e retorna uma resposta indicando o sucesso ou falha do cadastro.
   4. Excluir Usuário: Permite que os usuários excluam suas contas da plataforma com base em seu ID. A API remove o usuário e retorna uma resposta indicando se a exclusão foi bem-sucedida.
   5. Buscar Usuário por E-mail: Permite que os usuários busquem informações sobre outros usuários com base em seu endereço de e-mail. A API pesquisa os usuários e retorna os resultados.
   6. Buscar Usuário por CPF, E-mail ou Telefone: Permite que os usuários busquem informações sobre outros usuários com base em seu CPF, e-mail ou telefone. A API pesquisa os usuários e retorna os resultados.
   7. Resetar Senha de Usuário: Permite que os usuários redefinam suas senhas com base em seu endereço de e-mail e uma nova senha. A API atualiza a senha do usuário e retorna uma resposta indicando o sucesso ou falha da operação.
 
 
## Repositories:
Os repositórios, como `DoacaoRepository`, `FornecedorRepository`, `InsituicaoRepository` e `UsuarioRepository`, representam a camada de acesso a banco de dados. Eles estendem a interface `JpaRepository` do Spring Data JPA e fornecem métodos para executar consultas no banco de dados com base nas entidades correspondentes.
 
Services (Serviços):
1. DoacaoService:
    1. `fazerDoacao(Doacao doacao)`: Este método é responsável por criar uma doação no banco de dados. Ele salva uma nova doação usando o repositório `DoacaoRepository`. Após a doação ser registrada com sucesso, o serviço atualiza a contagem de doações do usuário doador correspondente.
    2. `findByUserId(int id)`: Este método busca uma doação feita por um usuário específico com base no ID do usuário doador.
2. FornecedorService:
   1. `cadastrarFornecedor(Fornecedor fornecedor)`: Este método cadastra um fornecedor no banco de dados. Ele utiliza o repositório `FornecedorRepository` para salvar os detalhes do fornecedor.
   2. `findByUserId(int id)`: Este método encontra um fornecedor com base no ID do usuário padrão associado a ele.
1. InstituicaoService:
    1. `cadastrarInstituicao(Instituicao instituicao)`: Esse método cadastra uma instituição no banco de dados por meio do repositório `InsituicaoRepository`.
    2. `findByUserId(int id)`: Este método procura uma instituição com base no ID do usuário padrão associado a ela.
2. ProdutoService:
    1. `listarProdutos()`: Este método recupera uma lista de produtos do banco de dados usando o repositório `ProdutoRepository`.
3. RotaService:
    1. `buscarRota(int rota)`: Esse método busca informações sobre uma rota específica com base no número da rota.
4. UsuarioService:
    1. `listarUsuarios()`: Este método recupera uma lista de todos os usuários registrados no sistema.
    2. `cadastrarUsuario(Usuarios usuario)`: Este método cadastra um novo usuário no banco de dados.
    3. `login(String email, String senha)`: Este método permite que um usuário faça login verificando as credenciais fornecidas (email e senha).
    4. `deleteById(Integer id)`: Remove um usuário com base no ID fornecido.
    5. `findByEmail(String email)`: Localiza um usuário com base no endereço de e-mail fornecido.
    6. `findByCpfOrEmailOrTelefone(String cpf, String email, String telefone)`: Procura por usuários que correspondam a qualquer um dos campos fornecidos (CPF, email, telefone) e fornece informações sobre quais campos existem no banco de dados.
  7. `resetSenha(String email, String novaSenha)`: Permite a redefinição da senha de um usuário com base no endereço de e-mail.
 
Controllers:
 
Models (Modelos):
 
As classes de modelo, como `Doacao`, `Fornecedor`, `Instituicao`, `Produto`, `Rota` e `Usuarios`, representam as entidades de dados que são armazenadas no banco de dados. Essas classes são anotadas com informações de mapeamento JPA para definir como elas são persistidas no banco de dados.
ApiResponse (Resposta da API):
A classe `ApiResponse` é usada para encapsular as respostas da API. Ela fornece informações sobre o resultado de uma operação, mensagens descritivas, dados retornados e, em alguns casos, informações adicionais, como no caso do método `findByCpfOrEmailOrTelefone`, que informa quais campos existem no banco de dados correspondendo aos critérios da consulta.
