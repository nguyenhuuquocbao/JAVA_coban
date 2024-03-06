package baith5;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Svien {
    private String hten;
    private String ngaysinh;
    private double diemtb;
    
    public Svien(String hten, String ngaysing, double diemtb) {
        this.hten = hten;
        this.ngaysinh = ngaysing;
        this.diemtb = diemtb;
    }
    public Svien() {
        this.hten = "";
        this.ngaysinh = "";
        this.diemtb = 0.0;
    }

    public void hienthi(){
        System.out.println("["+this.hten+", "+this.ngaysinh+", "+this.diemtb+"]");
    }
    public String getHten() {
        return hten;
    }
    public void setHoTen(String hten) {
        this.hten = hten;
    }public void setNgaySinh(String ngaysinh) {      
        this.ngaysinh = ngaysinh;
    }public void setDiemTrungBinh(double diemtb) {
        this.diemtb = diemtb;
    }
    public String getNgaysing() {
        return ngaysinh;
    }
    
    public double getDiemtb() {
        return diemtb;
    }

    //FIXME: Tính tuổi
    public double tinhTuoi() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(this.ngaysinh, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        double age = period.getYears() + (double) period.getMonths() / 12;
        return age;
    }
    
    //TODO: Đổi điểm số sang điểm chữ
    public String diemChu() {
        if (this.diemtb >= 8.5) 
            return "A";
        else if (this.diemtb >= 7)
            return "B";
        else if (this.diemtb >= 5.5)
            return "C";
        else if (this.diemtb >= 4)
            return "D";
        else 
            return "F";
        
    }
    //TODO:tao ngay bang LocalDay 
    static String taongay(String start, String end) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDay = LocalDate.parse(start,dtf);
        LocalDate endDay = LocalDate.parse(end, dtf);
        long numDays = endDay.toEpochDay() - startDay.toEpochDay();
        Random rd = new Random();        
        LocalDate day = startDay.plusDays(rd.nextLong(numDays));
        return day.format(dtf).toString();
    }
    static String taoten() {
        String ho[] = {"Nguyen","Tran","Le","Ho","Vo"};
        String tendem[] = {"Huu","Quang","Thi","Nu","Trong"};
        String ten[] = {"Bao","Duc","Nghia","Hoa","Tung"};
        Random rd = new Random();
        int indexHo = rd.nextInt(0,5);
        int indexTendem = rd.nextInt(0,5);
        int indexTen = rd.nextInt(0,5);
        return ho[indexHo] +" "+ tendem[indexTendem] +" "+ ten[indexTen];
    }
    static String DTB() {
		String dtb[] = {"0","1","2","3","4","5","6","7","8","9","10"};
		Random rd = new Random();
		int indexDTB = rd.nextInt(0,11);
		return dtb[indexDTB];
	}
    static void ghi_file() throws IOException {
        String url = "C:\\Users\\ROG\\Desktop\\Study\\Dev\\Java\\BT_tren_truong\\DSSV.txt";
        FileOutputStream fos = new FileOutputStream(url);
        OutputStreamWriter  osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        for(int i=0; i<=10; i++){
            String ten = taoten();
            String ngaysinh = taongay("01/01/2003","31/12/2003");
            String dtb = DTB();
            bw.write(i);
            bw.write(ten);
            bw.write(ngaysinh);
            bw.write(dtb);
        }
        bw.close();
        osw.close();
        fos.close();
    }
}
