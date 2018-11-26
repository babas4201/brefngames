package Launcher.Controller;

import Launcher.LauncherFactory;
import Parameter.Model.Parameters;
import Parameter.Parameters.Configurable;
import Parameter.Model.ParameterEnum;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

import java.util.*;

/**
 * This is the MasterController (Its view is the window)
 */
public class LauncherController extends AbstractSceneManagerController {

    private static Map<ParameterEnum, Configurable> configurations = Parameters.getConfiguration();;

    public LauncherController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new LauncherFactory());

        this.switchScene(SceneEnum.MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            case TRAINING:
                return SceneEnum.TRAINING;
            case CONTEST:
                return SceneEnum.CONTEST;
            case STATISTICS:
                return SceneEnum.STATISTICS;
            case PARAMETERS:
                return SceneEnum.PARAMETERS;
            case END_PARAMETERS:
            case END_TRAINING:
                return SceneEnum.MENU;
            case QUIT:
                return SceneEnum.QUIT;
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }

    public static Map<ParameterEnum, Configurable> getConfiguration() {
        return configurations;
    }
}