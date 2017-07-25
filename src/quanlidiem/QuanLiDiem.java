package quanlidiem;
public class QuanLiDiem extends TextMenu {
    public QuanLiDiem(){}
    public static void main(String[] args) {
        SinhVien st = new SinhVien(new String[]{"Quản Lí Điểm","Nhập thông tin","In bảng điểm","Tính ĐTBC","Thoát"});
        st.run();
    }    
}
