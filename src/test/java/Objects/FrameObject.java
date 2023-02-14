package Objects;

import java.util.HashMap;

public class FrameObject {
    private String FirstFrame;
    private String SecondFrame;

    public FrameObject(HashMap<String, String> TestData){
        PopulateObject(TestData);

    }

    public String getFirstFrame() {

        return FirstFrame;
    }

    public void setFirstFrame(String FirstFrame) {

        this.FirstFrame = FirstFrame;
    }

    public String getSecondFrame() {

        return SecondFrame;
    }

    public void setSecondFrame(String SecondFrame) {

        this.SecondFrame = SecondFrame;
    }
    private void PopulateObject(HashMap<String, String> TestData) {
        for (String Key : TestData.keySet()) {
            switch (Key) {
                case "FirstFrame":
                    setFirstFrame(TestData.get(Key));
                    break;
                case "SecondFrame":
                    setSecondFrame(TestData.get(Key));
                    break;


            }
        }
    }
}
