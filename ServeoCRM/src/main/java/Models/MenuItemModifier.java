package Models;

public class MenuItemModifier {
    
    private int idMenuItem, idModifier;
    private String menuItem, modifier, modDate,createDate;

    public int getIdMenuItem() {
        return idMenuItem;
    }

    public void setIdMenuItem(int idMenuItem) {
        this.idMenuItem = idMenuItem;
    }

    public int getIdModifier() {
        return idModifier;
    }

    public void setIdModifier(int idModifier) {
        this.idModifier = idModifier;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
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


}
