package carsharing.domain;

public record Customer (Integer id, String name, Integer rentedCarId) {
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rentedCarId=" + rentedCarId +
                '}';
    }
}
