package exercise2;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Alunos a1 = new Alunos("Nader", 4231, 0, 0, 0, 0);

        System.out.print("Digite a nota da P1: ");
        a1.setP1(sc.nextDouble());

        System.out.print("Digite a nota da P2: ");
        a1.setP2(sc.nextDouble());

        System.out.print("Digite a média de exercícios: ");
        double MT = sc.nextDouble();
        a1.setMT(MT);

        System.out.print("Digite a frequência (%): ");
        double frequencia = sc.nextDouble();
        a1.setFrequencia(frequencia);

        System.out.println("G1: " + a1.calcG1());

        if (a1.aprovadoPorMedia()) {
            System.out.println("Aluno aprovado por média!");
        } else if (frequencia < 75) {
            System.out.println("Aluno reprovado por frequência.");
        } else {
            System.out.println("Aluno não aprovado por média.");
            System.out.print("Deseja alterar a P1? (1 = Sim, 0 = Não): ");
            int opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a nova nota da P1: ");
                a1.setP1(sc.nextDouble());
            } else {
                System.out.print("Digite a nova nota da P2: ");
                a1.setP2(sc.nextDouble());
            }

            System.out.println("Novo G1: " + a1.calcG1());

            System.out.print("Digite a nota da G2: ");
            double G2 = sc.nextDouble();

            double mediaFinal = a1.calcG2(G2);
            System.out.println("Média final: " + mediaFinal);

            if (a1.aprovado(G2)) {
                System.out.println("Aluno aprovado!");
            } else {
                System.out.println("Aluno reprovado.");
            }
        }
        sc.close();
    }
}