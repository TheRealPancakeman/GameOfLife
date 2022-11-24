module com.gol.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.gol.gameoflife to javafx.fxml;
    exports com.gol.gameoflife;
}