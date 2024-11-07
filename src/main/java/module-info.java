module com.jpmillz.libraryapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.jpmillz.libraryapplication to javafx.fxml;
    exports com.jpmillz.libraryapplication;
}