package edu.jhu.slin.multipleselect;

/**
 * The item class.
 */
public class Item {
    private Integer id;
    private String name;
    private boolean checked;

    public Item(int id, String name, boolean initChecked) {
        this.checked = initChecked;
        this.id = id;
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return id + " | " + name + " | " + checked;
    }
}
