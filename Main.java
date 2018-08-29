package project.银行;

import java.util.Scanner;

public class Main {
    public void start(Customer customer,Customer customer1) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------------------------欢迎使用中国银行自助系统-----------------------------------------------------");
        System.out.println("1:登陆系统");
        System.out.println("0:退出");
        boolean flag=true;
        while (flag){
            int a=sc.nextInt();
            switch (a){
                case 1:  Login l=new Login();
                    l.start(customer1);
                    flag=false;
                    break;
                case 0:
                    writes.Writes(customer,customer1);
                    flag=false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
    }
}
