package org.enginehub.worldeditcui.forge;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = WorldEditCUIForge.MOD_ID)
public class WorldEditCUIForge {

    public static final String MOD_ID = "worldeditcui";

    public WorldEditCUIForge() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class,
                    ConfigPanelFactory::getFactory);

                    // ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class,
                    // () -> new ConfigGuiHandler.ConfigGuiFactory(new BiFunction<Minecraft, Screen, Screen>() {
                    //     @Override
                    //     public Screen apply(Minecraft mc, Screen screen) {
                    //         return new MyConfigGuiScreen();
                    // }));

            eventBus.register(WorldEditCUIForgeClient.ModEventBusListener.class);
            MinecraftForge.EVENT_BUS.register(WorldEditCUIForgeClient.ForgeEventBusListener.class);
        });
    }
}