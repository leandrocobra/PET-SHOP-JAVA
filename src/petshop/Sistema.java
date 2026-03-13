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
        while (opcao != 5) {
            System.out.println("\n=====PETSHOP=====");
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar pets");
            System.out.println("2 - Listar Pets");
            System.out.println("3 - Criar agendamento");
            System.out.println("4 - Listar agendamento");
            System.out.println("5 - Sair");

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
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        }
    }

// Método para cadastrar pet.

    public void cadastrarPet(){
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

            if (opcaoEspecie == 3){
                System.out.println("Aqui não é um zoológico");
            } else if (opcaoEspecie != 1 && opcaoEspecie != 2) {
                System.out.println("Opção inválida!");
            }

        }while (opcaoEspecie !=1 && opcaoEspecie !=2);

        if (opcaoEspecie == 1) {
            pet.especie = "Cachorro";
        } else {
            pet.especie = "Gato";
        }

        pets.add(pet);

        System.out.println("Pet cadastrado com sucesso!");
    }

// Método para listar pets.

    public void listarPets(){

        System.out.println("\n== LISTA DE PETS ===");

        if (pets.size() == 0){
            System.out.println("Nenhum pet cadastrado");
            return;
        }

        for (Pet pet : pets) {
            System.out.println(pet.id + " - " + pet.nome + " - " + pet.especie);
        }

    }

// Método para criar agendamento.

    public void criarAgendamento(){

        System.out.println("\n=== CRIAR AGENDAMENTO ===");

        if (pets.size() == 0){
            System.out.println("Nenhum pet cadastrado, cadastre um pet primeiro.");
            return;
        }

        System.out.println("\nEscolha o pet para o agendamento:");
        listarPets();

        Agendamento agendamento = new Agendamento();

        agendamento.id = agendamentos.size() + 1;

        System.out.println("Digite o ID do pet:");
        agendamento.idPet = scanner.nextInt();

        scanner.nextLine();

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

        }while (nagend < 1 || nagend > 3);

        agendamento.servico = nagend;

        agendamentos.add(agendamento);

    }

// Método para listar os agendamentos.

    public void listarAgendamentos(){

        System.out.println("\n=== LISTA DE AGENDAMENTOS ===");

        if (agendamentos.size() == 0){
            System.out.println("Nenhum agendamento cadastrado");
            return;
        }

        for (Agendamento agendamento : agendamentos){

            String nomePet = "";

            for (Pet pet : pets){
                if (pet.id == agendamento.idPet){
                    nomePet = pet.nome;
                    break;
                }
            }

            String nomeServico = "";

            switch (agendamento.servico){
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

            System.out.println(agendamento.id + " - " + nomePet + " - " + nomeServico);
        }
    }





}

















