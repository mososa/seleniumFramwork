package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public String name,email,password,DOBDay,DOBMonth,DOBYear,firstName,lastName,company,address,country,state,city,zipCode,
            mobileNumber;
    public void userRegistrationJsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserRegisyrationData.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray Jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        for (Object jsonObj :Jarray){
            JSONObject person = (JSONObject) jsonObj;
            name = (String) person.get("name");
            email = (String) person.get("email");
            password = (String) person.get("password");
            DOBDay = (String) person.get("DOBDay");
            DOBMonth = (String) person.get("DOBMonth");
            DOBYear = (String) person.get("DOBYear");
            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            company = (String) person.get("company");
            address = (String) person.get("address");
            country = (String) person.get("country");
            state = (String) person.get("state");
            city = (String) person.get("city");
            zipCode = (String) person.get("zipCode");
            mobileNumber = (String) person.get("mobileNumber");



        }


    }
}
/*
 "name": "mohammedSosa",
         "email": "msosa@gmail.com",
         "password" : "$ThisIsPassw@rd",
         "DOBDay": "16",
         "DOBMonth": "March",
         "DOBYear": "1989",
         "firstName": "Mohammed",
         "lastName" : "Sosa",
         "company" : "STC",
         "address" : "almorsalat",
         "country" : "United States",
         "state": "Washgonton",
         "city" : "Riyadh",
         "zipCode": "13725",
         "mobileNumber" : "00201221887865"


 */