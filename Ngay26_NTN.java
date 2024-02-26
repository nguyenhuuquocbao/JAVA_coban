import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class Ngay26_NTB {

	static String taoten(){
		String ho[]={"Le", "Tran","Nguyen","Ngo","Ton"};		
		String dem[]={"Nu", "Huu", "Van", "Thi","Quoc"};		
		String ten[]={"Cam", "Quyt", "Mo","Man","Cam"};		
		Random rd = new Random();
		int indexHo = rd.nextInt(0,4);
		int indexDem = rd.nextInt(0,4);
		int indexTen = rd.nextInt(0,4);
		return ho[indexHo]+" "+dem[indexDem]+" "+ten[indexTen];
	}
	static String taonganh(){
		String nganh[] = {"Kinh te", "CNTT", "Dien tu", "Bao chi truyen thong", "Co khi"};
		Random rd = new Random();
		int indexNganh = rd.nextInt(0,4);
		return " | "+nganh[indexNganh]+ " | ";
	}
	static String DTB(){
		String dtb[] = {"0","1","2","3","4","5","6","7","8","9","10"};
		Random rd = new Random();
		int indexDTB = rd.nextInt(0,11);
		return dtb[indexDTB];
	}
	static void ghi_file() throws IOException {
		String url = "C:\\Users\\lab\\OneDrive\\Desktop\\NHQB\\DanhSachSV.txt";
		FileOutputStream fos = new FileOutputStream(url);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		for (int i=0; i<=10; i++){
			String ten = taoten();
			String nganhhoc = taonganh();
			String dtb = DTB();
			bw.write(ten);
			bw.write(nganhhoc);
			bw.write(dtb);
			bw.newLine();
		}
		bw.close();
		osw.close();
		fos.close();
	}
	static void timmax_min(){
		String url = "C:\\Users\\lab\\OneDrive\\Desktop\\NHQB\\DanhSachSV.txt";
		FileInputStream fis = new FileInputStream(url);
		Scanner sc = Scanner(fis);

	}
	public static void main(String[] args) throws IOException {
		taoten();
		ghi_file();
	}

}
