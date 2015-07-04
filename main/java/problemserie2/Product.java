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

    private int buyValue;

    private int actualValue;

    public Product(String category, String agency, int buyValue, int actualValue){
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

    public int getBuyValue() {
        return buyValue;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    /**
     * Loss Value must be minor than 0
     * @return Loss Value (buyValue - actualValue)
     */
    public int getLossValue(){
        return buyValue - actualValue;
    }

    @Override
    public String toString() {
        return "Product number: "+id+", category: "+category+", from agency "+agency+" Loss Value: "+getLossValue();
    }
}
