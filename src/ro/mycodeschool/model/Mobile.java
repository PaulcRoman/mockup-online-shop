package ro.mycodeschool.model;

public class Mobile extends Product {


    private String operator;

    public Mobile(int id, String marca, String model, int stoc, double pret, String operator){
        super(id, "mobile",marca, model,stoc, pret);
        this.operator = operator;
    }

    public Mobile(String text){
        super(Integer.parseInt(text.split(",")[0]),text.split(",")[1],text.split(",")[2],text.split(",")[3], Integer.parseInt(text.split(",")[4]),Double.parseDouble(text.split(",")[5]));
        this.operator = text.split(",")[6];
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString(){
        return super.toString()+","+this.operator;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Mobile) {
            Mobile m = (Mobile) o;

            return super.equals(m) && this.getOperator().equals(m.getOperator());
        }
        return false;
    }
}
