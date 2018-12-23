package e.model;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component("three")
public class Transfer {
    private int num;
    private Warehouse fromWarehouse;
    private Warehouse toWarehouse;

    @Autowired
    public Transfer(Warehouse fromWarehouse, Warehouse toWarehouse) {
        this(3, fromWarehouse, toWarehouse);
    }

    public Transfer(
               int num, Warehouse fromWarehouse, Warehouse toWarehouse) {
        this.num = num;
        this.fromWarehouse = fromWarehouse;
        this.toWarehouse = toWarehouse;
    }

    @Override
    public String toString() {
        return String.format(
                      "Transfer{num:%d,fromWarehouse:%s,toWarehouse:%s}",
                         this.num, this.fromWarehouse, this.toWarehouse);
    }
}
