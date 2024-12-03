package carsharing.domain;

public record Car(Integer id, String name, int companyId) {

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
