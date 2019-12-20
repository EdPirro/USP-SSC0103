
public class Main {
    public static void inserirAgenda(Agenda agenda) throws  Exception{
        System.out.println("Que tipo de pessoa deseja adicionar?\n1-Fisica\n2-Juridica");
        int type = EntradaTeclado.leInt();
        String[] infos = new String[6];

        System.out.println("Insira o nome da pessoa:");
        infos[0] = EntradaTeclado.leString();
        System.out.println("Insira o endereço da pessoa:");
        infos[1] = EntradaTeclado.leString();
        System.out.println("Insira o e-mail da pessoa:");
        infos[2] = EntradaTeclado.leString();
        Pessoa contact;
        if(type == 1){
            System.out.println("Insira o CPF no formato (XXX.XXX.XXX-XX):");
            infos[3] = EntradaTeclado.leString();
            System.out.println("Insira a Data de Nascimento:");
            infos[4] = EntradaTeclado.leString();
            System.out.println("Insira o Estado civil:");
            infos[5] = EntradaTeclado.leString();
            PessoaFisica pessoa = new PessoaFisica(infos[0], infos[1], infos[2], infos[3], infos[4], infos[5]);
            contact = pessoa;
        }
        else {
            System.out.println("Insira o CNPJ no formato (XX.XXX.XXX/XXXX-XX):");
            infos[3] = EntradaTeclado.leString();
            System.out.println("Insira a Razão Social:");
            infos[4] = EntradaTeclado.leString();
            System.out.println("Insira o Inscrição Estadual:");
            infos[5] = EntradaTeclado.leString();
            PessoaJuridica pessoa = new PessoaJuridica(infos[0], infos[1], infos[2], infos[3], infos[4], infos[5]);
            contact = pessoa;
        }

        agenda.addContact(contact);

    }

    public static void removeAgenda(Agenda agenda) throws Exception{
        System.out.println("Deseja remover de que maneira?\n1-Por nome\n2-Por CPF\n3-Por CNPJ");
        int type = EntradaTeclado.leInt();
        switch (type){
            case 1:
                System.out.println("Entre o nome do contato que deseja remover:");
                String name = EntradaTeclado.leString();
                agenda.removeContactByName(name);
                break;
            case 2:
                System.out.println("Entre o CPF do contato que deseja remover:");
                String CPF = EntradaTeclado.leString();
                agenda.removeContactByCPF(CPF);
                break;
            case 3:
                System.out.println("Entre o CNPJ da pessoa que deseja remover:");
                String CNPJ = EntradaTeclado.leString();
                agenda.removeContactByCNPJ(CNPJ);
                break;
        }
    }

    public static void main(String[] args) throws Exception{
        Agenda agenda = new Agenda();
        int op = -5;
        while(op != 0) {
            System.out.println("Insira o numero da operação desejada\n1-Insere\n2-Busca\n3-Ordena\n4-Ver Contatos\n0-Sair");
            op = EntradaTeclado.leInt();
            switch (op) {
                case 1:
                    inserirAgenda(agenda);
                    break;
                case 2:
                    removeAgenda(agenda);
                    break;
                case 3:
                    agenda.sort();
                    break;
                case 4:
                    agenda.printAllContact();
                    break;
            }
        }
    }
}
