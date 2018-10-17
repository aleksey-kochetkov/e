package e;

/**
 * Four inheritance strategies with Hibernate.
 * 1) Mapped Superclass - mapped superclass is not an entity.
 * 2) Table per Class - the super class is now also an entity. Another
 *    difference is the additional @Inheritance annotation to define the
 *    inheritance strategy - InheritanceType.TABLE_PER_CLASS.
 * 3) Single Table - maps all entries of the inheritance structure to the
 *    same database table.
 * 4) Joined - this time, also abstract superclass gets mapped to a
 *    database table.
 */
public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private final Repository repository = new Repository();

    void run() {
        CreditCard card = new CreditCard("Взаим Новежлив", 6000);
        BankAccount account = new BankAccount("Предель Новежлив",
                                                          "Сосёте Банк");
        this.repository.createCreditCard(card);
        this.repository.createBankAccount(account);
        this.print();
        this.repository.close();
    }

    void print() {
        for (BillingDetail d : this.repository.findAllBillingDetails()) {
            System.out.println(d);
        }
    }
}
