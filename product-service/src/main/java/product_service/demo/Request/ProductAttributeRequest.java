package product_service.demo.Request;

public class ProductAttributeRequest{
    private String name;

    private String value;


    public ProductAttributeRequest() {
    }

    public ProductAttributeRequest(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
