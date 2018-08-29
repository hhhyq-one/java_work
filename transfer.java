package project.银行;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class transfer {
    public void start(Customer customer,Customer c) throws Exception {
        Function f=new Function();
        Main m=new Main();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您要转账的银行卡号：");
        String card=sc.next();
        System.out.println("请输入要转帐的具体数目：");
        while (true){
            int money=sc.nextInt();
            BigDecimal moneys=new BigDecimal(money);
            int p=moneys.compareTo(customer.getMoney());
            if(p==0||p<1){
                customer.setMoney(customer.getMoney().subtract(moneys));
                Customer c1;
                ArrayList<Customer> array=new ArrayList();
                Reader r=new InputStreamReader(new FileInputStream("src/Data/bank.txt"));
                BufferedReader br=new BufferedReader(r);
                int count=0;
                while (br.ready()){
                    br.readLine();
                    count++;
                }
                String[] a=new String[count];
                Reader r1=new InputStreamReader(new FileInputStream("src/Data/bank.txt"));
                BufferedReader br1=new BufferedReader(r1);
                int i=0;
                while (br1.ready()){
                    String b=br1.readLine();
                    a[i]=b;
                    i++;
                }
                String[] iofo;
                String[][] iofos=new String[count][];
                for (i = 0; i < a.length; i++) {
                    iofo=a[i].split(" ");
                    iofos[i]=iofo;
                    c1=new Customer(iofo[0],iofo[1],iofo[2],iofo[3],iofo[4],new BigDecimal(iofo[5]));
                    array.add(c1);
                }
                Customer customer1=new Customer();
                int j=0;
                for (; j <array.size(); j++) {
                    if(card.equals(array.get(j).getCardnum())){
                        customer1=array.get(j);
                        customer1.setMoney(customer1.getMoney().add(moneys));
                    }
                }
                System.out.println("成功"+"转给"+customer1.getName()+":"+moneys);
                System.out.println("1.返回上一级界面");
                System.out.println("2.返回主界面");
                boolean flag=true;
                while (flag){
                    int aa=sc.nextInt();
                    switch (aa){
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
            }else if (p>0){
                System.out.println("余额不足,请重新输入......");
            }else {
                System.out.println("输入金额不正规，请重新输入......");
            }


        }

    }

}
