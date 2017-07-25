package quanlidiem;

import java.util.Scanner;

public class DiemHP extends HocPhan implements Comparable<DiemHP> {
    private double diemCC, diemGK, diemCK;
    public DiemHP(){
        super();
    }
//-------- Hàm dựng 3 đối số -----------------
    public DiemHP(double diemCC, double diemGK, double diemCK) {
        this.diemCC = diemCC;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
    }
//------- Hàm dựng 1 đối số ------------------
    public DiemHP(HocPhan h) throws Exception{
        super(h.getMaHP(),h.getTenHP(),h.getSoTC());
        h.nhapDL();
        System.out.println(h);
    }
//-------- getset -----------------------------
    public void setDiemCC(double diemCC) {this.diemCC = diemCC;}
    public void setDiemGK(double diemGK) {this.diemGK = diemGK;}
    public void setDiemCK(double diemCK) {this.diemCK = diemCK;}
    public double getDiemCC() {return diemCC;}
    public double getDiemGK() {return diemGK;}
    public double getDiemCK() {return diemCK;}
//-------- Hàm nhập ---------------------------
    @Override
    public void nhapDL() throws Exception{
        Scanner sc = new Scanner(System.in);
        super.nhapDL();
        try {
            do {
                System.out.print("Điểm CC: ");setDiemCC(sc.nextDouble());    
            } while (getDiemCC()<0||getDiemCC()>10);
            do {                
                System.out.print("Điểm GK: ");setDiemGK(sc.nextDouble());            
            } while (getDiemGK()<0||getDiemGK()>10);
            do {                
                System.out.print("Điểm CK: "); setDiemCK(sc.nextDouble());
            } while (getDiemCK()<0||getDiemCK()>10);
            
        } catch (Exception e) {
            System.err.println("Lỗi: "+e);
        }        
    }
//--------- hàm input 3 điểm output điểm trung bình tổng kết----------
    public double diemTBTK(double cc, double gk, double ck){        
        return cc*0.2+gk*0.3+ck*0.5;
    }
//--------- hàm input điểmm thang 10 output điểm chữ -----------------
    public char convert10ToRate(double d10){
        return (d10<4)?'F':((d10<5.5)?'D':((d10<7.0)?'C':((d10<8.5)?'B':'A')));
    }
//--------- hàm input điểm chử out điểm thang 4 ----------------------
    public int convertRateto4(char rate){
        return (rate=='F')?0:((rate=='D')?1:((rate=='C')?2:((rate=='B')?3:((rate=='A')?4:-1))));
    }
//--------------------------------------------------------------------
    @Override
    public String toString(){
        return getMaHP()+": "+getDiemCC()+" "+getDiemGK()+" "+getDiemCK()+"::"+diemTBTK(diemCC, diemGK, diemCK)+"->"+convert10ToRate(diemTBTK(diemCC, diemGK, diemCK));
    }
//--------- sắp xếp đối tượng hp theo maHP-----------------------------------------
    public int compareTo(DiemHP hp) {
         return getMaHP().compareTo(hp.getMaHP());    
    }    
}
