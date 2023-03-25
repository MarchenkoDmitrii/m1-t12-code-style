
import java.util.Scanner;

public class calculateDeposit {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod ) {
       double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

       return roundUp(pay, 2);
    }
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundUp(amount + amount * yearRate * depositPeriod, 2);
    }
    double roundUp(double value, int places) {
       double scale = Math.pow(10, places);

       return Math.round(value * scale) / scale;
    }

    void depositMenu() {
        int period;
        int action;

        Scanner sum = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;

        int amount = sum.nextInt(); System.out.println("Введите срок вклада в годах:") ;

        period = sum.nextInt();
        System.out.println   ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = sum.nextInt();

        double outDoubleVar = 0;

        if (action == 1) {
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }
    public static void main(String[] args) {
        new calculateDeposit().depositMenu();
    }
}
