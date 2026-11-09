public class Cliente
{
private String nome;
private String email;
private String cpf;
private boolean estudante;
public Cliente(String nome, String email, String cpf, boolean estudante)
{
    setNome(nome);
    setEmail(email);
    setCpf(cpf);
    this.estudante = estudante;
}
//Setters
public void setNome(String nome) { this.nome = nome; }
public void setEmail(String email) { this.email = email; }
public void setCpf(String cpf) { this.cpf = cpf; }

//Getters
public String getNome() { return nome; }
public String getEmail() { return email; }
public String getCpf() { return cpf; }
public boolean getEstudante() { return estudante; }
}