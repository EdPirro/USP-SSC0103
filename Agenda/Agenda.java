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
            if(i.getNome() == name) return i;
        }
        return null;
    }

    public Pessoa searchContactByCPF(String CPF){
        for(Pessoa i : contatos){
            if(i instanceof PessoaFisica)
                if(((PessoaFisica)i).getCPF() == CPF) return i;
        }
        return null;
    }

    public Pessoa searchContactByCNPJ(String CNPJ){
        for(Pessoa i : contatos){
            if(i instanceof PessoaJuridica)
                if(((PessoaJuridica)i).getCNPJ() == CNPJ) return i;
        }
        return null;
    }

    public int searchContactIdByName(String name){
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i).getNome() == name) return i;
        }
        return -1;
    }

    public int searchContactIdByCPF(String CPF){
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i) instanceof PessoaFisica)
                if(((PessoaFisica)contatos.get(i)).getCPF() == CPF) return i;
        }
        return -1;
    }

    public int searchContactIdByCNPJ(String CNPJ){
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i) instanceof PessoaJuridica)
                if(((PessoaJuridica)contatos.get(i)).getCNPJ() == CNPJ) return i;
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
        System.out.println("E-mail: " + i.getEmail() + ".");
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

    private long getCPFNum(String CPF){ //CPF : XXX.XXX.XXX-XX
        String[] str = CPF.split("-");
        long longCPF = Integer.parseInt(str[1]);
        longCPF += Integer.parseInt(str[0].split("\\.")[2]) * 100L;
        longCPF += Integer.parseInt(str[0].split("\\.")[1]) * 100000L;
        longCPF += Integer.parseInt(str[0].split("\\.")[0]) * 100000000L;
        return longCPF;
    }


    private void sortCPF(ArrayList<PessoaFisica> pf){
        PessoaFisica[] newPF = new PessoaFisica[pf.size()];
        int size = pf.size();
        for(int i = 0; i < size; i++) newPF[i] = pf.get(i);
        pf.clear();
        for(int i = 0; i < size; i++){
            for(int j = size - 2; j >= i; j--) {
                if (getCPFNum(newPF[j + 1].getCPF()) < getCPFNum(newPF[j].getCPF())) {
                    PessoaFisica aux = newPF[j];
                    newPF[j] = newPF[j + 1];
                    newPF[j + 1] = aux;
                }
            }
        }
        for(PessoaFisica i : newPF) pf.add(i);
        return;
    }

    private long getCNPJNum(String CNPJ){ // CNPJ : XX.XXX.XXX/XXXX-XX
        String[] str = CNPJ.split("-");
        long longCNPJ = Integer.parseInt(str[1]);
        str = str[0].split("/");
        longCNPJ += Integer.parseInt(str[1]) * 100;
        longCNPJ += Integer.parseInt(str[0].split("\\.")[2]) * 1000000L;
        longCNPJ += Integer.parseInt(str[0].split("\\.")[1]) * 1000000000L;
        longCNPJ += Integer.parseInt(str[0].split("\\.")[0]) * 1000000000000L;
        return longCNPJ;
    }



    private void sortCNPJ(ArrayList<PessoaJuridica> pj){
        PessoaJuridica[] newPJ = new PessoaJuridica[pj.size()];
        int size = pj.size();
        for(int i = 0; i < size; i++) newPJ[i] = pj.get(i);
        pj.clear();
        for(int i = 0; i < size; i++){
            for(int j = size - 2; j >= i; j--) {
                if (getCNPJNum(newPJ[j + 1].getCNPJ()) < getCNPJNum(newPJ[j].getCNPJ())) {
                    PessoaJuridica aux = newPJ[j];
                    newPJ[j] = newPJ[j + 1];
                    newPJ[j + 1] = aux;
                }
            }
        }
        for(PessoaJuridica i : newPJ) pj.add(i);
        return;
    }


    public void sort(){
        ArrayList<PessoaFisica> pf = new ArrayList<>();
        ArrayList<PessoaJuridica> pj = new ArrayList<>();
        for(Pessoa i : contatos) {
            if (i instanceof PessoaFisica) pf.add((PessoaFisica) i);
            else pj.add((PessoaJuridica) i);
        }
        contatos.clear();
        sortCPF(pf);
        sortCNPJ(pj);
        for(PessoaFisica i : pf) contatos.add((Pessoa) i);
        for(PessoaJuridica i : pj) contatos.add((Pessoa) i);
    }

}
