public class Furniture {
    private String name;
    private int areaOfFurniture;

    public Furniture(String name, int areaOfFurniture) {
        this.name = name;
        this.areaOfFurniture = areaOfFurniture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAreaOfFurniture() {
        return areaOfFurniture;
    }

    public void setAreaOfFurniture(int areaOfFurniture) {
        this.areaOfFurniture = areaOfFurniture;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", square=" + areaOfFurniture +
                '}';
    }
}
