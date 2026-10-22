# Atividade Aula 12 - Padrões Comportamentais I: Strategy e Observer

## Resoluções

### 1. Divergência Encontrada
As regras de desconto divergiam entre `Matricula.calcularValor` e `GeradorBoleto.calcularValorDoBoleto`. O gerador de boletos não foi atualizado quando a política de desconto para egressos foi criada. Isso afetava a aluna **Ana Pereira**, que é egressa, pagando **R$ 720,00 na matrícula** (onde havia o desconto de 10% mapeado) e **R$ 800,00 no boleto** (que não possuía essa regra nos seus `ifs`).

### Como os padrões resolveram os problemas:
- **Strategy:** A cadeia de `if` foi substituída por implementações da interface `PoliticaDesconto`. A `Matricula` e o `GeradorBoleto` apenas recebem a interface via injeção e delegam o cálculo, unificando a regra e eliminando o código duplicado.
- **Observer:** As reações (`Email`, `Painel`, `Coordenacao`, `Auditoria` e a nova `Estatistica`) foram convertidas em `OuvinteMatricula`. A `FachadaMatricula` agora apenas delega a notificação para o `PublicadorMatricula`, cujo método `publicar()` envolve cada notificação num bloco `try/catch`. Isso isola as falhas, permitindo que a falha proposital no aviso da coordenação não interrompa o registo no sistema de auditoria.