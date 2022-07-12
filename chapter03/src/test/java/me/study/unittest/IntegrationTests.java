package me.study.unittest;

public abstract class IntegrationTests {

    protected final Database database;

    public IntegrationTests() {
        this.database = new Database();
    }

    public void dispose() {
        database.dispose();
    }
}
