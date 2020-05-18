import java.util.ArrayList;

public class Building {
    private ArrayList<Room> rooms = new ArrayList();

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void describe() throws IlluminationTooMuchException, SpaceUsageTooMuchException {
        for(Room room: rooms){
            room.describe();
        }
    }
}

