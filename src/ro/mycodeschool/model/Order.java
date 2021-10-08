package ro.mycodeschool.model;

public class Order {

    int id;
    int customerId;
    double amount;
    String shippingAddress;
    String date;

    public Order(int id,int customerId, double amount, String shippingAddress, String date){
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.shippingAddress = shippingAddress;
        this.date = date;

    }

    public Order(String text){

        this(Integer.parseInt(text.split(",")[0]),Integer.parseInt(text.split(",")[1]),Double.parseDouble(text.split(",")[2]),
                text.split(",")[3], text.split(",")[4]);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return this.id+","+this.customerId+","+this.amount+","+this.shippingAddress+","+this.date;
    }

    @Override
    public boolean equals(Object o){

        Order order = (Order) o;

        if (order.getCustomerId() == customerId){
            return true;
        }

        return false;
    }








}
