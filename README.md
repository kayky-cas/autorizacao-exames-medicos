# Autorização de Exames Médicos


1) O sistema deverá permitir escolher o usuário atual a qualquer momento. Cada usuário tem um identificador, um nome e o seu tipo: médico, paciente ou administrador.
2) O sistema deverá permitir a um médico incluir uma nova autorização de exame (não é necessário implementar edição ou exclusão). Cada autorização de exame tem um código numérico sequencial, uma data de cadastro, o médico solicitante, o paciente e o exame solicitado (ex. RaioX, Tomografia etc). Cada autorização permite apenas 1 exame. a) Todos os campos devem ser preenchidos via seleção (textual ou visual) e não via digitação de texto puro (ou seja, tecnicamente devem se referir aos objetos em memória e não ser apenas texto puro). b) A lista de exames é fixa e deve conter pelo menos 10 tipos diferentes.
3) O sistema deverá permitir a um médico listar todas as autorizações de exame filtrando por paciente ou por tipo de exame. Listar sempre ordenado pela data.
4) O sistema deverá permitir a um paciente marcar um exame como realizado, adicionando a data em que foi realizado. a) O sistema não deve permitir essa operação se a data informada for anterior à da solicitação ou for posterior a 30 dias da solicitação.
5) O sistema deverá permitir a um paciente listar as suas autorizações de exame, ordenadas pela data.
6) O sistema deverá permitir a um administrador incluir um novo usuário (médico, paciente ou outro administrador).
7) O sistema deverá permitir ao administrador buscar um médico ou paciente por parte de seu nome e listar as autorizações daquele usuário.
8) O sistema deverá permitir ao administrador ver estatísticas gerais contendo:
- Número de médicos ### 
- Número de pacientes ### 
- Número de autorizações emitidas 
- Percentual de autorizações com exames já realizados
9) Duas funcionalidades a mais, à escolha do grupo.
