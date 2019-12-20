public class PessoaFisica extends Pessoa {
    private String CPF;
    private String dataDeNascimento;
    private String estadoCivil;

    public PessoaFisica(String nome, String endereco, String email, String CPF, String dataDeNascimento, String estadoCivil) {
        super(nome, endereco, email);
        this.CPF = CPF;
        this.dataDeNascimento = dataDeNascimento;
        this.estadoCivil = estadoCivil;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
