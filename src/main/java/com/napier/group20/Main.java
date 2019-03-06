package com.napier.group20;

import com.napier.group20.utils.App;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.connect("localhost:3306", 10);

        app.loadDatabase();

        app.disconnect();
    }
}
