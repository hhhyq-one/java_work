package project.银行;

import java.math.BigDecimal;
import java.util.Scanner;

public class take {

    public void start(Customer customer,Customer customer1) throws Exception {
        Function f=new Function();
        Main m=new Main();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要取钱的具体数目：");
        while (true){
            int moneynum=sc.nextInt();
            BigDecimal num=new BigDecimal(moneynum);
            int p=num.compareTo(customer.getMoney());
            if(p==0||p<0){
                customer.setMoney(customer.getMoney().subtract(num));
                System.out.println("1.返回上一级界面");
                System.out.println("2.返回主界面");
                boolean flag=true;
                while (flag){
                    int a=sc.nextInt();
                    switch (a){
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
            }else if(p==1) {
                System.out.println("余额不足,请重新输入......");
            }else {
                System.out.println("输入金额不正规，请重新输入......");
            }
        }



    }

}
