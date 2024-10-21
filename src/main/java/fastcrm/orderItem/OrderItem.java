package fastcrm.orderItem;

public class OrderItem {
    private String id;
    private String order_id;
    private String product_id;
    private float value;

    public OrderItem() {}

    public OrderItem(String id, String order_id, String product_id, float value) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
