package github.aqumpusaxy.oneclickoneblock;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyBindingRegistry {
    public static final KeyBinding TOGGLE_DELAY = new KeyBinding(
            "key.oneclickoneblock.toggle_delay",
            KeyConflictContext.IN_GAME,
            Keyboard.KEY_NONE,
            "key.category.oneclickoneblock"
    );

    public static void register(){
        ClientRegistry.registerKeyBinding(TOGGLE_DELAY);
    }

    @Mod.EventBusSubscriber(modid = Tags.MOD_ID)
    public static class KeyHandler {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.KeyInputEvent event) {
            if (TOGGLE_DELAY.isPressed()) {
                OCOBConfig.enable = !OCOBConfig.enable;

                String messageKey = OCOBConfig.enable
                        ? "message.oneclickoneblock.enable"
                        : "message.oneclickoneblock.disable";
                Style style = new Style().setColor(
                        OCOBConfig.enable
                                ? TextFormatting.GREEN
                                : TextFormatting.RED
                );
                Minecraft.getMinecraft().player.sendMessage(new TextComponentTranslation(messageKey).setStyle(style));
            }
        }
    }
}
