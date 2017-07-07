# language: pt

@classe
Funcionalidade: Manipulação de arquivos passados para classe

Como um usuário 
Eu quero abrir um arquivo
De modo que seja possível editá-lo

Cenário: Arquivo com nome inválido
Dado um arquivo com nome inválido
Quando ocorre a tentativa de abrir o arquivo
Então uma mensagem de erro é mostrada 

Cenário: Arquivo com nome válido para leitura
Dado um arquivo com nome válido para leitura
Quando o arquivo é aberto e definido para leitura
Então o resultado do arquivo é mostrado na tela

Cenario: Arquivo com nome válido para escrita
Dado um arquivo com nome válido para ser escrito
Quando o arquivo é aberto e definido para escrita
Então a escrita é realizada e mostrada na tela

Cenario: Saída de um arquivo válido
Dado o usuario abriu um arquivo
Quando ele não quer mais o modificar
Então ele decide sair

Cenario: Arquivo aberto e comando inválido é digitado
Dado que o usuario abriu corretamente um arquivo
Quando ele escolhe um comando não válido
Então ele é avisado do ocorrido