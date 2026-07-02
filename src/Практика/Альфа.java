package Практика;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;




@Data
class User {
    private String username;
    private Integer age;
    private List<Group> groups;
}

@Data
class Group {
    private String name;
    private String description;
}

public class Альфа {
    public List<User> consume(Stream<User> usersStream) {
        return usersStream.filter(user -> user.getGroups()
                .stream()
                .anyMatch(g -> g.getName().startsWith("X")))
                .collect(Collectors.toList());
    }
}
