package Models;


public class Modifier {

    private int idModifier;
    private String name,modDate, createDate;
    private double extraPrice;

    public int getIdModifier() {
        return idModifier;
    }

    public void setIdModifier(int idModifier) {
        this.idModifier = idModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }


}
