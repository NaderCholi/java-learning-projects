import java.util.Scanner;

public class Principal
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();
        int op;

        do
        {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar evento");
            System.out.println("3 - Vender ingresso");
            System.out.println("4 - Cancelar ingresso");
            System.out.println("5 - Ingressos de um cliente");
            System.out.println("6 - Vagas de um evento");
            System.out.println("7 - Total de um evento");
            System.out.println("8 - Total geral");
            System.out.println("0 - Sair");
            op = sc.nextInt();
            sc.nextLine();

            if(op == 1)
            {
                System.out.println("Nome:");
                String nome = sc.nextLine();
                System.out.println("Email:");
                String email = sc.nextLine();
                System.out.println("CPF:");
                String cpf = sc.nextLine();
                System.out.println("Estudante? (s/n)");
                String resp = sc.nextLine();
                boolean estudante = resp.equals("s");

                Cliente c = new Cliente(nome, email, cpf, estudante);
                if(sistema.cadastrarCliente(c))
                {
                    System.out.println("Cliente cadastrado!");
                }
                else
                {
                    System.out.println("Nao deu pra cadastrar.");
                }
            }
            else if(op == 2)
            {
                System.out.println("Nome do evento:");
                String nome = sc.nextLine();
                System.out.println("Local:");
                String local = sc.nextLine();
                System.out.println("Data:");
                String data = sc.nextLine();
                System.out.println("Capacidade:");
                int cap = sc.nextInt();
                System.out.println("Preco:");
                double preco = sc.nextDouble();
                sc.nextLine();

                Evento e = new Evento(nome, local, data, cap, preco);
                if(sistema.cadastrarEvento(e))
                {
                    System.out.println("Evento cadastrado!");
                }
                else
                {
                    System.out.println("Nao deu pra cadastrar.");
                }
            }
            else if(op == 3)
            {
                System.out.println("CPF do cliente:");
                String cpf = sc.nextLine();
                System.out.println("Nome do evento:");
                String evento = sc.nextLine();

                if(sistema.venderIngresso(cpf, evento))
                {
                    System.out.println("Ingresso vendido!");
                }
                else
                {
                    System.out.println("Nao deu pra vender.");
                }
            }
            else if(op == 4)
            {
                System.out.println("CPF do cliente:");
                String cpf = sc.nextLine();
                System.out.println("Nome do evento:");
                String evento = sc.nextLine();

                if(sistema.cancelarIngresso(cpf, evento))
                {
                    System.out.println("Ingresso cancelado!");
                }
                else
                {
                    System.out.println("Nao deu pra cancelar.");
                }
            }
            else if(op == 5)
            {
                System.out.println("CPF do cliente:");
                String cpf = sc.nextLine();
                sistema.mostrarIngressosDoCliente(cpf);
            }
            else if(op == 6)
            {
                System.out.println("Nome do evento:");
                String evento = sc.nextLine();
                int vagas = sistema.vagasDoEvento(evento);

                if(vagas == -1)
                {
                    System.out.println("Evento nao encontrado.");
                }
                else
                {
                    System.out.println("Vagas: " + vagas);
                }
            }
            else if(op == 7)
            {
                System.out.println("Nome do evento:");
                String evento = sc.nextLine();
                double total = sistema.totalDoEvento(evento);

                if(total == -1)
                {
                    System.out.println("Evento nao encontrado.");
                }
                else
                {
                    System.out.println("Total: R$ " + total);
                }
            }
            else if(op == 8)
            {
                System.out.println("Total geral: R$ " + sistema.totalGeral());
            }
            else if(op != 0)
            {
                System.out.println("Opcao invalida.");
            }

        } while(op != 0);
        sc.close();
    }
}