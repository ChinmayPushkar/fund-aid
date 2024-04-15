
package AdminDashboard;

import javax.swing.Icon;

public class Model_Card {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getValues() {
        return values;
    }

    public void setValues(float values) {
        this.values = values;
    }


    public Model_Card(Icon icon, String category, float values) {
        this.icon = icon;
        this.category = category;
        this.values = values;
    }

    public Model_Card() {
    }

    private Icon icon;
    private String category;
    private float values;
}