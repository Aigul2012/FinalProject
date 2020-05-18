import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class Room {
    private String name;
    private int area;
    private int numberOfWindows;
    private int totalRoomIllumination = 0;
    private Logger logger = LogManager.getLogger();
    private ArrayList<LightBulb> lightBulbs = new ArrayList<LightBulb>();
    private ArrayList<Furniture> listOfFurniture = new ArrayList<Furniture>();

    public Room(String name, int area, int numberOfWindows) {
        this.name = name;
        this.area = area;
        this.numberOfWindows = numberOfWindows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public ArrayList<LightBulb> getLightBulbs() {
        return lightBulbs;
    }

    public void setLightBulbs(ArrayList<LightBulb> lightBulbs) {
        this.lightBulbs = lightBulbs;
    }

    public void addLightBulb(LightBulb lightBulb) {
        lightBulbs.add(lightBulb);
    }

    public void addFurniture(Furniture furniture){
        listOfFurniture.add(furniture);
    }

    public ArrayList<Furniture> getListOfFurniture() {
        return listOfFurniture;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", numberOfWindows=" + numberOfWindows +
                '}';
    }

    public void describe() throws IlluminationTooMuchException, SpaceUsageTooMuchException {
        final int ONE_WINDOW_ILLUMINATION = 700;
        final int HIGH_BOUNDARY_ROOM_ILLUMINATION = 4000;
        final float ALLOWED_COVERAGE_OF_AREA = 0.7f;
        int totalLightBulbsIllumination = 0;
        float totalFurnitureArea=0;
        float percentageOfCoveredArea=0;
        float freeSpace;
        float percentageOfFreeSpace=0;

        if (getLightBulbs().size() > 0) {
            for (int i = 0; i <= getLightBulbs().size() - 1; i++) {
                totalLightBulbsIllumination = totalLightBulbsIllumination + getLightBulbs().get(i).getLux();
            }
            totalRoomIllumination = getNumberOfWindows() * ONE_WINDOW_ILLUMINATION + totalLightBulbsIllumination;
            if (totalRoomIllumination >= HIGH_BOUNDARY_ROOM_ILLUMINATION) {
                logger.error("IlluminationTooMuchException is up");
                throw new IlluminationTooMuchException("Слишком много света в комнате");
            } else {
                logger.info("Общее освещение комнаты " + totalRoomIllumination + " = " + getNumberOfWindows() + " окна по " + ONE_WINDOW_ILLUMINATION + " лк, и " + getLightBulbs().size() + " лампочки");
            }
        } else {
            totalRoomIllumination = getNumberOfWindows() * ONE_WINDOW_ILLUMINATION;
            if (totalRoomIllumination >= HIGH_BOUNDARY_ROOM_ILLUMINATION) {
                logger.error("IlluminationTooMuchException is up");
                throw new IlluminationTooMuchException("Слишком много света");
            } else {
                logger.info("Общее освещение комнаты " + totalRoomIllumination + " = " + getNumberOfWindows() + " окна по " + ONE_WINDOW_ILLUMINATION + " лк");
            }
        }
        if (getListOfFurniture().size()>0){
            for (int i=0; i <= getListOfFurniture().size()-1; i++){
                totalFurnitureArea = totalFurnitureArea + getListOfFurniture().get(i).getAreaOfFurniture();
            }
            freeSpace = getArea()-totalFurnitureArea;
            percentageOfCoveredArea = totalFurnitureArea / getArea();
            percentageOfFreeSpace = 1 -percentageOfCoveredArea;
            if (percentageOfCoveredArea >= ALLOWED_COVERAGE_OF_AREA) {
                logger.error("SpaceTooMuchException is up");
                throw new SpaceUsageTooMuchException("Cуммарная площадь предметов не должна превышает 70% площади помещения");
            }
            else {
                logger.info("Общая прощадь комнаты " + getArea() + "м2 (занято " + totalFurnitureArea + "м2 или " + percentageOfCoveredArea + "%, " + "свободно " + freeSpace + "м2 или " + percentageOfFreeSpace + "%. В комнате " + listOfFurniture.size() + " предмета)");
            }
        }
        else {
            logger.info("Мебели нет. Свободно 100%");
        }
    }
}
