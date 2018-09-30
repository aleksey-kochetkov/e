package e;

public class Certificate {
    private int id;
    private String descript;

    public Certificate() {
    }

    public Certificate(String descript) {
        this.descript = descript;
    }

    public Certificate(int id, String descript) {
        this.id = id;
        this.descript = descript;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
