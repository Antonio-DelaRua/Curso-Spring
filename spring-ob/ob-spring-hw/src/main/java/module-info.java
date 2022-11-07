module com.example.obspringhw {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;


    opens com.example.obspringhw to javafx.fxml;
    exports com.example.obspringhw;
}