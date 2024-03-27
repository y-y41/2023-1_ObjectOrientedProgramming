package manager;

import account.*;

import java.time.LocalDate;
import java.util.Random;

public class AccountManager {
    public static void main(String[] args) {
        LocalDate c = LocalDate.of(2021, 12, 01);

        Account ac = new Account("Choi", 5, c);
        System.out.println(ac);

        int year = 0;
        int month = 0;
        int flag = 1;
        while (ac.getBalance() <= 10000) {
            ac.receiveIncome(100);
            ac.receiveInterest();
            month++;
            if (month == 12) {
                year++;
                month = 0;
            }
            if (year >= 1 && ac.getCreated().getMonthValue()+month == 13) {
                Random rnd = new Random();
                int event = rnd.nextInt(9);
                if (event == 4) {
                    ac.receiveIncome(100);
                    System.out.println("이벤트 당첨!");
                }
            }
            if (year == 3 && flag == 1) {
                ac.increaseYearlyInterest(2);
                System.out.println("가입 후 3년이 지나서 이자율이 2% 인상되었습니다.");
                flag = 0;
            }
        }
        LocalDate r1 = c.plusYears(year);
        LocalDate r2 = r1.plusMonths(month);
        System.out.println(ac+", 1억 모으기 끝: "+r2);
    }
}
