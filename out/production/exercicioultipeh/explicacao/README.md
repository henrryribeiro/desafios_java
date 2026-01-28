// Desafio proposto:

Fazer um programa para ler os dados de N
produtos (N fornecido pelo usuário). Ao final,
mostrar a etiqueta de preço de cada produto na
mesma ordem em que foram digitados.
Todo produto possui nome e preço. Produtos
importados possuem uma taxa de alfândega, e
produtos usados possuem data de fabricação.
Estes dados específicos devem ser
acrescentados na etiqueta de preço conforme
exemplo (próxima página). Para produtos
importados, a taxa e alfândega deve ser
acrescentada ao preço final do produto.
Favor implementar o programa conforme
projeto ao lado.

// Exemplo de Output:

Enter the number of products: 3
Product #1 data:
Common, used or imported (c/u/i)? i
Name: Tablet
Price: 260.00
Customs fee: 20.00
Product #2 data:
Common, used or imported (c/u/i)? c
Name: Notebook
Price: 1100.00
Product #3 data:
Common, used or imported (c/u/i)? u
Name: Iphone
Price: 400.00
Manufacture date (DD/MM/YYYY): 15/03/2017
PRICE TAGS:
Tablet $ 280.00 (Customs fee: $ 20.00)
Notebook $ 1100.00
Iphone (used) $ 400.00 (Manufacture date: 15/03/2017)


------------------------------------------------------------

Explicando minha solução: 

Criamos a classe Product que contém os atributos, name e price
em seguida fizemos um construtor e usamos getters e setters,
construimos também no fim da classe uma função chamada priceTag,
que me retorna o nome e o preço do produto.

Em seguida construimos a classe ImportedProducts,
que herda a classe Products a diferença é que nesta classe
colocamos uma função chamada totalPrice que me dá o preço e a taxa 
da alfândega.

Continuamos com a proxima classe chamada UsedProduct
nesta classe eu importei a biblioteca Date para que eu consiga ter a data de fabricação,
como foi pedido no enunciado do exercício, fizemos também um Override para adicionar as diferenças de cada classe.

Agora vem a parte principal do Programa a classe Main que lê e executa a entrada do usuario. 
Para a classe main eu utilizei a biblioteca Scanner que é reponsavel por armazenar o valor digitado pelo usuario,
também usei a biblioteca List para que conseguisse associar cada produto a sua classe e com seus valores 