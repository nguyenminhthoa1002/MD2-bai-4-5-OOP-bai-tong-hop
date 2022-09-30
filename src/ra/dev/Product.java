package ra.dev;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private String title;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private String descriptions;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productId, String productName, String title, float importPrice, float exportPrice, int quantity, String descriptions, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Product Id: ");
        this.productId = scanner.nextLine();
        System.out.println("Enter Product Name: ");
        this.productName = scanner.nextLine();
        System.out.println("Enter Product Title: ");
        this.title = scanner.nextLine();
        System.out.println("Enter the import price of Product: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter the quantity of Product: ");
        this.quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the descriptions of Product: ");
        this.descriptions = scanner.nextLine();
        System.out.println("Enter the status of Product: ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
//        System.out.println("******************************Product Information*********************************");
//        System.out.println("Product Id: " + this.productId);
//        System.out.println("Product Name: " + this.productName);
//        System.out.println("Product Title: " + this.title);
//        System.out.println("Import Price: " + this.importPrice);
//        System.out.println("Export Price: " + this.exportPrice);
//        System.out.println("Quantity: "+this.quantity);
//        System.out.println("Product Descriptions: " + this.descriptions);
//        System.out.println("Product Status: " + this.productStatus);
//        System.out.printf("%-15s%-20s%-20s%-15s%-15s%-15s%-20s%-15s\n","Product Id","Product Name","Title","Import Price","Export Price","Quantity","Descriptions","Status");
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s%-15s\n",this.productId,this.productName,this.title,this.importPrice,this.exportPrice,this.quantity,this.descriptions,this.productStatus);
    }

    public void calExportPrice(){
        this.exportPrice = (float) (this.importPrice*1.2);
    }
}
