package Game;

import Game.Games.TicTacToe.TicTacToeScene;
import Player.Player;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;
import Training.TrainingMenuScene;

public class GameSceneFactory implements SceneFactoryInterface {

    private Player[] listPLayers;

    public GameSceneFactory(Player[] listPlayers) {
        this.listPLayers = listPlayers;
    }

    /**
     * Create a game associated to an game
     */
    public GameScene createScene(SceneEnum gameEnum) {
        // TODO fill the switch when scenes will be created
        switch (gameEnum) {
            case TIC_TAC_TOE:
                return new TicTacToeScene();
                // return new TicTacToeScene(this.listPlayers);
            case RUNNER:
                // return new RunnerScene(this.listPlayers);
            case CONNECT_FOUR:
                // return new ConnectFourScene(this.listPlayers);
            case COOKIE_CLICKER:
                // return new CookieClickerScene(this.listPlayers);
            case TRAINING_MENU:
                return new TrainingMenuScene();
            default:
                throw new RuntimeException("GameEnum (" + gameEnum + ") is unknown");
        }
    }
}
