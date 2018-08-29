package project.银行;

import java.util.Scanner;

public class Function {

    public void see(Customer customer,Customer customer1) throws Exception {
        Main m=new Main();
        Scanner sc=new Scanner(System.in);
        System.out.println("1.查看余额");
        System.out.println("2.存款");
        System.out.println("3.取款");
        System.out.println("4.转账");
        System.out.println("5.修改个人信息");
        System.out.println("6.退回主界面");
        System.out.println("请输入你所需的功能的ID：");
        boolean flag=true;
        while (flag){
            int a=sc.nextInt();
            switch (a){
                case 1:
                    balance y=new balance();
                    y.see(customer,customer1);
                    flag=false;
                    break;
                case 2:
                    save c=new save();
                    c.start(customer,customer1);
                    flag=false;
                    break;
                case 3:
                    take q=new take();
                    q.start(customer,customer1);
                    flag=false;
                    break;
                case 4:
                    transfer z=new transfer();
                    z.start(customer,customer1);
                    flag=false;
                    break;
                case 5: Pinformation p=new Pinformation();
                    p.change(customer,customer1);
                    flag=false;
                    break;
                case 6: m.start(customer,customer1);
                    flag=false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入：");
            }
        }

    }
}
