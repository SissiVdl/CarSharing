package carsharing.domain;

public record Company(Integer id, String name) {
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
