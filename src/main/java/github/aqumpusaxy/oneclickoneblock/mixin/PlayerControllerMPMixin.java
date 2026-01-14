package github.aqumpusaxy.oneclickoneblock.mixin;

import github.aqumpusaxy.oneclickoneblock.OCOBConfig;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PlayerControllerMP.class)
public abstract class PlayerControllerMPMixin {
    @Shadow
    private int blockHitDelay;

    @Inject(
            method = "onPlayerDestroyBlock",
            at = @At("RETURN")
    )
    private void addBlockHitDelay(BlockPos pos, CallbackInfoReturnable<Boolean> cir){
        if (OCOBConfig.enable) {
            this.blockHitDelay = OCOBConfig.delay;
        }
    }
}
