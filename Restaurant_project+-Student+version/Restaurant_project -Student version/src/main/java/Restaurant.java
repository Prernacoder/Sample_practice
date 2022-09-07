import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();
    private List<Item>order = new ArrayList<Item>();
    private int orderValue =0;

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        if((getCurrentTime().isAfter(openingTime))&&(getCurrentTime().isBefore(closingTime)))
            return true;
        else
            return false;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
       // return Collections.unmodifiableList(menu);
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    //Adding Order and Calculating Value
    public void selectMenuItem(String name,int price){
        Item newOrderItem = new Item(name,price);
        order.add(newOrderItem);
    }

   public int returnOrderValue(){
     for(Item item : order)
         orderValue += item.getPrice();
     return(orderValue);
 }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {
        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
//    public void displayDetails(){
//        System.out.println("Restaurant:"+ name + "\n"
//                +"Location:"+ location + "\n"
//                +"Opening time:"+ openingTime +"\n"
//                +"Closing time:"+ closingTime +"\n"
//                +"Menu:"+"\n"+getMenu());
//
//    }

    public String getName() {
        return name;
    }

}
