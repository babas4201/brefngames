package Statistic;

import Scene.Model.Scene;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;

public class StatisticSceneFactory implements SceneFactoryInterface {
    @Override
    public Scene createScene(SceneEnum sceneEnum) {
        switch (sceneEnum) {
            case STATISTIC_MENU :
                return new StatisticMenuScene();
            case STATISTIC_PLAYER:
                return new StatisticPlayerScene();
            default:
                throw new RuntimeException("ParametersScene (" + sceneEnum + ") is unknown");
        }
    }
}
