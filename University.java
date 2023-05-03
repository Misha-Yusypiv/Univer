import java.util.List;
import java.util.ArrayList;

public class University {
    private String name;
    private List<Group> groups = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }
}
