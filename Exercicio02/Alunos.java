package exercise2;
public class Alunos {
        private String nome;
        private int matricula;
        private double frequencia,P1,P2,MT;
        private double G1,G2;

        public Alunos(String nome, int matricula, double frequencia, double P1,double P2, double MT)
        {
            this.nome = nome;
            this.matricula = matricula;
            this.frequencia = frequencia;
            this.P1 = P1;
            this.P2 = P2;
            this.MT = MT;
            this.G1 = 0.0;
            this.G2 = 0.0;
        }
        public String getNome()
        {
            return nome;
        }
        public int getMatricula()
        {
            return matricula;
        }
        public double getFrequencia()
        {
            return frequencia;
        }
        public double getP1()
        {
            return P1;
        }
        public double getP2()
        {
            return P2;
        }
        public double getG1()
        {
            return G1;
        }
        public double getG2()
        {
            return G2;
        }
        public double getMT()
        {
            return MT;
        }
        public void setP1(double novaNota)
        {
            this.P1 = novaNota;
        }
        public void setP2(double novaNota)
        {
            this.P2 = novaNota;
        }
        public void setMT(double MT) 
        {
            this.MT = MT;
        }
        public void setFrequencia(double frequencia) 
        {
            this.frequencia = frequencia;
        }
        public double calcG1()
        {
            this.G1 = (P1 + P2 + MT) / 3;
            return G1;
        }
        public double calcG2(double G2)
        {
        double notaF = (calcG1() + G2) / 2;
        if (calcG1() < 7 && frequencia >= 75)
            {
                return notaF;
            }
        return calcG1();
        }
        public boolean aprovado(double G2)
        {
        if (frequencia < 75)
        {
            return false;
        }

        if (calcG1() >= 7)
        {
            return true;
        }
        return calcG2(G2) >= 5;
        }
        public boolean aprovadoPorMedia()
        {
            return calcG1() >= 7 && frequencia >= 75;
        }
    }