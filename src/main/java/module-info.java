module com.example.fortuneteller {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.fortuneteller to javafx.fxml;
    exports com.example.fortuneteller;
}