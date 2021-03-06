package logic.view.graphic.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import logic.controller.ViewRoadController;
import logic.view.AlertControl;
import logic.view.ViewComponent;

public class AnchorPaneMap extends Decorator{

	public AnchorPaneMap(ViewComponent anchorPaneComponent) {
		super(anchorPaneComponent);
	}
	
	public AnchorPane manageMap(AnchorPane anchorPane) {
		WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        
        final URL urlGoogleMaps = getClass().getResource("../../resources/maps.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
        
		Button b = new Button("OPEN IN MAPS");
		b.setMinWidth(anchorPane.getWidth());
		b.setStyle("-fx-background-color:  #272F54;");
		b.setTextFill(Color.WHITE);
		b.setAlignment(Pos.CENTER);
		b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 	
					try {
						ViewRoadController controlRoad = new ViewRoadController();
						if(controlRoad.getRoad().equals("Error")) {
							AlertControl.infoBox("Impossible send request to maps, check your address", "Error request");
						}else {
							Desktop.getDesktop().browse(new URL(controlRoad.getRoad()).toURI());
						}
					} catch (IOException | URISyntaxException e1) {
						AlertControl.infoBox("Error connection to Google Maps", "Error connection");
					}
            }
        });
        
        VBox verticalBox = new VBox(webView, b);
		anchorPane.getChildren().add(verticalBox);
		verticalBox.setMaxWidth(256);
        verticalBox.setMaxHeight(238);
        b.setMinWidth(256);
        
		return anchorPane;
    }
	
	
	@Override
	public AnchorPane draw() {
		AnchorPane preliminaryResults = super.draw();
		preliminaryResults = this.manageMap(preliminaryResults);
		return preliminaryResults;
	}
	
}
