import model.MainModel;
import view.MainFrame;

public class RunApplication {
    public static void main(String[] args) {
        MainModel mainModel = new MainModel();
        MainFrame mainApplication = new MainFrame(mainModel);
    }
}