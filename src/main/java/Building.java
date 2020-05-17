import java.util.ArrayList;

public class Building {
    private ArrayList<Room> rooms = new ArrayList();

    public void addRoom(Room room){
        rooms.add(room);
    }

    public ArrayList<Room> getRooms(String name) {
        return rooms;
    }

}

