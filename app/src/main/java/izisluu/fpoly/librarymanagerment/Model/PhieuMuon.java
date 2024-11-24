package izisluu.fpoly.librarymanagerment.Model;

public class PhieuMuon {
    private String maPhieuMuon;
    private String maThanhVien;
    private String maThuThu;
    private String ngayMuon;
    private String ngayTra;
    private int trangThai;
    private String thanhTien;
    private String maSach;

    public PhieuMuon(String maPhieuMuon, String maThanhVien, String maThuThu, String ngayMuon, String ngayTra, int trangThai, String thanhTien, String maSach, String ngayMuon1, String ngayTra1) {
        this.maPhieuMuon = maPhieuMuon;
        this.maThanhVien = maThanhVien;
        this.maThuThu = maThuThu;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
        this.thanhTien = thanhTien;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon1;
        this.ngayTra = ngayTra1;
    }

    public PhieuMuon() {

    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(String maThanhVien) {
        this.maThanhVien = maThanhVien;
    }

    public String getMaThuThu() {
        return maThuThu;
    }

    public void setMaThuThu(String maThuThu) {
        this.maThuThu = maThuThu;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
}
