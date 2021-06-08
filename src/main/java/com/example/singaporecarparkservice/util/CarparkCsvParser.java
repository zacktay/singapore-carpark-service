package com.example.singaporecarparkservice.util;

import com.example.singaporecarparkservice.entity.Carpark;
import com.example.singaporecarparkservice.enums.CarparkType;
import com.example.singaporecarparkservice.enums.ParkingSystemType;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j2
public class CarparkCsvParser {

    @Value("${csv.file-location}")
    private String fileLocation;

    private static final String[] HEADERS = {
            "car_park_no",
            "address",
            "x_coord",
            "y_coord",
            "car_park_type",
            "type_of_parking_system",
            "short_term_parking",
            "free_parking",
            "night_parking",
            "gantry_height",
            "car_park_basement"
    };

    private Double getDouble(CSVRecord record, String columnName) {
        return Double.valueOf(record.get(columnName));
    }

    private Integer getInteger(CSVRecord record, String column) {
        return Integer.valueOf(record.get(column));
    }

    private Boolean getBoolean(CSVRecord record, String column) {
        return record.get(column).equalsIgnoreCase("YES")
                || record.get(column).equalsIgnoreCase("Y");
    }

    public List<Carpark> getCarparks() throws IOException {
        Reader in = new FileReader(fileLocation);
        return CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in)
                .getRecords()
                .stream()
                .map(this::createCarpark)
                .collect(Collectors.toList());
    }

    private Carpark createCarpark(CSVRecord record) {
        return Carpark
                .builder()
                .code(record.get("car_park_no"))
                .address(record.get("address"))
                .xCoord(getDouble(record, "x_coord"))
                .yCoord(getDouble(record, "y_coord"))
                .decks(getInteger(record, "car_park_decks"))
                .gantryHeight(getDouble(record, "gantry_height"))
                .carparkType(CarparkType.getType(record.get("car_park_type")))
                .parkingSystemType(ParkingSystemType.getType(record.get("type_of_parking_system")))
                .shortTermParking(record.get("short_term_parking"))
                .freeParking(record.get("free_parking"))
                .night(getBoolean(record, "night_parking"))
                .basement(getBoolean(record, "car_park_basement"))
                .build();
    }

}
