package module11;

public class UsersForTest {
    private String name;
    private int id;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public UsersForTest(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
