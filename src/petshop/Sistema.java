package petshop;

import java.util.Scanner;
import java.util.ArrayList;


public class Sistema {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Pet> pets = new ArrayList<>();
    ArrayList<Agendamento> agendamentos = new ArrayList<>();

// Método para iniciar o sistema com menu.

    public void iniciar() {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n=====PETSHOP=====");
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar pets");
            System.out.println("2 - Listar Pets");
            System.out.println("3 - Criar agendamento");
            System.out.println("4 - Listar agendamento");
            System.out.println("5 - Entrar no menu de ADM");
            System.out.println("6 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    cadastrarPet();
                    break;

                case 2:
                    listarPets();
                    break;

                case 3:
                    criarAgendamento();
                    break;

                case 4:
                    listarAgendamentos();
                    break;
                case 5:
                    menuAdm();
                    break;
                case 6:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        }
    }

// Método para cadastrar pet.

    public void cadastrarPet() {
        Pet pet = new Pet();

        System.out.println("== CADASTRO DE PET ==");

        pet.id = pets.size() + 1;

        scanner.nextLine();

        System.out.print("Nome do pet: ");
        pet.nome = scanner.nextLine();

        int opcaoEspecie;
        do {
            System.out.println("Escolha a espécie do pet: ");
            System.out.println("Digite 1 para Cachorro");
            System.out.println("Digite 2 para Gato");
            System.out.println("Digite 3 para outra espécie");

            opcaoEspecie = scanner.nextInt();

            if (opcaoEspecie == 3) {
                System.out.println("Aqui não é um zoológico");
            } else if (opcaoEspecie != 1 && opcaoEspecie != 2) {
                System.out.println("Opção inválida!");
            }

        } while (opcaoEspecie != 1 && opcaoEspecie != 2);

        if (opcaoEspecie == 1) {
            pet.especie = "Cachorro";
        } else {
            pet.especie = "Gato";
        }

        scanner.nextLine();

        System.out.println("Escolha a raça do PET:");
        pet.raca = scanner.nextLine();

        System.out.println("Escolha a idade do PET:");
        pet.idade = scanner.nextInt();

        do {
            System.out.println("\nEscolha o porte do animal:");
            System.out.println("1 - Pequeno (até 10kg)");
            System.out.println("2 - Médio (10kg a 25kg)");
            System.out.println("3 - Grande (acima de 25kg)");
            System.out.print("Opção: ");
            pet.porte = scanner.nextInt();
            scanner.nextLine();

            if (pet.porte < 1 || pet.porte > 3) {
                System.out.println("Opção de porte inválida!");
            }

        } while (pet.porte < 1 || pet.porte > 3);


        pets.add(pet);

        System.out.println("Pet cadastrado com sucesso!");
    }

// Método conversão de porte de inteiro para string.

    public String textoPorte(int porte){
        if (porte == 1){
            return "Pequeno";
        } else if (porte == 2) {
            return "Médio";
        }else{
            return "Grande";
        }
    }
//Método para buscar pet por ID

    public Pet buscarPetPorId(int id){
        for (Pet pet : pets){
            if (pet.id == id){
                return pet;
            }
        }
        return null;
    }



// Método para listar pets.

    public void listarPets() {

        System.out.println("\n==== LISTA DE PETS =====");
        System.out.println("ID -- NOME -- ESPÉCIE -- RAÇA -- IDADE -- PORTE");

        if (pets.size() == 0) {
            System.out.println("Nenhum pet cadastrado");
            return;
        }

        for (Pet pet : pets) {
            System.out.println(pet.id + " - " + pet.nome + " - " + pet.especie + " - " + pet.raca + " - " + pet.idade + " anos - " + " Porte: " + textoPorte(pet.porte));
        }

    }

//Método para calcular valor do serviço.

    public double calcularValorServico(int servico, int porte) {
        switch (servico) {
            case 1:
                if (porte == 1) {
                    return 30;
                } else if (porte == 2) {
                    return 40;
                } else {
                    return 50;
                }
            case 2:
                if (porte == 1) {
                    return 40;
                } else if (porte == 2) {
                    return 50;
                } else {
                    return 60;
                }
            case 3:
                return 80;
            default:
                return 0;
        }
    }
// Método para criar agendamento.

    public void criarAgendamento() {

        System.out.println("\n=== CRIAR AGENDAMENTO ===");

        if (pets.size() == 0) {
            System.out.println("Nenhum pet cadastrado, cadastre um pet primeiro.");
            return;
        }

        System.out.println("\nEscolha o pet para o agendamento:");
        listarPets();

        Agendamento agendamento = new Agendamento();

        agendamento.id = agendamentos.size() + 1;

        Pet petEncontrado;

        do {
            System.out.println("Digite o ID do pet:");
            int idInformado = scanner.nextInt();

            petEncontrado = buscarPetPorId(idInformado);

            if (petEncontrado == null) {
                System.out.println("ID de pet não encontrado! Digite novamente.");
                }else {
                    agendamento.idPet = idInformado;
            }
        } while (petEncontrado == null);

        int nagend = 0;

        do {

            System.out.println("== ESCOLHA SEU SERVIÇO ==");
            System.out.println("==== 1 - BANHO ====");
            System.out.println("==== 2 - TOSA ====");
            System.out.println("==== 3 - VACINA ====");

            nagend = scanner.nextInt();

            switch (nagend) {
                case 1:
                    System.out.println("Serviço de BANHO criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Serviço de TOSA criado com sucesso!");
                    break;
                case 3:
                    System.out.println("Serviço de VACINA criado com sucesso!");
                    break;
                default:
                    System.out.println("NÚMERO DE SERVIÇO INCORRETO!!!");
            }

        } while (nagend < 1 || nagend > 3);

        agendamento.servico = nagend;

        agendamento.valor = calcularValorServico(nagend, petEncontrado.porte);
        System.out.println("Valor do serviço R$:" + agendamento.valor);

        agendamento.status = "AGENDADO";

        agendamentos.add(agendamento);

    }

// Método para listar os agendamentos.

    public void listarAgendamentos() {

        System.out.println("\n=== LISTA DE AGENDAMENTOS ===");

        if (agendamentos.size() == 0) {
            System.out.println("Nenhum agendamento cadastrado");
            return;
        }

        for (Agendamento agendamento : agendamentos) {

            Pet pet = buscarPetPorId(agendamento.idPet);

            String nomeServico = "";

            switch (agendamento.servico) {
                case 1:
                    nomeServico = "BANHO";
                    break;
                case 2:
                    nomeServico = "TOSA";
                    break;
                case 3:
                    nomeServico = "VACINA";
                    break;
            }

            System.out.println(agendamento.id + " - " + pet.nome + " - " + nomeServico + " R$: " + agendamento.valor + " Status: " + agendamento.status);
        }
    }

    public void menuAdm(){

        int opcao = 0;

        while (opcao !=3){

            System.out.println("\n=== MÓDULO DE ADM ===");
            System.out.println("1 - Listar Agendamentos");
            System.out.println("2 - Alterar status dos agendamentos");
            System.out.println("3 - Voltar");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    listarAgendamentos();
                    break;
                case 2:
                    alterarStatusAgendamento();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void alterarStatusAgendamento() {

        if (agendamentos.size() == 0) {
            System.out.println("Nenhum agendamento cadastrado");
            return;
        }

        listarAgendamentos();

        System.out.println("Digite o ID do agendamento que deseja alterar Status");
        int idAgendamento = scanner.nextInt();

        Agendamento agendamentoEncontrado = null;

        for (Agendamento agendamento : agendamentos) {
            if (agendamento.id == idAgendamento) {
                agendamentoEncontrado = agendamento;
            }
        }

        if (agendamentoEncontrado == null) {
            System.out.println("Agendamento não encontrado.");
            return;
        }

        System.out.println("Escolha o novo status:");
        System.out.println("1 - AGENDADO");
        System.out.println("2 - EM ANDAMENTO");
        System.out.println("3 - FINALIZADO");
        System.out.println("4 - CANCELADO");

        int opcaoStatus = scanner.nextInt();

        switch (opcaoStatus){
            case 1:
                agendamentoEncontrado.status = "AGENDADO";
                break;
            case 2:
                agendamentoEncontrado.status = "EM ANDAMENTO";
                break;
            case 2:
                agendamentoEncontrado.status = "CANCELADO";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.println("Status atualizado com sucesso!");

    }
}

















