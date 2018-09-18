package algo;

import javax.xml.ws.Response;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vikasnaiyar on 14/09/18.
 */
public class BookingService {


    private static CityCabManager cityCabManager = new FlipkartCityCabManager();

    private static TripManager tripManager = new FlipkartTripManager(cityCabManager);


    public static void main(String args[] ) throws Exception {


        boolean endOfCommand = false;

        Scanner scanner = new Scanner(System.in);

        while(!endOfCommand) {
            String nextInputCommand = null;

            // This code is just for end of inputs condition.
            try {
                nextInputCommand= scanner.nextLine();
            } catch (Exception ex) {
                endOfCommand = true;
            }

            // just checking whether inputs need to be processed or not
            if(!endOfCommand && nextInputCommand != null && !nextInputCommand.trim().equals("")) {
                // add_city command
                String[] commandAndArgs = scanner.nextLine().split(" ");
                String commandName = commandAndArgs[0];

                Command command = Command.getCommand(commandName);
                handleCommand(command,commandAndArgs);
            }

        }


        scanner.close();

    }

    public static void handleCommand(Command command, String[] commandArgs) {
        switch (command) {
            case ADD_CITY:
                if(commandArgs.length < 3) {
                    System.out.println(ResponseCode.ERROR.toString());
                } else {
                    handleAddCityCommand(commandArgs);
                }
                break;
            case ADD_VEHICLE:
                if(commandArgs.length < 3) {
                    System.out.println(ResponseCode.ERROR.toString());
                } else {
                    handleAddVehicleCommand(commandArgs);
                }
                break;
            case RENT_VEHICLE:
                if(commandArgs.length < 3) {
                    System.out.println(ResponseCode.ERROR.toString());
                } else {
                    handleRentVehicleCommand(commandArgs);
                }
                break;

            case END_TRIP:
                if(commandArgs.length < 2) {
                    System.out.println(ResponseCode.ERROR.toString());
                } else {
                    handleEndTripCommand(commandArgs);
                }
                break;



        }

    }

    public static void handleEndTripCommand(String[] commandArgs) {
        String vehicleNumber = commandArgs[1];
        if(vehicleNumber == null || vehicleNumber.equals("") ) {
            System.out.println(ResponseCode.ERROR.toString());
            return;
        }

        Cab c = cityCabManager.getCab(vehicleNumber);

        if(c != null) {
            c.setCabState(CabState.IDLE);
            System.out.print(ResponseCode.OK);
        } else {
            System.out.print(ResponseCode.ERROR);
        }

    }

    public static void handleRentVehicleCommand(String[] commandArgs) {
        String fromCityName = commandArgs[1];
        if(fromCityName == null || fromCityName.equals("") ) {
            System.out.println(ResponseCode.ERROR.toString());
            return;
        }

        String toCityName = commandArgs[2];
        if(toCityName == null || toCityName.equals("") ) {
            System.out.println(ResponseCode.ERROR.toString());
            return;
        }

        ResponseCode code = tripManager.rentVehicle(fromCityName, toCityName);

        System.out.println(code.toString());


    }

    public static void handleAddCityCommand(String[] commandArgs) {
        String cityName = commandArgs[1];
        if(cityName == null || cityName.equals("") ) {
            System.out.println(ResponseCode.ERROR.toString());
            return;
        }

        String quantityString = commandArgs[2];
        if(quantityString == null || quantityString.equals("") ) {
            System.out.println(ResponseCode.ERROR.toString());
            return;
        }

        int quantity = Integer.valueOf(quantityString);

        if(commandArgs.length < 3 + quantity) {
            System.out.println(ResponseCode.ERROR.toString());
            return;
        }

        cityCabManager.addCity(cityName); // add city

        for (int i=3;i<commandArgs.length; i++) {
            cityCabManager.addVehicle(cityName, commandArgs[i]);
        }
        System.out.println(ResponseCode.OK);
    }

    public static void handleAddVehicleCommand(String[] commandArgs) {
        String cityName = commandArgs[1];
        if(cityName == null || cityName.equals("") ) {
            System.out.println(ResponseCode.ERROR.toString());
            return;
        }

        String quantityString = commandArgs[2];
        if(quantityString == null || quantityString.equals("") ) {
            System.out.println(ResponseCode.ERROR.toString());
            return;
        }

        int quantity = Integer.valueOf(quantityString);

        if(commandArgs.length < 3 + quantity) {
            System.out.println(ResponseCode.ERROR.toString());
            return;
        }

        for (int i=3;i<commandArgs.length; i++) {
            cityCabManager.addVehicle(cityName, commandArgs[i]);
        }
        System.out.println(ResponseCode.OK);
    }

    public interface Cab {
        String getLicensePlateNumber();
        CabState getCabState();
        boolean setCabState(CabState cabState);
    }


    public enum CabState{
        IDLE,
        ON_TRIP;
    }

    public interface Vehicle {
        String getLicensePlateNumber();
        int getNumberOfWheels();
    }

     public static class FourWheelVehicle implements Vehicle {
         private String licencePlateNumber;
         private int numberOfWheels;
         public FourWheelVehicle(String licencePlateNumber){
             this.licencePlateNumber = licencePlateNumber;
             this.numberOfWheels=4;
         }
         @Override
         public String getLicensePlateNumber() {
             return this.licencePlateNumber;
         }

         @Override
         public int getNumberOfWheels() {
             return this.numberOfWheels;
         }
     }

    public static class FlipkartCab extends FourWheelVehicle implements Cab {

        private CabState cabState;

        public FlipkartCab(String licencePlateNumber) {
            super(licencePlateNumber);
            cabState = CabState.IDLE;
        }

        @Override
        public CabState getCabState() {
            return this.cabState;
        }

        @Override
        public boolean setCabState(CabState cabState) {
            boolean cabStateUpdated = false;
            if(cabState != null) {
                this.cabState = cabState;
                cabStateUpdated = true;
            }
            return cabStateUpdated;
        }


        @Override
        public boolean equals(Object obj) {
            if(obj == null) {
                return  false;
            }

            if(obj instanceof FlipkartCab) {
                return this.getLicensePlateNumber().equals(((FlipkartCab)obj).getLicensePlateNumber());
            }
            else {
                return  false;
            }

        }


        @Override
        public int hashCode(){
            return 13 * this.getLicensePlateNumber().hashCode();
        }
    }


    public static interface TripManager {
        ResponseCode rentVehicle(String fromCity,String toCity);
        ResponseCode endTrip(String fromCity, String toCity);
    }


    public static class  FlipkartTripManager implements TripManager {

        private CityCabManager cityCabManager;

        public FlipkartTripManager(CityCabManager cityCabManager) {
            this.cityCabManager = cityCabManager;
        }


        @Override
        public ResponseCode rentVehicle(String fromCity, String toCity) {
            ResponseCode responseCode = ResponseCode.ERROR;
            Cab cab = cityCabManager.getCabFromCity(fromCity);

            if(cab  != null) {
                cab.setCabState(CabState.ON_TRIP);
                responseCode = ResponseCode.OK;
            }

            return responseCode;
        }

        @Override
        public ResponseCode endTrip(String fromCity, String toCity) {
            return ResponseCode.OK;
        }
    }




    public static interface CityCabManager {
        ResponseCode addCity(String cityName);
        ResponseCode addVehicle(String cityName, String licencePlate);
        Cab getCabFromCity(String cityName);
        Cab getCab(String licencePlate);
    }

    public static class FlipkartCityCabManager implements CityCabManager{

        private Map<String, Set<Cab>> cityCabsMap;
        public  FlipkartCityCabManager() {
                this.cityCabsMap = new ConcurrentHashMap<>();
        }

        @Override
        public Cab getCab(String licencePlate) {
            Cab cab = null;

            Collection<Set<Cab>> allCabs = cityCabsMap.values();

            for (Set<Cab> cs : allCabs) {
                for (Cab c : cs) {
                    if (c.getLicensePlateNumber().equals(licencePlate)) {
                        cab = c;
                        break;
                    }
                }

                if(cab != null) {
                    break;
                }
            }

            return cab;
        }


        @Override
        public Cab getCabFromCity(String fromCity){
            Cab cab = null;

            Set<Cab> cabs = cityCabsMap.get(fromCity);

            if(cabs != null) {
                for (Cab c: cabs) {
                    if(c.getCabState() == CabState.IDLE) {
                        cab = c;
                        break;
                    }
                }
            }

            return  cab;
        }

        @Override
        public ResponseCode addCity(String cityName) {
            if(!cityCabsMap.containsKey(cityName)) {
                cityCabsMap.put(cityName, new HashSet<>());
            }
            return ResponseCode.OK;
        }

        @Override
        public ResponseCode addVehicle(String cityName, String licencePlate) {
            if(!cityCabsMap.containsKey(cityName)) {
                cityCabsMap.put(cityName, new HashSet<>());
            }

            cityCabsMap.get(cityName).add(new FlipkartCab(licencePlate));

            return ResponseCode.OK;
        }
    }

     enum ResponseCode {
        OK,
        ERROR;
    }

    public enum Command{
        ADD_CITY("add_city"),
        ADD_VEHICLE("add_vehicle"),
        RENT_VEHICLE("rent_vehicle"),
        END_TRIP("end_trip"),
        PRINT_STATUS("print_status");

        String commandName;

        Command(String commandName) {
            this.commandName = commandName;
        }

        public String getCommandName(){
            return commandName;
        }

        private static Command getCommand(String commandName) {
            Command commandsEnum = null;
            for (Command command : Command.values()) {
                if (command.commandName.equals(commandName)){
                    commandsEnum = command;
                    break;
                }
            }
            return commandsEnum;
        }

    }



}
