/**
 *
 * @author Shun Lett Pyae Oo
 * Date: 15th May 2025
 * Description: FortuneTeller Controller for Fortune Teller App which handles UI actions and connects with logic.
 */
package com.example.fortuneteller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.ObservableList;
import java.util.Optional;


public class FortuneTellerController {

    @FXML
    private Label fortuneLabel;

    @FXML
    private TextField newFortuneInput;

    @FXML
    private ListView<String> fortuneListView;

    private FortuneTeller logic;

    @FXML
    public void initialize() {
        logic = new FortuneTeller();
        fortuneListView.getItems().addAll(logic.getFortunes());
        fortuneListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * Displays a randomly selected fortune in the label.
     */
    @FXML
    private void onGetFortuneClickButton() {
        String fortune = logic.getRandomFortune();
        fortuneLabel.setText(fortune);
    }

    /**
     * Adds a new fortune to the list if the input is not empty.
     */
    @FXML
    private void onAddFortuneClickButton() {
        String newFortune = newFortuneInput.getText().trim();
        if (newFortune.isEmpty()) {
            showAlert("Input Error", "Please enter a fortune.");
            return;
        }

        logic.addFortune(newFortune);
        fortuneListView.getItems().add(newFortune);
        newFortuneInput.clear();
    }

    /**
     * Removes all selected fortunes from the list with confirmation dialog.
     */
    @FXML
    private void onRemoveFortuneClickButton() {
        ObservableList<String> selectedFortunes = fortuneListView.getSelectionModel().getSelectedItems();

        if (selectedFortunes.isEmpty()) {
            showAlert("Selection Error", "Please select at least one fortune to remove.");
            return;
        }

        Alert confirm = new Alert(AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Removal");
        confirm.setHeaderText("Remove selected fortunes?");
        confirm.setContentText("Are you sure you want to delete the selected fortunes?");

        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            logic.removeFortunes(selectedFortunes);
            fortuneListView.getItems().removeAll(selectedFortunes);
        }
    }

    /**
     * Shows an alert dialog with the given title and message.
     * @param title the title of the alert
     * @param content the content of the alert
     */
    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
