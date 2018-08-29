package project.银行;

import java.math.BigDecimal;

import java.util.Scanner;

public class save {

    public void start(Customer customer,Customer customer1) throws Exception {
        Function f=new Function();
        Main m=new Main();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要存钱的具体数目：");
        while (true){
            int moneynum=sc.nextInt();
            if(moneynum>0){
                BigDecimal num=new BigDecimal(moneynum);
                customer.setMoney(customer.getMoney().add(num));
                System.out.println("存款成功，本次共存款"+moneynum+"元，余额为："+customer.getMoney());
                System.out.println("1.返回上一级界面");
                System.out.println("2.返回主界面");
                boolean flag=true;
                while (flag){
                    int a1=sc.nextInt();
                    switch (a1){
                        case 1:
                            f.see(customer,customer1);
                            flag=false;
                            break;
                        case 2:m.start(customer,customer1);
                            flag=false;
                            break;
                        default:
                            System.out.println("输入有误，请重新输入");
                    }
                }
                break;
            }else {
                System.out.println("输入金额不正规，请重新输入.....");
            }
        }
    }
}
