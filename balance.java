package project.银行;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class balance {

   public void see(Customer customer,Customer customer1)throws Exception{
      BigDecimal b=customer.getMoney();
      NumberFormat ins=NumberFormat.getCurrencyInstance();
      ins.setCurrency(Currency.getInstance(Locale.CHINA));
      System.out.println("您的余额为："+ins.format(b));
      Function f=new Function();
      Main m=new Main();
      Scanner sc=new Scanner(System.in);
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
   }

}
