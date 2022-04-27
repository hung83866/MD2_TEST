import java.util.Scanner;

public class Main {
    public Main() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chon chức năng theo số (Để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ File");
        System.out.println("7. Ghi vào FIle");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng : ");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        scanner.nextLine();
        switch (key){
            case 1:
                new DanhBaServiceIMPL().findAll();
                break;
            case 2:
                new DanhBaServiceIMPL().themDanhBa();
                break;
            case 3:
                new DanhBaServiceIMPL().capNhat();
                break;
            case 4:
                new DanhBaServiceIMPL().xoaDanhBa();
                break;
            case 5:
                new DanhBaServiceIMPL().timKiem();
                break;
            case 6:
                new DanhBaServiceIMPL().docFileCSV();
                break;
            case 7:
                new DanhBaServiceIMPL().ghiFileCSV();
                break;
            default:
                break;
        }

    }

    public static void main(String[] args) {
        new Main();
    }
}

