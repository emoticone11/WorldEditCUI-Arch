package org.enginehub.worldeditcui.forge;

import net.minecraftforge.client.ConfigGuiHandler;
import org.enginehub.worldeditcui.gui.CUIConfigPanel;

/**
 * @author Mark Vainomaa
 */
public final class ConfigPanelFactory {

    public static ConfigGuiHandler.ConfigGuiFactory getFactory() {
        return new ConfigGuiHandler.ConfigGuiFactory((mc, screen) ->
                new CUIConfigPanel(screen, WorldEditCUIForgeClient.getInstance().getController().getConfiguration()));
    }
}
