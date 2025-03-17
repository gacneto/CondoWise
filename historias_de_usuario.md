# 📖 Histórias de Usuário - CondoWise

## 🔹 História 1 - Cadastro de Morador
**Como** morador,  
**Quero** me cadastrar na plataforma,  
**Para** acessar as funcionalidades do sistema.  
✅ **Critérios de Aceitação:**  
- O cadastro deve incluir nome, CPF, e-mail, telefone, número do apartamento e bloco.  
- O sistema deve validar se o CPF e o e-mail já estão cadastrados.  
- O usuário deve definir uma senha segura para acesso.  

---

## 🔹 História 2 - Login de Usuário
**Como** usuário do sistema,  
**Quero** fazer login com minhas credenciais,  
**Para** acessar as funcionalidades disponíveis conforme meu perfil.  
✅ **Critérios de Aceitação:**  
- O login deve ser realizado com e-mail e senha cadastrados.  
- O sistema deve informar caso as credenciais estejam incorretas.  
- Após o login, o usuário deve ser redirecionado para a sua dashboard correspondente (morador, síndico ou porteiro).  

---

## 🔹 História 3 - Reserva de Área Comum
**Como** morador,  
**Quero** reservar uma área comum,  
**Para** garantir que poderei utilizá-la no horário desejado.  
✅ **Critérios de Aceitação:**  
- O sistema deve exibir a disponibilidade das áreas comuns.  
- O morador pode selecionar a data e horário desejados.  
- Reservas não podem ser duplicadas para o mesmo horário.  
- O status da reserva pode ser **Confirmada**, **Pendente** ou **Cancelada**.  

---

## 🔹 História 4 - Controle de Visitantes
**Como** porteiro,  
**Quero** registrar a entrada e saída de visitantes,  
**Para** manter um controle de segurança no condomínio.  
✅ **Critérios de Aceitação:**  
- O visitante deve ser cadastrado com nome e documento (RG/CPF).  
- A data e horário de entrada e saída devem ser registrados.  
- O sistema deve permitir associar o visitante a um morador.  

---

## 🔹 História 5 - Registro de Encomendas
**Como** porteiro,  
**Quero** registrar encomendas recebidas,  
**Para** notificar os moradores sobre suas entregas.  
✅ **Critérios de Aceitação:**  
- O porteiro deve cadastrar a encomenda com o código de rastreio.  
- O sistema deve associar a encomenda a um morador.  
- O status da encomenda pode ser **Entregue** ou **Pendente**.  

---

## 🔹 História 6 - Abertura de Chamado de Manutenção
**Como** morador,  
**Quero** abrir um chamado de manutenção,  
**Para** relatar problemas e solicitar reparos no condomínio.  
✅ **Critérios de Aceitação:**  
- O chamado deve conter uma descrição detalhada do problema.  
- O sistema deve registrar a data de abertura e permitir acompanhar o status (**Aberto**, **Em andamento**, **Concluído**).  
- O síndico deve ser notificado sobre novos chamados.  

---

## 🔹 História 7 - Comunicação entre Síndico e Moradores
**Como** síndico,  
**Quero** publicar comunicados,  
**Para** informar os moradores sobre assuntos do condomínio.  
✅ **Critérios de Aceitação:**  
- O comunicado deve conter título, descrição e data de publicação.  
- Apenas o síndico pode criar comunicados.  
- Os moradores devem visualizar os comunicados na plataforma.  

---

## 🔹 História 8 - Fórum de Discussões
**Como** morador,  
**Quero** participar de um fórum de discussões,  
**Para** debater assuntos relevantes sobre o condomínio.  
✅ **Critérios de Aceitação:**  
- O morador pode criar discussões com título e mensagem inicial.  
- Os participantes podem comentar nas discussões existentes.  
- O fórum deve exibir mensagens em ordem cronológica.  
