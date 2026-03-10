module sio.tp4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens sio.tp4.models;

    opens sio.tp4 to javafx.fxml;
    exports sio.tp4;
}