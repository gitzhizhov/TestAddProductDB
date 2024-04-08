package tests;

import org.ibs.basetestsclass.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestAddDB extends BaseTest {

    @Test
    @DisplayName("TestDB")
    public void startTest() throws SQLException {

        String foodName = "Картошка";
        String foodType = "VEGETABLE";
        boolean isExotic = false;


        String query = "select * from food";
        String insertPS = "INSERT INTO food(food_name, food_type, food_exotic) values (?, ?, ?)";
        String delete = "DELETE FROM food WHERE food_name = ?";

        displayResult.printResult(rm.selectRequest(query));

        rm.insertPrepStatement(insertPS,foodName,foodType,isExotic);

        displayResult.printResult(rm.selectRequest(query));

        rm.deleteRowPS(delete, foodName);

        displayResult.printResult(rm.selectRequest(query));
    }
}
