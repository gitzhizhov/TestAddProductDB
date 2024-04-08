package org.ibs.basetestsclass;

import org.ibs.managers.ConnectionManager;
import org.ibs.managers.DisplayResult;
import org.ibs.managers.RequestsManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

public class BaseTest {

    String connString = "jdbc:h2:tcp://localhost:9092/mem:testdb";
    String login = "user";
    String password = "pass";

    private static final ConnectionManager connectionManager = ConnectionManager.getConnectionManager();

    protected RequestsManager rm = RequestsManager.getRequestsManager();
    protected DisplayResult displayResult = DisplayResult.getDisplayResult();

    @BeforeEach
    public void beforeEach() {
        Connection connection = connectionManager.getConnection(connString, login, password);
    }

    @AfterAll
    public static void quitConnect() {
        connectionManager.quitConnection();
    }
}
