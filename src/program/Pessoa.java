package program;

public class Pessoa {
    private static int counter = 1;

    private String nome;
    private String CPF;
    private String email;


    public Pessoa(String nome, String CPF, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        counter += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "program.Pessoa{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
