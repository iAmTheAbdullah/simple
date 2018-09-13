import model.MainModel;
import view.MainFrame;
import controller.Controller;

public class RunApplication {
    public static void main(String[] args) {
        MainModel mainModel = new MainModel();
        Controller mainController = new Controller(mainModel);
        MainFrame mainApplication = new MainFrame(mainModel, mainController);

        mainModel.addObserver(mainApplication);
        mainModel.initiateSimulation(0);
    }
}