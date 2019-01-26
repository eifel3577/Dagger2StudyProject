package com.example.fujitsu.dagger2studyproject;

public class ApplicationDatabase {

    private String databaseName;

    public ApplicationDatabase(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}
