fun main() {
    val myList = ShoppingList()
                    .addOrder(Order(1)
                             .addItem(Noodles())
                             .addItem(Vegetables("Spinach", "Onions", "Nchuanwu")))
                    .addOrder(Order(2)
                            .addItem(Noodles())
                            .addItem(Vegetables("Naruto", "Onions")))
                    .addOrder(Order(3)
                            .addItem(Noodles())
                            .addItem(Vegetables()))
    
    println(myList)
}

class ShoppingList {
    val orders: MutableList<Order> = mutableListOf()
    
    public override fun toString(): String {
        return orders.joinToString("\n\n")
    }
    
    // Add an Order and return the ShoppingList object to allow chaining
    public fun addOrder(order: Order): ShoppingList {
        orders.add(order)
        return this
    }
}

class Order(val orderNumber: Int) {
    private val items: MutableList<Item> = mutableListOf()
    
    public override fun toString(): String {
        return "Order #$orderNumber\n" + items.joinToString("\n")
    }
    
    public fun addItem(item: Item): Order {
        items.add(item)
        return this
    }
}

open class Item(val itemName: String, val price: Double)

class Noodles: Item("Noodles", 5.0) {
    public override fun toString(): String {
        return "$itemName: $price"
    }
}
class Vegetables(vararg val toppings: String): Item("Vegetables", 10.0) {
    public override fun toString(): String {
        if(toppings.isEmpty()) {
            return "$itemName Chef's Choice: $price"
        }
        return "$itemName ${toppings.joinToString()}: $price"
    }
}
