package problemserie2;

/**
 *  Cada produto � caracterizado por um identificador (chave num�rica atribu�da ao produto quando este � inserido na fila
 * priorit�ria), categoria do produto (t�tulo, a��o, etc.), nome da ag�ncia de investimento, valor de compra e valor atual..
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
