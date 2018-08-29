package project.银行;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public void start(Customer customer1)throws Exception{
        ArrayList<Customer> array=new ArrayList<>();
        Customer c;
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
            c=new Customer(iofo[0],iofo[1],iofo[2],iofo[3],iofo[4],new BigDecimal(iofo[5]));
            array.add(c);
        }

        int num=0;
        boolean flag=true;
        while (flag){
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入您的银行卡号：");
            String cardnum=sc.next();
            System.out.println("请输入您的密码：");
            String password=sc.next();
            boolean flags=true;
            for (int j = 0; j < iofos.length; j++) {
                if(cardnum.equals(iofos[j][3])&&password.equals(iofos[j][4])){
                    System.out.println(iofos[j][0]+"                登录成功");
                    System.out.println("-----------------欢饮使用中国银行自主系统------------------");
                    flag=false;
                    flags=true;
                    Function f=new Function();
                    f.see(array.get(j),customer1);
                    break;
                }else {
                    flags=false;
                }
            }
            if(!flags){
                ++num;
                if(num==3){
                    System.out.println("输入次数过多，已冻结！！！");
                    break;
                }else {
                    System.out.println("银行卡号或密码错误,请重新输入..................");
                }
            }
        }
    }
}
