package Launcher;

import Menu.MenuScene;
import Parameter.Scenes.ParametersScene;
import Scene.Model.Scene;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;
import Training.TrainingScene;

public class LauncherFactory implements SceneFactoryInterface {

    @Override
    public Scene createScene(SceneEnum sceneEnum) {
        switch (sceneEnum) {
            case MENU:
                return new MenuScene();
            case TRAINING:
                return new TrainingScene();
            case CONTEST:
            case STATISTICS:
            case PARAMETERS:
                return new ParametersScene();
            case QUIT:
                System.exit(0);
            default:
                throw new RuntimeException("Unexpected scene : " + sceneEnum);
        }
    }
}
