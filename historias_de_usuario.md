## 📖 Histórias de Usuário  

As histórias de usuário definem os principais recursos e funcionalidades do CondoWise, garantindo que cada entrega agregue valor real aos moradores, síndicos e porteiros do condomínio.  

---

### 🏠 História 1: Agendamento de Áreas Comuns  
**Como morador**, quero agendar o uso das áreas comuns do condomínio para garantir minha reserva e evitar conflitos com outros moradores.  

#### 🎯 Critérios de Aceitação  
- O morador pode selecionar uma área comum, data e horário disponíveis.  
- O sistema deve impedir reservas duplicadas para o mesmo horário.  
- O morador recebe uma confirmação da reserva ao finalizar o agendamento.  
- O síndico pode visualizar todos os agendamentos.  

#### 📌 Cenários BDD  
✅ **Cenário 1: Agendamento bem-sucedido**  
- Dado que sou um morador logado  
- Quando seleciono uma área comum e escolho uma data e horário disponíveis  
- Então minha reserva é confirmada e registrada no sistema  

❌ **Cenário 2: Tentativa de agendamento em horário já reservado**  
- Dado que outra pessoa já reservou a área comum no horário desejado  
- Quando tento agendar para o mesmo horário  
- Então recebo uma mensagem informando que a área não está disponível  

---

### 🛠 História 2: Relato de Problemas e Manutenção  
**Como morador**, quero relatar problemas no condomínio para que possam ser solucionados rapidamente.  

#### 🎯 Critérios de Aceitação  
- O morador pode enviar um relato com descrição e foto opcional.  
- O síndico deve ser notificado sobre novos relatos.  
- O morador pode acompanhar o status dos relatos.  

#### 📌 Cenários BDD  
✅ **Cenário 1: Relato de problema bem-sucedido**  
- Dado que sou um morador logado  
- Quando acesso a seção de relatos e envio uma descrição do problema com foto opcional  
- Então o problema fica registrado e o síndico recebe uma notificação  

❌ **Cenário 2: Acompanhamento de status do problema**  
- Dado que registrei um problema anteriormente  
- Quando acesso a seção de relatos  
- Então posso visualizar o status atualizado do problema (pendente, em andamento, resolvido)  

---

### 📢 História 3: Comunicados do Síndico  
**Como síndico**, quero publicar comunicados para que todos os moradores sejam informados sobre avisos importantes.  

#### 🎯 Critérios de Aceitação  
- O síndico pode criar, editar e remover comunicados.  
- Todos os moradores devem ser notificados sobre novos comunicados.  
- Os comunicados devem ser exibidos de forma organizada e de fácil acesso.  

#### 📌 Cenários BDD  
✅ **Cenário 1: Publicação de um novo comunicado**  
- Dado que sou um síndico logado  
- Quando escrevo e publico um comunicado  
- Então todos os moradores recebem uma notificação e o comunicado fica disponível no sistema  

❌ **Cenário 2: Edição ou remoção de comunicados**  
- Dado que publiquei um comunicado  
- Quando edito ou removo o comunicado  
- Então as alterações são refletidas para todos os moradores  

---

### 🚪 História 4: Registro de Visitantes  
**Como porteiro**, quero registrar visitantes na portaria para garantir a segurança do condomínio.  

#### 🎯 Critérios de Aceitação  
- O porteiro pode registrar o nome do visitante e o apartamento a ser visitado.  
- O morador deve ser notificado para autorizar ou negar a entrada.  
- Visitantes não autorizados não podem entrar no condomínio.  

#### 📌 Cenários BDD  
✅ **Cenário 1: Registro de visitante autorizado**  
- Dado que sou um porteiro logado  
- Quando recebo um visitante e registro seu nome e o apartamento que deseja visitar  
- Então o morador correspondente recebe uma notificação solicitando autorização  

❌ **Cenário 2: Entrada negada por falta de autorização**  
- Dado que um visitante não foi autorizado pelo morador  
- Quando tento registrar sua entrada  
- Então o sistema informa que o visitante não pode entrar  

---

### 💰 História 5: Gestão de Pagamentos e Boletos  
**Como morador**, quero visualizar e pagar meus boletos de condomínio para manter minhas contas organizadas.  

#### 🎯 Critérios de Aceitação  
- O morador pode visualizar boletos pendentes e pagos.  
- O sistema deve atualizar o status do boleto após pagamento.  
- O morador pode enviar o comprovante de pagamento.  

#### 📌 Cenários BDD  
✅ **Cenário 1: Visualização de boletos pendentes**  
- Dado que sou um morador logado  
- Quando acesso a seção de pagamentos  
- Então vejo a lista de boletos pendentes com data de vencimento e valor  

❌ **Cenário 2: Confirmação de pagamento de um boleto**  
- Dado que visualizei um boleto pendente  
- Quando realizo o pagamento e envio o comprovante  
- Então o sistema atualiza o status do boleto para "pago"  

---

### 🚗 História 6: Controle de Veículos e Estacionamento  
**Como morador**, quero cadastrar meu veículo no sistema do condomínio para evitar problemas no estacionamento.  

#### 🎯 Critérios de Aceitação  
- O morador pode cadastrar um veículo informando placa, modelo e cor.  
- O sistema deve verificar o limite de veículos por morador.  
- O síndico pode visualizar os veículos cadastrados.  

#### 📌 Cenários BDD  
✅ **Cenário 1: Cadastro de veículo bem-sucedido**  
- Dado que sou um morador logado  
- Quando insiro as informações do meu veículo (placa, modelo, cor)  
- Então o veículo fica registrado no sistema  

❌ **Cenário 2: Tentativa de cadastrar mais veículos do que o permitido**  
- Dado que o condomínio tem um limite de veículos por morador  
- Quando tento cadastrar um novo veículo além do limite permitido  
- Então recebo um aviso informando que não posso adicionar outro veículo  

---

### 🗣 História 7: Fórum de Discussões entre Moradores  
**Como morador**, quero participar de um fórum de discussões para interagir e debater temas sobre o condomínio.  

#### 🎯 Critérios de Aceitação  
- O morador pode criar novos tópicos no fórum.  
- Outros moradores podem visualizar e responder aos tópicos.  
- As discussões devem ser organizadas e exibidas de forma clara.  

#### 📌 Cenários BDD  
✅ **Cenário 1: Criação de uma nova discussão**  
- Dado que sou um morador logado  
- Quando publico um novo tópico no fórum  
- Então o tópico fica visível para outros moradores interagirem  

❌ **Cenário 2: Responder a uma discussão existente**  
- Dado que um morador criou um tópico no fórum  
- Quando respondo ao tópico com minha opinião  
- Então minha resposta fica registrada e visível para todos  

---

### 📦 História 8: Envio de Encomendas e Notificações  
**Como morador**, quero ser notificado quando uma encomenda chegar na portaria para que eu possa retirá-la o mais rápido possível.  

#### 🎯 Critérios de Aceitação  
- A portaria pode registrar a chegada de uma encomenda.  
- O morador recebe uma notificação quando há uma encomenda aguardando retirada.  
- O sistema deve atualizar o status da encomenda após retirada.  

#### 📌 Cenários BDD  
✅ **Cenário 1: Notificação de nova encomenda**  
- Dado que sou um morador logado  
- Quando a portaria registra a chegada de uma encomenda para mim  
- Então recebo uma notificação no sistema informando que há uma encomenda aguardando retirada  

❌ **Cenário 2: Confirmação de retirada de encomenda**  
- Dado que recebi uma notificação sobre uma encomenda  
- Quando vou até a portaria e retiro a encomenda  
- Então o sistema atualiza o status da encomenda para "retirada"   
