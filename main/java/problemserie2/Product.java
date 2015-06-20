package problemserie2;

/**
 *  Cada produto é caracterizado por um identificador (chave numérica atribuída ao produto quando este é inserido na fila
 * prioritária), categoria do produto (título, ação, etc.), nome da agência de investimento, valor de compra e valor atual..
 */
public class Product {

    private static int ID_Default = 0;

    private int id;

    private String category;

    private String agency;

    private float buyValue;

    private float actualValue;

    public Product(String category, String agency, float buyValue, float actualValue){
        this.id = ID_Default++;
        this.category = category;
        this.agency = agency;
        this.buyValue = buyValue;
        this.actualValue = actualValue;
    }


    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getAgency() {
        return agency;
    }

    public float getBuyValue() {
        return buyValue;
    }

    public float getActualValue() {
        return actualValue;
    }

    /**
     * Loss Value must be minor than 0
     * @return Loss Value (buyValue - actualValue)
     */
    public float getLossValue(){
        return buyValue - actualValue;
    }

    @Override
    public String toString() {
        return "Product number: "+id+", category: "+category+", from agency "+agency+" Loss Value: "+getLossValue();
    }
}
