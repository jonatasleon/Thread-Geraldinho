# Thread-Geraldinho

[![Build Status](https://travis-ci.org/jonatasleon/Thread-Geraldinho.svg?branch=master)](https://travis-ci.org/jonatasleon/Thread-Geraldinho)

### Objetivo

Código desenvolvido para apresentação sobre a utilização prática de Threads à disciplina de Sistemas Operacionas I, lecionada pelo Prof.º José Geraldo, na FATEC Guaratinguetá.

### Ideia Geral

* As classes Corrida e Corredor tem relacionamento 1 - N.

* Corredor implementa a Interface Runnable e ao sobreescrever o método run() é especificado que ali ocorre a "corrida" de cada objeto de Corredors

* Corrida mantém uma lista com todos seus corredores, e começa a corrida.

* Ao começar a corrida, cada corredor da lista de Corrida recebe uma Thread na simula as voltas que os corredores realizarão.

* A interface Fim serve como um Listener para que o objeto Corrida receba um Callback que determine o que fazer ao acabar a corrida.

License
----

MIT
