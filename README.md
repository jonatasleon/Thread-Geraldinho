# Thread-Geraldinho

### Objetivo

Código desenvolvido para apresentação sobre a utilização prática de Threads à disciplina de Sistemas Operacionas I, lecionada pelo Prof.º José Geraldo, na FATEC Guaratinguetá.

### Ideia Geral

As classes Corrida e Corredor tem relacionamento 1 - N.

Corredor implementa a Interface Runnable e ao sobreescrever o método run() é especificado que ali ocorre a "corrida" de cada objeto de Corredor

Corrida mantém uma lista com todos seus corredores, e começa a corrida.

Ao começar a corrida, cada corredor da lista de Corrida recebe uma Thread na simula as voltas que os corredores realizarão.

* A interface Fim serve como um Listener para que o objeto Corrida receba um Callback que determine o que fazer ao acabar a corrida.
 
### Agradecimentos

Por mais simples que este código possa ser, ele foi de grande utilidade para o entendimento de conceitos até então pouco dominados, como por exemplo: Interface, Listerner, Callback, Threads, sychronized, static, Singleton.

Sendo assim, agradeço aqui ao Prof.º José Geraldo pela proposta desse trabalho, que por mais simples que tenha sido me ajudou na aprimoração sobre a linguagem Java.
