import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhBaServiceIMPL {
    private static final String FILE_HEADER = "sdt,nhom,hoTen,gioiTinh,DiaChi,NgaySinh,email";

    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String COMMA_DELIMITER = ",";
    private Scanner scanner = new Scanner(System.in);
    public static List<DanhBa> danhBaList = new ArrayList();

    public void findAll() {
       docFileCSV();
    }

    public void docFileCSV() {
        BufferedReader br = null;
        List<DanhBa> danhBaList = new ArrayList<DanhBa>();
        try {
            String line;
            br = new BufferedReader(new FileReader("D:\\module2\\TestMD2\\untitled1\\file cvs"));

            while ((line = br.readLine()) != null) {
                printDanhBa(parseCsvLine(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        new Main();
    }

    private static void printDanhBa(List<String> danhBa) {
        DanhBa danhBa1 = new DanhBa();
        danhBa1.setSoDienThoai(danhBa.get(0));
        danhBa1.setNhom(danhBa.get(1));
        danhBa1.setHoTen(danhBa.get(2));
        danhBa1.setGioiTinh(danhBa.get(3));
        danhBa1.setDiaChi(danhBa.get(4));
        danhBa1.setNgaySinh(danhBa.get(5));
        danhBa1.setEmail(danhBa.get(6));
        danhBaList.add(danhBa1);
        System.out.println(danhBa1);
    }

    private List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();

        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
    public List<DanhBa> showList(){
        List<DanhBa> list = new ArrayList<>();

        return list;
    }
    public void themDanhBa() {
        System.out.println("Nh???p s??? ??i???n tho???i:");
        String sdt = scanner.nextLine();
        System.out.println("Nh???p nh??m :");
        String nhom = scanner.nextLine();
        System.out.println("Nh???p H??? t??n :");
        String hoTen = scanner.nextLine();
        System.out.println("Nh???p Gi???i t??nh :");
        String gioiTinh = scanner.nextLine();
        System.out.println("Nh???p ?????a ch??? :");
        String diaChi = scanner.nextLine();
        System.out.println("Nh???p ng??y sinh :");
        String ngaySinh = scanner.nextLine();
        System.out.println("Nh???p email :");
        String email = scanner.nextLine();
        DanhBa danhBa = new DanhBa(sdt, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email);
        danhBaList.add(danhBa);
        System.out.println("Th??m th??nh c??ng!");
        new Main();
    }

    public void capNhat() {
        System.out.println("Nh???p s??? ??i???n tho???i:");
        String sdt = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < danhBaList.size(); i++) {
            if (danhBaList.get(i).getSoDienThoai().equals(sdt)) {
                check = false;
                System.out.println("Nh???p nh??m :");
                String nhom = scanner.nextLine();
                danhBaList.get(i).setNhom(nhom);
                System.out.println("Nh???p H??? t??n :");
                String hoTen = scanner.nextLine();
                danhBaList.get(i).setHoTen(hoTen);
                System.out.println("Nh???p Gi???i t??nh :");
                String gioiTinh = scanner.nextLine();
                danhBaList.get(i).setGioiTinh(gioiTinh);
                System.out.println("Nh???p ?????a ch??? :");
                String diaChi = scanner.nextLine();
                danhBaList.get(i).setDiaChi(diaChi);
                System.out.println("Nh???p ng??y sinh :");
                String ngaySinh = scanner.nextLine();
                danhBaList.get(i).setNgaySinh(ngaySinh);
                System.out.println("Nh???p email :");
                String email = scanner.nextLine();
                danhBaList.get(i).setEmail(email);
                System.out.println("THAY ?????I TH??NH C??NG!");
                new Main();
            }
        }
        if (check) {
            System.out.println("KH??NG T??M TH???Y DANH B??? V?? S??? ??I???N THO???I TR??N! H??Y TH??? L???I");
            new Main();
        }

    }

    public void xoaDanhBa() {
        System.out.println("Nh???p s??? ??i???n tho???i:");
        String sdt = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < danhBaList.size(); i++) {
            if (danhBaList.get(i).getSoDienThoai().equals(sdt)) {
                check = false;
                danhBaList.remove(danhBaList.get(i));
                System.out.println("X??A TH??NH C??NG !");
                new Main();
            }
        }
        if (check) {
            System.out.println("KH??NG T??M TH???Y DANH B??? V?? S??? ??I???N THO???I TR??N! H??Y TH??? L???I");
            new Main();
        }
    }

    public void timKiem() {
        System.out.println("Nh???p s??? ??i???n tho???i Ho???c T??n : ");
        String id = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < danhBaList.size(); i++) {
            if (danhBaList.get(i).getHoTen().equals(id) || danhBaList.get(i).getSoDienThoai().equals(id)) {
                check = true;
                System.out.println(danhBaList.get(i));
            }
        }
        if (check) {
            System.out.println("KH??NG T??M TH???Y DANH B??? V?? S??? ??I???N THO???I HO???C T??N TR??N! H??Y TH??? L???I");
            new Main();
        }
    }

    public void ghiFileCSV() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:\\module2\\TestMD2\\untitled1\\file cvs");
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (DanhBa danhBas : danhBaList) {
                fileWriter.append(danhBas.getSoDienThoai());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(danhBas.getNhom());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(danhBas.getHoTen());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(danhBas.getGioiTinh());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(danhBas.getDiaChi());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(danhBas.getNgaySinh());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(danhBas.getEmail());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Ghi file th??nh c??ng! !!!");
            new Main();
        } catch (Exception e) {
            System.err.println("L???i r???i!!!");
            e.printStackTrace();
            new Main();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("L???i!!!");
                e.printStackTrace();
                new Main();
            }
        }
    }
}

