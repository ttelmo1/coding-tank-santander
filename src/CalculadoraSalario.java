import java.util.Scanner;

public class CalculadoraSalario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] salariosBruto = new double[5];
        double[] inss = new double[5];
        double[] impostoRenda = new double[5];
        double[] salarioliquido = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o salário bruto do funcionário " + (i + 1) + ": ");
            salariosBruto[i] = scanner.nextDouble();

            inss[i] = calcularINSS(salariosBruto[i]);
            impostoRenda[i] = calcularImpostoRenda(salariosBruto[i]);
            salarioliquido[i] = salariosBruto[i] - inss[i] - impostoRenda[i];

            System.out.printf("Salário bruto: R$%.2f%n", salariosBruto[i]);
            System.out.printf("Valor pago ao INSS: R$%.2f%n", inss[i]);
            System.out.printf("Valor pago de Imposto de Renda: R$%.2f%n", impostoRenda[i]);
            System.out.printf("Salário líquido do funcionário %d: R$%.2f%n", (i + 1), salarioliquido[i]);
            System.out.println();
        }

        scanner.close();
    }

    public static double calcularINSS(double salarioBruto) {
        if (salarioBruto <= 1212.00) {
            return salarioBruto * 0.075;
        } else if (salarioBruto <= 2427.35) {
            return salarioBruto * 0.09;
        } else if (salarioBruto <= 3641.03) {
            return salarioBruto * 0.12;
        } else {
            return salarioBruto * 0.14;
        }
    }

    public static double calcularImpostoRenda(double salarioBruto) {
        if (salarioBruto <= 1903.98) {
            return 0.0;
        } else if (salarioBruto <= 2826.65) {
            return salarioBruto * 0.075;
        } else if (salarioBruto <= 3751.05) {
            return salarioBruto * 0.15;
        } else if (salarioBruto <= 4664.68) {
            return salarioBruto * 0.225;
        } else {
            return salarioBruto * 0.275;
        }
    }
}
