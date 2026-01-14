package github.aqumpusaxy.oneclickoneblock;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Tags.MOD_ID)
@Config.LangKey("config.oneclickoneblock.general")
public class OCOBConfig {
    @Config.Comment("Enable Block Hit Delay\nDefault: true")
    @Config.LangKey("config.oneclickoneblock.general.enable")
    public static boolean enable = true;

    @Config.Comment("Block Hit Delay\nDefault: 5")
    @Config.LangKey("config.oneclickoneblock.general.delay")
    @Config.RangeInt(min = 0)
    public static int delay = 5;

    @Mod.EventBusSubscriber(modid = Tags.MOD_ID)
    public static class ConfigSyncHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Tags.MOD_ID)) {
                ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
