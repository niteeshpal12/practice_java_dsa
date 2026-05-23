public class Restaurent {

    //include attributes getters and setters
    private String customerName;
    private int orderNumber;
    private String deliveryType;
    private String foodName;
    private long phoneNumber;

    public Restaurent(String customerName,int orderNumber,String deliveryType,String foodName,
        long phoneNumber
    ){
        this.customerName=customerName;
        this.orderNumber=orderNumber;
        this.deliveryType=deliveryType;
        this.foodName=foodName;
        this.phoneNumber=phoneNumber;
    }
    public String getCustomerName(){
        return customerName;
    }
    public int getOrderNumber(){
        return orderNumber;
    }   
    public String getDeliveryType(){
        return deliveryType;
    }
    public String getFoodName(){
        return foodName;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }


    public double calculateTotalBill(double cost){
        double tax=0.0;
        if(deliveryType.equals("HomeDelivery")){
            tax=0.8;
        }
        else if(deliveryType.equals("Parcel")){
            tax=0.5;
        }
        else if(deliveryType.equals("NormalOrder")){
            tax=0.3;
        }
        return cost+(cost*tax);
    }
    
}
