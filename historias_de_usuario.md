# 📖 Histórias de Usuário - CondoWise

## História 1: Agendamento de Áreas Comuns
**Como morador**, quero agendar o uso das áreas comuns do condomínio para garantir minha reserva e evitar conflitos com outros moradores.

### 🎯 Critérios de Aceitação:
- O sistema deve permitir que moradores selecionem uma área comum e escolham uma data e horário disponíveis.
- Se a reserva for bem-sucedida, deve ser registrada no sistema e notificar o morador.
- O sistema deve impedir reservas para horários já ocupados e exibir uma mensagem informativa.

### 📝 Cenários BDD:

#### ✅ Cenário 1: Agendamento bem-sucedido
**Dado** que sou um morador logado  
**Quando** seleciono uma área comum e escolho uma data e horário disponíveis  
**Então** minha reserva é confirmada e registrada no sistema  

#### ❌ Cenário 2: Tentativa de agendamento em horário já reservado
**Dado** que outra pessoa já reservou a área comum no horário desejado  
**Quando** tento agendar para o mesmo horário  
**Então** recebo uma mensagem informando que a área não está disponível  

---

## História 2: Controle de Visitantes
**Como porteiro**, quero registrar a entrada e saída de visitantes para manter um controle de acesso ao condomínio.

### 🎯 Critérios de Aceitação:
- O porteiro deve conseguir registrar nome, documento e morador associado ao visitante.
- O sistema deve registrar automaticamente a data e horário da entrada e saída do visitante.
- O morador deve receber uma notificação quando um visitante for registrado para ele.

### 📝 Cenários BDD:

#### ✅ Cenário 1: Registro de entrada bem-sucedido
**Dado** que sou um porteiro logado  
**Quando** registro um visitante informando nome, documento e morador associado  
**Então** o sistema registra a entrada e notifica o morador  

#### ❌ Cenário 2: Registro de saída sem entrada correspondente
**Dado** que o visitante não tem um registro de entrada  
**Quando** tento registrar a saída  
**Então** o sistema exibe uma mensagem de erro informando que não há entrada registrada  

---

## História 3: Notificação de Encomendas
**Como morador**, quero receber notificações quando uma encomenda chegar para que eu possa retirá-la o quanto antes.

### 🎯 Critérios de Aceitação:
- O sistema deve permitir que o porteiro registre uma encomenda associada a um morador.
- O morador deve ser notificado automaticamente quando a encomenda chegar.
- O status da encomenda pode ser "Pendente" ou "Entregue".

### 📝 Cenários BDD:

#### ✅ Cenário 1: Registro de encomenda bem-sucedido
**Dado** que sou um porteiro logado  
**Quando** registro uma encomenda associada a um morador  
**Então** o sistema notifica o morador sobre a chegada da encomenda  

#### ❌ Cenário 2: Tentativa de retirada sem encomenda pendente
**Dado** que não há nenhuma encomenda pendente para o morador  
**Quando** ele tenta marcar a retirada  
**Então** o sistema exibe uma mensagem informando que não há encomendas disponíveis  

---

## História 4: Chamados de Manutenção
**Como morador**, quero abrir chamados de manutenção para reportar problemas no condomínio e acompanhar seu status.

### 🎯 Critérios de Aceitação:
- O sistema deve permitir que moradores abram chamados com descrição do problema.
- O status do chamado deve ser atualizado conforme seu andamento ("Aberto", "Em andamento" e "Concluído").
- O síndico deve conseguir visualizar e gerenciar os chamados abertos.

### 📝 Cenários BDD:

#### ✅ Cenário 1: Abertura de chamado bem-sucedida
**Dado** que sou um morador logado  
**Quando** abro um chamado de manutenção descrevendo o problema  
**Então** o chamado é registrado com status "Aberto"  

#### ❌ Cenário 2: Tentativa de alteração de chamado já concluído
**Dado** que um chamado está com status "Concluído"  
**Quando** tento editar ou reabrir o chamado  
**Então** o sistema não permite e exibe uma mensagem informando que ele já foi resolvido  

---

## História 5: Publicação de Comunicados
**Como síndico**, quero publicar comunicados para informar moradores sobre eventos e avisos importantes.

### 🎯 Critérios de Aceitação:
- O sistema deve permitir que apenas o síndico publique comunicados.
- Os comunicados devem conter título, descrição e data de publicação.
- Todos os moradores devem ser notificados sobre novos comunicados.

### 📝 Cenários BDD:

#### ✅ Cenário 1: Publicação de comunicado bem-sucedida
**Dado** que sou um síndico logado  
**Quando** publico um comunicado com título e descrição  
**Então** todos os moradores são notificados e o comunicado aparece na plataforma  

#### ❌ Cenário 2: Tentativa de publicação sem permissão
**Dado** que sou um morador sem permissões administrativas  
**Quando** tento publicar um comunicado  
**Então** o sistema exibe uma mensagem informando que essa ação só pode ser feita pelo síndico  
