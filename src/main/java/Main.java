public class Main {
    public static void main(String[] args) throws IlluminationTooMuchException, SpaceUsageTooMuchException {
        System.setProperty("log4j.configurationFile", "/Users/polzovatel/IdeaProjects/FinalProject/src/main/resources/log4j2.xml");
        Building building = new Building();
        Room room1 = new Room("Room1", 100, 3);
        Room room2 = new Room("Room2", 5, 2);
        System.out.println(room1);


        LightBulb lightBulb1 = new LightBulb(150);
        LightBulb lightBulb2 = new LightBulb(250);
        Furniture furniture1 = new Furniture("Cтол письменный", 3);
        Furniture furniture2 = new Furniture("Кресло мягкое и пушистое", 1);
        building.addRoom(room1);
        building.addRoom(room2);
        room1.addLightBulb(lightBulb1);
        room1.addLightBulb(lightBulb2);
        room1.addFurniture(furniture1);
        room1.addFurniture(furniture2);
        System.out.println("Здание №1: ");
        building.describe();
    }
}
