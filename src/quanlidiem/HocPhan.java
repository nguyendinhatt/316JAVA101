package quanlidiem;

import java.util.Scanner;

public class HocPhan {
    private String maHP,tenHP;
    private int soTC;
    
//-------Hàm dựng-----------------------------
    public HocPhan(){}
    public HocPhan(String maHP, String tenHP, int soTC) {
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.soTC = soTC;
    }
//-------getset-------------------------------
    public void setMaHP(String maHP) {this.maHP = maHP;}
    public void setTenHP(String tenHP) {this.tenHP = tenHP;}
    public void setSoTC(int soTC) {this.soTC = soTC;}
    public String getMaHP() {return maHP;}
    public String getTenHP() {return tenHP;}
    public int getSoTC() {return soTC;}
//-------hàm nhập------------------------------
    public void nhapDL() throws Exception{
       Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Mã học phần: ");setMaHP(sc.nextLine());
            System.out.print("Tên học phần: ");setTenHP(sc.nextLine());
            do {                
                System.out.print("Số Tín Chỉ: ");setSoTC(sc.nextInt());
            } while (getSoTC()<1||getSoTC()>5);           
        } catch (Exception e) {
            System.err.println("Lỗi: "+e);
        }      
    }
}
    