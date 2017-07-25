package quanlidiem;

import java.util.*;
public class SinhVien extends TextMenu{
    private String maSV, hoTen, dob, pw;
    public static int count = 1000, tongHP=1;
    private Vector<DiemHP> diem = new Vector<DiemHP>(10,5);
    
//-------Hàm dựng 0 đối số-------------------------
    public SinhVien(){
        super();
    }
//-------Hàm dựng 1 đối số-------------------------
    public SinhVien(String [] menu){
        super(menu);
    }
//-------Hàm dựng 3 đối số-------------------------
    public SinhVien(String ht, String ns, String mk){
        hoTen = ht;
        dob = ns;
        pw = mk;
    }
    
// Hàm dựng 4 đối số
//    public SinhVien(String mSV, String ht, String ns, String mk){
//        maSV = mSV="SV"+count++;
//        hoTen = ht;
//        dob = ns;
//        pw = mk;        
//    }
    
//--------getset---------------------------------
    public void setMaSV(String maSV) {this.maSV = maSV;}
    public void setHoTen(String hoTen) {this.hoTen = hoTen;}
    public void setDob(String dob) {this.dob = dob;}
    public void setPw(String pw) {this.pw = pw;}
    public String getMaSV() {return maSV;}
    public String getHoTen() {return hoTen;}
    public String getDob() {return dob;}
    public String getPw() {return pw;}
// --------Hàm nhập------------------------------  
    public void nhapDL() throws RuntimeException{
        Scanner sc = new Scanner(System.in);
        
        try {
            boolean check = true;
            
                do {                
                    System.out.print("Nhập họ tên: "); hoTen = sc.nextLine(); 
                } while (hoTen.length()<5);
                do {             
                     System.out.print("Nhập ngày sinh: "); dob = sc.nextLine();                 
                } while (dob.indexOf("/")!=2||dob.lastIndexOf("/")!=5||dob.length()!=10);           
                System.out.print("Nhập mật khẩu: ");pw=sc.nextLine();
                setMaSV("SV"+count++);
                do{
                    DiemHP dHP = new DiemHP();
                    dHP.nhapDL();diem.add(dHP);
                    System.out.print("Continue ?? (y/n): ");
                    String ok = sc.nextLine();
                    check = ok.equals("y");
                    if (check==true) tongHP++;
                }while(check);
        } catch (Exception e) {
            System.err.println("Lỗi: "+e);
        }       
    }    
    @Override
    public String toString(){
        return getMaSV()+" - "+getHoTen()+" - "+getDob();
    }
 //----- Hàm in bảng điểm------------------------------------------
    public void printScores(){
        if (getHoTen()!=null) {
            System.out.println(this);
            Collections.sort(diem);
            for (DiemHP a: diem) {
                System.out.println(a.getMaHP()+": "+a.getDiemCC()+" "+a.getDiemGK()+" "+a.getDiemCK()+"::"+a.diemTBTK(a.getDiemCC(),a.getDiemGK(),a.getDiemCK())+"->"+a.convert10ToRate(a.diemTBTK(a.getDiemCC(),a.getDiemGK(),a.getDiemCK())));
            }           
        }
        else System.err.println("Bạn chưa nhập thông tin!");
    }
 //----- Các hàm tính điểm Điểm trung bình tích luỹ ---------------  
    public int tongTC(){
        int ttc=0;
        for (DiemHP d:diem) {
            ttc+=d.getSoTC();
        }
        return ttc;
    }
    public int tongD4STC(){
        int sum =0;
        for (DiemHP d:diem) {
            sum+=(d.getSoTC()*d.convertRateto4(d.convert10ToRate(d.diemTBTK(d.getDiemCC(),d.getDiemGK(),d.getDiemCK()))));
        }        
        return sum;
    }
    public void tinhDTBC(){       
        double tbc=(double)tongD4STC()/(double)tongTC();
        if (Double.isNaN(tbc)) {
            System.err.println("Bạn chưa nhập học phần nào!");
        }else System.out.println("Điểm TBC:"+tbc);
    }

//------- Thực thi mChon------------------------------------
    @Override
    public void execute(int n){
        switch (n){
            case 1: nhapDL();break;
            case 2: printScores();break;
            case 3: tinhDTBC();break;                
            case 4: System.exit(0);            
        }      
    }
//    public static void main(String[] args) {
//        SinhVien st = new SinhVien();
//        st.nhapDL();
//        SinhVien st1 = new SinhVien();
//        st1.nhapDL();
//    }
    
}   
