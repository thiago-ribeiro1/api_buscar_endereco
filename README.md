# Buscar Endereço

Este projeto é uma aplicação que consome a API ViaCEP para buscar informações de endereço a partir de um CEP informado. O backend utiliza Spring Boot com banco de dados H2 para salvar automaticamente os dados retornados pela API, enquanto o frontend permite consultas em uma página criada com AngularJS.

![Image](https://github.com/user-attachments/assets/1f2aeaac-6388-4ee0-aed6-71de9b43716c)

![Image](https://github.com/user-attachments/assets/3bc09710-6224-4d84-895f-1a30f807d326)

---

## Visão Geral do Projeto

### Funcionalidades principais:
1. Consulta de endereços a partir de um CEP utilizando a API ViaCEP.
2. Salvamento automático dos dados retornados no banco de dados H2.
3. Exibição das informações de endereço no frontend.
4. Requisições ao backend via endpoint RESTful (`localhost:8080/{cep}`).
5. Persistência de dados no banco em memória H2 para consultas posteriores.

---

## Como Executar o Projeto

### Pré-requisitos:
- **JDK 17** (Java Development Kit versão 17).
- **Maven** para gerenciar dependências e executar o projeto.
- Navegador para acessar o frontend e o console H2.
  
---

## Configuração para IntelliJ IDEA (Lombok)

Para que o Lombok funcione corretamente no IntelliJ IDEA, é necessário ativar o processamento de anotações. Siga os passos abaixo:

1. Abra as configurações do IntelliJ IDEA:
   - No menu, clique em **File > Settings** (ou **Ctrl+Alt+S** no Windows/Linux, **Command+,** no macOS).
2. Navegue até **Build, Execution, Deployment > Compiler > Annotation Processors**.
3. Certifique-se de que as seguintes opções estão habilitadas:
   - **Enable annotation processing**
   - **Obtain processors from project classpath**
4. Clique em **Apply** e depois em **OK** para salvar as configurações.

### Passos para executar o backend:

1. Clone este repositório:
   ```bash
   git clone https://github.com/thiago-ribeiro1/api_buscar_endereco.git
   cd api_buscar_endereco
   ```

2. Compile e execute o projeto Spring Boot:
   ```bash
   mvn spring-boot:run
   ```

3. O backend estará disponível em:
   ```
   http://localhost:8080
   ```

4. Teste o endpoint diretamente (exemplo com o CEP `01001000`):
   ```
   http://localhost:8080/01001000
   ```

5. Acesse o console do banco H2 para visualizar os dados salvos:
   - URL: `http://localhost:8080/h2-console`
   - Configuração:
     - **JDBC URL:** `jdbc:h2:mem:api_cep`
     - **Username:** `sa`
     - **Password:** (deixe em branco).

6. Execute a seguinte query no console H2 para verificar os dados:
   ```sql
   SELECT * FROM endereco;
   ```

### Passos para executar o frontend:

1. Com o projeto backend em execução, abra o arquivo `angular_viacep.html` em um navegador.
2. Insira o CEP no campo do formulário e clique no botão "Buscar Endereço".
3. As informações retornadas pelo backend serão exibidas na tela, e os dados serão salvos no banco H2 automaticamente.

---

## Tecnologias Utilizadas

### Backend:
- **Java 17 (JDK 17)**: Linguagem de programação.
- **Spring Boot**: Framework para desenvolvimento do backend.
- **Spring Data JPA**: Persistência de dados.
- **Banco de Dados H2**: Banco em memória para armazenamento de endereços.
- **Spring Web**: Para criação de APIs RESTful.
- **OpenFeign**: Para consumo de APIs externas de forma simples.
- **Lombok**: Para reduzir código boilerplate em classes Java.

### Frontend:
- **AngularJS**: Framework para criar a interface do usuário.
- **HTML5 e CSS3**: Estrutura e estilo do frontend.
