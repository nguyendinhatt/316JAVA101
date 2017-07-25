package quanlidiem;

import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextMenu implements Menu{ 
    private Vector<String> mChon = new Vector<String>(10,5);
    public TextMenu(){}
    public TextMenu(Vector<String> mChon){
        this.mChon = mChon;
    }
    public TextMenu(String [] mc){
        for (String s : mc) mChon.add(s);
    }
//------- In menu-------------------------
    public void display(){
        System.out.println("======["+mChon.elementAt(0)+"]=====");
        for (int i = 1; i < mChon.size(); i++)
        System.out.println(i+"."+mChon.elementAt(i));            
        System.out.println("=========================");
    }
//------- nhận mChon------------------------
    public int getSelected(){
        display();
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời chọn: ");
        return sc.nextInt();
    }
//------- thực thi mChon-------------------
    @Override
    public void execute(int n){}
//------- run -----------------------------
    public void run(){
        while(true){
        execute(getSelected());
        }
    }
}