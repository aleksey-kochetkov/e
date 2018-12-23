package e.model;

public class Warehouse {
    private String code;
    private String descript;

    public Warehouse(String code, String descript) {
        this.code = code;
        this.descript = descript;
    }

    @Override
    public String toString() {
        return String.format("Warehouse{code:%s,descript:%s}",
                                               this.code, this.descript);
    }
}
