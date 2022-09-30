import ra.dev.Product;

import java.util.Scanner;

public class ProductManage {
    static Product[] listProduct = new Product[1000];
    static int index = 0;

    public static void main(String[] args) {
        do {
            System.out.println("********************MENU**********************");
            System.out.println("1. Nhập thông tin cho n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Tính giá bán cho tất cả sản phẩm");
            System.out.println("3. Hiển thị thông tin các sản phẩm");
            System.out.println("4. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Thống kê số lượng và in thông tin các sản phẩm sắp hết hàng (quantity<=5)");
            System.out.println("7. Cập nhật trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("8. Thoát");
            System.out.println("Your choice is: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ProductManage.inputProduct(scanner);
                    break;
                case 2:
                    ProductManage.calExportPrice();
                    break;
                case 3:
                    ProductManage.displayProduct();
                    break;
                case 4:
                    ProductManage.sortProductByExportPriceACS();
                    break;
                case 5:
                    ProductManage.searchProduct(scanner);
                    break;
                case 6:
                    ProductManage.productOutOfStock();
                    break;
                case 7:
                    ProductManage.updateStatusProduct(scanner);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.err.println("Please choose 1 - 8");
            }
        } while (true);
    }

    public static void inputProduct(Scanner scanner) {
        System.out.println("Enter the number of product you want to input: ");
        int number = scanner.nextInt();
        for (int i = index; i < number; i++) {
            System.out.printf("Input information of the product %d : \n",index+1);
            listProduct[index] = new Product();
            listProduct[index].inputData();
            index++;
        }
    }

    public static void calExportPrice() {
        for (int i = 0; i < index; i++) {
            listProduct[i].calExportPrice();
        }
        System.out.println("All the export price have been calculated");
    }

    public static void displayProduct(){
        System.out.println("******************************Product Information*********************************");
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s\n","Product Id","Product Name","Title","Import Price","Export Price","Quantity","Descriptions","Status");
        for (int i = 0; i < index; i++) {
            listProduct[i].displayData();
        }
    }

    public static void sortProductByExportPriceACS(){
        System.out.println("******************************Product Information*********************************");
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s\n","Product Id","Product Name","Title","Import Price","Export Price","Quantity","Descriptions","Status");
        for (int i = 0; i < index-1; i++) {
            for (int j = i+1; j < index; j++) {
                if (listProduct[i].getExportPrice()>listProduct[j].getExportPrice()){
                    Product temp = listProduct[i];
                    listProduct[i] =listProduct[j];
                    listProduct[j] = temp;
                }
            }
        }
        for (int i = 0; i < index; i++) {
            listProduct[i].displayData();
        }
    }

    public static void searchProduct(Scanner scanner){
        System.out.println("Input product's name: ");
        scanner.nextLine();
        String search = scanner.nextLine();
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s\n","Product Id","Product Name","Title","Import Price","Export Price","Quantity","Descriptions","Status");
        for (int i = 0; i < index; i++) {
            if (listProduct[i].getProductName().startsWith(search)) {
                listProduct[i].displayData();
            }
        }
    }

    public static void productOutOfStock () {
        System.out.println("Product is out of stock");
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s\n","Product Id","Product Name","Title","Import Price","Export Price","Quantity","Descriptions","Status");
        for (int i = 0; i < index; i++) {
            if (listProduct[i].getQuantity()<=5) {
                listProduct[i].displayData();
            }
        }
    }

    public static void updateStatusProduct(Scanner scanner){
        System.out.println("Enter product's id to change product's status");
        scanner.nextLine();
        String update = scanner.nextLine();
        for (int i = 0; i < index; i++) {
            if (listProduct[i].getProductId().equals(update)){
                listProduct[i].setProductStatus(!listProduct[i].isProductStatus());
            }
        }
    }
}