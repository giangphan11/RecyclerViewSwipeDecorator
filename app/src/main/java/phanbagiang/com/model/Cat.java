package phanbagiang.com.model;

public class Cat {
    private int hinh;
    private String ten;
    private String gia;

    public Cat() {
    }

    public Cat(int hinh, String ten, String gia) {
        this.hinh = hinh;
        this.ten = ten;
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
