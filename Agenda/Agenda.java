import java.util.ArrayList;

public class Agenda {
    private ArrayList<Pessoa> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void addContact(Pessoa contato){
        contatos.add(contato);
    }

    public Pessoa searchContactByName(String name){
        for(Pessoa i : contatos){
            if(i.getNome().equals(name)) return i;
        }
        return null;
    }

    public Pessoa searchContactByCPF(String CPF){
        for(Pessoa i : contatos){
            if(i instanceof PessoaFisica)
                if(((PessoaFisica)i).getCPF().equals(CPF)) return i;
        }
        return null;
    }

    public Pessoa searchContactByCNPJ(String CNPJ){
        for(Pessoa i : contatos){
            if(i instanceof PessoaJuridica)
                if(((PessoaJuridica)i).getCNPJ().equals(CNPJ)) return i;
        }
        return null;
    }

    public int searchContactIdByName(String name){
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i).getNome().equals(name)) return i;
        }
        return -1;
    }

    public int searchContactIdByCPF(String CPF){
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i) instanceof PessoaFisica)
                if(((PessoaFisica)contatos.get(i)).getCPF().equals(CPF)) return i;
        }
        return -1;
    }

    public int searchContactIdByCNPJ(String CNPJ){
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i) instanceof PessoaJuridica)
                if(((PessoaJuridica)contatos.get(i)).getCNPJ().equals(CNPJ)) return i;
        }
        return -1;
    }

    public void removeContactByName(String name){
        int pos = searchContactIdByName(name);
        if(pos != -1)
            contatos.remove(pos);
        return;
    }

    public void removeContactByCPF(String CPF){
        int pos = searchContactIdByCPF(CPF);
        if(pos != -1)
            contatos.remove(pos);
        return;
    }

    public void removeContactByCNPJ(String CNPJ){
        int pos = searchContactIdByCNPJ(CNPJ);
        if(pos != -1)
            contatos.remove(pos);
        return;
    }

    public void printFisica(PessoaFisica i){
        System.out.println("Nome: " + i.getNome() + ".");
        System.out.println("CPF: " + i.getCPF() + ".");
        System.out.println("E-mail: " + i.getEmail() + ".\n");
    }
    public void printJuridica(PessoaJuridica i){
        System.out.println("Nome: " + i.getNome() + ".");
        System.out.println("CNPJ: " + i.getCNPJ() + ".");
        System.out.println("E-mail: " + i.getEmail() + ".");
    }


    public void printAllContact(){
        for(Pessoa i : contatos){
            if(i instanceof PessoaFisica) printFisica((PessoaFisica)i);
            else printJuridica((PessoaJuridica) i);
        }
    }

}
