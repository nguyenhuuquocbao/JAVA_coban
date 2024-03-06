package baith5;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class QLsvien {

    public static void main(String[] args) throws IOException {
        Svien sv1 = new Svien("Ten Ban", "ngay/thang/nam", 9.0);
        Svien sv2 = new Svien("Ten Ban Than", "ngay/thang/nam", 7.5);
        Svien sv3 = new Svien();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin cho sinh vien 3:");
        System.out.print("Ho ten: ");
        sv3.setHoTen(scanner.nextLine());
        System.out.print("Ngay sinh (dd/MM/yyyy): ");
        sv3.setNgaySinh(scanner.nextLine());
        System.out.print("Điem trung binh: ");
        sv3.setDiemTrungBinh(scanner.nextDouble());

        // In thông tin
        Svien.ghi_file();
        sv1.hienthi();
        sv2.hienthi();
        sv3.hienthi();
    }
}
