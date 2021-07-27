public class traiCay {
    private int fruitId; // mã trái cây
    private String fruitName; // Tên trái cây
    private int fruitPrice; // Giá trái cây
    private int fruitNum; // Số lượng trái cây
    private String source; // Nguồn gốc trái cây

    public traiCay() {
    }
    public traiCay(int fruitId, String fruitName, int fruitPrice, int fruitNum, String source) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.fruitNum = fruitNum;
        this.source = source;
    }
    // Setter
    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
    public void setFruitPrice(int fruitPrice) {
        this.fruitPrice = fruitPrice;
    }
    public void setFruitNum(int fruitNum) {
        this.fruitNum = fruitNum;
    }
    public void setSource(String source) {
        this.source = source;
    }

    // Getter
    public int getFruitId() {
        return fruitId;
    }
    public String getFruitName() {
        return fruitName;
    }
    public int getFruitPrice() {
        return fruitPrice;
    }
    public int getFruitNum() {
        return fruitNum;
    }
    public String getSource() {
        return source;
    }
}
