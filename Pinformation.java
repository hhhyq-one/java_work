package project.银行;

import java.util.Scanner;

public class Pinformation {
    public void change(Customer customer,Customer customer1)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入原来的密码：");
        String password=sc.next();
        while (true){
            if(customer.getPassword().equals(password)){
                System.out.println("请输入修改后密码：");
                String password1=sc.next();
                System.out.println("再输入一次的密码：");
                String password2=sc.next();
                if (password1.equals(password2)){
                    customer.setPassword(password2);
                    System.out.println("密码修改完成");
                    Function f=new Function();
                    f.see(customer,customer1);
                    break;
                }else {
                    System.out.println("两次输入的密码不一样"+"\n"+"请重新输入修改前的密码");
                }
            }else {
                System.out.println("密码输入错误！！！"+"\n"+"请重新输入");
            }
        }


    }
}
