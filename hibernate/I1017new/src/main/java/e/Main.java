package e;

/**
 * Constructor based query.
 */
public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private final Repository repository = new Repository();

    public void run() {
        this.repository.createStudent(new Student("Имя", "Фамилия"));
        this.repository.createStudent(new Student("Два", "Второй"));
        for (Student s : this.repository.findAllStudents()) {
            System.out.println(s);
        }
        for (Result r : this.repository.findCount()) {
            System.out.println(r.getCount());
        }
        this.repository.close();
    }
}
