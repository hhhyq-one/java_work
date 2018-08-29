package project.银行;

import java.io.*;
import java.util.ArrayList;

public class writes {
    public static void Writes(Customer customer,Customer customer1)throws Exception{
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
        String[] iofo=new String[6];
        String[][] iofos=new String[count][];
        for (i = 0; i < a.length; i++) {
            for (int j=0;j<6;j++) {
                iofo=a[i].split(" ");
            }
            iofos[i]=iofo;
        }
        StringBuffer str=new StringBuffer();
        StringBuffer strr=new StringBuffer();
        for (int j = 0; j < iofos.length; j++) {
            if(customer!=null&&iofos[j][3].equals(customer.getCardnum())){
                for (String aa:iofos[j]) {
                    str.append(aa+" ");
                }
                str=str.deleteCharAt(str.lastIndexOf(" "));
            }
        }
        for (int j = 0; j < iofos.length; j++) {
            if(customer1!=null&&iofos[j][3].equals(customer1.getCardnum())){
                for (String aa:iofos[j]) {
                    strr.append(aa+" ");
                }
                strr=strr.deleteCharAt(strr.lastIndexOf(" "));
            }
        }
        String str1=new String(str);
        String strr1=new String(strr);
        Reader r2=new InputStreamReader(new FileInputStream("src/Data/bank.txt"));
        BufferedReader br2=new BufferedReader(r2);
        ArrayList<String> array=new ArrayList<>();
        while (br2.ready()){
            String b=br2.readLine();
            array.add(b);
        }
        boolean flag=false;
            for (int j = 0; j < array.size(); j++) {
                if(customer!=null&&str1.equals(array.get(j))){
                    array.remove(j);
                }
            }
        for (int j = 0; j < array.size(); j++) {
            if(customer1!=null&&strr1.equals(array.get(j))){
                array.remove(j);
                flag=true;
            }
        }
            String yuan= customer.getName() + " " + customer.getAge() + " " + customer.getGender() + " " + customer.getCardnum() + " " + customer.getPassword() + " " + customer.getMoney();
            array.add(yuan);
            if(flag){
                String yuan1= customer1.getName() + " " + customer1.getAge() + " " + customer1.getGender() + " " + customer1.getCardnum() + " " + customer1.getPassword() + " " + customer1.getMoney();
                array.add(yuan1);
            }


        Writer w=new OutputStreamWriter(new FileOutputStream("src/Data/bank.txt"));
        BufferedWriter bw=new BufferedWriter(w);
        String[] xie = array.toArray(new String[array.size()]) ;
        for (String aa:xie) {
            bw.write(aa);
            bw.newLine();
        }
        bw.flush();
    }
}
