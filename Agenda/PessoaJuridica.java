public class PessoaJuridica extends Pessoa {
    private String CNPJ;
    private String razaoSocial;
    private String inscricaoEstadual;

    public PessoaJuridica(String nome, String endereco, String email, String CNPJ, String razaoSocial, String inscricaoEstadual) {
        super(nome, endereco, email);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {

        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}
