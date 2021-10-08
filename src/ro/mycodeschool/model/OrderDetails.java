package ro.mycodeschool.model;

public  class OrderDetails  {

    int id;
    int orderId;
    int productId;
    double price;
    int quantity;

    public OrderDetails(int id, int orderId, int productId, double price, int quantity){
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetails(String text){
        this(Integer.parseInt(text.split(",")[0]),Integer.parseInt(text.split(",")[1]),Integer.parseInt(text.split(",")[2]),
                Double.parseDouble(text.split(",")[3]),Integer.parseInt(text.split(",")[4]));

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

@Override
    public String toString(){

        return this.id+","+this.orderId+","+this.productId+","+this.price+","+this.quantity;
}



@Override
    public boolean equals(Object o){

        OrderDetails od = (OrderDetails) o;

        if (od.getOrderId() == orderId){
            return true;
        }

        return false;

}


}