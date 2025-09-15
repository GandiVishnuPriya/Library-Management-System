package library.domain;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private final String id;
    private String name;
    private String email;
    private final List<LendingRecord> history = new ArrayList<>();

    public Patron(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void addRecord(LendingRecord record) { history.add(record); }
    public List<LendingRecord> getHistory() { return history; }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Patron{id='" + id + "', name='" + name + "'}";
    }
}
