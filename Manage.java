import java.util.*;

public class Manage {
    private static Scanner input = new Scanner(System.in);
    private static int count = 1;
    private static int j = 0;
    public static void main(String[] args) {
        ArrayList<traiCay> listFruit = new ArrayList<traiCay>(); // luu tru cac trai cay
        ArrayList<traiCay> matHang = new ArrayList<traiCay>(); // luu tru cac mat hang ma khach mua
        Hashtable<String, String> donDatHang = new Hashtable<String, String>();
        Hashtable<String, Integer> tongGia = new Hashtable<String, Integer>();
        listFruit.add(new traiCay(1, "Dừa", 2, 10, "Việt Nam"));
        listFruit.add(new traiCay(2, "Cam", 3, 10, "Mỹ"));
        listFruit.add(new traiCay(3, "Táo", 4, 10, "Thái Lan"));
        listFruit.add(new traiCay(4, "Nho", 6, 10, "Pháp"));
        do {
            // Hiển thị các chức năng của chương trình và yêu cầu người dùng nhập lựa chọn
            System.out.println("HỆ THỐNG CỬA HÀNG TRÁI CÂY");
            System.out.println("    1. Tạo trái cây");
            System.out.println("    2. Xem đơn đặt hàng");
            System.out.println("    3. Mua sắm (cho người mua) ");
            System.out.println("    4. Thoát");
            System.out.println();
            System.out.println("Vui lòng chọn 1 để tạo sản phẩm, 2 để xem đơn hàng, 3 để mua sắm, 4 để Thoát chương trình.");
            System.out.print("Nhập lựa chọn: ");
            int answer = input.nextInt();

            if(answer < 1 || answer > 4) { // Điều kiện nếu lựa chọn người dùng nhập nhỏ hơn 1 hoặc lớn hơn 4 thì hiển thị thông báo lỗi.
                throw new InputMismatchException("Lựa chọn bạn nhập không hợp lệ");
            } else if (answer == 1) { // Điều kiện nếu lựa chọn là 1
                getFruitInformation(listFruit);
                System.out.println();
            } else if (answer == 2) {
                viewOrder(donDatHang, tongGia);
            } else if (answer == 3) {
                Shopping(listFruit, matHang, donDatHang, tongGia);
                System.out.println();
            }
        } while(true);
    }

    /********************************************************************
     * Hàm được sử dụng để tạo Trái cây. Sau khi tạo xong mỗi quả, hàm sẽ
     * hiện ra thông báo người dùng có muốn tiếp tục tạo trái cây không.
     * Nếu chọn "Y" thì sẽ tiếp tục, nếu "N" thì sẽ hiển thị tất cả Trái
     * cây được tạo ra và quay về màn hình chính.
     * @param listFruit được sử dụng để lưu trữ các loại trái cây.
     ********************************************************************/
    public static void getFruitInformation(ArrayList<traiCay> listFruit) {
        int i = 1;
        do {
            traiCay fruit = new traiCay();
            System.out.println("Vui lòng nhập thông tin của loại trái cây thứ " + i);
            System.out.print("Nhập mã trái cây: ");
            fruit.setFruitId(input.nextInt());
            input.nextLine();
            System.out.print("Nhập tên trái cây: ");
            fruit.setFruitName(input.nextLine());
            System.out.print("Nhập giá: ");
            fruit.setFruitPrice(input.nextInt());
            System.out.print("Nhập số lượng: ");
            fruit.setFruitNum(input.nextInt());
            input.nextLine();
            System.out.print("Nhập nguồn gốc: ");
            fruit.setSource(input.nextLine());
            System.out.print("Bạn có muốn tiếp tục (Y/N) không? ");
            String choose = input.next();
            listFruit.add(fruit);
            if(choose.equalsIgnoreCase("Y")) {
                i += 1;
                continue;
            } else if(choose.equalsIgnoreCase("N")) {
                break;
            }
        }while(true);
        System.out.println("=======DANH SACH TRAI CAY=======");
        for(traiCay traicay : listFruit) {
            System.out.println(traicay.getFruitId() + ". " + traicay.getFruitName());
        }
    }

    public static void viewOrder(Hashtable<String, String> donDatHang, Hashtable<String, Integer> tongGia) {
        for(Map.Entry<String, String> e : donDatHang.entrySet()) {
            System.out.println("Khách hàng: " + e.getKey());
            System.out.println();
            System.out.println("   Sản phẩm | Số lượng | Giá | Số tiền");
            System.out.print("   " + e.getValue());
            int price = tongGia.get(e.getKey());
            System.out.println("Tổng cộng: " + price + "$");
            System.out.println();
        }
        System.out.println();
    }

    public static void Shopping(ArrayList<traiCay> listFruit, ArrayList<traiCay> matHang, Hashtable<String, String> donDatHang, Hashtable<String, Integer> tongGia) {
        do {
             traiCay fruit = new traiCay();
             System.out.println("| ++Mục++ | ++Tên trái cây ++ | ++Xuất xứ++ | ++Giá++ |");
             for (traiCay traicay : listFruit) {
                 String row = String.format("%6d %8s %24s %10s", traicay.getFruitId(), traicay.getFruitName(), traicay.getSource(), traicay.getFruitPrice() + "$");
                 System.out.println(row);
             }
             System.out.print("Xin vui lòng chọn mặt hàng theo mục trong bảng: ");
             int choose = input.nextInt();
             for (traiCay traicay : listFruit) {
                 if (choose == traicay.getFruitId()) {
                     fruit.setFruitName(traicay.getFruitName());
                     fruit.setFruitPrice(traicay.getFruitPrice());
                     System.out.println("Bạn đã chọn: " + traicay.getFruitName());
                 }
             }
             System.out.print("Vui lòng nhập số lượng: ");
             fruit.setFruitNum(input.nextInt());
             for (traiCay traicay : listFruit) {
                 if (fruit.getFruitNum() > traicay.getFruitNum() && choose == traicay.getFruitId()) {
                     System.out.println("Xin lỗi số lượng trái cây tại cửa hàng không đủ với số lượng bạn yêu cầu.\nSố lượng " + traicay.getFruitName() + " tại cửa hàng hiện tại là: " + traicay.getFruitNum());
                     System.out.print("Vui lòng nhập lại số lượng: ");
                     fruit.setFruitNum(input.nextInt());
                 } else if (fruit.getFruitNum() < traicay.getFruitNum() && choose == traicay.getFruitId()) {
                     traicay.setFruitNum(traicay.getFruitNum() - fruit.getFruitNum());
                 }
             }
             matHang.add(fruit);
             System.out.print("Bạn có muốn đặt hàng ngay bây giờ (Y/N): ");
             String result = input.next();
             if(result.equalsIgnoreCase("Y")) {
                 System.out.println("Sản phẩm | Số lượng | Giá | Số tiền");
                 int sum = 0;
                 String str = "";
                 int i = 1;
                 for (int k = j; k < matHang.size(); k++) {
                     traiCay traicay = matHang.get(k);
                     int total = traicay.getFruitNum() * traicay.getFruitPrice();
                     String row = String.format("%3s %10s %9s %6s", traicay.getFruitName(), traicay.getFruitNum() + "", traicay.getFruitPrice() + "$", total + "$\n");
                     str +=  i + ". " + String.format("%3s %7s %9s %9s", traicay.getFruitName(), traicay.getFruitNum() + "", traicay.getFruitPrice() + "$", total + "$\n") + "   ";
                     System.out.print(row);
                     sum += total;
                     i++;
                 }
                 System.out.println("Tổng cộng:: " + sum + "$");
                 input.nextLine();
                 System.out.print("Nhập tên của bạn: ");
                 String name = input.nextLine();
                 donDatHang.put(name, str);
                 tongGia.put(name, sum);
                 break;
             } else if(result.equalsIgnoreCase("N")) {
                 count += 1;
                 continue;
             }
         } while(true);
        j += count;
    }
}
