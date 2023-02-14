package Objects;

import java.util.HashMap;

public class AlertObject {
    private String AlertText;
    public AlertObject(HashMap<String, String> TestData){
        PopulateObject(TestData);

    }

    public String getAlertText() {

        return AlertText;
    }

    public void setAlertText(String AlertText) {

        this.AlertText = AlertText;
    }
    private void PopulateObject(HashMap<String, String> TestData) {
        for (String Key : TestData.keySet()) {
            switch (Key) {
                case "AlertText":
                    setAlertText(TestData.get(Key));
                    break;

            }
        }
    }
}
