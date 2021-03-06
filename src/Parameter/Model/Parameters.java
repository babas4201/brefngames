package Parameter.Model;

import Launcher.Controller.LauncherController;
import Parameter.Parameters.ColorParameter;
import Parameter.Parameters.Configurable;
import Parameter.Parameters.IconParameter;
import Repository.ModifyFiles;
import Repository.Parameter.DefaultPlayerParameterRepository;
import Repository.Parameter.MusicParameterRepository;
import Repository.Parameter.SoundParameterRepository;
import Repository.Parameter.ThemeParameterRepository;
import Utils.Music.MusicManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parameters {

    public final static String DEFAULT_PARAMETER_FILE_JSON = "src/data/JSON/parameters.default.json";
    public final static String PARAMETERS_JSON_FILE = "src/data/JSON/parameters.json";

    public static Map<ParameterEnum, Configurable> getConfiguration() {
        Map<ParameterEnum, Configurable> configuration = new HashMap<>();
        // Added default player configuration
        configuration.put(ParameterEnum.PLAYER_1_COLOR, DefaultPlayerParameterRepository.getColorFromPlayer(DefaultPlayerParameterEnum.PLAYER_1));
        configuration.put(ParameterEnum.PLAYER_2_COLOR, DefaultPlayerParameterRepository.getColorFromPlayer(DefaultPlayerParameterEnum.PLAYER_2));
        configuration.put(ParameterEnum.PLAYER_1_ICON, DefaultPlayerParameterRepository.getIconFromPlayer(DefaultPlayerParameterEnum.PLAYER_1));
        configuration.put(ParameterEnum.PLAYER_2_ICON, DefaultPlayerParameterRepository.getIconFromPlayer(DefaultPlayerParameterEnum.PLAYER_2));
        // Added sound configuration
        configuration.put(ParameterEnum.SOUND, SoundParameterRepository.getSound());
        // Added music configuration
        configuration.put(ParameterEnum.MUSIC, MusicParameterRepository.getMusic());
        // Added theme configuration
        configuration.put(ParameterEnum.THEME_FIRST_COLOR, ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR));
        configuration.put(ParameterEnum.THEME_SECOND_COLOR, ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR));

        return configuration;
    }

    public static void save(Map<ParameterEnum, Configurable> configuration) {
        DefaultPlayerParameterRepository.save(
                DefaultPlayerParameterEnum.PLAYER_1,
                DefaultPlayerParameterRepository.DEFAULT_COLOR_FIELD,
                ((ColorParameter) configuration.get(ParameterEnum.PLAYER_1_COLOR)).getStringColor()
        );

        DefaultPlayerParameterRepository.save(
                DefaultPlayerParameterEnum.PLAYER_2,
                DefaultPlayerParameterRepository.DEFAULT_COLOR_FIELD,
                ((ColorParameter) configuration.get(ParameterEnum.PLAYER_2_COLOR)).getStringColor()
        );

        DefaultPlayerParameterRepository.save(
                DefaultPlayerParameterEnum.PLAYER_1,
                DefaultPlayerParameterRepository.DEFAULT_ICON_FIELD,
                ((IconParameter) configuration.get(ParameterEnum.PLAYER_1_ICON)).getName()
        );

        DefaultPlayerParameterRepository.save(
                DefaultPlayerParameterEnum.PLAYER_2,
                DefaultPlayerParameterRepository.DEFAULT_ICON_FIELD,
                ((IconParameter) configuration.get(ParameterEnum.PLAYER_2_ICON)).getName()
        );

        ThemeParameterRepository.save(
                ThemeParameterRepository.DEFAULT_FIRST_COLOR_FIELD,
                ((ColorParameter) configuration.get(ParameterEnum.THEME_FIRST_COLOR)).getStringColor()
        );

        ThemeParameterRepository.save(
                ThemeParameterRepository.DEFAULT_SECOND_COLOR_FIELD,
                ((ColorParameter) configuration.get(ParameterEnum.THEME_SECOND_COLOR)).getStringColor()
        );

        SoundParameterRepository.save(
                (boolean) configuration.get(ParameterEnum.SOUND).getValue()
        );

        MusicParameterRepository.save(
                (boolean) configuration.get(ParameterEnum.MUSIC).getValue()
        );
    }

    public static void reset() {
        try {
            ModifyFiles.copyFile(Parameters.DEFAULT_PARAMETER_FILE_JSON, Parameters.PARAMETERS_JSON_FILE);
            LauncherController.reloadConfiguration();

            // music manager
            MusicManager.getInstance().stop();
            if ((Boolean) MusicParameterRepository.getMusic().getValue()) {
                MusicManager.getInstance().start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
