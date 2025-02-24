package carpetextra.mixins;

import net.minecraft.block.ComparatorBlock;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ComparatorBlock.class)
public abstract class ComparatorBlockMixin {
    @Redirect(
        method = "activate", 
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/entity/player/PlayerEntity;abilities:Lnet/minecraft/entity/player/PlayerAbilities;"
        )
    )
    private PlayerAbilities hasPlayerAbilities(final PlayerEntity player) {
        if(player == null) return new PlayerAbilities();
        return player.abilities;
    }
}
