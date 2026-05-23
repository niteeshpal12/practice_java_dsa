import java.util.Scanner;
public class UserInterface 
{
	public static void main(String args[]) 
	{
		Scanner sc =new Scanner(System.in);
		//Fill the code
		System.out.println("Enter the Name");
String name = sc.nextLine();

System.out.println("Enter the Order Number");
int orderNumber = sc.nextInt();
sc.nextLine(); // consume newline

System.out.println("Enter the Delivery Type");
String deliveryType = sc.nextLine();

// Validate delivery type
if (!(deliveryType.equals("HomeDelivery") ||
      deliveryType.equals("Parcel") ||
      deliveryType.equals("NormalOrder"))) {
    System.out.println("Invalid Order Type");
    sc.close();
    return;
}

System.out.println("Enter the Food Name");
String foodName = sc.nextLine();

System.out.println("Enter the Phone Number");
long phoneNumber = sc.nextLong();

System.out.println("Enter the price of the item");
double cost = sc.nextDouble();

// Create Restaurant object
Restaurent restaurant = new Restaurent(
        name, orderNumber, deliveryType, foodName, phoneNumber
);

// Calculate bill
double billAmount = restaurant.calculateTotalBill(cost);

// Print output
System.out.println("Name " + restaurant.getCustomerName());
System.out.println("Order Number " + restaurant.getOrderNumber());
System.out.println("Delivery Type " + restaurant.getDeliveryType());
System.out.println("Food Name " + restaurant.getFoodName());
System.out.println("Phone Number " + restaurant.getPhoneNumber());
System.out.println("Bill Amount " + billAmount);

sc.close();

	}
}
